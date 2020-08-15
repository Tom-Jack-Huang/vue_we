package com.hl.vuewe.utils;

import java.security.MessageDigest;
import java.util.Formatter;
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
    public static String SHA1(String decript) throws Exception {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(decript.getBytes("UTF-8"));
       return byteToHex(crypt.digest());
    }
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

}
