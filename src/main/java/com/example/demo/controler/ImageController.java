package com.example.demo.controler;

import com.example.demo.Service.ImageService;
import com.example.demo.entity.Image;
import com.example.demo.entity.ImageData;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imgService;


    @RequestMapping("/find/one")
    public byte[] find() {
        return imgService.findOne().getContent().getData();
    }

    @RequestMapping("/find/all")
    public ImageData findAll(int id) {
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
    public void saveMultipImages(@RequestParam("file") List<MultipartFile> files) throws IOException {
        System.out.println(files);
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
