package com.teacher.server.serverImpl;

import com.teacher.dao.UserDao;
import com.teacher.dao.daoImpl.UserDaoImpl;
import com.teacher.model.Student;
import com.teacher.model.Teacher;
import com.teacher.model.User;
import com.teacher.server.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public void userRegist(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        if ("admin".equals(user.getPlace())) {
            userDao.userRegist(user);
        }else if ("teacher".equals(user.getPlace())) {
            Teacher teacher = new Teacher(user);
            userDao.userRegist(teacher);
        }else {
//            Student student = (Student) user;
            Student student = new Student(user);
            userDao.userRegist(student);  //学生
        }
    }

    @Override
    public boolean userActive(String code) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        Student student = userDao.studentActive(code);
        Teacher teacher = userDao.teacherActive(code);
        if (null != student) {
            student.setState(1);
            student.setCode(null);
            userDao.updateUser(student);
            return true;
        }else if (null != teacher) {
            teacher.setState(1);
            teacher.setCode(null);
            userDao.updateUser(teacher);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User userLogin(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user1 =  userDao.userLogin(user);
        if (null == user1){
            throw new RuntimeException("密码或账号不正确!");
        }else if (user1.getState() == 0) {
            throw  new RuntimeException("用户未激活!");
        }else {
            return user1;
        }
    }

}
