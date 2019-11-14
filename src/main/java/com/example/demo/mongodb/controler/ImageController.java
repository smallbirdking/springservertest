package com.example.demo.mongodb.controler;

import com.example.demo.Util.AuthenUtil;
import com.example.demo.Util.PathUtil;
import com.example.demo.mongodb.entity.Image;
import com.example.demo.mongodb.entity.ImageListData;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mongodb.entity.image.ImageResponse;
import com.example.demo.mongodb.service.ImageService;
import com.example.demo.mysql.service.UserTokenService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {
    private static final Logger LOG = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imgService;

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    HttpServletRequest requestHeader;

    @RequestMapping("/find/one")
    public byte[] findOne() {
        return imgService.findOne().getContent().getData();
    }

    @RequestMapping("/find/all")
    public ImageListData findAll(int id) {
        System.out.println(id);
        return imgService.findAll(id);
    }

    @RequestMapping("/find/urls")
    public ImageListData findByUrls(List<String> urls) {
      LOG.info("find imgs by " + urls);
      return imgService.findByUrls(urls);
    }

    @PutMapping(value = "/upload/image")
    @ResponseBody
    public void save(String decrip, @RequestParam("uploaded_file") MultipartFile file) throws IOException {
        LOG.info("save img");
        Image image = new Image();

        image.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        imgService.save(image);
    }

    @PutMapping(value = "/upload/multipimages")
    public ImageResponse saveMultipImages(@RequestParam("file") List<MultipartFile> files,
                                          @RequestParam("path") List<String> paths,
                                          @RequestParam("md5Hex") List<String> md5Hexes,
                                          @RequestParam("extension") List<String> extensions) throws IOException {
        UserHeader userHeader = AuthenUtil.getUserHeader(requestHeader);
        ImageResponse response = new ImageResponse();
        long userId = userTokenService.verifyUserAuthen(userHeader, response);
        if (userId > 0) {
            int length = files.size();
            List<Image> imageList = new ArrayList<>();
            Map<String, String> newUrls = new HashMap<>();
            if (paths.size() == length && md5Hexes.size() == length) {
                for (int i = 0; i < length; i++) {
                  String md5Id = md5Hexes.get(i);
                  String newPath = "";
                  if (StringUtils.isNotEmpty(md5Id)) {
                    newPath = imgService.hasSameImage(md5Id);
                  }
                  if (StringUtils.isEmpty(md5Id)) {
                    String extension = "";
                    if (extensions.size() > i) {
                      extension = extensions.get(i);
                    }
                    newPath = PathUtil.generateSavingPath(userId, extension);
                    Image image = new Image();
                    image.setUrl(newPath);
                    image.setContent(new Binary(BsonBinarySubType.BINARY, files.get(i).getBytes()));
                    image.setMD5Id(md5Id);
                    imageList.add(image);
                  }
                  newUrls.put(paths.get(i), newPath);
                }
                if (CollectionUtils.isNotEmpty(imageList)){
                  imgService.saveMultipImages(imageList);
                }
            } else {
                response.setCode("6001");
                response.setMsg("MISSING IMAGE URL");
                LOG.error("6001", "MISSING IMAGE URL");
            }
            response.setUrls(newUrls);
        }
        return response;
    }
}
