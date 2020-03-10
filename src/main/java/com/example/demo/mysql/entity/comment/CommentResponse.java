package com.example.demo.mysql.entity.comment;

import com.example.demo.entity.BaseResponse;

public class CommentResponse extends BaseResponse {
    private int totalAmount;
//    private List<CommentDetailBean> list;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

//    public void setList(List<CommentDetailBean> list) {
//        this.list = list;
//    }
//    public List<CommentDetailBean> getList() {
//        return list;
//    }

}
