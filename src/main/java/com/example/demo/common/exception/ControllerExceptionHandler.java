package com.example.demo.common.exception;

import com.example.demo.pojo.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseVO handleUnknownException(Exception e) {
        log.info("Failed: " + e.getMessage());
        return ResponseVO.fail("Failed");
    }
}
