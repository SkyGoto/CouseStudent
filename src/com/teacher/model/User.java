package com.teacher.model;

import java.util.Date;

public class User {
    private long uid;  // 唯一标志
    private String username;
    private String password;
    private String name;
    private String sex;
    private int age;
    private String email;
    private String telephone;
    private Date birthday;
    private int state; //  状态：0=未激活，1=已激活
    private String code; //  激活码
    private String place ;   // 用户的身份   0 管理员 1 教师  2 学生

    public User() {}

    public User(long uid, String username, String password, String name, String sex, int age, String email, String telephone, Date birthday, int state, String code, String place) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.birthday = birthday;
        this.state = state;
        this.code = code;
        this.place = place;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", state=" + state +
                ", code='" + code + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
