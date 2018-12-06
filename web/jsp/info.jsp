<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>


    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- ElegantFonts CSS -->
    <link rel="stylesheet" href="css/elegant-fonts.css">

    <!-- themify-icons CSS -->
    <link rel="stylesheet" href="css/themify-icons.css">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="css/swiper.min.css">

    <!-- Styles -->
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="hero-content">
    <header class="site-header">
        <div class="top-header-bar">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-6 d-none d-md-flex flex-wrap justify-content-center justify-content-lg-start mb-3 mb-lg-0">
                        <div class="header-bar-email d-flex align-items-center">
                            <i class="fa fa-envelope"></i><a href="#">mytest.design@gmail.com</a>
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
                                <li class="current-menu-item"><a href="index.jsp">首页</a></li>
                                <li><a href="#">关于</a></li>
                                <li><a href="#">课程</a></li>
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

    <div class="hero-content-overlay">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="hero-content-wrap flex flex-column justify-content-center align-items-start">
                        <header class="entry-header">
                            <h4>开始学习属于自己的在线课程</h4>
                            <h1>最好的在线<br/>学习互动系统</h1>
                        </header><!-- .entry-header -->

                        <div class="entry-content">
                            <!--<p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium</p>-->
                        </div><!-- .entry-content -->

                        <footer class="entry-footer read-more">
                            <a href="#">Learn More</a>
                        </footer><!-- .entry-footer -->
                    </div><!-- .hero-content-wrap -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .hero-content-hero-content-overlay -->
</div><!-- .hero-content -->
<h3>${msg}</h3>
</body>
</html>
