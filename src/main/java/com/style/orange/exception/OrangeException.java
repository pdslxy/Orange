package com.style.orange.exception;

import com.style.orange.enums.OrangeResultCode;

/**
 * @author Mr.Li
 * @create 2018-07-30 17:04
 * @desc 异常处理类
 **/
public class OrangeException extends RuntimeException {

    private OrangeResultCode orangeResultCode;

    public OrangeException(OrangeResultCode orangeResultCode) {
        this.orangeResultCode = orangeResultCode;
    }

    public OrangeResultCode getOrangeResultCode() {
        return orangeResultCode;
    }
}
