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
#inputFile{
    display: none;
}

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
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>

  <div class="content-push">

    <div class="breadcrumb-box">
      <a href="#">홈</a> <a href="#">A/S 자세히 보기</a>
    </div>

    <div class="information-blocks">
      <div class="row">

        <div class="col-md-9 col-md-push-2 information-entry">
          <div class="blog-landing-box type-1 detail-post">
            <div class="blog-entry">
              <h3 class="additional-blog-title">${member.id }님의 A/S 상세보기 </h3>
                <div class="row">
                  <div class="col-md-3">
                    <label>이름</label> 
                    <input class="simple-field" type="text" name="name" value="${member.name }" readonly="readonly" />
                    <div class="clear"></div>
                  </div>
                  
                  <div class="col-md-3">
                    <label>나이</label> 
                    <input class="simple-field" type="text" name="age" value="${member.age }" readonly="readonly" />
                    <div class="clear"></div>
                  </div>
                  
                  <div class="col-md-3">
                    <label>연락가능한 번호</label> 
                    <input class="simple-field" type="text" name="phone" value="${member.phone }" readonly="readonly" />
                    <div class="clear"></div>
                  </div>
                  
                  <div class="col-md-3">
                    <label>성별</label> 
                    <input class="simple-field" type="text" name="gender" value="${member.gender }" readonly="readonly" />
                    <div class="clear"></div>
                  </div>

                  <div class="col-md-6">
                    <label>주소</label> 
                    <input class="simple-field" type="text" name="address" value="${member.address }" readonly="readonly" />
                    <div class="clear"></div>
                  </div>
                  
                  <div class="col-md-3">
                    <label>우편번호</label> 
                    <input class="simple-field" type="text" name="postcode" value="${member.postcode }" readonly="readonly" />
                    <div class="clear"></div>
                  </div>
                  
                  <div class="image col-md-4"">
                    <img src="/resources/images/${after.attachFile }">
                  </div>
                  
                  <div class="col-sm-8">
                    <label>글 내용</label>
                    <textarea class="simple-field" name="content" style="resize: none;" readonly="readonly">${after.content }</textarea>
                    <a href="/after/update/${after.aftersalesNo }" class="button style-12">접수하기</a>
                    <a href="/after/list" class="button style-10">뒤로가기</a>
                  </div>
                  </div>
                </div>
              
            </div>
          </div>
        </div>
        
      </div>
    </div>

  <div class="clear"></div>


</body>
</html>
