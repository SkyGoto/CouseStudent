package com.teacher.model;

import java.util.Date;

public class Student extends User{
    private String sclass;

    public String getSclass() {
        return sclass;
    }

    public void setClass(String sclass) {
        this.sclass = sclass;
    }

    public Student(long uid, String username, String password, String name, String sex, int age, String email, String telephone, Date birthday, int state, String code, String place, String sclass) {
        super(uid, username, password, name, sex, age, email, telephone, birthday, state, code, place);
        this.sclass = sclass;
    }

    public Student(User user) {
        super(user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(),user.getSex(),user.getAge(),
                user.getEmail(),user.getTelephone(),user.getBirthday(),user.getState(),user.getCode(),user.getPlace());
    }

    public Student() {}

    @Override
    public String toString() {

        return "Student{" +super.toString()+
                "sclass='" + sclass + '\'' +
                '}';
    }
}

