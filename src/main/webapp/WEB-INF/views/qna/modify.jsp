<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="format-detection" content="telephone=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/idangerous.swiper.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700%7CDancing+Script%7CMontserrat:400,700%7CMerriweather:400,300italic%7CLato:400,700,900' rel='stylesheet' type='text/css' />
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" />
    <!--[if IE 9]>
        <link href="css/ie9.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link rel="shortcut icon" href="/resources/img/favicon-6.ico" />
</head>
<body class="style-10">

    <!-- LOADER -->
    <div id="loader-wrapper">
        <div class="bubbles">
            <div class="title">loading</div>
            <span></span>
            <span id="bubble2"></span>
            <span id="bubble3"></span>
        </div>
    </div>

            <div class="content-push">

                <div class="breadcrumb-box">
                    <a href="/">홈</a>
                    <a href="/qna/list">리스트</a>
                    <a href="#">문의내용 수정</a>
                </div>

                <div class="information-blocks">
                    <div class="row">
                        
                        <div class="col-md-9 col-md-push-3 information-entry">
                            <div class="blog-landing-box type-1 detail-post">
                                <div class="blog-entry">
                                    <h3 class="additional-blog-title">수정 하기</h3>
                                    <form id="modifyForm" method="post">
                                        <input type='hidden' name='memberNo' value="${qna.memberNo}"> 
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>글 제목 <span>*</span></label>
                                                <input class="simple-field" type="text" name="title" placeholder="글 제목 (입력)" value="${qna.title}" />
                                            </div>    
                                            <div class="col-md-3">    
                                                <label>상품번호 <span>*</span></label>
                                                <input class="simple-field" type="text" name="goodsNo" placeholder="상품번호 (입력)" value="${qna.goodsNo}" />
                                                <div class="clear"></div>
                                            </div>
                                            <div class="col-sm-12">
                                                <label>글 내용 <span>*</span></label>
                                                <textarea class="simple-field" name="content" placeholder="무엇을 도와드릴까요? (입력)">${qna.content}</textarea>
                                                <div class="button style-10">수정하기<input type="submit" value="" /></div>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>

                

            </div>

        <div class="clear"></div>


    <script src="/resources/js/jquery-2.1.3.min.js"></script>
    <script src="/resources/js/idangerous.swiper.min.js"></script>
    <script src="/resources/js/global.js"></script>

    <!-- custom scrollbar -->
    <script src="/resources/js/jquery.mousewheel.js"></script>
    <script src="/resources/js/jquery.jscrollpane.min.js"></script>
</body>
</html>
