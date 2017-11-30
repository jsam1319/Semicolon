<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    
<script>
$(document).ready(function(){
	
	var page = 1;
	var memberNo = ${no};
	
	

	$.getJSON("/after/" + memberNo + "/" + page , function(data){
		var str = afterList(data);
		//$("#afterDiv").append(str);
		if(str == ""){
			str += 
	        	'<div class="container-404">'+
	       		 	'<div class="description hidden-xs" >이력이 없습니다.</div>'+
	       		 	'<div class="text">글을 작성하여 주십시오.</div>'
	       		 '</div>';
		}
		$("#afterDiv").append(str);
	});
	
	$(document).on("click", "#afterText", function(event) {
    	$(this).next().slideToggle();
	});
	
	$(document).on("click", "#afterDetail", function(event) {
		$("form").attr("action", "/after/select" );
		$("form").attr("method", "get");
		$("form").submit();
	});
	
	$('.moreView').each(function(i){
		  $(this).click(function(e){
			  e.preventDefault();
			  page++;
			  
			  $.ajax({
				  url: "/after/" + memberNo + "/" + page,
				  dataType: "json",
				  success: function(data){
					  console.log(data);
					  var str = afterList(data)
					  $("#afterDiv").append(str);
				  },
				  error: function(data){
					  console.log(data)
				  }
			  })
		  })
	  });
	
});

function afterList(data){
	var str = '';
	
	
	
	$(data.list).each(
			function(){
				
				var status = "";
				if( this.status == '0') status = '<span class="inline-label green">접수중</span>';
				else status = '<span class="inline-label red">접수완료</span>';
				
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
				
                
				str += '<div class="accordeon-title" id="afterText">' + this.regdate + status;
				if(${no} == -1){
					str += '<p>회원번호 : ' + this.memberNo + '</p>';
				}
				str += '</div>';
				str += '<div class="accordeon-entry">';
				str += '<div class="article-container style-1">';
				str += '<div class="image"><img width="200px" src="/resources/images/' + this.attachFile + '"></div>';
				
				str += '<p>' + this.content + '</p>';
				
				if(this.status == '1'){
					str += '<blockquote class="latest-review">';
    				str += '<div class="text">"접수가 완료 되었습니다! 감사합니다!"</div>';
    				str += '<footer><cite><이 재 삼 대표> 010-7574-7591</cite></footer>';
    				str += '</blockquote>';
				}else{
					if(${no} == -1){
						str += '<a class="button style-7" href="/after/' + this.aftersalesNo + '">자세히보기</a>';
					}
				}
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
                    <a href="/admin/">마이페이지</a>
                    <a href="/after/list">A / S 리스트</a>
                </div>
                <div class="col-md-5 EnterDiv"></div>
                
                <div class="information-blocks col-md-10 RequestDiv">
                    <div class="row">
                        <div class="information-entry">
                        <div class="blog-landing-box type-2">
                         <div class="accordeon" id="afterDiv"></div>
                            <c:if test="${no != -1 }">
                                <a class="button style-10 RequestBtn" href="/after/regist">작성하기</a>
                                <div class="enterContent-6"></div>
                            </c:if>
                         <div class="page-selector">
                           <a class="moreView"><i class="fa fa-angle-down"></i></a>
                         </div>
                        </div>
                      </div>
                    </div>

                  </div>
                </div>

              <div class="clear"></div>
              
    <script src="/resources/js/global.js"></script>
    <script src="/resources/js/moment.js"></script>
    <script src="/resources/js/ko.js"></script>
    <script src="/resources/js/jquery-2.1.3.min.js"></script>
    <script src="/resources/js/idangerous.swiper.min.js"></script>
    

    <!-- custom scrollbar -->
    <script src="/resources/js/jquery.mousewheel.js"></script>
    <script src="/resources/js/jquery.jscrollpane.min.js"></script>             
    
</body>
</html>
