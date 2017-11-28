<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8"%>

<head>
<script>

//멤버 사이즈
var userSize = new Object;
//상품 사이즈
var productSize = new Object;
//베스트 사이즈
var bestSize = new Object;

$(document).ready(function(){
	$(".compare").append();   
 	console.log("memberno:${no}"); 
	matchBest();
	
	$(".size").click(function(){
	   changeSizeGap($(this).text());
	});
	
	
});

//가장 적합한 사이즈를 반환
var matchBest = function(){
     $.ajax({
    url : "/size/get/${no}/${goods.goodsNo}",
    type : "get",
    dataType : "json",
    success : function(data){
        console.log(data); 
        print(data);
        $("#sizeAnnounce").html("회원님에게 적합한 사이즈는 "+data.sizes+" 입니다.");
    },
    error : function(xhr, statusText){
        console.log("("+xhr.status+", "+statusText+")"); 
    }
 }); 
}

 //사이즈 비교 결과 띄어줌
var print = function(data){
    
	 console.log(data.types); 
    
    $(".compare").html("이 "+data.sizes+"은(는) 회원님의 <br>");
    
    if(data.types == 'pants' || data.types == 'shortPants' || data.types == 'skirt'){
        letter('허리',data.waist);
        
        if(data.types != 'skirt'){
	        letter('밑위',data.rise);
	        letter('허벅지',data.thigh);
        }
        
        letter('엉덩이',data.hip);
    }
    else{ //상의
        var num = productSize.sleeveLength - userSize.sleeve;
        letter('소매길이', data.sleeveLength);
    }
    
    letter('총 길이', data.fullLength);
}
 


var letter = function(body, num){
    $(".compare").append(body+" 사이즈와 "+num+" 차이가 납니다.<br>");
} 

//사용자가 클릭할 때마다 사이즈 차이 변환
var changeSizeGap = function(data){
   console.log("size:"+data); 
     $.ajax({
       url : "/size/get/${no}/"+data+"/${goods.goodsNo}",
       type : "get",
       dataType : "json",
       success : function(data){
           print(data);
       },
       error : function(xhr, statusText){
           console.log("("+xhr.status+", "+statusText+")"); 
       }
    }); 
}



</script>
</head>

