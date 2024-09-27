package com.codingworld.apigateway.exception;

public class BadCredentialsException extends RuntimeException{
    String msg;
    public BadCredentialsException(){}
    public BadCredentialsException(String msg){
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
