package com.hl.vuewe.controller;

import com.hl.vuewe.utils.HlUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("share")
public class ShareController {

    @Value("${app.appid}")
    private String appid;

    @Value("${app.secret}")
    private String secret;

    @PostMapping("wxToken")
    @ResponseBody
    private Object getWxToken(String urlStr) throws Exception {
        HashMap<String,Object> resultMap = HlUtil.handleHelpForMap();
        RestTemplate restTemplate = new RestTemplate();
        HashMap tokenResult = restTemplate.getForObject("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret,HashMap.class);

        if (tokenResult.get("access_token") == null) {
            resultMap.put(HlUtil.result,false);
            resultMap.put(HlUtil.msg,"WX_token获取出错");
            return resultMap;
        }
        String access_token = tokenResult.get("access_token").toString();
        HashMap ticketResult = restTemplate.getForObject("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi",HashMap.class);

        if (ticketResult.get("ticket") == null) {
            resultMap.put(HlUtil.result,false);
            resultMap.put(HlUtil.msg,"WX_ticket获取出错");
            return resultMap;
        }

        String ticket = ticketResult.get("ticket").toString();
        String noncestr = UUID.randomUUID().toString().replace("-","");
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime()/1000);

        String sigStr = "jsapi_ticket="+ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+urlStr;

        String signature =HlUtil.SHA1(sigStr);
        HashMap<String,Object> data = new HashMap<String,Object>(16);
        data.put("appId",appid);
        data.put("timestamp",timestamp);
        data.put("nonceStr",noncestr);
        data.put("signature",signature);
        data.put("ticket",ticket);
        data.put("access_token",access_token);
        resultMap.put("data",data);
        return resultMap;
    }
}
