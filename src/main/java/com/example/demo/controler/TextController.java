package com.example.demo.controler;

import com.example.demo.Service.TextService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.Text;
import com.example.demo.entity.TextData;
import com.example.demo.entity.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void save(@RequestBody Text text) throws JSONException {
        System.out.println(text);
//        JSONObject jsonObject =new JSONObject(text);
//
//        String freetext = (String) jsonObject.get("freetext");
//        Integer ttt = (Integer) jsonObject.get("ttt");
//
//        Text tt = new Text(freetext,ttt);

        textService.save(text);
    }
}
