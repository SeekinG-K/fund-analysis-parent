package com.scale.invest.api.model.env;

import org.springframework.http.HttpStatus;

/**
 * @description: 响应对象
 * @copyright: Copyright (c) 2019 迅策科技
 * @author: chasel
 * @version: 1.0
 * @date: 2019年4月19日
 * @time: 上午10:58:28
 */
public class ResponseData<T> {

    /**
     * 错误或者成功代码
     */
    private String code;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 响应结果
     */
    private T data;

    /**
     * Http响应状态码
     */
    private int status;

    /**
     * 构造函数
     */
    public ResponseData() {
        this(ResponseCode.UNKOWN_EXCEPTION);
    }

    /**
     * 构造函数
     *
     * @param code    错误或者成功代码
     * @param message 错误描述
     */
    public ResponseData(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    /**
     * 构造函数
     *
     * @param code    错误或者成功代码
     * @param message 错误描述
     * @param data    响应结果
     */
    public ResponseData(String code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @param code    错误或者成功代码
     * @param message 错误描述
     * @param data    响应结果
     * @param status  Http响应状态码
     */
    public ResponseData(String code, String message, T data, int status) {
        this.code = code;
        this.msg = message;
        this.data = data;
        this.status = status;
    }


    /**
     * 构造函数
     */
    public ResponseData(AppCode appCode) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
    }

    /**
     * 构造函数
     */
    public ResponseData(AppCode appCode, T data) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
        this.data = data;
    }

    /**
     * 构造函数
     */
    public ResponseData(AppCode appCode, T data, int status) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
        this.data = data;
        this.status = status;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public ResponseData<T> setData(T data) {
        this.data = data;
        return this;
    }

    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public ResponseData<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public void ResponseCode(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public ResponseData<T> ok() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMessage();
        this.status = HttpStatus.OK.value();
        return this;
    }

    public ResponseData<T> error(AppCode appCode) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
        this.status = HttpStatus.BAD_REQUEST.value();
        return this;
    }

    /**
     * @return
     * @description：成功返回true
     * @date：2019年2月1日 下午2:36:10
     */
    public boolean isSuccess() {
        return ResponseCode.SUCCESS.getCode().equals(this.code);
    }
}
