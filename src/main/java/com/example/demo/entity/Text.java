package com.example.demo.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class Text {

    String freetext;

    Integer ttt;


//    public Text(String freetext, Integer ttt) {
//        this.freetext = freetext;
//        this.ttt = ttt;
//    }

    public String getFreetext() {
        return freetext;
    }

    public void setFreetext(String freetext) {
        this.freetext = freetext;
    }

    public Integer getTtt() {
        return ttt;
    }

    public void setTtt(Integer ttt) {
        this.ttt = ttt;
    }
}
