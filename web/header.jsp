<%--
  Created by IntelliJ IDEA.
  User: misaki
  Date: 11/15/18
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="page-header">
    <header class="site-header">
        <div class="top-header-bar">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-6 d-none d-md-flex flex-wrap justify-content-center justify-content-lg-start mb-3 mb-lg-0">
                        <div class="header-bar-email d-flex align-items-center">
                            <i class="fa fa-envelope"></i><a href="#">tuanna.design@gmail.com</a>
                        </div><!-- .header-bar-email -->

                        <div class="header-bar-text lg-flex align-items-center">
                            <p><i class="fa fa-phone"></i>001-1234-88888 </p>
                        </div><!-- .header-bar-text -->
                    </div><!-- .col -->

                    <div class="col-12 col-lg-6 d-flex flex-wrap justify-content-center justify-content-lg-end align-items-center">
                        <div class="header-bar-search">
                            <form class="flex align-items-stretch">
                                <input type="search" placeholder="What would you like to learn?">
                                <button type="submit" value="" class="flex justify-content-center align-items-center"><i class="fa fa-search"></i></button>
                            </form>
                        </div><!-- .header-bar-search -->

                        <div class="header-bar-menu">
                            <ul class="flex justify-content-center align-items-center py-2 pt-md-0">
                                <c:if test="${empty loginUser}">
                                    <li><a href="/UserServlet?method=registUI">注册</a></li>
                                    <li><a href="/UserServlet?method=loginUI">登录</a></li>
                                </c:if>
                                <c:if test="${not empty loginUser}">
                                    <li><a href="#">欢迎! ${loginUser.name }</a></li>
                                    <li><a href="/UserServlet?method=logOut">注销</a></li>
                                </c:if>
                            </ul>
                        </div><!-- .header-bar-menu -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container-fluid -->
        </div><!-- .top-header-bar -->

        <div class="nav-bar">
            <div class="container">
                <div class="row">
                    <div class="col-9 col-lg-3">
                        <div class="site-branding">
                            <h1 class="site-title"><a href="index.jsp" rel="home">Easy<span>Learn</span></a></h1>
                        </div><!-- .site-branding -->
                    </div><!-- .col -->

                    <div class="col-3 col-lg-9 flex justify-content-end align-content-center">
                        <nav class="site-navigation flex justify-content-end align-items-center">
                            <ul class="flex flex-column flex-lg-row justify-content-lg-end align-content-center">
                                <li class="current-menu-item"><a href="/">首页</a></li>
                                <li><a href="#">关于</a></li>
                                <li><a href="/Course?method=MycourseUI">课程</a></li>
                                <li><a href="#">博客</a></li>
                                <li><a href="#">联系我们</a></li>
                            </ul>

                            <div class="hamburger-menu d-lg-none">
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>
                            </div><!-- .hamburger-menu -->

                            <div class="header-bar-cart">
                                <a href="#" class="flex justify-content-center align-items-center"><span aria-hidden="true" class="icon_bag_alt"></span></a>
                            </div><!-- .header-bar-search -->
                        </nav><!-- .site-navigation -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .nav-bar -->
    </header><!-- .site-header -->

    <div class="page-header-overlay">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <header class="entry-header">
                        <h1>${nowPlace}</h1>
                    </header><!-- .entry-header -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .page-header-overlay -->
</div><!-- .page-header -->
</body>
</html>
