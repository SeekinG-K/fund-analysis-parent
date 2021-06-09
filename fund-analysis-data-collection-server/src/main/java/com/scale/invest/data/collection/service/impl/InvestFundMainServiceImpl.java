
package com.scale.invest.data.collection.service.impl;

import com.scale.invest.api.model.InvestFundMain;
import com.scale.invest.data.collection.dao.InvestFundMainDao;
import com.scale.invest.data.collection.service.InvestFundMainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
  * <pre>
  * @description: 业务类
  * @copyright: Copyright (c) 2021 Alex
  * @author: bo.yan
  * @version: 1.0
  * @date: 2021-1-10
  * @time: 17:22:53
  * </pre>
  */
@Service
@Transactional
public class InvestFundMainServiceImpl extends ServiceImpl<InvestFundMainDao, InvestFundMain> implements InvestFundMainService {

    @Autowired
    private InvestFundMainDao investFundMainDao;
}
