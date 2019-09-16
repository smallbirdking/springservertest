package com.example.demo.mongodb.controler;

import com.example.demo.mongodb.service.TextService;
import com.example.demo.mongodb.entity.Text;
import com.example.demo.mongodb.entity.TextData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/text")
public class TextController {

    @Autowired
    private TextService textService;


    @RequestMapping("/find/all")
    public TextData find(){
        return textService.findAll();
    }

    @RequestMapping(value= "/save", method = RequestMethod.PUT)
    public void save(@RequestBody Text text) {
        textService.save(text);
    }
}
