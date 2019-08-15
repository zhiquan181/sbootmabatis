package com.zhiquan.cai.service;

import com.github.pagehelper.Page;
import com.zhiquan.cai.mapper.UserMapper;
import com.zhiquan.cai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    // 获取单个用户信息
    public User selectUser(int id) {
        return userMapper.selectUser(id);
    }

    //获取所有的用户
    public ArrayList<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    //新增用户
    public int insertUser(User u){
        try {
            userMapper.insertUser(u);
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }

    //修改用户
    public int updateUser(User u){
        try {
            userMapper.updateUser(u);
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }

    //删除用户
    public int deleteUser(int id){
        try {
            userMapper.deleteUser(id);
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }

    public Page<User> getUsers() {
        return userMapper.getUsers();
    }
}