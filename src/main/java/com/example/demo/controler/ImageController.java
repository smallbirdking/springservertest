package com.example.demo.controler;

import com.example.demo.Service.ImageService;
import com.example.demo.entity.Image;
import com.example.demo.entity.ImageUpd;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imgService;


    @RequestMapping("/find/one")
    public byte[] find(){
        return imgService.findOne().getContent().getData();
    }

    @PutMapping(value= "/upload/image")
    @ResponseBody
    public void save(  String decrip ,  @RequestParam("uploaded_file") MultipartFile file) throws JSONException, IOException {
        System.out.println(file);
        Image image = new Image();

        image.setContent(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        imgService.save(image);
    }
}
