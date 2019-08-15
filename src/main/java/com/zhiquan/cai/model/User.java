package com.zhiquan.cai.model;

/**
 *
 * @类名：User
 * @author ：zhiquan
 * @功能描述：用户表的实体类
 */
public class User{
    private int id;
    private String username;
    private String password;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
            "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", age=" + age
            ;
    }
}