package com.teacher.dao;

import com.teacher.model.Student;
import com.teacher.model.Teacher;
import com.teacher.model.User;

import java.sql.SQLException;

public interface UserDao {
    void userRegist(User user) throws SQLException;
    void userRegist(Student student) throws SQLException;
    void userRegist(Teacher teacher)throws SQLException;
    Student studentActive(String code)throws SQLException;
    Teacher teacherActive(String code)throws SQLException;
    void updateUser(Student student)throws SQLException;
    void updateUser(Teacher teacher)throws SQLException;
    User userLogin(User user) throws SQLException;
}