<body class="style-10">

  <!-- LOADER -->
  <div id="loader-wrapper">
    <div class="bubbles">
      <div class="title">loading</div>
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>

  <!-- HEADER -->
  <div class="header-wrapper style-10">
    <div class="clear"></div>
  </div>

  <div class="content-push container">

    <div class="breadcrumb-box">
      <a href="#">Home</a> <a href="#">Shop</a> <a href="#">T-shirts</a>
      <a href="#">Careers</a> <a href="#">T-shirt Stampata</a>
    </div>
    
  <form action="/order/" method="post" id="orderForm">
    <div class="information-blocks">
      <div class="row">
        <div class="col-sm-5 col-md-4 col-lg-5 information-entry">
          <div class="product-preview-box">
            <div class="swiper-container product-preview-swiper slider"
              data-autoplay="0" data-loop="1" data-speed="500"
              data-center="0" data-slides-per-view="1">
              <div class="swiper-wrapper">
                <div class="swiper-slide">
                  <div class="product-zoom-image">
                    <img src="/resources/img/ex/cat.jpg" alt=""
                      data-zoom="/resources/img/ex/cat-zoom.png" />
                  </div>
                </div>
                <div class="swiper-slide">
                  <div class="product-zoom-image">
                    <img src="/resources/img/ex/dog.jpg" alt=""
                      data-zoom="/resources/img/ex/dog-zoom.png" />
                  </div>
                </div>
              </div>

              <!-- Add Pagination -->
              <div class="swiper-pagination"></div>

              <div class="pagination"></div>
              <div class="product-zoom-container">
                <div class="move-box">
                  <img class="default-image"
                    src="/resources/img/product-main-1.jpg" alt="" /> <img
                    class="zoomed-image"
                    src="/resources/img/product-main-1-zoom.jpg" alt="" />
                </div>
                <div class="zoom-area"></div>
              </div>
            </div>
          </div>
        </div>

        <!-- 상품 정보 -->
          <div class="col-sm-7 col-md-4 information-entry">
            <div class="product-detail-box">
              <h1 class="product-title">${goods.name}</h1>
              <h3 class="product-subtitle">${companyName}</h3>

              <div class="rating-box" id="avgGrade"></div>

              <div class="price detail-info-entry">
                <div class="current">￦ ${gpurchase.price}</div>
              </div>
              <div class="size-selector detail-info-entry">
                <div class="detail-info-entry-title sizeDiv">Size</div>
                
                <!-- 상의/하의 구분해 데이터 출력  -->
                <c:forEach var="size" items="${size}">
                  <c:choose>
                    <c:when test="${size.TOPSNO != null}">
                      <div class="entry size" name="TOP" id="${size.TOPSNO}">${size.SIZES}</div>
                    </c:when>
                    <c:when test="${size.BOTTOMNO != null}">
                      <div class="entry size" name="BOTTOM" id="${size.BOTTOMNO}">${size.SIZES}</div>
                    </c:when>
                  </c:choose>
                </c:forEach>
                
              </div>
              
              <script>
            $(document).ready(function(){
            	
            	var no = 0;
            	
            	/** 주문항목 추가 */
            	$(".size").on("click", function(){
            		var pSize = $(this).html()	// size 이름 (ex XS/S/M...)
            		var pNum = $(this).attr("id")	// 상의/하의 PK
            		
            		
            		$(this).addClass("active")
            		
            		var str = "";
            		no += 1
            		
            		/** 이미 선택한 사이즈인지 체크 / 선택한 사이즈면 return */
            		if ($("#"+pNum+"qt").length == 1) {
						return;
            			
					} else {
						
            		str += "<div class='article-container style-1' id='"+no+"'>"
                    str += "	<div class='col-sm-4 checkDiv1 inline-product-column-title'> - "+pSize+" </div>"
                    str += "	<div class='col-sm-6 checkDiv2'>"
                    str += "		<div class='quantity-selector detail-info-entry qtnChoice'>"
                    str += "			<div class='entry number-minus minus'>&nbsp;</div>"
                    str += "			<div class='entry number quantity' name='quantity' id='"+pNum+"qt'>1</div>"
                    str += "			<div class='entry number-plus plus'>&nbsp;</div>"
                    str += "		</div>"
                    str += "	</div>"
                    str += "	<div class='col-sm-1 xMark'>"
                    str += "		<i class='fa fa-times '></i>"
                    str += "	</div>"
                    str += "</div>"
            		
            		$(".orderItem").append(str)
            		
            		
            		var hiddenStr = "";
                    
                    var qtP = $("#"+pNum+"qt").html()
                    
                    
                    if ($(".size").attr("name") == 'TOP') {
                    	hiddenStr += "<input type='hidden' name='topsNo' value='"+pNum+"'>"
					} else {
            			hiddenStr += "<input type='hidden' name='bottomNo' value='"+pNum+"'>"
            		 	
					}
                    
            		hiddenStr += "<input type='hidden' class='"+pNum+"qt' name='qty' value='"+qtP+"'>"
            		hiddenStr += "<input type='hidden' name='sizes' value='"+pSize+"'>"
            		
            		$("#"+no+"").append(hiddenStr)
            		
					}
            		
            	})
            	
            	/** 상품 갯수 +/- */
            	$(document).on("click", ".plus", function(){
            		var qtIdP = $(this).prev().attr("id")	// 상의/하의 pk +qt
            		var qtP = $("#"+qtIdP).html()
            		qtP = Number(qtP)
            		
            		qtP += 1
            		
            		$("#"+qtIdP).html(qtP)	// +된 데이터 붙여주기
            		$("."+qtIdP+"").val(qtP)	// name='qty'의 value 넣어주기
            		
            	})
            	
            	$(document).on("click", ".minus", function(){
            		var qtIdM = $(this).next().attr("id")
            		var qtM = $("#"+qtIdM).html()
            		qtM = Number(qtM)
            		
            		if (qtM > 1) {
            			qtM -= 1
            			
            			$("#"+qtIdM).html(qtM)
            			$("."+qtIdM+"").val(qtM)
					}
            	})
            	
           
            	/** 선택한 상품 삭제 */
            	 $(document).on("click", ".xMark", function(){
            		 $(this).parent().remove();
            		 
            	 })
            	
            	 
            	 $("#orderForm").submit(function(e){
            		e.preventDefault();
            		
            		var gpurchaseNo = '${gpurchase.gpurchaseNo}'
                		var qty = $("input[name='qty']")
                		var sizes = $("input[name='sizes']")
                			
                		if ($(".size").attr("name") == 'TOP') {	
                			var topsNo = $("input[name='topsNo']")
                			var type = 'top'
                		} else {
                			var bottomNo = $("input[name='bottomNo']")
                		}
                		 
                		
            		var OrderList;
            		var OlList = new Array();
            		
            		 for (var i = 0; i < qty.length; i++) {
            			  
            			 if (type == 'top') {
                				 OrderList = {
         								'topsNo' : topsNo[i].value,
         								'gpurchaseNo' : gpurchaseNo,
         								'qty' : qty[i].value,
         								'sizes' : sizes[i].value
         						}
						} else {
    							OrderList = {
    									'bottomNo' : bottomNo[i].value, 
    									'gpurchaseNo' : gpurchaseNo,
    									'qty' : qty[i].value,
         								'sizes' : sizes[i].value
    							}
						}
						 
            			 OlList.push(OrderList)
					}
                		  
            		 
                		 var OLJson = JSON.stringify(OlList) 
                		 
                		 var submitStr = "<input type='hidden' name='orderList' value='"+OLJson+"'>"
            		
                		 $(this).append(submitStr)
                		 
                		 $(this).get(0).submit();
            		
            	 })
            	  
            	 
            	 /** 구매 버튼 클릭 시 데이터 전송 */
            	 /* 
            	 $(document).on("click", ".purchaseBtn", function(){
            		 
            		var gpurchaseNo = '${gpurchase.gpurchaseNo}'
            		var qty = $("input[name='qty']")
            		var sizes = $("input[name='sizes']")
            			
            		if ($(".size").attr("name") == 'TOP') {	
            			var topsNo = $("input[name='topsNo']")
            			var type = 'top'
            		} else {
            			var bottomNo = $("input[name='bottomNo']")
            		}
            		 
            		
            		var OrderList;
            		var OlList = new Array();
            		
            		 for (var i = 0; i < qty.length; i++) {
            			  
            			 if (type == 'top') {
                				 OrderList = {
         								'topsNo' : topsNo[i].value,
         								'gpurchaseNo' : gpurchaseNo,
         								'qty' : qty[i].value,
         								'sizes' : sizes[i].value
         						}
						} else {
    							OrderList = {
    									'bottomNo' : bottomNo[i].value, 
    									'gpurchaseNo' : gpurchaseNo,
    									'qty' : qty[i].value,
         								'sizes' : sizes[i].value
    							}
						}
						 
            			 OlList.push(OrderList)
					}
            		  
            		 console.log("OlList")
            		 console.log(OlList)
            		 
            		 $.ajax({
							url : "/order/",
							type: "POST",
							data: {
								orderList : JSON.stringify(OlList)
								},
							success: function(data){
								console.log(data)
								window.location.href = data;
							},
							error: function(data){
								console.log("error!!");
								console.log(data)
							}
						})
            		  
            		 
            	 })
            	  */
            })
            </script>
            
              <div class="orderListDiv col-sm-12">
                <div class="accordeon">
                  <div class="accordeon-title">주문항목</div>
                  <!-- 주문항목 appendDiv -->
                  <div class="accordeon-entry orderItem" style="display: block;">
                  </div>
                  <!-- /.주문항목 appendDiv -->
                </div>
              </div>
              
              <div class="col-sm-12 enterContent-3"></div>
              <div class="purchaseNum">
                <div class="col-sm-5 pNumDiv">(${gpurchase.pNum} /
                  ${gpurchase.min}) 참여</div>
                <div class="detail-info-entry btnDiv">
                  <div class="clear"></div>
                </div>
              </div>
              <div class="col-sm-7 enterContent-3"></div>

              <div class="detail-info-entry buttonDiv">
                <div class="clear"></div>
              </div>


              <script>
              <!-- 공구재요청 -->
              var string = "";
            	  if(${gpurchase.status} == 1) {
            		  string += "<a class='button style-15 purchaseBtn'><i class='fa fa-heart'></i>구매하기"
            		  // style-10
            		  string += "<input type='submit' value=''>"
            		  
            		  $(".btnDiv").html(string)
            	  } else {
            		  askBtn("${askCnt}")
            	  }
              
              function askBtn(askCheck) {
            	  var str = "";
            	  if(askCheck == 0) {
            		  str += "<a class='button style-10 askresale'>재공구요청</a>"
            	  } else {
            		  str += "<a class='button style-10 askcancle'>요청취소</a>"
            	  }
            	  
            	  $(".buttonDiv").html(str)
              }

              
              
              var gpurchaseNo = ${gpurchase.gpurchaseNo}
              
              $(document).on("click", ".askresale", function(event){
            	  askCheck(0, gpurchaseNo)
            	  event.stopImmediatePropagation()
              })
              $(document).on("click", ".askcancle", function(event){
            	  askCheck(1, gpurchaseNo)
            	  event.stopImmediatePropagation()
              })
              
              function askCheck(askCk, gpNo){ 
            	  $.ajax({
            		  url: "/product/askck/"+askCk+"/"+gpNo,
            		  type: "POST",
            		  data: {
            			  "memberNo" : "${no}"
            		  },
            		  success: function(askCheck){
            			  askBtn(askCheck)
            		  },
            		  error: function(data){
            			  console.log(data)
            		  }
            	  })
            	  
              }
              </script>


            </div>
          </div>
        <!-- /.상품 정보 -->


        <div class="clear visible-xs visible-sm"></div>

        <!-- Side 추천 상품 정보 -->
        <div class="col-md-4 col-lg-3 information-entry product-sidebar">
          <div class="row">
            <div class="col-md-12">
              <div class="information-blocks">
                <div class="information-entry products-list">
                  <h3 class="block-title inline-product-column-title">Featured
                    products</h3>
                  <div class="inline-product-entry">
                    <a href="#" class="image"><img alt=""
                      src="/resources/img/product-image-inline-1.jpg"></a>
                    <div class="content">
                      <div class="cell-view">
                        <a href="#" class="title">Pullover Batwing
                          Sleeve Zigzag</a>
                        <div class="price">
                          <div class="prev">$199,99</div>
                          <div class="current">$119,99</div>
                        </div>
                      </div>
                    </div>
                    <div class="clear"></div>
                  </div>

                  <div class="inline-product-entry">
                    <a href="#" class="image"><img alt=""
                      src="/resources/img/product-image-inline-2.jpg"></a>
                    <div class="content">
                      <div class="cell-view">
                        <a href="#" class="title">Pullover Batwing
                          Sleeve Zigzag</a>
                        <div class="price">
                          <div class="prev">$199,99</div>
                          <div class="current">$119,99</div>
                        </div>
                      </div>
                    </div>
                    <div class="clear"></div>
                  </div>

                  <div class="inline-product-entry">
                    <a href="#" class="image"><img alt=""
                      src="/resources/img/product-image-inline-3.jpg"></a>
                    <div class="content">
                      <div class="cell-view">
                        <a href="#" class="title">Pullover Batwing
                          Sleeve Zigzag</a>
                        <div class="price">
                          <div class="prev">$199,99</div>
                          <div class="current">$119,99</div>
                        </div>
                      </div>
                    </div>
                    <div class="clear"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /.Side 추천 상품 정보 -->
      </div>
      
      <div class="enterContent-1"></div>
      
       <!-- 상품 Keyword(Tag) -->
      <div class="tags-selector detail-info-entry col-sm-6">
        <div class="detail-info-entry-title">Tags: </div>
       <c:forEach var="keyword" items="${keyword}">
          <a href="#">${keyword}</a>&nbsp;
          <c:if test="${not status.last }">/&nbsp; </c:if>
       </c:forEach>
      </div>
      <!-- /.상품 Keyword(Tag) -->
      
    </div>
    </form>
    <div class="clear"></div>

    <div id="productInfo1"></div>
    <div class="information-blocks">
    <div class="enterContent-4"></div>
      <div>
        <a class="button style-14" href="#productInfo1">상세 정보</a> <a
          class="button style-40" href="#productInfo2">상품 리뷰</a> <a
          class="button style-40" href="#productInfo3">유의 사항</a>
      </div>

      <div class="inline-product-entry">${goods.detail}</div>

      <div id="productInfo2"></div>
      
      <div class="enterContent-4"></div>
      <div>
        <a class="button style-40" href="#productInfo1">상세 정보</a> <a
          class="button style-14" href="#productInfo2">상품 리뷰</a> <a
          class="button style-40" href="#productInfo3">유의 사항</a>
      </div>


      <c:choose>
        <c:when test="${gpurchase.status == 1}">
          <div class="inline-product-entry">
            <form id="replyform" method="post"
              enctype="multipart/form-data">
              <div class="row">
                <div class=" col-md-8">
                  <label>리뷰 작성<span>*</span></label>
                  <textarea class="simple-field" style="resize: none;"
                    id="content" name="content"
                    placeholder="Your message content (required)"></textarea>
                </div>
                <div class="col-md-4">
                  <div style="margin-top: 10%">
                    <input type="file" id="attachFile" name="attachFile"
                      accept="image/*">
                  </div>

                  <div id="targetType" style="margin-top: 10%"></div>
                  <div id="targetType-hint" class="input hint"></div>

                  <div class="button style-10" style="margin-top: 10%">
                    리뷰 작성<input type="button" id="reviewBtn" value="">
                  </div>
                </div>
              </div>
            </form>
          </div>
        </c:when>
      </c:choose>

      <div id="reviewList"></div>

      <div class="page-selector">
          <a class="moreView"> <i class="fa fa-angle-down"></i>
          </a>
      </div>

      <div id="productInfo3"></div>
