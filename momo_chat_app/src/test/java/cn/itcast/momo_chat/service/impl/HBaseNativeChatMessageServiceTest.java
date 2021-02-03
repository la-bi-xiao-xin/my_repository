package cn.itcast.momo_chat.service.impl;

import cn.itcast.momo_chat.entity.Msg;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class HBaseNativeChatMessageServiceTest {

    @Test
    public void getMassage() throws IOException {
        HBaseNativeChatMessageService hBaseNativeChatMessageService = new HBaseNativeChatMessageService();
        List<Msg> massage = hBaseNativeChatMessageService.getMassage("2020-09-11", "15187066291", "15236208916");
        for (Msg msg : massage) {
            System.out.println(msg);
        }
    }
}