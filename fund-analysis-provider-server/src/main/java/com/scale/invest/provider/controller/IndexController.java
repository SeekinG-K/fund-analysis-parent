package com.scale.invest.provider.controller;

import com.scale.invest.api.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class IndexController extends BaseController {

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "success";
    }

    @RequestMapping("/index2")
    @ResponseBody
    public Map<String, String> index2() {
        return getBuildVersion();
    }
}
