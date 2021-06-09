package com.scale.invest.data.collection;

import com.scale.invest.api.dto.stock.StockBaseInfoDataSource;
import com.scale.invest.api.model.InvestFundMain;
import com.scale.invest.data.collection.service.InvestFundMainService;
import com.scale.invest.api.uitl.JsonFormatUtil;
import org.junit.jupiter.api.Test;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class DataCollectionApplicationTests {

    @Autowired
    private InvestFundMainService investFundMainService;

    @Test
    void contextLoads() {
        InvestFundMain byId = investFundMainService.getById(1L);
        System.out.println(byId);
    }

    public static void main1(String[] args) {
        String s = "http://5.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112407040162056358112_1610752431697" +
                "&pn=1&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&" +
                "invt=2&fid=f3&fs=m:1+t:2,m:1+t:23&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1610752431720";

        String s1 = "jQuery112407040162056358112_1610752431697({\"rc\":0,\"rt\":6,\"svr\":182482182,\"lt\":1,\"full\":1,\"data\":{\"total\":1872,\"diff\":[{\"f1\":2,\"f2\":34.85,\"f3\":8.0,\"f4\":2.58,\"f5\":49170,\"f6\":167197134.0,\"f7\":8.3,\"f8\":2.26,\"f9\":29.52,\"f10\":1.33,\"f11\":0.58,\"f12\":\"603801\",\"f13\":1,\"f14\":\"志邦家居\",\"f15\":35.05,\"f16\":32.37,\"f17\":32.37,\"f18\":32.27,\"f20\":7783167596,\"f21\":7590691046,\"f22\":-0.03,\"f23\":3.89,\"f24\":2.5,\"f25\":0.99,\"f62\":7053903.0,\"f115\":26.45,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":16.32,\"f3\":7.87,\"f4\":1.19,\"f5\":31354,\"f6\":49703977.0,\"f7\":10.24,\"f8\":1.96,\"f9\":69.23,\"f10\":1.77,\"f11\":-0.12,\"f12\":\"603978\",\"f13\":1,\"f14\":\"深圳新星\",\"f15\":16.54,\"f16\":14.99,\"f17\":15.05,\"f18\":15.13,\"f20\":2611200000,\"f21\":2611200000,\"f22\":-0.06,\"f23\":1.71,\"f24\":-18.93,\"f25\":-5.34,\"f62\":754179.0,\"f115\":56.5,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":20.09,\"f3\":7.84,\"f4\":1.46,\"f5\":58868,\"f6\":116998730.0,\"f7\":12.13,\"f8\":2.08,\"f9\":154.56,\"f10\":2.77,\"f11\":0.25,\"f12\":\"688007\",\"f13\":1,\"f14\":\"光峰科技\",\"f15\":20.65,\"f16\":18.39,\"f17\":18.63,\"f18\":18.63,\"f20\":9095886141,\"f21\":5691499712,\"f22\":0.0,\"f23\":4.52,\"f24\":-9.71,\"f25\":8.3,\"f62\":10783057.0,\"f115\":85.44,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":10.67,\"f3\":7.67,\"f4\":0.76,\"f5\":25171,\"f6\":26272531.0,\"f7\":9.79,\"f8\":1.37,\"f9\":155.26,\"f10\":1.02,\"f11\":-0.84,\"f12\":\"603038\",\"f13\":1,\"f14\":\"华立股份\",\"f15\":10.8,\"f16\":9.83,\"f17\":9.91,\"f18\":9.91,\"f20\":1964687021,\"f21\":1964687021,\"f22\":-0.28,\"f23\":1.86,\"f24\":2.3,\"f25\":19.48,\"f62\":3034034.0,\"f115\":50.48,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":31.29,\"f3\":7.42,\"f4\":2.16,\"f5\":42465,\"f6\":133210652.0,\"f7\":9.68,\"f8\":14.58,\"f9\":44.01,\"f10\":1.87,\"f11\":-0.03,\"f12\":\"688529\",\"f13\":1,\"f14\":\"豪森股份\",\"f15\":32.48,\"f16\":29.66,\"f17\":29.7,\"f18\":29.13,\"f20\":4005120000,\"f21\":911315837,\"f22\":0.03,\"f23\":3.89,\"f24\":54.9,\"f25\":-15.11,\"f62\":2406609.0,\"f115\":42.79,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":24.15,\"f3\":7.29,\"f4\":1.64,\"f5\":16626,\"f6\":39584798.0,\"f7\":7.95,\"f8\":6.81,\"f9\":53.5,\"f10\":1.03,\"f11\":0.12,\"f12\":\"688466\",\"f13\":1,\"f14\":\"金科环境\",\"f15\":24.37,\"f16\":22.58,\"f17\":23.18,\"f18\":22.51,\"f20\":2481654000,\"f21\":589392825,\"f22\":0.33,\"f23\":2.67,\"f24\":-32.09,\"f25\":-2.74,\"f62\":-1647293.0,\"f115\":32.57,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":25.53,\"f3\":7.27,\"f4\":1.73,\"f5\":15929,\"f6\":39447358.0,\"f7\":8.11,\"f8\":1.55,\"f9\":20.88,\"f10\":1.89,\"f11\":-0.31,\"f12\":\"603610\",\"f13\":1,\"f14\":\"麒盛科技\",\"f15\":25.73,\"f16\":23.8,\"f17\":23.8,\"f18\":23.8,\"f20\":5296429725,\"f21\":2629236001,\"f22\":0.04,\"f23\":1.84,\"f24\":-22.0,\"f25\":5.63,\"f62\":4105548.0,\"f115\":16.9,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":10.15,\"f3\":7.07,\"f4\":0.67,\"f5\":796284,\"f6\":807508416.0,\"f7\":5.7,\"f8\":3.77,\"f9\":21.49,\"f10\":1.68,\"f11\":-0.2,\"f12\":\"600737\",\"f13\":1,\"f14\":\"中粮糖业\",\"f15\":10.42,\"f16\":9.88,\"f17\":9.88,\"f18\":9.48,\"f20\":21709309514,\"f21\":21427652414,\"f22\":0.0,\"f23\":2.51,\"f24\":14.82,\"f25\":4.86,\"f62\":38327006.0,\"f115\":29.03,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":45.1,\"f3\":7.05,\"f4\":2.97,\"f5\":236046,\"f6\":1056327552.0,\"f7\":6.2,\"f8\":9.74,\"f9\":126.13,\"f10\":3.24,\"f11\":0.29,\"f12\":\"603690\",\"f13\":1,\"f14\":\"至纯科技\",\"f15\":46.0,\"f16\":43.39,\"f17\":43.68,\"f18\":42.13,\"f20\":13881988001,\"f21\":10928135765,\"f22\":0.29,\"f23\":4.81,\"f24\":29.23,\"f25\":14.7,\"f62\":29857131.0,\"f115\":117.37,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":9.72,\"f3\":7.05,\"f4\":0.64,\"f5\":971593,\"f6\":932841520.0,\"f7\":6.94,\"f8\":5.13,\"f9\":6.27,\"f10\":2.66,\"f11\":0.0,\"f12\":\"601838\",\"f13\":1,\"f14\":\"成都银行\",\"f15\":9.87,\"f16\":9.24,\"f17\":9.24,\"f18\":9.08,\"f20\":35111082966,\"f21\":18420168055,\"f22\":-0.1,\"f23\":0.92,\"f24\":-12.83,\"f25\":-8.9,\"f62\":168651905.0,\"f115\":6.11,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":230.82,\"f3\":7.0,\"f4\":15.1,\"f5\":13468,\"f6\":303604112.0,\"f7\":11.36,\"f8\":9.81,\"f9\":161.25,\"f10\":0.66,\"f11\":-0.34,\"f12\":\"688617\",\"f13\":1,\"f14\":\"惠泰医疗\",\"f15\":236.5,\"f16\":212.0,\"f17\":212.01,\"f18\":215.72,\"f20\":15388769400,\"f21\":3168793674,\"f22\":-0.08,\"f23\":9.79,\"f24\":209.99,\"f25\":209.99,\"f62\":34423230.0,\"f115\":165.72,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":24.18,\"f3\":6.99,\"f4\":1.58,\"f5\":206396,\"f6\":496618672.0,\"f7\":9.12,\"f8\":4.47,\"f9\":19.35,\"f10\":1.33,\"f11\":-0.29,\"f12\":\"603599\",\"f13\":1,\"f14\":\"广信股份\",\"f15\":24.7,\"f16\":22.64,\"f17\":22.79,\"f18\":22.6,\"f20\":11235941484,\"f21\":11159211646,\"f22\":-0.41,\"f23\":2.05,\"f24\":21.14,\"f25\":0.88,\"f62\":17792229.0,\"f115\":21.34,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":16.85,\"f3\":6.71,\"f4\":1.06,\"f5\":25951,\"f6\":42894858.0,\"f7\":9.06,\"f8\":2.38,\"f9\":382.82,\"f10\":2.19,\"f11\":-0.18,\"f12\":\"603496\",\"f13\":1,\"f14\":\"恒为科技\",\"f15\":17.16,\"f16\":15.73,\"f17\":15.8,\"f18\":15.79,\"f20\":3386600704,\"f21\":1840501742,\"f22\":-0.18,\"f23\":4.25,\"f24\":-13.99,\"f25\":6.31,\"f62\":2701669.0,\"f115\":1335.18,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":29.85,\"f3\":6.61,\"f4\":1.85,\"f5\":119355,\"f6\":349723648.0,\"f7\":7.71,\"f8\":17.9,\"f9\":30.18,\"f10\":0.73,\"f11\":-0.67,\"f12\":\"603565\",\"f13\":1,\"f14\":\"中谷物流\",\"f15\":30.38,\"f16\":28.22,\"f17\":28.81,\"f18\":28.0,\"f20\":19900000010,\"f21\":1990000010,\"f22\":-0.47,\"f23\":4.28,\"f24\":18.5,\"f25\":30.86,\"f62\":7712879.0,\"f115\":24.86,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":26.27,\"f3\":6.49,\"f4\":1.6,\"f5\":15704,\"f6\":40744379.0,\"f7\":10.38,\"f8\":1.81,\"f9\":57.89,\"f10\":1.83,\"f11\":0.08,\"f12\":\"603722\",\"f13\":1,\"f14\":\"阿科力\",\"f15\":26.98,\"f16\":24.42,\"f17\":24.42,\"f18\":24.67,\"f20\":2310118125,\"f21\":2282810460,\"f22\":0.0,\"f23\":4.16,\"f24\":-18.92,\"f25\":-4.09,\"f62\":1456352.0,\"f115\":60.19,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":22.71,\"f3\":6.37,\"f4\":1.36,\"f5\":3635738,\"f6\":8285966080.0,\"f7\":5.01,\"f8\":1.85,\"f9\":7.08,\"f10\":2.55,\"f11\":-0.18,\"f12\":\"601166\",\"f13\":1,\"f14\":\"兴业银行\",\"f15\":23.35,\"f16\":22.28,\"f17\":22.5,\"f18\":21.35,\"f20\":471781871955,\"f21\":445462340013,\"f22\":-0.13,\"f23\":0.77,\"f24\":24.64,\"f25\":8.82,\"f62\":458574272.0,\"f115\":7.51,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":8.37,\"f3\":6.35,\"f4\":0.5,\"f5\":425800,\"f6\":345866224.0,\"f7\":10.42,\"f8\":5.71,\"f9\":72.27,\"f10\":1.09,\"f11\":0.48,\"f12\":\"600773\",\"f13\":1,\"f14\":\"西藏城投\",\"f15\":8.6,\"f16\":7.78,\"f17\":7.82,\"f18\":7.87,\"f20\":6860560427,\"f21\":6244896289,\"f22\":0.0,\"f23\":1.94,\"f24\":41.86,\"f25\":19.91,\"f62\":7462006.0,\"f115\":64.69,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":17.86,\"f3\":6.31,\"f4\":1.06,\"f5\":317703,\"f6\":564367680.0,\"f7\":9.05,\"f8\":1.98,\"f9\":54.8,\"f10\":0.8,\"f11\":-0.06,\"f12\":\"600827\",\"f13\":1,\"f14\":\"百联股份\",\"f15\":18.32,\"f16\":16.8,\"f17\":16.8,\"f18\":16.8,\"f20\":31865242570,\"f21\":28655475571,\"f22\":0.0,\"f23\":1.76,\"f24\":11.63,\"f25\":22.33,\"f62\":51085456.0,\"f115\":47.05,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":11.79,\"f3\":6.22,\"f4\":0.69,\"f5\":816655,\"f6\":966090672.0,\"f7\":8.11,\"f8\":30.94,\"f9\":18.61,\"f10\":2.1,\"f11\":0.0,\"f12\":\"601187\",\"f13\":1,\"f14\":\"厦门银行\",\"f15\":12.21,\"f16\":11.31,\"f17\":11.32,\"f18\":11.1,\"f20\":31115317800,\"f21\":3111531782,\"f22\":0.0,\"f23\":1.77,\"f24\":75.71,\"f25\":-10.68,\"f62\":146152719.0,\"f115\":17.28,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2},{\"f1\":2,\"f2\":31.38,\"f3\":6.19,\"f4\":1.83,\"f5\":20619,\"f6\":64598167.0,\"f7\":11.17,\"f8\":8.4,\"f9\":270.74,\"f10\":1.57,\"f11\":0.06,\"f12\":\"688589\",\"f13\":1,\"f14\":\"力合微\",\"f15\":32.3,\"f16\":29.0,\"f17\":29.45,\"f18\":29.55,\"f20\":3138000000,\"f21\":770612436,\"f22\":-0.03,\"f23\":4.5,\"f24\":-39.02,\"f25\":-13.12,\"f62\":1443604.0,\"f115\":81.02,\"f128\":\"-\",\"f140\":\"-\",\"f141\":\"-\",\"f136\":\"-\",\"f152\":2}]}});";
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(s1);
        if (matcher.find()) {
            String group = matcher.group(1);
            StockBaseInfoDataSource stockDataSource = JsonFormatUtil.formatJsonToObject(group, StockBaseInfoDataSource.class);
            System.out.println(stockDataSource);
        }
    }

    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("C:\\Users\\scale\\Desktop\\baoStock.py");
    }
}