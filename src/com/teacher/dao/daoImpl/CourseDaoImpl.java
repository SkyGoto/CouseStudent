package com.teacher.dao.daoImpl;

import com.teacher.dao.CourseDao;
import com.teacher.model.Cou_Stu;
import com.teacher.model.Course;
import com.teacher.model.User;
import com.teacher.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public List listMyCourse(User user, int page) throws SQLException {
        int listNum = 6;
        String sql = "SELECT * FROM course_student WHERE student_uuid = ? limit ? ,?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List list =  queryRunner.query(sql, new BeanListHandler<Cou_Stu>(Cou_Stu.class),user.getUid(),(listNum*(page-1)),listNum);
        return list;
    }

    @Override
    public List<Course> listThisCourse(String course) throws SQLException {
        String sql = "SELECT * FROM course WHERE course_id = ? ORDER BY course_time";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List list = queryRunner.query(sql,new BeanListHandler<Course>(Course.class),course);
        return list;
    }

    @Override
    public int getCourseNum(User user) throws SQLException {
        int listNum = 6;
        String sql = "SELECT COUNT(*) FROM course_student WHERE student_uuid = ? ";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Long num =  queryRunner.query(sql,new ScalarHandler<>(),user.getUid());
        return  (int)Math.ceil(num.intValue()/(double)listNum);
    }
}
