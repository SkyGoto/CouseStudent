package com.teacher.server;

import com.teacher.model.Student;
import com.teacher.model.Teacher;
import com.teacher.model.User;

import java.sql.SQLException;

public interface UserService {
    void userRegist(User user) throws SQLException;
    boolean userActive(String code) throws SQLException;
    User userLogin(User user) throws SQLException;
//    void userRegist(Student student) throws SQLException;
//    void userRegist(Teacher teacher) throws SQLException;
}
