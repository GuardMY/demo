package com.example.demo.common.constant;

public enum ResponseCode {
    SUCCESS(1, "Success"),
    ERROR(0, "Internal Exception"),

    BATCH_SIZE_TOO_LARGE(1001,"Batch size is too large, the max batch size is:%s"),

    NO_SUCH_ENUM(2001, "No Such Enum: %s"),
    NOT_ALLOW_EMPTY(2002, "Variable Can't Be Empty: %s"),

    PARSE_JSON_FAILED(3001, "Fail To Parse Json File: %s"),

    EXECUTE_CMD_FAILED(4001, "Fail To Execute CMD: %s"),

    API_CALL_FAILED(6001, "Fail To Call API"),
    API_RETURN_INVALID(6002, "Return of API Is Invalid");

    private Integer code;

    private String message;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
