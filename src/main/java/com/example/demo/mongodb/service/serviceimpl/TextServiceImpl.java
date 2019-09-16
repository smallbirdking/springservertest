package com.example.demo.mongodb.service.serviceimpl;


import com.example.demo.mongodb.service.TextService;
import com.example.demo.mongodb.dao.TextDao;
import com.example.demo.mongodb.entity.Text;
import com.example.demo.mongodb.entity.TextData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("textService")
public class TextServiceImpl implements TextService {
    @Autowired
    private TextDao textDao;

    @Override
    public TextData findAll() {
        List<Text> texts = textDao.findAll();
        TextData textData = new TextData(texts);

        return textData;
    }

    @Override
    public void save(Text text) {
        textDao.save(text);
    }
}
