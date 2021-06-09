
package com.scale.invest.data.collection.service.impl;

import com.scale.invest.api.model.InvestFundDataSource;
import com.scale.invest.data.collection.dao.InvestFundDataSourceDao;
import com.scale.invest.data.collection.service.InvestFundDataSourceService;
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
  * @time: 21:49:52
  * </pre>
  */
@Service
@Transactional
public class InvestFundDataSourceServiceImpl extends ServiceImpl<InvestFundDataSourceDao, InvestFundDataSource> implements InvestFundDataSourceService {

    @Autowired
    private InvestFundDataSourceDao investFundDataSourceDao;
}
