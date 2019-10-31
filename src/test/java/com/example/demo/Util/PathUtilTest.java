package com.example.demo.Util;

import org.junit.Test;

public class PathUtilTest {

  @Test
  public void testGenerateSavingPath(){
    String newPath = PathUtil.generateSavingPath(1, "jpg");

    System.out.println(newPath);
  }
}
