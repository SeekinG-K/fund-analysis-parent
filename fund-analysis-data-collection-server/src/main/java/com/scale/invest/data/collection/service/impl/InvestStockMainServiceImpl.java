
package com.scale.invest.data.collection.service.impl;

import com.scale.invest.api.dto.stock.D1;
import com.scale.invest.api.dto.stock.StockBaseInfoDataSource;
import com.scale.invest.api.model.InvestStockMain;
import com.scale.invest.data.collection.dao.InvestStockMainDao;
import com.scale.invest.data.collection.service.InvestStockMainService;
import com.scale.invest.api.uitl.JsonFormatUtil;
import com.scale.invest.api.uitl.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * <pre>
 * @description: 业务类
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 21:49:59
 * </pre>
 */
@Service
@Transactional
public class InvestStockMainServiceImpl extends ServiceImpl<InvestStockMainDao, InvestStockMain> implements InvestStockMainService {
    private static final Logger logger = LoggerFactory.getLogger(InvestStockMainServiceImpl.class);

    @Autowired
    private InvestStockMainDao investStockMainDao;

    @Override
    public Boolean saveStockInfoDataSource(String baseValue) {

        boolean result = true;
        String bracketInnerValue = StringUtil.getBracketInnerValueSplit(baseValue);
        if (StringUtils.isNotEmpty(bracketInnerValue)) {
            logger.info(bracketInnerValue);
            StockBaseInfoDataSource stockBaseInfoDataSource = JsonFormatUtil.formatJsonToObject(bracketInnerValue, StockBaseInfoDataSource.class);
            if (Objects.nonNull(stockBaseInfoDataSource) && Objects.nonNull(stockBaseInfoDataSource.getData()) && !CollectionUtils.isEmpty(stockBaseInfoDataSource.getData().getDiff())) {
                List<D1> diff = stockBaseInfoDataSource.getData().getDiff();
                for (D1 d1 : diff) {
                    String f12 = d1.getF12();
                    String f14 = d1.getF14();
                    InvestStockMain investStockMain = InvestStockMain.builder()
                            .stockCode(f12)
                            .stockName(f14)
                            .stockType(1)
                            .createTime(new Date())
                            .updateTime(new Date())
                            .build();
                    try {
                        boolean save = save(investStockMain);
                        if (!save) {
                            logger.error("error==>{}  ==>{}", f12, f14);
                        }
                        result = save & result;
                    } catch (Exception e) {
                       int i = 0;
                    }
                }
            }
        }
        return result;
    }
}
