package com.teacher.dao;

import com.teacher.model.Course;
import com.teacher.model.HomeWork;
import com.teacher.model.User;

import java.sql.SQLException;

public interface WorkSubmitDao {
    void saveFile(User user, String fileName, Course course) throws SQLException;

    HomeWork readFileInfo(User user, Course course) throws SQLException;
}
