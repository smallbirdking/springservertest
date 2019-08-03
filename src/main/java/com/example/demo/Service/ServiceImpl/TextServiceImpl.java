package com.example.demo.Service.ServiceImpl;


import com.example.demo.Service.TextService;
import com.example.demo.dao.TextDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Text;
import com.example.demo.entity.TextData;
import com.example.demo.entity.User;
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
