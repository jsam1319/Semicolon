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
			<a href="#">Home</a> <a href="#">Shop</a> <a href="#">T-shirts</a> <a
				href="#">Careers</a> <a href="#">T-shirt Stampata</a>
		</div>

		<div class="information-blocks">
			<div class="row">
				<div class="col-sm-5 col-md-4 col-lg-5 information-entry">
					<div class="product-preview-box">
						<div class="swiper-container product-preview-swiper slider"
							data-autoplay="0" data-loop="1" data-speed="500" data-center="0"
							data-slides-per-view="1">
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
							<div class="detail-info-entry-title">Size</div>
							<div class="entry active size">24</div>
							<div class="entry size">25</div>
							<div class="entry size">26</div>
							<div class="entry size">27</div>
							<div class="entry size">28</div>
							<div class="entry size">29</div>
							<div class="entry size">30</div>
							<div class="spacer"></div>
						</div>
						<div class="information-entry products-list">
							<div class="inline-product-entry">
									<div class="title" id="sizeAnnounce"></div>
									<div class="price">
										<h3 class="compare product-subtitle"></h3>
									</div>
								<div class="clear"></div>
							</div>
						</div>
								
						<div class="color-selector detail-info-entry">
							<div class="detail-info-entry-title">Color</div>
							<div class="entry active" style="background-color: #d23118;">&nbsp;</div>
							<div class="entry" style="background-color: #2a84c9;">&nbsp;</div>
							<div class="entry" style="background-color: #000;">&nbsp;</div>
							<div class="entry" style="background-color: #d1d1d1;">&nbsp;</div>
							<div class="spacer"></div>
						</div>
						<div class="quantity-selector detail-info-entry">
							<div class="detail-info-entry-title">Quantity</div>
							<div class="entry number-minus">&nbsp;</div>
							<div class="entry number">1</div>
							<div class="entry number-plus">&nbsp;</div>
						</div>
						<div class="detail-info-entry btnDiv">
            
              
              <script>
              
              
              <!-- 공구재요청 -->
              var string = "";
            	  if(${gpurchase.status} == 1) {
            		  string += "<a class='button style-10'><i class='fa fa-heart'></i>구매하기</a>"
            		  
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
            	  
            	  $(".btnDiv").html(str)
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
              
							<div class="clear"></div>
						</div>
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
												<a href="#" class="title">Pullover Batwing Sleeve Zigzag</a>
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
												<a href="#" class="title">Pullover Batwing Sleeve Zigzag</a>
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
												<a href="#" class="title">Pullover Batwing Sleeve Zigzag</a>
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
		</div>
		<div class="clear"></div>

		<div id="productInfo1"></div>

		<div class="information-blocks">
			
			<!-- 체형별 상품 비교 -->
			<div class="tags-selector detail-info-entry">
				<div class="detail-info-entry-title">Tags:</div>
					<a href="#">bootstrap</a>/ <a href="#">collections</a> 
					<a href="#">color/</a>/ <a href="#">responsive</a>
			</div>
			<!----------------------->
			
			
			<div>
				<a class="button style-14" href="#productInfo1">상세 정보</a> <a
					class="button style-40" href="#productInfo2">상품 리뷰</a> <a
					class="button style-40" href="#productInfo3">유의 사항</a>
			</div>

			<div class="inline-product-entry"></div>

			<div id="productInfo2"></div>
			<br> <br> <br> <br> <br>
			<div>
				<a class="button style-40" href="#productInfo1">상세 정보</a> <a
					class="button style-14" href="#productInfo2">상품 리뷰</a> <a
					class="button style-40" href="#productInfo3">유의 사항</a>
			</div>


            <c:choose>
            <c:when test="${gpurchase.status == 1}">
			<div class="inline-product-entry">
				<form id="replyform" method="post" enctype="multipart/form-data">
					<div class="row">
						<div class=" col-md-8">
							<label>리뷰 작성<span>*</span></label>
							<textarea class="simple-field" style="resize: none;" id="content"
								name="content" placeholder="Your message content (required)"></textarea>
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
				<center>
					<a class="moreView"> <i class="fa fa-angle-down"></i>
					</a>
				</center>
			</div>

			<div id="productInfo3"></div>

			<br /> <br /> <br /> <br /> <br />

			<div id="productInfo1">
				<a class="button style-40" href="#productInfo1">상세 정보</a> <a
					class="button style-40" href="#productInfo2">상품 리뷰</a> <a
					class="button style-14" href="#productInfo3">유의 사항</a>
			</div>
      <c:choose>
      <c:when test="${gpurchase.status == 1 }">
			<div class="inline-product-entry">
      <p>진행중인 공동구매입니다. </p>
      <p>공동구매 상품이므로 반품은 불가능합니다. </p>
      </div>
      </c:when>
      <c:when test="${gpurchase.status == 2 }">
      <div class="inline-product-entry">
      <p>마감된 공동구매입니다. </p>
      <p>해당 상품 공동구매를 원하시면 재공구요청을 해주세요. </p>
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
	<script src="/resources/js/product.js"></script>
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
					  console.log(data);
					  var str = printList(data)
					  $("#reviewList").append(str);
				  },
				  error: function(data){
					  console.log(data)
				  }
			  })
		  })
	  })
	
	$(document).on("click", "#removeBtn", function(event){
		
		var reviewNo = $(this).attr("title");
		
		var removetag = $(this).parent().parent().parent();
		
		console.log(removetag);
		
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
