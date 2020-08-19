package com.hl.vuewe.controller.im;

import net.openmob.mobileimsdk.server.event.MessageQoSEventListenerS2C;
import net.openmob.mobileimsdk.server.protocal.Protocal;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * @author apple
 */
@Controller
public class MessageQosEventS2cListnerImpl implements MessageQoSEventListenerS2C {

    @Override
    public void messagesBeReceived(String s) {

    }

    @Override
    public void messagesLost(ArrayList<Protocal> arrayList) {

    }
}
