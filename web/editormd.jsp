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

    <link rel="stylesheet" href="./editormd/css/editormd.min.css">
    <link rel="stylesheet" href="css/commons.css">
</head>
<body class="courses-page">

<%@ include file="header.jsp"%>

<div class="container">


        <div class="col embed-responsive embed-responsive-21by9">
            <iframe  src="./pdfjs/web/viewer.html?file=../../upload/test.pdf" frameborder="0"></iframe>
        </div>
    <hr style="border: 1px solid #c0c0c0">
    <div for="test-editormd" class="control-label  text-center course-info "><h1>可重复提交,以最后一次为准</h1></div>
        <div class="col">
            <form class="form-horizontal" method="post" action="/WorkSubmit?method=WorkSubmit&workId=${submitCourse.course_id}&workTime=${submitCourse.course_time}" enctype="multipart/form-data">
                <div class="form-group">

                    <!--class="editormd"-->
                    <div id="test-editormd" class="col-sm-10">
                        <!--实际内容-->
                        <textarea style="display:none;" class="test-editormd-markdown-doc" name="content"
                                  placeholder="请输入内容" id="content"></textarea>
                        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                        <textarea class="editormd-html-textarea" name="text" id="text"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-1"></div>
                        <div class="col-md-6">

                            <div class="col-xs-12 col-sm-8 col-md-8">
                                <div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
                                    <button class="btn btn-success fileinput-button" type="button">文件上传</button>
                                    <input type="file" name="fileupload" id="jobData" onchange="loadFile(this.files[0])" style="position:absolute;top:0;left:0;font-size:34px; opacity:0">
                                </div>
                                <span id="filename" style="vertical-align: middle">未上传文件</span>
                            </div>
                        </div>
                        <div class="col-5">
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                    </div>

                </div>
            </form>
        </div>
</div>
<script src="./jquery/jquery.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<script src="./editormd/js/editormd.min.js"></script>
<script type="text/javascript">
    $(function () {
        editormd("test-editormd", {
            width: "100%",
            height: 640,
            syncScrolling: "single",
            tocm: false, // Using [TOCM]
            tex: true, // 开启科学公式TeX语言支持，默认关闭
            flowChart: false, // 开启流程图支持，默认关闭
            //static->editormd/lib/
            path: "./editormd/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea: true,
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/WorkSubmit?method=uploadImages&workId=${submitCourse.course_id}&workTime=${submitCourse.course_time}",
            onload: function () {
                this.width("80%");
                this.height("80%");
            }
        });
    });
</script>
<script>
    function loadFile(file){
        $("#filename").html(file.name);
    }
</script>
</body>
</html>
