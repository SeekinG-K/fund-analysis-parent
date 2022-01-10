package com.scale.invest.data.collection.service.impl;

import com.scale.invest.api.dto.web.Wechat;
import com.scale.invest.api.dto.web.WechatFile;
import com.scale.invest.api.dto.web.WechatMedia;
import com.scale.invest.data.collection.service.InvestHttpRequestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.python.antlr.ast.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.jar.JarFile;

/**
 * <pre>
 * @description: http请求业务接口
 * @copyright: Copyright (c) 2021 Alex
 * @author: bo.yan
 * @version: 1.0
 * @date: 2021-1-10
 * @time: 17:22:53
 * </pre>
 */
@Service
@Transactional
@Slf4j
public class InvestHttpRequestTemplateServiceImpl implements InvestHttpRequestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 不携带请求参数请求数据
     *
     * @param uri
     * @param clazz
     * @return
     */
    @Override
    public <T> T getNoneRequestParamData(String uri, Class<T> clazz) {
        return restTemplate.getForObject(uri, clazz);
    }


    /**
     * 携带请求参数请求的数据
     *
     * @param clazz
     * @return
     */
    @Override
    public <T> T getRequestParamData(String uri, Class<T> clazz) {
        URI uriInfo = null;
        try {
            uriInfo = new URI(uri);

//Accept-Encoding: gzip, deflate
//Cookie: qgqp_b_id=297358795c62816f04298dad8ed9503b; cowCookie=true; intellpositionL=1624.95px; st_si=03583703569681; st_asi=delete; intellpositionT=455px; st_pvi=87207395476032; st_sp=2022-01-03%2013%3A14%3A40; st_inirUrl=https%3A%2F%2Fwww.baidu.com%2Flink; st_sn=19; st_psi=20220108124833415-113200313002-5783241779
//Host: 17.push2.eastmoney.com
//Referer: http://quote.eastmoney.com/
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36 Edg/97.0.1072.55
            //如果发送的参数数据是json数据的话，需要添加特殊的请求头
            //headers.setContentType(MediaType.APPLICATION_JSON);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cookie", "qgqp_b_id=fc0e45a579c9d3ee9a088ca3c3fbb12e; AUTH_FUND.EASTMONEY.COM_GSJZ=AUTH*TTJJ*TOKEN; em_hq_fls=js; st_si=26963690661780; EMFUND0=11-24%2021%3A17%3A13@%23%24%u4E1C%u65B9%u91D1%u5143%u5B9D%u8D27%u5E01@%23%24001987; EMFUND1=12-18%2023%3A32%3A44@%23%24%u6613%u65B9%u8FBE%u5B89%u5FC3%u56DE%u62A5%u503A%u5238A@%23%24110027; EMFUND2=12-18%2023%3A31%3A14@%23%24%u5BCC%u8363%u5BCC%u7965%u7EAF%u503A@%23%24003999; EMFUND3=12-26%2015%3A33%3A10@%23%24%u534E%u5B89%u7EB3%u65AF%u8FBE%u514B100%u6307%u6570@%23%24040046; EMFUND4=01-10%2017%3A06%3A51@%23%24%u666F%u987A%u957F%u57CE%u65B0%u5174%u6210%u957F%u6DF7%u5408@%23%24260108; EMFUND5=12-26%2020%3A11%3A27@%23%24%u5174%u5168%u5408%u6DA6%u5206%u7EA7%u6DF7%u5408@%23%24163406; EMFUND6=12-26%2020%3A16%3A20@%23%24%u6613%u65B9%u8FBE%u84DD%u7B79%u7CBE%u9009%u6DF7%u5408@%23%24005827; EMFUND7=01-10%2017%3A16%3A43@%23%24%u5174%u5168%u5408%u5B9C%u6DF7%u5408%28LOF%29A@%23%24163417; EMFUND8=01-10%2017%3A07%3A09@%23%24%u5BCC%u56FD%u6587%u4F53%u5065%u5EB7%u80A1%u7968A@%23%24001186; ASP.NET_SessionId=qvhuo1zvgowkzmrxu5wele2i; cowCookie=true; intellpositionL=1269px; intellpositionT=2227.8px; emshistory=%5B%22%E4%B8%AD%E5%85%8D%22%2C%22600743%22%5D; _adsame_fullscreen_18503=1; EMFUND9=01-16 16:25:03@#$%u62DB%u5546%u4E2D%u8BC1%u767D%u9152%u6307%u6570%28LOF%29@%23%24161725; searchbar_code=110027_040046_163406_260108_001186_163417_161725_60083511_60055911_00700213; HAList=d-hk-00700%2Ca-sh-601766-%u4E2D%u56FD%u4E2D%u8F66%2Ca-sh-601888-%u4E2D%u56FD%u4E2D%u514D%2Ca-sh-600559-%u8001%u767D%u5E72%u9152%2Ca-sh-600835-%u4E0A%u6D77%u673A%u7535%2Ca-sz-000568-%u6CF8%u5DDE%u8001%u7A96%2Ca-sh-603801-%u5FD7%u90A6%u5BB6%u5C45%2Ca-sh-600519-%u8D35%u5DDE%u8305%u53F0%2Ca-sz-300059-%u4E1C%u65B9%u8D22%u5BCC%2Ca-sz-000858-%u4E94%20%u7CAE%20%u6DB2%2Ca-sz-300760-%u8FC8%u745E%u533B%u7597; _adsame_fullscreen_16928=1; st_asi=delete; st_pvi=23463818034049; st_sp=2020-11-24%2021%3A17%3A14; st_inirUrl=https%3A%2F%2Fwww.baidu.com%2Flink; st_sn=276; st_psi=20210116172111445-0-3521170538");
            headers.add("Accept", "*/*");
            // headers.add("Accept-Encoding", "gzip, deflate");
            headers.add("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
//            headers.add("Cache-Control", "no-cache");
            headers.add("Connection", "keep-alive");
            headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36 Edg/97.0.1072.55");
//            headers.add("Cookie", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
            headers.add("Host", "17.push2.eastmoney.com");
//            headers.add("Pragma", "no-cache");
//            headers.add("Referer", "http://fund.eastmoney.com/data/fundranking.html");
            //添加参数,因为HttpEntity里面的参数是MultiValueMap类型的，所以使用这个map集合
//            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//            map.add("op", "ph");
//            map.add("dt", "kf");
//            map.add("ft", "all");
//            map.add("rs", "");
//            map.add("gs", "0");
//            map.add("sc", "6yzf");
//            map.add("st", "desc");
//            map.add("sd", "2020-01-16");
//            map.add("ed", "2020-01-16");
//            map.add("qdii", "");
//            map.add("tabSubtype", ",,,,,");
//            map.add("pi", "3");
//            map.add("pn", "50");
//            map.add("dx", "1");
//            map.add("v", "0.6719658032064333");

            //添加请求的实体类，这里第一个参数是要发送的参数，第二个参数是请求头里的数据
            HttpEntity<Object> requestEntity = new HttpEntity<>(null, headers);
            ResponseEntity<T> responseEntity = restTemplate.exchange(uriInfo, HttpMethod.GET, requestEntity, clazz);
            return responseEntity.getBody();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T pushFileStream(byte[] streamByte, String name) {
        URI uriInfo = null;
        MultiValueMap<String, Object> bodyParams = new LinkedMultiValueMap<>();
        org.springframework.core.io.Resource resource = new ByteArrayResource(streamByte) {
            @Override
            public String getFilename() {
                return name;
            }
        };
        bodyParams.add("media", streamByte);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        String one = "https://qyapi.weixin.qq.com/cgi-bin/webhook/upload_media?key=dfbc116d-2154-47bf-a9c6-d757ebc32c8e&type=file";
        try {
            uriInfo = new URI(one);
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyParams, headers);
            ResponseEntity<Wechat> exchange = restTemplate.exchange(uriInfo, HttpMethod.POST, requestEntity, Wechat.class);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Wechat body = exchange.getBody();
            if (Objects.nonNull(body)) {
                String two = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=dfbc116d-2154-47bf-a9c6-d757ebc32c8e";
                String media_id = body.getMedia_id();
                uriInfo = new URI(two);
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType type=MediaType.parseMediaType("application/json;charset=UTF-8");
                httpHeaders.setContentType(type);
                WechatMedia wechatMedia = new WechatMedia(media_id);
                WechatFile wechatFile = new WechatFile("file", wechatMedia);
                HttpEntity<WechatFile> objectHttpEntity = new HttpEntity<>(wechatFile,httpHeaders);
                ResponseEntity<String> responseEntity = restTemplate.postForEntity(uriInfo, objectHttpEntity, String.class);
                String message = responseEntity.getBody();
                log.info(message);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
