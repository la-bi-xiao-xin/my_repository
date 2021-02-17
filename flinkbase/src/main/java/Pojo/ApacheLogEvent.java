package Pojo;

import lombok.Data;

@Data
public class ApacheLogEvent {
    String ip;      // 访问ip
    int userId;     // 用户id
    String times; // 访问时间戳
    String method;  // 访问方法
    String path;    // 访问路径

    public ApacheLogEvent(String ip, int userId, String times, String method, String path) {
        this.ip = ip;
        this.userId = userId;
        this.times = times;
        this.method = method;
        this.path = path;
    }
}
