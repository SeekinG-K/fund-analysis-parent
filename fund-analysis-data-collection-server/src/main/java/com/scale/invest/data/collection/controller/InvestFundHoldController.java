
package com.scale.invest.data.collection.controller;

import com.scale.invest.data.collection.service.InvestFundHoldService;
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
  * @time: 21:49:56
  * </pre>
  */
@RestController
public class InvestFundHoldController{

    private static final Logger logger = LoggerFactory.getLogger(InvestFundHoldController.class);

    @Autowired
    private InvestFundHoldService investFundHoldService;

}
