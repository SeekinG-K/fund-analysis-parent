
package com.scale.invest.data.collection.service;

import com.scale.invest.api.model.InvestStockMain;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <pre>
 * @description: 业务接口
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 21:49:59
 * </pre>
 */
public interface InvestStockMainService extends IService<InvestStockMain> {

    public Boolean saveStockInfoDataSource(String baseValue);

}
