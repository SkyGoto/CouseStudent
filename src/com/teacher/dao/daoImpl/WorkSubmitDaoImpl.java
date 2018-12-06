package com.teacher.dao.daoImpl;

import com.teacher.dao.WorkSubmitDao;
import com.teacher.model.Course;
import com.teacher.model.HomeWork;
import com.teacher.model.User;
import com.teacher.utils.JDBCUtils;
import com.teacher.utils.SnowFlake;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


public class WorkSubmitDaoImpl implements WorkSubmitDao {
    /**
     * 保存用户上传的文件
     * @param user
     * @param fileName
     * @param course
     * @throws SQLException
     */
    @Override
    public void saveFile(User user, String fileName, Course course) throws SQLException {
        if (readFileInfo(user,course) == null){
//            之前没提交过
            String sql = "INSERT INTO homework VALUES (?,?,?,?,?,?,?,?)";
            QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
            long nowFlake =  SnowFlake.nextId(0,0);
            Object [] params = {nowFlake, course.getCourse_time(), null, fileName, course.getCourse_id(), user.getUid(), null, null};
            queryRunner.update(sql,params);
        }else {
//            之前已经提交过了
            String sql = "UPDATE homework SET taskContent = ? WHERE  taskTime = ? and courseId = ? and studentId = ? ";
            QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
            Object [] params = {
                    fileName,
                    course.getCourse_time(),
                    course.getCourse_id(),
                    user.getUid()
            };
            queryRunner.update(sql,params);
        }
    }

    /**
     * 查看(用户)的作业
     * @param user
     * @param course
     * @return
     */
    @Override
    public HomeWork readFileInfo(User user, Course course) throws SQLException {
        String sql = "SELECT * FROM homework WHERE taskTime = ? and courseId = ? and studentId = ? ";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object [] params = {
                course.getCourse_time(),
                course.getCourse_id(),
                user.getUid()
        };
        return queryRunner.query(sql,new BeanHandler<HomeWork>(HomeWork.class),params);
    }

}
