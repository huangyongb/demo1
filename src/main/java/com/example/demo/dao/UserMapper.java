package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(username,password) VALUES (#{username},#{md5Password})")
    void registerInsert(String username, String md5Password);

    @Select("SELECT * FROM user WHERE username=#{username} and password=#{md5Password}")
    User loginSelect(String username, String md5Password);
    @Update("UPDATE user SET username=#{username} WHERE id=#{id}")
    boolean updateUserById(String username, int id);
    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteUerById(int id);
    @Select("SELECT username FROM user WHERE id=#{id}")
    String getUserById(int id);
}
