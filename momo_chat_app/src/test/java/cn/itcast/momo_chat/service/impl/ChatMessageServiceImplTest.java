package cn.itcast.momo_chat.service.impl;

import cn.itcast.momo_chat.entity.Msg;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ChatMessageServiceImplTest {

    @Test
    public void getMassage() throws IOException {
        //"2020-09-11","15187066291","15236208916"
        ChatMessageServiceImpl chatMessageService = new ChatMessageServiceImpl();
        List<Msg> massage = chatMessageService.getMassage("2020-09-11", "13514684105", "13869783495");
        System.out.println("*****************");
        for (Msg msg : massage) {
            System.out.println("*********************");
            System.out.println(msg);
        }
        System.out.println(massage);

    }

    @Test
    public void close() {
    }
}