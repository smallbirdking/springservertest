package com.example.demo.mongodb.controler;

import com.example.demo.mongodb.entity.Image;
import com.example.demo.mongodb.entity.ImageListData;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mongodb.entity.image.ImageResponse;
import com.example.demo.mongodb.service.ImageService;
import com.example.demo.mysql.service.UserTokenService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {
    private static final Logger LOG = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imgService;

    @Autowired
    private UserTokenService userTokenService;


    @RequestMapping("/find/one")
    public byte[] find() {
        return imgService.findOne().getContent().getData();
    }

    @RequestMapping("/find/all")
    public ImageListData findAll(int id) {
        System.out.println(id);
        return imgService.findAll(id);
    }

    @PutMapping(value = "/upload/image")
    @ResponseBody
    public void save(String decrip, @RequestParam("uploaded_file") MultipartFile file) throws IOException {
        System.out.println(file);
        Image image = new Image();

        image.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        imgService.save(image);
    }

    @PutMapping(value = "/upload/multipimages")
    public void saveMultipImages(@RequestHeader("head") UserHeader userHeader, @RequestParam("file") List<MultipartFile> files) throws IOException {
        System.out.println(files);
        ImageResponse response = new ImageResponse();
        long userId = userTokenService.verifyUserAuthen(userHeader, response);
        if (userId>0) {
            List<Image> imageList = new ArrayList<>();
            for (MultipartFile file :
                    files) {
                Image image = new Image();
                image.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
                imageList.add(image);
            }
            imgService.saveMultipImages(imageList);
        }
    }
}
