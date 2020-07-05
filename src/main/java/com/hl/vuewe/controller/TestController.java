package com.hl.vuewe.controller;

import com.alibaba.fastjson.JSON;
import com.hl.vuewe.entity.Peo;
import com.hl.vuewe.service.PeoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author apple
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Resource
    private PeoService peoService;

    @RequestMapping("test")
    @ResponseBody
    private Object test() throws Exception {
        Peo peo = peoService.selectByPrimaryKey(1);
        System.out.println(peo);
        return JSON.toJSON(peo);
    }

}
