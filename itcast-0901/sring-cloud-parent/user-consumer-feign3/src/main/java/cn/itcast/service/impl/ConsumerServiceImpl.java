package cn.itcast.service.impl;

import cn.itcast.pojo.User;
import cn.itcast.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    // 处理熔断的业务逻辑
    public User findById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setNote("feign 处理熔断的方法... ...");

        return user;
    }
}