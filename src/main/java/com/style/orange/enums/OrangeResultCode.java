package com.style.orange.enums;

/**
 * @author: Mr.Li
 * @date: 2018/7/31 13:23
 * @description: 返回结果枚举类
 */
public enum OrangeResultCode {

    /**
     * 登录认证错误
     */
    ERROR_PWD(400, "用户名或密码错误"),
    ERROR_USER(400, "用户不存在"),
    ERROR_SYSTEM(500, "服务器错误"),
    ERROR_TOKEN(401, "token无效");


    private int code;
    private String msg;

    OrangeResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    OrangeResultCode(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
