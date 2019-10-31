package com.example.demo.Util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class PathUtil {

  public static String SERVERID = "HEATWAVE";
  public static String THEAD_TAG = "THREAD";

  public static String generateSavingPath(long userId, String imgType) {
    if(userId > 0 && StringUtils.isNotEmpty(imgType)){

      long time = System.currentTimeMillis();
      UUID uuid = UUID.randomUUID();
      String imgName = userId + "_" + time + "_" + uuid + "." + imgType;
      return SERVERID + "/" + THEAD_TAG + "/" + imgName;
    }
    return null;
  }
}
