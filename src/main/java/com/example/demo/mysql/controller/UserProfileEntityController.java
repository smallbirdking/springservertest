package com.example.demo.mysql.controller;

import com.example.demo.Util.AuthenUtil;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mysql.entity.UserProfileEntity;
import com.example.demo.mysql.entity.headportrait.HeadPortraitResponse;
import com.example.demo.mysql.service.UserProfileEntityService;
import com.example.demo.mysql.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/userprofile")
public class UserProfileEntityController {


    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private UserProfileEntityService userEntityService;

    @Autowired
    HttpServletRequest requestHeader;

    @GetMapping(value = "/find_head_portrait")
    public HeadPortraitResponse getHeadPortraitByUserId(@RequestParam("userIds[]") String[] userIds) {

        UserHeader userHeader = AuthenUtil.getUserHeader(requestHeader);
        HeadPortraitResponse response = new HeadPortraitResponse();
        long userId = userTokenService.verifyUserAuthen(userHeader, response);
        if (userId > 0) {
            Map<Long, String> headPortraits = new HashMap<>();
            List<Long> userIdList = new ArrayList<>();
            for(String id : userIds) {
                Long lo = (long)Double.parseDouble(id);
                userIdList.add(lo);
            }
            for (Long usrId : userIdList) {
                Stream<UserProfileEntity> byUserId = userEntityService.findByUserID(usrId);
                Optional<UserProfileEntity> userProfileEntity = byUserId.findFirst();
                if (userProfileEntity.isPresent()) {
                    headPortraits.put(usrId, userProfileEntity.get().getHeadPortrait());
                }
            }
            response.setUrls(headPortraits);
        }
        return response;
    }
}
