package com.zhiquan.cai.mapper;

import com.github.pagehelper.Page;
import com.zhiquan.cai.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE id = #{id}")
    User selectUser(int id);//返回一个User对象

    @Select("select * from USER order by id")
    ArrayList<User> selectAllUser();//返回一个User List对象

    @Insert("INSERT INTO USER(username,password,age) VALUES(#{username},#{password},#{age})")
    void insertUser(User u);

    @Update("UPDATE user SET username=#{username},password=#{password},age=#{age} WHERE id=#{id}")
    int updateUser(User u);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int deleteUser(int id);

    @Select("select * from user ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "age", column = "age")
    })
    Page<User> getUsers();
}
