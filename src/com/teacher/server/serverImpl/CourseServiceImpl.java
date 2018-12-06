package com.teacher.server.serverImpl;

import com.teacher.dao.CourseDao;
import com.teacher.dao.daoImpl.CourseDaoImpl;
import com.teacher.model.Course;
import com.teacher.model.User;
import com.teacher.server.CourseService;

import java.sql.SQLException;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    @Override
    public List listMyCourse(User user, int page) throws SQLException {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.listMyCourse(user,page);
    }

    @Override
    public List<Course> listThisCourse(String course) throws SQLException {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.listThisCourse(course);
    }

    @Override
    public int getCourseNum(User user) throws SQLException {
        CourseDao courseDao = new CourseDaoImpl();
        return courseDao.getCourseNum(user);
    }
}