<div class="enterContent-4"></div>
      <div>
        <a class="button style-40" href="#productInfo1">상세 정보</a> <a
          class="button style-40" href="#productInfo2">상품 리뷰</a> <a
          class="button style-14" href="#productInfo3">유의 사항</a>
      </div>
      <c:choose>
        <c:when test="${gpurchase.status == 1 }">
          <div class="inline-product-entry">
            <p>진행중인 공동구매입니다.</p>
            <p>공동구매 상품이므로 반품은 불가능합니다.</p>
            <p>구매는 한번에 한 상품씩 가능합니다.</p>
          </div>
        </c:when>
        <c:when test="${gpurchase.status == 2 }">
          <div class="inline-product-entry">
            <p>마감된 공동구매입니다.</p>
            <p>해당 상품 공동구매를 원하시면 재공구요청을 해주세요.</p>
          </div>
        </c:when>
      </c:choose>
    </div>
  </div>

  <div class="clear"></div>

  <br>
  <br>

  <script src="/resources/js/moment.js"></script>
  <script src="/resources/js/ko.js"></script>
  <script src="/resources/js/gpurchase/product.js"></script>
  <script src="/resources/js/jquery.raty.js"></script>
  <script>

$(function() {
	
	var goodsNo = ${goods.goodsNo}
	
	$.getJSON("/review/" + goodsNo, function(data){
        
		var str = '';
		
		for(var i = 0; i < data; i++){
			str += '<div class="star">';
			str += '<i class="fa fa-star"></i>';
			str += '</div>';
		}
        
		for(var j = 0; j < 5-data; j++){
			str += '<div class="star">';
			str += ' <i class="fa fa-star-o"></i>';
			str += '</div>';
		}
		
		
		$("#avgGrade").html(str);
    });
	
	var page = 1;
    
    var gpurchaseNo = ${gpurchase.gpurchaseNo};
    
    $('#targetType').raty({
		cancel     : true,
		target     : '#targetType-hint',
		targetType : 'score'
	});
      
	$.getJSON("/review/" + gpurchaseNo + "/" + page, function(data){
        
		var str = printList(data);
        
        $("#reviewList").prepend(str);
    });
    
    
	$("#reviewBtn").click(function(){
		
		var contentObj = $("#content");
		var fileObj = $("#attachFile");
		
		var memberNo = ${no};
		var goodsNo = ${goods.goodsNo};
		var grade = $("#targetType").raty("score");
		var content = contentObj.val();
		var attachFile = fileObj.val();

		var replyform = document.getElementById("replyform");
		
		var formdata = new FormData(replyform);
		formdata.append("memberNo", memberNo);
		formdata.append("goodsNo", goodsNo);
		formdata.append("grade", grade);
		
		$.ajax({
			type: "post",
			url: "/review/",
			data: formdata,
			processData: false,
			contentType: false,
			success: function(data){
    				
    			contentObj.val("");
    			fileObj.val("");
    			$ ('#targetType').raty('score', 0);
    				
    			page = 1;
    		        
    			var str = printList(data);
    		        
    		    $("#reviewList").prepend(str);
    		    
    		    $.getJSON("/review/" + goodsNo, function(data){
    		        
    				var str = '';
    				
    				for(var i = 0; i < data; i++){
    					str += '<div class="star">';
    					str += '<i class="fa fa-star"></i>';
    					str += '</div>';
    				}
    		        
    				for(var j = 0; j < 5-data; j++){
    					str += '<div class="star">';
    					str += ' <i class="fa fa-star-o"></i>';
    					str += '</div>';
    				}
    				
    				
    				$("#avgGrade").html(str);
    		    });
			}
			
		});
		
	});
	
	$('.moreView').each(function(i){
		  $(this).click(function(e){
			  e.preventDefault();
			  page++;
			  
			  $.ajax({
				  url: "/review/" + gpurchaseNo + "/" + page,
				  dataType: "json",
				  success: function(data){
					 /*  console.log(data); */
					  var str = printList(data)
					  $("#reviewList").append(str);
				  },
				  error: function(data){
					 /*  console.log(data) */
				  }
			  })
		  })
	  })
	
	$(document).on("click", "#removeBtn", function(event){
		
		var reviewNo = $(this).attr("title");
		
		var removetag = $(this).parent().parent().parent();
		
		/* console.log(removetag); */
		
		$.ajax({
	        type:'delete',
	        url:'/review/'+reviewNo,	
	        headers: { 
	              "Content-Type": "application/json",
	              "X-HTTP-Method-Override": "DELETE" },
	        dataType:'text', 
	        success:function(result){
	          console.log("result: " + result);
	          if(result == 'SUCCESS'){
	            alert("삭제 되었습니다.");
	            removetag.remove();
	          }
	      }});
	});
      
  });
  
