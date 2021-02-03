package cn.itcast.momo_chat.service.impl;

import cn.itcast.momo_chat.entity.Msg;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PhoenixChatMessageServiceTest {

    @Test
    public void getMassage() throws Exception {
        PhoenixChatMessageService phoenixChatMessageService = new PhoenixChatMessageService();
        List<Msg> massage = phoenixChatMessageService.getMassage("2020-09-11", "15187066291", "15236208916");
        for (Msg msg : massage) {
            System.out.println(msg);
        }
    }
}