package com.example.demo.entity;

import java.util.List;

public class TextData {
    List<Text> texts;

    public TextData(List<Text> texts) {
        this.texts = texts;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
