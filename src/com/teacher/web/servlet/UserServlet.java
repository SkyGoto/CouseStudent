package com.teacher.web.servlet;

import com.teacher.model.Student;
import com.teacher.model.Teacher;
import com.teacher.model.User;
import com.teacher.server.UserService;
import com.teacher.server.serverImpl.UserServiceImpl;
import com.teacher.utils.MailUtils;
import com.teacher.utils.MyBeanUtils;
import com.teacher.utils.UUIDUtils;
import com.teacher.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
    /**
     * 注册界面
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */ //注册界面
    public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/jsp/regist.jsp";
    }

    /**
     * 注册
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */  //注册
    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        MyBeanUtils.populate(user, request.getParameterMap());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());
//        System.out.println(user);
        UserService studentService = new UserServiceImpl();
        try {
            studentService.userRegist(user);
            MailUtils.sendMail(user.getEmail(),user.getCode());
            request.setAttribute("msg", "注册成功,请激活!");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "注册失败,请重新注册!");
        }
        return "/info.jsp";
    }

    /**
     * 用户激活
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */ //用户激活
    public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        UserService userService = new UserServiceImpl();
        boolean flag = false;
        try {
            flag = userService.userActive(code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag) {
            request.setAttribute("msg","激活成功!");
            return "info.jsp";
        }else {
            request.setAttribute("msg","激活失败!");
            return "info.jsp";
        }
    }

    /**
     * 注册界面
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */ //注册界面
    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        return "/jsp/login.jsp";
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */ //用户登录
    public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        MyBeanUtils.populate(user,request.getParameterMap());
        UserService userService = new UserServiceImpl();
        User user1 = null;
        try {
            user1 = userService.userLogin(user);
            request.getSession().setAttribute("loginUser",user1);
            response.sendRedirect("/index.jsp");
            return null;
        }catch (Exception e) {
            String msg = e.getMessage();
            request.setAttribute("msg",msg);
            return "/jsp/login.jsp";
        }
    }

    /**
     * 用户注销
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */ //用户注销
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/index.jsp");
        return null;
    }








    /**
     * 提取的方法(弃用)
     * @param request
     * @param user
     * @param t
     */ //提取的方法(弃用)
    public  void resolveRegist(HttpServletRequest request, User user, boolean t){
        UserService studentService = new UserServiceImpl();
        try {
            studentService.userRegist((Student) user);
            MailUtils.sendMail(user.getEmail(),user.getCode());
            request.setAttribute("msg", "用户注册成功,请激活!");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "用户注册失败,请重新激活!");
        }
    }
}
