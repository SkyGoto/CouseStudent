package com.teacher.server.serverImpl;

import com.teacher.dao.WorkSubmitDao;
import com.teacher.dao.daoImpl.WorkSubmitDaoImpl;
import com.teacher.model.Course;
import com.teacher.model.HomeWork;
import com.teacher.model.User;
import com.teacher.server.WorkSubmitService;

import java.sql.SQLException;

public class WorkSubmitServiceImpl implements WorkSubmitService {
    @Override
    public void saveFile(User user, String fileName, Course course) throws SQLException {
        WorkSubmitDao workSubmitDao = new WorkSubmitDaoImpl();
        workSubmitDao.saveFile(user,fileName,course);
    }

    @Override
    public HomeWork readFileInfo(User user, Course course) throws SQLException {
        WorkSubmitDao workSubmitDao = new WorkSubmitDaoImpl();
        return workSubmitDao.readFileInfo(user,course);
    }
}
