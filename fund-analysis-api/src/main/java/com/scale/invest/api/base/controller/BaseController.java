package com.scale.invest.api.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${app.version}")
    private String version;
    @Value("${app.build.time}")
    private String buildTime;

    /**
     * 获取请求头信息
     *
     * @return
     */
    public Map<String, String> getBuildVersion() {
        Map<String, String> ret = new HashMap<>();
        ret.put("version", version);
        ret.put("buildTime", buildTime);
        logger.info(ret.toString());
        return ret;
    }

}
