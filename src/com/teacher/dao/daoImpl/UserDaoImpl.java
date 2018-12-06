package com.teacher.dao.daoImpl;

import com.teacher.dao.UserDao;
import com.teacher.model.Student;
import com.teacher.model.Teacher;
import com.teacher.model.User;
import com.teacher.utils.JDBCUtils;
import com.teacher.utils.SnowFlake;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    static  Map<String, String> studentMap;
    static  Map<String, String> teacherMap;
    static {
        studentMap = new HashMap<String, String>();
        teacherMap = new HashMap<String, String>();
        studentMap.put("student_uuid", "uid");
        studentMap.put("student_username", "username");
        studentMap.put("student_password", "password");
        studentMap.put("student_name", "name");
        studentMap.put("student_sex", "sex");
        studentMap.put("student_age", "age");
        studentMap.put("student_class", "sclass");
        studentMap.put("student_email", "email");
        studentMap.put("student_tel", "telephone");
        studentMap.put("student_birthday", "birthday");
        studentMap.put("student_state", "state");
        studentMap.put("student_code", "code");

    }

    /**
     * 管理员暂时不做处理
     * @param user
     * @throws SQLException
     */
    @Override
    public void userRegist(User user) throws SQLException {
    }

    /**
     * 学生注册
     * @param student
     * @throws SQLException
     */
    @Override
    public void userRegist(Student student) throws SQLException {
        String sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {
                SnowFlake.nextId(0,0),
                student.getUsername(),
                student.getPassword(),
                student.getName(),
                student.getSex(),
                student.getAge(),
                student.getSclass(),
                student.getEmail(),
                student.getTelephone(),
                student.getBirthday(),
                student.getState(),
                student.getCode()};
        qr.update(sql,params);
    }

    @Override
    public void userRegist(Teacher teacher) {}

    @Override
    public Student studentActive(String code) throws SQLException {
//        JavaBean 和 数据库表进行映射
        BeanProcessor beanProcessor = new BeanProcessor(studentMap);
        RowProcessor rowProcessor = new BasicRowProcessor(beanProcessor);
        String sql = "select * from student where student_code=?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Student student =  qr.query(sql, new BeanHandler<Student>(Student.class,rowProcessor),code);
        return student;
    }

    @Override
    public Teacher teacherActive(String code) throws SQLException {
//        JavaBean 和 数据库表进行映射
        return null;
    }

    @Override
    public void updateUser(Student student) throws SQLException {
        String sql = "update student set student_username = ? ,student_password = ? ,student_name = ? ," +
                "student_sex = ? ,student_age = ? ,student_class = ?, student_email = ?, student_tel = ?,student_birthday = ?,student_state = ?," +
                "student_code = ? where student_uuid=?";
        Object[] params = {student.getUsername(),
                student.getPassword(),
                student.getName(),
                student.getSex(),
                student.getAge(),
                student.getSclass(),
                student.getEmail(),
                student.getTelephone(),
                student.getBirthday(),
                student.getState(),
                student.getCode(),
                student.getUid()};
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,params);
    }

    @Override
    public void updateUser(Teacher teacher) throws SQLException {

    }

    @Override
    public User userLogin(User user) throws SQLException {
//        JavaBean 和 数据库表进行映射
        BeanProcessor beanProcessor = new BeanProcessor(studentMap);
        RowProcessor rowProcessor = new BasicRowProcessor(beanProcessor);
        String sql= "select * from student where student_username = ? and student_password = ?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql,new BeanHandler<Student>(Student.class,rowProcessor),user.getUsername(),user.getPassword());
    }
}
