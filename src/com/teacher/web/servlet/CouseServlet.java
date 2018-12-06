package com.teacher.web.servlet;

import com.teacher.model.Course;
import com.teacher.model.User;
import com.teacher.server.CourseService;
import com.teacher.server.serverImpl.CourseServiceImpl;
import com.teacher.utils.MyBeanUtils;
import com.teacher.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CouseServlet",urlPatterns = "/Course")
public class CouseServlet extends BaseServlet {
    public String MycourseUI(HttpServletRequest request, HttpServletResponse response  ){
        User user = (User) request.getSession().getAttribute("loginUser");
        if(isNotLogin(user,request)) return "/info.jsp";
        CourseService courseService = new CourseServiceImpl();
        int page = 1,allPage = 1;
        List myCourse=null;
        page = request.getParameter("page") == null? 1:Integer.parseInt(request.getParameter("page")) ;
        try {
            myCourse =  courseService.listMyCourse(user,page);
            allPage = courseService.getCourseNum(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("myCourses",myCourse);
        request.getSession().setAttribute("pageNum",allPage);
        request.getSession().setAttribute("nowPage",page);
        request.getSession().setAttribute("nowPlace",user.getName()+"的课程");
        return "courses.jsp";
    }

    public String getCourseInfo(HttpServletRequest request, HttpServletResponse response ){
        User user = (User) request.getSession().getAttribute("loginUser");
        if(isNotLogin(user,request)) return "/info.jsp";
        String course = request.getParameter("course");
        CourseService courseService = new CourseServiceImpl();
        List<Course> thisCourse = null;
        try {
            thisCourse = courseService.listThisCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        MyBeanUtils.populate(user,request.getParameterMap());
        request.getSession().setAttribute("thisCourse",thisCourse);
        request.getSession().setAttribute("nowPlace",thisCourse.get(0).getCourse_name());
        return "thisCourses.jsp";
    }


    private boolean isNotLogin(User user,HttpServletRequest request){
        if ( user == null){
            String msg = "请先登录!";
            request.setAttribute("msg",msg);
            return true;
        }
        return false;
    }
}
