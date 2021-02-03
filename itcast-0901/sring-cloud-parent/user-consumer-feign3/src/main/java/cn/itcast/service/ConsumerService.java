package cn.itcast.service;


import cn.itcast.pojo.User;
import cn.itcast.service.impl.ConsumerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// http://user-provider/user/findById/" + id
// 通过feign 指定服务的名称
@FeignClient(value = "user-provider",
        fallback = ConsumerServiceImpl.class
)
@Service
public interface ConsumerService {

    // 指定资源的路径
    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") Integer id);

}
