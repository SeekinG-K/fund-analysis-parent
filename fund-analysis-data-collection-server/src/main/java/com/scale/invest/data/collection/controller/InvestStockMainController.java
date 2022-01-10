
package com.scale.invest.data.collection.controller;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.scale.invest.api.base.controller.BaseController;
import com.scale.invest.api.model.InvestStockMain;
import com.scale.invest.api.uitl.PoiUtil;
import com.scale.invest.data.collection.service.InvestHttpRequestTemplateService;
import com.scale.invest.data.collection.service.InvestStockMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

            String url = "http://82.push2.eastmoney.com/api/qt/clist/get?cb=jQuery1124033049568032833476_1610786827398&pn=" + i +
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


    @RequestMapping(value = "/investMarketDataSource/get", method = RequestMethod.GET)
    public Boolean getMarketInfoDataSource() {
        boolean b = false;
        for (int i = 1; i <= 7; i++) {
            String url = "http://17.push2.eastmoney.com/api/qt/clist/get?cb=jQuery1124020537372933193265_1641617312827&pn=" + i +
                    "&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:3+f:!50" +
                    "&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222";
            String noneRequestParamData = investHttpRequestTemplateService.getRequestParamData(url, String.class);
            logger.info(noneRequestParamData);
            b = investStockMainService.saveStockInfoDataSource(noneRequestParamData);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Map<String, String> buildVersion = getBuildVersion();
        logger.info(buildVersion.toString());
        return b;
    }

    @RequestMapping("/export")
    public void exportMarketInfo(HttpServletResponse response) {
        List<InvestStockMain> marketInfoList = investStockMainService.list();
        List<ExcelExportEntity> colList = new ArrayList<>();
        //第一列
        ExcelExportEntity colEntity1 = new ExcelExportEntity("概念代码", "stockCode");
        colList.add(colEntity1);
        //第二列
        ExcelExportEntity colEntity2 = new ExcelExportEntity("概念名称日期", "stockName");
        colList.add(colEntity2);
        Map<String, List<InvestStockMain>> maps = marketInfoList.stream()
                .collect(Collectors.groupingBy(InvestStockMain::getStockCode));
        LinkedHashSet<Integer> set = marketInfoList.stream().map(InvestStockMain::getTradeDate)
                .sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<String> collect = marketInfoList.stream().map(InvestStockMain::getStockCode)
                .sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        set.forEach(item -> colList.add(new ExcelExportEntity(String.valueOf(item), String.valueOf(item))));
        List<Map<String, String>> dataList = new ArrayList<>();
        collect.forEach(stockCode -> {

            List<InvestStockMain> orDefault = maps.getOrDefault(stockCode, new LinkedList<>());
            Map<Integer, InvestStockMain> investStockMainMap = orDefault.stream()
                    .collect(Collectors.toMap(InvestStockMain::getTradeDate, Function.identity(), (k1, k2) -> k2));
            List<InvestStockMain> findStockInfo = orDefault
                    .stream().filter(item -> !StringUtils.isEmpty(item.getStockCode())).collect(Collectors.toList());
            InvestStockMain investStockMain = findStockInfo.get(0);
            Map<String, String> map = new LinkedHashMap<>();
            map.put("stockCode", stockCode);
            map.put("stockName", investStockMain.getStockName());
            set.forEach(time -> {
                InvestStockMain finalData = investStockMainMap.getOrDefault(time, new InvestStockMain());
                map.put(String.valueOf(time), Objects.nonNull(finalData.getPriceLimit()) ? finalData.getPriceLimit().toPlainString() : "");
            });
            dataList.add(map);
        });

        byte[] streamByte = PoiUtil.exportExcel(colList, dataList, null, "概念热点图", "概念热点图.xlsx", response);
//        String noneRequestParamData = investHttpRequestTemplateService.pushFileStream(streamByte, "概念热点图.xlsx");

    }
}
