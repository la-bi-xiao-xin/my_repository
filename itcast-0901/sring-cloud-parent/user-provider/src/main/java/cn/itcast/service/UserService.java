package cn.itcast.service;

import cn.itcast.pojo.User;

public interface UserService {

    /**
     * 根据id查询用户信息
     */
    public User findById(int id);

}
