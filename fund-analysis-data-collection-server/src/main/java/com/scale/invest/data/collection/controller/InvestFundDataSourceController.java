
package com.scale.invest.data.collection.controller;


import com.scale.invest.data.collection.service.InvestFundDataSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
  * <pre>
  * @description: 表现层控制类
  * @copyright: Copyright (c) 2021 Alex
  * @author: bo.yan
  * @version: 1.0
  * @date: 2021-1-10
  * @time: 21:49:52
  * </pre>
  */
@RestController
public class InvestFundDataSourceController{

    private static final Logger logger = LoggerFactory.getLogger(InvestFundDataSourceController.class);

    @Autowired
    private InvestFundDataSourceService investFundDataSourceService;


}
