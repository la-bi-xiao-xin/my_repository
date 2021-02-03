package cn.itcast.momo_chat.service;

import cn.itcast.momo_chat.entity.Msg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ChatMessageService {
    public List<Msg> getMassage(String date, String sender, String receiver ) throws Exception;
    public void close() throws IOException, SQLException, Exception;
}
