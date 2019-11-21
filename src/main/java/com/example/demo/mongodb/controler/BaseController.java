package com.example.demo.mongodb.controler;

import com.example.demo.Util.AuthenUtil;
import com.example.demo.entity.BaseResponse;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mysql.service.UserTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class BaseController {
  private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

  @Autowired
  HttpServletRequest requestHeader;

  @Autowired
  private UserTokenService userTokenService;

  public long authenticate(BaseResponse response) {
    LOG.info("authenticate : start");
    UserHeader userHeader = AuthenUtil.getUserHeader(requestHeader);
    long userId = userTokenService.verifyUserAuthen(userHeader, response);
    LOG.debug("authenticate : [userId] : {}", userId);
    return userId;
  }
}
