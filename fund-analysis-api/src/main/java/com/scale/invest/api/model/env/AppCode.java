package com.scale.invest.api.model.env;

/**
 * @description: 业务代码
 * @copyright: Copyright (c) 2019 迅策科技
 * @author: chasel
 * @version: 1.0
 * @date: 2019年3月7日
 * @time: 下午2:47:07
 */
public interface AppCode {

    /**
     * @return
     * @description：返回业务代码
     */
    public String getCode();

    /**
     * @param code 业务代码
     * @description：设置业务代码
     */
    public void setCode(String code);

    /**
     * @return
     * @description：返回业务代码对应描述信息
     */
    public String getMessage();

    /**
     * @param message
     * @description：设置业务代码对应描述信息
     */
    public void setMessage(String message);

    /**
     * @return
     * @description：是否成功
     * @date：2019年4月19日 上午10:54:02
     */
    default boolean isSuccess() {
        return "0".equals(getCode());
    }
}
