package com.example.demo.dao.daoImpl;

import com.example.demo.dao.ImageDao;
import com.example.demo.entity.Image;
import com.example.demo.entity.Text;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository("imageDao")
public class ImageDaoImpl implements ImageDao {
    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 查找全部dezhuzhuwang
     */
    @Override
    public Image findOne() {
        Query query=new Query();
        Image one = (Image) mongoTemplate.findOne(query, Image.class, "Image");

        return one;
    }

    /**
     * 查找全部dexiaoxiannvmaomao
     */
    @Override
    public void saveImage(Image file){

        BufferedImage bImage2 = null;
        try {
            Binary content = file.getContent();
            ByteArrayInputStream bis = new ByteArrayInputStream(content.getData());
            bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "png", new File("output.png") );
        } catch (IOException e) {
            e.printStackTrace();
        }

        mongoTemplate.insert(file);
    }

}
