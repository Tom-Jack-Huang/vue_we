package com.hl.vuewe.controller.im;

import io.netty.channel.Channel;
import net.openmob.mobileimsdk.server.event.ServerEventListener;
import net.openmob.mobileimsdk.server.protocal.Protocal;
import net.openmob.mobileimsdk.server.utils.LocalSendHelper;
import org.springframework.stereotype.Controller;

/**
 * @author apple
 */
@Controller
public class ServerEventListenerImpl implements ServerEventListener {
    /**
     * 登录验证
     * @param s 用户名
     * @param s1 token 或 者密码
     * @param s2  额外字段
     * @param channel
     * @return
     */
    @Override
    public int onVerifyUserCallBack(String s, String s1, String s2, Channel channel) {
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        return 0;
    }

    /**
     * 用户登录回调 用户上线了
     * @param s 用户名
     * @param s1 额外字段
     * @param channel
     */
    @Override
    public void onUserLoginAction_CallBack(String s, String s1, Channel channel) {
        System.out.println(s);
        System.out.println(s1);
//        LocalSendHelper.sendData("");
    }

    @Override
    public void onUserLogoutAction_CallBack(String s, Object o, Channel channel) {
        System.out.println(s);
        System.out.println(o);
    }

    @Override
    public void onTransBuffer_C2C_CallBack(Protocal protocal) {
        System.out.println("收到了客户端"+protocal.getFrom()+"发给客户端"+protocal.getTo()+"的消息：str="+protocal.getDataContent());
    }


    @Override
    public boolean onTransBuffer_C2C_RealTimeSendFaild_CallBack(Protocal protocal) {
        return false;
    }

    @Override
    public boolean onTransBuffer_C2S_CallBack(Protocal protocal, Channel channel) {
        return false;
    }
}
