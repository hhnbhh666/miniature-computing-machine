package com.example.common;

import lombok.Data;

//包装类
//统一后端返回数据类型
@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result() {}

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("error");
//        result.setData(data);
        return result;
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(400);
        result.setMsg("自定义异常");
        result.setData(msg);
        return result;
    }

}
