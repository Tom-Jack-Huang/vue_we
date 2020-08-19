package com.hl.vuewe.controller.im;

import net.openmob.mobileimsdk.server.ServerLauncher;
import net.openmob.mobileimsdk.server.qos.QoS4SendDaemonS2C;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @author apple
 */
@Controller
public class ServerLauncherImpl extends ServerLauncher {
    private static ServerLauncherImpl instance = null;

    public static ServerLauncherImpl getInstance() throws IOException {
        if (instance == null) {
            // 设置AppKey
            ServerLauncher.appKey = "5418023dfd98c579b6001741";
            ServerLauncher.PORT = 9901;
            ServerLauncher.debug = true;

            //          ServerLauncherImpl.setSenseMode(SenseMode.MODE_10S);
            instance = new ServerLauncherImpl();

        }
        return instance;
    }

    public ServerLauncherImpl() throws IOException {
        super();
    }

    /**
     *      * 初始化消息处理事件监听者.
     *      
     */

    @Override
    protected void initListeners() {
        // ** 设置回调
        this.setServerEventListener(new ServerEventListenerImpl());
        this.setServerMessageQoSEventListener(new MessageQosEventS2cListnerImpl());
    }

}
