package com.codingworld.apigateway.exception;

public class TokenMissing extends RuntimeException{
    String msg;
    public TokenMissing(){}
    public TokenMissing(String msg){
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
