<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

<script src="/resources/js/require/requireInsert.js"></script>
<link href="/resources/css/require/requireInsert.css" rel="stylesheet" type="text/css"></link>

</head>

<body class="style-10">
  <!-- LOADER -->
  <div id="loader-wrapper">
    <div class="bubbles">
      <div class="title">loading</div>
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>


  <%-- Main 영역 시작 --%>
  
  <div class="breadcrumb-box">
    <a href="#">Home</a> <a href="#">공구요청</a>
  </div>

  <div class="content-push">
    <div class="information-blocks">
      <div class="row">
        <div class="col-md-10 col-md-push-1 information-entry">
          <div class="blog-landing-box type-1 detail-post">

            <div class="blog-entry">
              <h3 class="additional-blog-title">Ask For the Group Purchase</h3>
              <form id="formTag" method="post" action="/require/insert">
                <div class="row">
                  <div class="col-sm-6">
                    <label>상품이름 <span>*</span></label> <input
                      class="simple-field" type="text" name="title" value="" required />
                      
                    <label>희망가격 <span>*</span></label> <input
                      class="simple-field" type="number" name="price" value="" required />
                    
                    <label>회사명(제조사) <span>*</span></label> <input
                      class="simple-field" type="text" name="company" value="" required />
                        
                    <label>요청내용 <span>*</span></label>
                    <textarea class="simple-field" required name="content"
                      placeholder="상품정보 등을 입력해주세요."></textarea>
                    <div class="clear"></div>
                  </div>
                  
                  <div class="col-sm-6">
                      <label id="imageLabel">Image <span>*</span></label>
                      <div class="button style-11 col-sm-12" id="uploadBtn" data-toggle="tooltip" title="이미지는 한장만 업로드해주세요">
                        Upload Image
                      </div>
                      <input type="file" id="fileUpload">
                  </div>
                  <div class="col-sm-6">
                    <div class="imageDiv"></div>
                   </div>
                  
                  <div class="col-sm-12">
                    <div class="button style-10 btnDiv" id="sendBtn" > Send <input type="submit" value="" /> </div> 
                    <div class="button style-10 btnDiv"><a href="/require/list">GO LIST </a></div> 
                  </div>
                </div>
              </form>
            </div>

          </div>
        </div>
        <br><br><br>
      </div>
    </div>
  </div>
 <div class="clear"></div>
 
<%-- Main 영역 종료 --%>

</body>




