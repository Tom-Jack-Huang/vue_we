package com.hl.vuewe.controller;

import com.hl.vuewe.controller.im.ServerLauncherImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

/**
 * @author apple
 */
@Controller
public class AutoApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        ServerLauncherImpl.getInstance().startup();
    }
}
