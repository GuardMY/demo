package com.example.demo.pojo.vo;

import com.example.demo.common.constant.ResponseCode;
import lombok.Data;

@Data
public class ResponseVO {
    private Integer code;

    private String message;

    private Object data;

    public ResponseVO(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    public ResponseVO(ResponseCode responseCode, Object data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    public ResponseVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseVO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseVO ok() {
        return new ResponseVO(ResponseCode.SUCCESS);
    }

    public static ResponseVO ok(Object data) {
        return new ResponseVO(ResponseCode.SUCCESS, data);
    }

    public static ResponseVO fail() {
        return new ResponseVO(ResponseCode.ERROR);
    }

    public static ResponseVO fail(Object data) {
        return new ResponseVO(ResponseCode.ERROR, data);
    }
}
