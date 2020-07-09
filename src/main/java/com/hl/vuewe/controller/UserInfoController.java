package com.hl.vuewe.controller;

import com.hl.vuewe.entity.UserInfo;
import com.hl.vuewe.service.UserInfoService;
import com.hl.vuewe.utils.HlUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * login
     *
     * @param userName 用户名
     * @param password 密码
     * @return Object
     * @throws Exception e
     */
    @PostMapping("login")
    @ResponseBody
    private Object login(String userName, String password) throws Exception {
        HashMap<String, Object> resultMap = HlUtil.handleHelpForMap();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            resultMap.put(HlUtil.result, false);
            resultMap.put(HlUtil.msg, "用户名或密码为空");
        }
        //如果输入的是邮箱
        if (HlUtil.isEmail(userName)) {
            HashMap<String,Object> param = new HashMap<String,Object>(16);
            param.put("email",userName);
            param.put("password",password);
            UserInfo userInfo = userInfoService.selectInfoFromEmail(param);
            if (Objects.isNull(userInfo)) {
                resultMap.put(HlUtil.result, false);
                resultMap.put(HlUtil.msg, "邮箱或密码有误");
            } else  {
                resultMap.put("userInfo",userInfo);
            }
        } else {
            HashMap<String,Object> param = new HashMap<String,Object>(16);
            param.put("userName",userName);
            param.put("password",password);
            UserInfo userInfo = userInfoService.selectInfoFromUseName(param);
            if (Objects.isNull(userInfo)) {
                resultMap.put(HlUtil.result, false);
                resultMap.put(HlUtil.msg, "用户名或密码有误");
            } else  {
                resultMap.put("userInfo",userInfo);
            }
        }
        return resultMap;
    }
}
