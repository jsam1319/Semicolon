<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="format-detection" content="telephone=no" />
    <link href="/resources/css/semantic.css" rel="stylesheet" type="text/css" />
    <!--[if IE 9]>
        <link href="css/ie9.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link rel="shortcut icon" href="/resources/img/favicon-6.ico" />
    <script src="/resources/js/semantic.js"></script>
<style>

#preview{
    z-index: 9999;
    position:absolute;
    border:0px solid #ccc;
    background:#333;
    padding:1px;
    display:none;
    color:#fff;
}
</style>    
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
                    <a href="#">홈</a>
                    <a href="#">문의 보내기</a>
                </div>

                <div class="information-blocks">
                    <div class="row">
                        
                        <div class="col-md-9 col-md-push-3 information-entry">
                            <div class="blog-landing-box type-1 detail-post">
                                <div class="blog-entry">
                                    <h3 class="additional-blog-title">1 : 1 문의 하기</h3>
                                    <form id="registerForm" method="post">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>글 제목 <span>*</span></label>
                                                <input class="simple-field" type="text" name="title" placeholder="글 제목 (입력)" value="" />
                                            </div>    
                                            <!-- <div class="col-md-3">    
                                                <label>상품번호 <span>*</span></label>
                                                <input class="simple-field" type="text" name="goodsNo" placeholder="상품번호 (입력)" value="" />
                                                <div class="clear"></div>
                                            </div> -->
                                            <div class="col-md-3">
                                              <label>상품검색 <span>*</span></label>
                                              <div class="ui inline dropdown button" id="dropdown">
                                                <span class="text" id="choose">Choose Category</span>
                                                <i class="dropdown icon"></i>
                                                <div class="menu">
                                                  <div class="item">
                                                    <i class="dropdown icon"></i>
                                                    <span class="text">Tops</span>
                                                    <div class="menu" id="topsMenu"></div>
                                                  </div>
                                                  <div class="item">
                                                    <i class="dropdown icon"></i> 
                                                    <span class="text">Bottom</span>
                                                    <div class="menu" id="bottomMenu"></div>
                                                  </div>
                                                </div>
                                              </div>
                                              <div class="clear"></div>
                                            </div>
                                            <div class="col-sm-12">
                                                <label>글 내용 <span>*</span></label>
                                                <textarea class="simple-field" name="content" placeholder="무엇을 도와드릴까요? (입력)"></textarea>
                                                <div class="button style-10">보내기<input type="submit" value="" /></div>
                                            </div>
                                            <div id="hiddenData"></div>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>

                

            </div>

        <div class="clear"></div>

    
    <script>
    var goodsNo = "";
    $(document).ready(function(){
    	
    	$('.dropdown').dropdown();
    	
    	$(document).on('click','#dropdown div > a', function() {
    	    // 선택된 항목 값(value) 얻기
    	    goodsName = $(this).text();
    	    goodsNo = $(this).attr('id');
    	});
    	
    	$(document).on("mouseover", ".image", function(e){
    		$("body").append("<p id='preview'><img src='"+ $(this).attr("src") +"' width='150px' /></p>");
    		
    		$("#preview").css("top", 35 + "%")
    		             .css("left", 35 + "%")
    		             .fadeIn("fast");
    	});
    	
    	$(document).on("mousemove", ".image", function(e){
    		$("#preview").css("top", 35 + "%")
    		             .css("left", 35 + "%");
    		
    	});
    	
    	$(document).on("mouseout", ".image", function(){
    		$("#preview").remove();
    	});
    	
		$.getJSON("/goods/list", function(data){
            
    		var str = "";
    		
            $(data).each(function(){
				if(this.category == 1){
					str += '<a class="item" id="' + this.goodsNo + '" ><img class="ui avatar image" src="/resources/img/ex/' + this.frontImg + '">' + this.name + '</a>';
				}
            });
            $("#topsMenu").html(str);
            
            str = "";
            $(data).each(function(){
            	if(this.category == 2){
    				str += '<a class="item" id="' + this.goodsNo + '"><img class="ui avatar image" src="/resources/img/ex/' + this.frontImg + '">' + this.name + '</a>';
  				}
            });
            $("#bottomMenu").html(str);
        });
    	
    });
    
    $("#registerForm").submit(function(event){
    	event.preventDefault();
    	
		var registerForm = document.getElementById("registerForm");
		
		var memberNo = ${no};
		
		var str = "";
		
		str += "<input type='hidden' name='goodsNo' value='" + goodsNo + "'> ";
		str += "<input type='hidden' name='memberNo' value='" + memberNo + "'> ";
		
		$("#hiddenData").append(str);
		
		var formData = new FormData(registerForm);
		
		$(this).get(0).submit();
	});
    </script>
</body>
</html>
