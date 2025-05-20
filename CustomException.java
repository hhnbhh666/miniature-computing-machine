package com.example.exception;

import lombok.AllArgsConstructor;



public class CustomException extends RuntimeException{
    private int code;
    private String msg;

    public CustomException(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
