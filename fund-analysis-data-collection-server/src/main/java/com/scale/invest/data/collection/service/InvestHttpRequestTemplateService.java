package com.scale.invest.data.collection.service;

/**
 * <pre>
 * @description: http请求业务接口
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 17:22:53
 * </pre>
 */
public interface InvestHttpRequestTemplateService {


    /**
     * 不携带请求参数请求数据
     * @param uri
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getNoneRequestParamData(String uri, Class<T> clazz);

    /**
     * 携带请求参数请求的数据
     * @param uri
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getRequestParamData(String uri, Class<T> clazz);
}
