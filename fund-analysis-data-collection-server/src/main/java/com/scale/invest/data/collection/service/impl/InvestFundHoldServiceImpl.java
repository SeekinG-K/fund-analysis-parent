
package com.scale.invest.data.collection.service.impl;

import com.scale.invest.api.model.InvestFundHold;
import com.scale.invest.data.collection.dao.InvestFundHoldDao;
import com.scale.invest.data.collection.service.InvestFundHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


/**
  * <pre>
  * @description: 业务类
  * @copyright: Copyright (c) 2021 Alex
  * @author: bo.yan
  * @version: 1.0
  * @date: 2021-1-10
  * @time: 21:49:56
  * </pre>
  */
@Service
@Transactional
public class InvestFundHoldServiceImpl extends ServiceImpl<InvestFundHoldDao, InvestFundHold> implements InvestFundHoldService {

    @Autowired
    private InvestFundHoldDao investFundHoldDao;
}
