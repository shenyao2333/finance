package com.sy.finance.web;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：sy
 * @date ：Created in 2020.3.26 21:53
 * @description: 自定义异常
 */
@Slf4j
@Data
public class GrabException extends RuntimeException {

    private Integer code;

    private String msg;

    public GrabException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GrabException(ErrorEnum err) {
        this.code=err.getCode();
        this.msg=err.getMsg();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
