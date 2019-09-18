package com.example.demo.mysql.controller;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserEntityController {
    @Autowired
    private UserEntityService userEntityService;

    @GetMapping(value = "/find_all_user")
    public List<UserEntity> findAllUsers(){
        List<UserEntity> list= userEntityService.findAll();
        return list;
    }

//    @RequestMapping(value = "/")
//    @ResponseBody
//    public List<UserEntity> findUsersByUserName(String userName){
//        List<UserEntity> list= userEntityService.findByUserName(userName);
//        return list;
//    }


}
