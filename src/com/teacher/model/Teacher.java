package com.teacher.model;

import java.util.Date;

public class Teacher extends User {
    public Teacher() {
    }

    public Teacher(long uid, String username, String password, String name, String sex, int age, String email, String telephone, Date birthday, int state, String code, String place) {
        super(uid, username, password, name, sex, age, email, telephone, birthday, state, code, place);
    }

    public Teacher(User user) {
        super(user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getSex(), user.getAge(),
                user.getEmail(), user.getTelephone(), user.getBirthday(), user.getState(), user.getCode(), user.getPlace());
    }
}
