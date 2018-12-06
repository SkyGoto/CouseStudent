<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hello World</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">F

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
<body class="single-courses-page">
<%@ include file="header.jsp"%>

    <div class="container">
        <div class="row">
            <div class="col-12 offset-lg-1 col-lg-10">
                <div class="featured-image">
                    <img src="images/single-course-featured-img.jpg" alt="">

                    <div class="course-cost">Free</div>
                </div>
            </div><!-- .col -->
        </div><!-- .row -->

        <div class="row">
            <div class="col-12 offset-lg-1 col-lg-1">
            </div><!-- .col -->

            <div class="col-12 col-lg-8">
                <div class="single-course-wrap">
                    <div class="course-info flex flex-wrap align-items-center">
                        <div class="course-author flex flex-wrap align-items-center mt-3">
                            <img src="images/course-author.jpg" alt="">

                            <div class="author-wrap">
                                <label class="m-0">Teacher</label>
                                <div class="author-name"><a href="#">Ms. Lara Croft</a></div>
                            </div><!-- .author-wrap -->
                        </div><!-- .course-author -->

                        <div class="course-cats mt-3">
                            <label class="m-0">Categories</label>
                            <div class="author-name"><a href="#">Web design</a></div>
                        </div><!-- .course-cats -->

                        <div class="course-students mt-3">
                            <label class="m-0">Student</label>
                            <div class="author-name"><a href="#">26 (REGISTERED)</a></div>
                        </div><!-- .course-students -->

                        <div class="buy-course mt-3">
                            <a class="btn" href="#">ADDED COURSE</a>
                        </div><!-- .buy-course -->
                    </div><!-- .course-info -->


                    <div class="single-course-accordion-cont mt-3">
                        <header class="entry-header flex flex-wrap justify-content-between align-items-center">
                            <h2>Curriculum For This Course</h2>

                            <div class="number-of-lectures">### Lectures</div>

                            <div class="total-lectures-time">##:##:##</div>
                        </header><!-- .entry-header -->

                        <div class="entry-contents">
                            <div class="accordion-wrap type-accordion">
                                <h3 class="entry-title flex flex-wrap justify-content-between align-items-lg-center active">
                                    <span class="arrow-r"><i class="fa fa-plus"></i><i class="fa fa-minus"></i></span>
                                    <span class="lecture-group-title">Introduction to this Course</span>
                                    <span class="number-of-lectures">7 Lectures</span>
                                    <span class="total-lectures-time">21:29</span>
                                </h3>

                                <div class="entry-content">
                                    <ul class="p-0 m-0">
                                        <c:forEach items="${thisCourse}" var="cour">
                                            <li class="flex flex-column flex-lg-row align-items-lg-center">
                                                <span class="lecture-title">${cour.course_info}</span>
                                                <span class="lectures-preview"><a href="/WorkSubmit?method=WorkSubmitUI&workId=${cour.course_id}&workTime=${cour.course_time}&workName=${cour.course_name}">提交作业</a></span>
                                                <span class="lectures-time text-left text-lg-right"><a href="/WorkSubmit?method=SeeSubmitUI&workId=${cour.course_id}&workTime=${cour.course_time}&workName=${cour.course_name}">查看作业</a></span></li>
                                        </c:forEach>

                                    </ul>
                                </div>

                            </div>
                        </div><!-- .entry-contents -->
                    </div><!-- .single-course-accordion-cont  -->




                </div><!-- .single-course-wrap -->
            </div><!-- .col -->
        </div><!-- .row -->
    </div><!-- .container -->

    <div class="clients-logo">
        <div class="container">
            <div class="row">
                <div class="col-12 flex flex-wrap justify-content-center justify-content-lg-between align-items-center">
                    <div class="logo-wrap">
                        <img src="images/logo-1.png" alt="">
                    </div><!-- .logo-wrap -->

                    <div class="logo-wrap">
                        <img src="images/logo-2.png" alt="">
                    </div><!-- .logo-wrap -->

                    <div class="logo-wrap">
                        <img src="images/logo-3.png" alt="">
                    </div><!-- .logo-wrap -->

                    <div class="logo-wrap">
                        <img src="images/logo-4.png" alt="">
                    </div><!-- .logo-wrap -->

                    <div class="logo-wrap">
                        <img src="images/logo-5.png" alt="">
                    </div><!-- .logo-wrap -->
                </div><!-- .col -->
            </div><!-- .row -->
        </div><!-- .container -->
    </div><!-- .clients-logo -->

    <footer class="site-footer">
        <div class="footer-widgets">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="foot-about">
                            <a class="foot-logo" href="#"><img src="images/foot-logo.png" alt=""></a>

                            <p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia dese mollit anim id est laborum. </p>

                            <p class="footer-copyright">
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | made with Colorlib -  More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
</p>
                        </div><!-- .foot-about -->
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-3 mt-5 mt-md-0">
                        <div class="foot-contact">
                            <h2>Contact Us</h2>

                            <ul>
                                <li>Email: info.deertcreative@gmail.com</li>
                                <li>Phone: (+88) 111 555 666</li>
                                <li>Address: 40 Baria Sreet 133/2 NewYork City, US</li>
                            </ul>
                        </div><!-- .foot-contact -->
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-3 mt-5 mt-lg-0">
                        <div class="quick-links flex flex-wrap">
                            <h2 class="w-100">Quick Links</h2>

                            <ul class="w-50">
                                <li><a href="#">About </a></li>
                                <li><a href="#">Terms of Use </a></li>
                                <li><a href="#">Privacy Policy </a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>

                            <ul class="w-50">
                                <li><a href="#">Documentation</a></li>
                                <li><a href="#">Forums</a></li>
                                <li><a href="#">Language Packs</a></li>
                                <li><a href="#">Release Status</a></li>
                            </ul>
                        </div><!-- .quick-links -->
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-3 mt-5 mt-lg-0">
                        <div class="follow-us">
                            <h2>Follow Us</h2>

                            <ul class="follow-us flex flex-wrap align-items-center">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            </ul>
                        </div><!-- .quick-links -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .footer-widgets -->

        <div class="footer-bar">
            <div class="container">
                <div class="row flex-wrap justify-content-center justify-content-lg-between align-items-center">
                    <div class="col-12 col-lg-6">
                        <div class="download-apps flex flex-wrap justify-content-center justify-content-lg-start align-items-center">
                            <a href="#"><img src="images/app-store.png" alt=""></a>
                            <a href="#"><img src="images/play-store.png" alt=""></a>
                        </div><!-- .download-apps -->

                    </div>

                    <div class="col-12 col-lg-6 mt-4 mt-lg-0">
                        <div class="footer-bar-nav">
                            <ul class="flex flex-wrap justify-content-center justify-content-lg-end align-items-center">
                                <li><a href="#">DPA</a></li>
                                <li><a href="#">Terms of Use</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                            </ul>
                        </div><!-- .footer-bar-nav -->
                    </div><!-- .col-12 -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .footer-bar -->
    </footer><!-- .site-footer -->

    <script type='text/javascript' src='js/jquery.js'></script>
    <script type='text/javascript' src='js/swiper.min.js'></script>
    <script type='text/javascript' src='js/masonry.pkgd.min.js'></script>
    <script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
    <script type='text/javascript' src='js/custom.js'></script>

</body>
</html>
