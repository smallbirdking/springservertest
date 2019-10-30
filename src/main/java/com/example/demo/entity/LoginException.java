package com.example.demo.entity;

public class LoginException extends Exception {
    String msg;
    String code;

    public LoginException(String message, String code) {
        this.msg = message;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
