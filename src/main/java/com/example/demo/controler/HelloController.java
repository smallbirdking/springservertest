package com.example.demo.controler;

import com.example.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Hello World! 你好";
    }

    @RequestMapping("/index.html")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/people.html")
    public String people(Map<String,Object> map){
        List<Person> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Person student = new Person();
            student.setFirstName("张三"+i);
            list.add(student);
        }
        map.put("sList",list);// 返回给页面的数据
        logger.info("studentList: {}",list);
        return "people";
    }


}
