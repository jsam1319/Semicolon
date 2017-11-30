<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no, minimal-ui"/>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/idangerous.swiper.css" rel="stylesheet" type="text/css" />
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700%7CDancing+Script%7CMontserrat:400,700%7CMerriweather:400,300italic%7CLato:400,700,900' rel='stylesheet' type='text/css' />
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" />
    <!--[if IE 9]>
        <link href="css/ie9.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link rel="shortcut icon" href="/resources/img/favicon-6.ico" />
  	<title></title>
<script>
$(document).ready(function(){	
	
	var page = 1;
	
	$.getJSON("/qna/" + page, function(data){
		
		var str = printList(data);
		
		if(str == ""){
			str += 
	        	'<div class="container-404">'+
	       		 	'<div class="description hidden-xs" >이력이 없습니다.</div>'+
	       		 	'<div class="text">글을 작성하여 주십시오.</div>'
	       		 '</div>';
		}
		
		$("#replies").append(str);
	});
	
	$(document).on("click", "#reply", function(event) {
    	$(this).next().slideToggle();
	});
	
	$('.moreView').each(function(i){
		  $(this).click(function(e){
			  e.preventDefault();
			  page++;
			  
			  $.ajax({
				  url: "/qna/" + page,
				  dataType: "json",
				  success: function(data){
					  var str = printList(data)
					  $("#replies").append(str);
				  },
				  error: function(data){
					  console.log(data)
				  }
			  });
		  });
	  });
});

function printList(data) {
	var str = "";
	console.log(data);
	$(data.list).each(
			function(){
				var status = "";
				if( this.status == '0') status = "미확인";
				else status = "확인";
				
				var regdate = this.regdate.trim();	
				
				var date = regdate.split(" ")[0];
				var time = regdate.split(" ")[1];
				
				var mon = date.split("-")[1];
                var day = date.split("-")[2];
                
                var timeString = "";
                
                var date1 = new Date();
                var date2 = new Date(regdate);
                
                if( (date1 - date2 - 86400000) > 0) timeString = time;
                else								timeString = moment(regdate).fromNow();
                
                var answer = "";
                if( this.answerContent == null ) {
                	answer = "아직 읽지 않았습니다.. 잠시만 기다려주세요.."; 
                	if (${no }== -1) {
						answer = "<a class='style-19' href='/qna/rewrite/" + this.qnaNo + "' id='rewrite'>답변작성</a>";
					} 
                } else {
                	answer = this.answerContent.replace(/\n/gi, "<br>");
                }
                
      			str += '<div class="blog-entry" id="qnalist">';
      			str += '<div class="date hidden-xs" id="date">' + day + '<span>' + mon + '</span></div>';
      			str += '<div class="content">';
      			str += '<a class="title" href="/qna/read/' + this.qnaNo + '">' + this.title + '</a>';
      			str += '<div class="subtitle">' + timeString + '  /  ';
      			str += '<span style="font-weight:bold">' + status + '</span>';
      			str += '</div>';
      			str += '<div class="description">' + this.content.replace(/\n/gi, "<br>") + '</div>';
                    
      			str += '<div class="accordeon-title" id="reply" >문의 답변</div>';
      			str += '<div class="accordeon-entry">';
      			str += '<div class="article-container style-1">';
      			str += '<p>' + answer + '</p>';
      			str += '</div>';
      			str += '</div>';
      			str += '</div>';
      			str += '</div>';
      		});
	
	return str;
}
</script>
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
                    <a href="/qna/list">문의 리스트</a>
                </div>
                <div class="col-md-5 EnterDiv"></div>

                <div class="information-blocks col-md-10 RequestDiv">
                    <div class="row">
                        
                        <div class="information-entry">
                            <div class="blog-landing-box type-2">
                              <div class="accordeon" id="replies"></div>
                                <c:if test="${no != -1 }">
                                    <a class="button style-14 RequestBtn" href="/qna/regist">문의 작성</a>
                                    <div class="enterContent-6"></div>
                                </c:if>
                              <div class="page-selector">
                                 <a class="moreView"><i class="fa fa-angle-down"></i></a>
                            </div>
                           </div> 
                        </div>

                    </div>
                </div>
                
                <div class="enterContent-2"></div>
            </div>

        <div class="clear"></div>
        
        
    <script src="/resources/js/moment.js"></script>
    <script src="/resources/js/ko.js"></script>
    <script src="/resources/js/jquery-2.1.3.min.js"></script>
    <script src="/resources/js/idangerous.swiper.min.js"></script>
    <script src="/resources/js/global.js"></script>

    <!-- custom scrollbar -->
    <script src="/resources/js/jquery.mousewheel.js"></script>
    <script src="/resources/js/jquery.jscrollpane.min.js"></script>
</body>
</html>
