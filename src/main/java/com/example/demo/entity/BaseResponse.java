package com.example.demo.entity;

public class BaseResponse {

    String tocken;
    String refreshtoken;

    //返回码
    private String code;
    //返回描述
    private String msg;

    public BaseResponse() {
        code = "0000";
        msg = "SUCCESS";
    }

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }

    public String getRefreshtoken() {
        return refreshtoken;
    }

    public void setRefreshtoken(String refreshtoken) {
        this.refreshtoken = refreshtoken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
