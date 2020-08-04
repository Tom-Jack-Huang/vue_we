package com.hl.vuewe.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class HlUtil {

    static public String result = "result";
    static public String msg = "msg";


    static public HashMap<String,Object>handleHelpForMap() {
        HashMap<String,Object> resultMap = new HashMap<String, Object>(16);
        resultMap.put(result,true);
        resultMap.put(msg,"数据获取成功！");
        return resultMap;
    }

    public static boolean isEmail(String string) {
        if (string == null) {
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        return m.matches();
    }

}
