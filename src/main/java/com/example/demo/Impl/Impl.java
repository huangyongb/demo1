package com.example.demo.Impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.util.Md5Util;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public class Impl implements UserMapper{
    private final UserMapper userMapper;

    public Impl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void registerInsert(String username,String password){
        String md5Password= Md5Util.getMD5String(password);
        userMapper.registerInsert(username,md5Password);
    }

    @Override
    public User loginSelect(String username, String password) {
        String md5Password=Md5Util.getMD5String(password);
        return userMapper.loginSelect(username,md5Password);
    }
    @Update("UPDATE user SET username=#{username} WHERE id=#{id}")


    @Override
    public boolean updateUserById(String username,int id){
        return userMapper.updateUserById(username,id);
    }
    @Override
    public void deleteUerById(int id){
        userMapper.deleteUerById(id);
    }
    @Override
    public String getUserById(int id){
        return userMapper.getUserById(id);
    }

}
