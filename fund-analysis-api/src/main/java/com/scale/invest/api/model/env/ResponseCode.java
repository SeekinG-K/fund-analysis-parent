package com.scale.invest.api.model.env;

/**
 * @description: 处理结果响应代码
 * @copyright: Copyright (c) 2019 迅策科技
 * @author: chasel
 * @version: 1.0
 * @date: 2019年2月1日
 * @time: 下午12:03:52
 */
public enum ResponseCode implements AppCode {

    RESOURCE_NOT_FOUND("404", "资源不存在"),
    UNKOWN_EXCEPTION("-1", "系统调用异常,请稍后重试！"),
    SUCCESS("0", "OK"),
    DATA_INSERT_EXCEPTION("10", "数据新增失败！"),
    DATA_INSERT_BATCH_EXCEPTION("11", "数据新增失败！"),
    DATA_UPDATE_EXCEPTION("20", "数据更新失败！"),
    DATA_DELETE_EXCEPTION("30", "数据删除失败！"),
    DATA_DISABLE_EXCEPTION("31", "使数据无效失败！"),
    DATA_SELECT_ONE_EXCEPTION("40", "数据获取失败！"),
    DATA_SELECT_EXCEPTION("41", "数据获取失败！"),
    DATA_SELECT_PAGINATION_EXCEPTION("42", "数据获取失败！"),


    RPC_RESPONSE_NULL("101", "返回内容为空"),
    RPC_RESPONSE_EROOR("102","远程调用异常"),
    ;

    private String code;

    private String message;

    private ResponseCode(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    @Override
    public String toString() {
        return getCode();
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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

    public <T> ResponseData<T> setResult(ResponseData<T> resp) {
        resp.setCode(getCode());
        resp.setMsg(getMessage());
        return resp;
    }
}
