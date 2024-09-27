package com.codingworld.service1.ExceptionHandler;

public class ResoureNotFoundException extends RuntimeException{
    private String msg;
    public ResoureNotFoundException(){}
    public ResoureNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
