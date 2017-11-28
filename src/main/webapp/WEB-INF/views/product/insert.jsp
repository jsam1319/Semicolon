<%@ page language="java" pageEncoding="UTF-8"%>
 
<head>

<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>

<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

<script src="/resources/js/gpurchase/insert.js"></script>
<link href="/resources/css/gpurchase/insert.css" rel="stylesheet" type="text/css"></link>

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
                <div class="contact-spacer"></div>
                <div class="information-blocks">
                    <div class="row">
                    <form id="registerForm" role="form" method="post" action="/product/insert">
                        <div class="col-md-12 information-entry">
                            <h3 class="block-title main-heading">공구 사전조사 등록</h3>
                                <div class="row">
                                      <div class="col-sm-6" id="divmargin">
                                          <label>공구상품 <span>*</span></label>
                                          <input class="simple-field" type="text" name="title" value="${goods.name}" disabled readonly />
                                      </div>
                                      <div class="col-sm-6">
                                          <label>공구진행날짜 <span>*</span></label>
                                          <input class="simple-field" type="text" name="date" id="date" />
                                          <div class="clear"></div>
                                      </div>
                                      
                                      <div class="col-sm-6">
                                          <label>최소인원 <span>*</span></label>
                                          <input class="simple-field" type="number" name="min" placeholder="최소인원" value=""  required/>
                                          <div class="clear"></div>
                                      </div>
                                      <div class="col-sm-6">
                                          <label>가격(￦) <span>*</span></label>
                                          <input class="simple-field" type="number" name="price" value="" required />
                                          <div class="clear"></div>
                                      </div>
                                    <input type="hidden" name="goodsNo" value="${goods.goodsNo }">
                                    <input type="hidden" name="category" value="${goods.category}">
                                      
                              </div>
                        </div>
                        <div id="imageButtonDiv">
                           <a class="button style-10">REGISTER<input type="submit" id="" value="" /></a>
                        </div>
                       </form>
                    </div>
                </div>
                <br><br>
            </div>
        <div class="clear"></div>  

</body>


