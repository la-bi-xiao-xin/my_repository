package cn.itcast.service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(int id) {
        User user = userMapper.findById(id);
        return user;
    }
}