function printList(data) {
  
  var str = "";
  
  $(data.list).each( function(){
	  
	  var regdate = this.regdate == undefined ? '' : this.regdate.trim();	
		
	  var date = regdate.split(" ")[0];
	  var time = regdate.split(" ")[1];
		
	  var mon = date.split("-")[1];
      var day = date.split("-")[2];
      
      var timeString = "";
      
      var date1 = new Date();
      var date2 = new Date(regdate);
      
      if( (date1 - date2 - 86400000) > 0) timeString = time;
      else								  timeString = moment(regdate).fromNow();
      
    str += '<div class="wishlist-entry">';
    str += '<div class="column-1">';
    str += '<div class="comment">';
    str += '<a class="comment-image" href="#"><img src="/resources/images/' + this.attachFile + '" /></a>';
    str += '<div class="comment-content">';
    str += '<div class="comment-title"><span>' + this.memberNo + '</span> Posted ' + timeString + ', ' + date + '</div>';
    
    var grade = this.grade;
    var staro = 5 - grade;
    
    str += '<div class="rating-box">';
    
    for(var i = 0; i < grade; i++){
    	
    	str += '<div class="star">';
        str += '<i class="fa fa-star"></i>';
        str += '</div>';
        
    }
    
    for(var i = 0; i < staro; i++){
    	str += '<div class="star">';
        str += '<i class="fa fa-star-o"></i>';
        str += '</div>';
    }
    
    str += '</div>';
    
    str += '<div class="comment-text">' + this.content.replace(/\n/gi, "<br>") + ' </div>';
    str += '</div>';
    str += '</div>';
    str += '</div>';
    str += '<div class="column-2">';
    str += '<a class="button style-14">더보기</a>';
    str += '<a class="remove-button"><i class="fa fa-times" title="' + this.reviewNo + '" id="removeBtn"></i></a>';
    str += '</div> ';
    str += '</div>';
  });

  return str;
}
</script>
  <link href="/resources/css/gpurchase.css" rel="stylesheet"
    type="text/css"></link>

</body>
