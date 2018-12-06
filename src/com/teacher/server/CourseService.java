package com.teacher.server;

import com.teacher.model.Course;
import com.teacher.model.User;

import java.sql.SQLException;
import java.util.List;

public interface CourseService {
    List listMyCourse(User user, int page) throws SQLException;

    List<Course> listThisCourse(String course) throws SQLException;

    int getCourseNum(User user) throws SQLException;
}
