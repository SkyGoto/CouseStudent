<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <title>Hello World</title>

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
    <div class="row"><div class="col-12 offset-lg-1 col-lg-1"></div>
        <div class="col-xs-12 col-md-12">
            <header class="course-info entry-header flex flex-wrap justify-content-between align-items-center">
                <div class="flex"><h3>作业提交情况:&nbsp;&nbsp;</h3><%--<h3 style="color:red">已交</h3>--%></div>
                <div class="number-of-lectures"></div>
                <div class="total-lectures-time"> <div class="flex"><h2>分数:</h2> <h2 style="color:red">100</h2></div></div>
            </header>
            <div class="course-info "></div>
            <c:out value="${homeworkInfo}" escapeXml="false" />
            <div class="course-info "></div>
        </div>

    </div>
</div>
</body>
</html>
