$(document).ready(function(){
	var page = 1
	var memberNo = $("#loginMemberNo").val()
	
	/** 글 정렬 후 처음 리스트 붙이기 .html */
	$.getJSON("/product/research/"+page, function(data){ 
		printList(data)
	   }) 
	
   $("#productOrder").on('change',(function(){
	  productOrder = this.value
	  
	  $.ajax({
		  url: "/product/research/"+page,
		  dataType: "json",
		  data: {
			  "productOrder" : productOrder
		  },
		  success: function(data){
			  printList(data)
		  },
		  error: function(data){
			  console.log(data)
		  }
	  })
	  
	})) 
	
	  function printList(data){
		var str = returnStr(data)
	    $(".researchView").html(str);
		
		modalSelect();
	  }
	  
	
	/** 글 정렬 후 더보기 버튼 클릭 시 붙이기 .append  */
	  $('.moreView').each(function(){
		  $(this).click(function(e){
			  e.preventDefault();
			  page += 1;
			  print();  
		  })
	  })
	  
	  function print(){
		  var productOrder = $("select option:selected").val(); 
		  $.ajax({
			  url: "/product/research/"+page,
			  dataType: "json",
			  data: {
				  "productOrder" : productOrder
			  },
			  success: function(data){
				  printlist(data)
			  },
			  error: function(data){
				  console.log(data)
			  }
		  })
		  }
	
	  function printlist(data){
			var str = returnStr(data)
		    $(".researchView").append(str);
			
			modalSelect();
		  }
	  
		/** 붙이는 html String */
	  function returnStr(data) {
	  	var str = "";
	  	 
	  	$(data.gplist).each(function(){
	  	      var gpurchase = this;
	  	      $(data.glist).each(function(){
	  	        var goods = this;
	  	        if (gpurchase.goodsNo == goods.goodsNo) {
	  	              str += "  <div class='col-md-3 col-sm-4 shop-grid-item'>"
	  	              str += "    <div class='product-slide-entry shift-image eee'>"
	  	              str += "      <div class='product-image'>"
	  	              str += "        <img src='/resources/img/ex/KakaoTalk_20171115_220127147.jpg' alt='totoro' />"
	  	              str += "        <img src='/resources/img/ex/cat.jpg' alt='image' />"
	  	              str += "        <div class='bottom-line left-attached'>"
	  	              str += "          <a class='bottom-line-a square'><i class='fa fa-heart'></i></a>"
	  	              str += "        </div>"
	  	              str += "      </div>"
	  	              str += "      <a class='tag' href='#'>Enter Company Name </a>"
	  	              str += "      <a class='title' title='"+gpurchase.gpurchaseNo+"' data-toggle='modal' data-target='#gpurchaseInfo'>"+goods.name+"</a>"
	  	              str += "      <div class='price gpurchasePrice'>"
	  	              str += "        <div class='current gpurchasePrice'>"+gpurchase.price+"</div>"
	  	              str += "      </div>"
	  	              str += "		<div class='date'>"
	  	              str += " 			<div>"+gpurchase.startDate+" ~ "+gpurchase.endDate+"</div>"
	  	              str += "		</div>"
	  	              str += "      <div class='list-buttons'>"
	  	              str += "      </div></div><div class='clear'></div></div>"
	  	        }
	  	      })
	  	    });
	  	
	  	return str;
	  	
	  }	  
	  
	  
	  
	  /** 공구 조사 상세보기 modal 띄우기 */
	  function modalSelect(){
	  $(".title").on("click", function(){
		  
		  var gpurchaseNo = $(this).attr("title")
		  
		  $.getJSON("/product/"+gpurchaseNo+"/"+memberNo, function(data){
			  var gpurchase = data.gpurchase;
			  var goods = data.goods;
			  var gwishCheck = data.gwishCheck;
			  
			  var str = "";
			  
			  str += "<div class='modal-header'>";
			  str += "	<button type='button' class='close' data-dismiss='modal'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>";
			  str += "	<h4 class='modal-title goods-name'>"+goods.name+"</h4>";
			  str += "</div>";
			  str += "<div class='modal-body'>";
			  str += "	<div class='form-group'>";
			  str += "		<img class='modal-image' src='/resources/img/ex/cat.jpg' alt='' data-zoom='/resources/img/ex/cat-zoom.png' />";
			  str += "		<div class='product-detail-box'>"
			  str += "			<div class='price detail-info-entry modal-price'>";
			  str += "				<div class='current'>￦"+gpurchase.price+"</div>";
			  str += "			</div>";
			  str += "			<div class='size-selector detail-info-entry'>";
			  str += "				<div class='detail-info-entry-title size-text'>구입 가능 사이즈</div>";
			  str += "				<div class='entry'>xs</div>";
			  str += "				<div class='entry'>s</div>";
			  str += "				<div class='entry'>m</div>";
			  str += "				<div class='entry'>l</div>";
			  str += "				<div class='entry'>xl</div>";
			  str += "				<div class='spacer'></div>";
			  str += "			</div>";
			  str += "		</div>";
			  str += "	</div>";
			  str += "</div>"
			  str += "<div class='modal-footer'>";
			  str += "	<input type='hidden' id='puNo' value='"+gpurchase.gpurchaseNo+"'>"
			  str += "	<div class='form-group wishButton'>";
			  str += "	</div>";
			  str += "</div>";
			  
			  $(".modal-content").html(str);
			  
			  
			  wishBtn(gwishCheck)
			  
			 
			  
			 /** 공구조사 참여/취소 버튼 클릭 이벤트 */
			 $(document).on("click", ".wishJoinBtn", function(event){
				  gpurchaseNo = $("#puNo").val()
				 
				  wishCheck(gpurchaseNo, 0)
				  event.stopImmediatePropagation()
			 })
			 
			  $(document).on("click", ".wishCancleBtn", function(event){
				  gpurchaseNo = $("#puNo").val()
				  
				  wishCheck(gpurchaseNo, 1)
				  event.stopImmediatePropagation()
			 })
			 
		  })
	  })
	  }
	  
	  
	 
	  /** 공구조사 상세보기(modal) 버튼 html */
	  function wishBtn(gwishCheck) {
		  var str = "";
		  
		  if (gwishCheck == 0) {
			  str += "	<center><a class='button style-11 wishBtn wishJoinBtn'>공동 구매 참여</a></center>";
		  }else {
			  str += "	<center><a class='button style-10 wishBtn wishCancleBtn' >구매 참여 취소</a></center>";
		  }
		  
		  $(".wishButton").html(str)
	  }
	  
	  
	  /** 공구조사 참여 동작 */
	  function wishCheck(gpNo, wishCk){
				 
			$.ajax({
			url: "/product/"+wishCk+"/"+gpNo,
			dataType: "json",
			type: "POST",
			data: {
				"memberNo" : memberNo
			},
			success: function(gwishCheck){
				wishBtn(gwishCheck)
			},
			error: function(data){
				console.log(data)
			}
		})
		  
	  }
	  
	  
	  
	  
	  
 	  
/** document.readt End */	  
})


