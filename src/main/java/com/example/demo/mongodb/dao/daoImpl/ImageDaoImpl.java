package com.example.demo.mongodb.dao.daoImpl;

import com.example.demo.mongodb.dao.ImageDao;
import com.example.demo.mongodb.entity.Image;
import com.example.demo.mongodb.entity.ImageListData;
import com.example.demo.mongodb.entity.ImageUpd;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Base64;
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
        Query query = new Query();
        return (Image) mongoTemplate.findOne(query, Image.class, "Image");
    }

    @Override
    public ImageListData findAll() {
        Query query = new Query();
        List<Image> images = mongoTemplate.findAll(Image.class, "Image");
        List<ImageUpd> imageUpds = imageUpdBuilder(images);
        return new ImageListData(imageUpds);
    }

    @Override
    public ImageListData findByUrls(List<String> urls) {
      Query query = new Query(Criteria.where("URL").in(urls));
      List<Image> images = mongoTemplate.find(query, Image.class);
      List<ImageUpd> imageUpds = imageUpdBuilder(images);
      return new ImageListData(imageUpds);
    }

    private List<ImageUpd> imageUpdBuilder(List<Image> images) {
      List<ImageUpd> imageUpds = new ArrayList<>();
      if(images != null){
        for (Image image:
            images) {
          ImageUpd imageUpd = new ImageUpd();
          String encoded = Base64.getEncoder().encodeToString(image.getContent().getData());
          imageUpd.setContent(encoded);
          imageUpds.add(imageUpd);
        }
      }
      return imageUpds;
    }

  /**
     * 查找全部dexiaoxiannvmaomao
     */
    @Override
    public void saveImage(Image file) {

//        BufferedImage bImage2 = null;
//        try {
//            Binary content = file.getContent();
//            ByteArrayInputStream bis = new ByteArrayInputStream(content.getData());
//            bImage2 = ImageIO.read(bis);
//            ImageIO.write(bImage2, "png", new File("output.png") );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        mongoTemplate.insert(file);
    }

    /**
     * 查找全部dexiaoxiannvmaomao
     */
    @Override
    public void saveMultipImages(List<Image> files) {
        mongoTemplate.insertAll(files);
    }

    @Override
    public String hasSameMD5IdInImage(String md5Id) {
      Query query = new Query(Criteria.where("MD5ID").is(md5Id));
      query.fields().include("URL");
      Image img = mongoTemplate.findOne(query, Image.class);
      return StringUtils.isNotEmpty(img.getUrl()) ? img.getUrl() : null ;
    }

}
