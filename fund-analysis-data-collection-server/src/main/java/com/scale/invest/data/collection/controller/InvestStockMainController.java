
package com.scale.invest.data.collection.controller;

import com.scale.invest.api.base.controller.BaseController;
import com.scale.invest.data.collection.service.InvestHttpRequestTemplateService;
import com.scale.invest.data.collection.service.InvestStockMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * <pre>
 * @description: 表现层控制类
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 21:50:00
 * </pre>
 */
@RestController
public class InvestStockMainController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(InvestStockMainController.class);

    @Autowired
    private InvestStockMainService investStockMainService;
    @Autowired
    private InvestHttpRequestTemplateService investHttpRequestTemplateService;

    @RequestMapping(value = "/investFundDataSource/get", method = RequestMethod.GET)
    public Boolean getStockInfoDataSource() {

        boolean b = false;
        for (int i = 1; i <= 1; i++) {
            //            String url = "http://5.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112407040162056358112_1610752431697" +
//                    "&pn="+i+"&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&" +
//                    "invt=2&fid=f3&fs=m:1+t:2,m:1+t:23&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1610752431720";
//
//            String url = "http://5.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112407040162056358112_1610752431695" +
//                    "&pn="+i+"&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80,m:1+t:2,m:1+t:23&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1610752433588";

//            String url = "http://5.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112407040162056358112_1610752431697" +
//                    "&pn="+i+"&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2" +
//                    "&invt=2&fid=f3&fs=m:0+t:6,m:0+t:13,m:0+t:80&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1610752433860";

            String url = "http://82.push2.eastmoney.com/api/qt/clist/get?cb=jQuery1124033049568032833476_1610786827398&pn="+i+
                    "&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:128+t:3,m:128+t:4,m:128+t:1,m:128+t:2&fields=f12,f14&_=1610786827409";
            String noneRequestParamData = investHttpRequestTemplateService.getRequestParamData(url, String.class);
//            b = investStockMainService.saveStockInfoDataSource(noneRequestParamData);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Map<String, String> buildVersion = getBuildVersion();
        logger.info(buildVersion.toString());
        return b;
    }
}
