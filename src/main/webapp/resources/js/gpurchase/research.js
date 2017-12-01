$(document).ready(function(){
	var page = 1
	var memberNo = $("#loginMemberNo").val()
	var category = $("#category").val()
	
	/** 글 정렬 후 처음 리스트 붙이기 .html */
	$.post("/product/research/"+category+"/"+page, function(data){
		printList(data)
	})
	
   $("#productOrder").on('change',function(){
	  productOrder = this.value
	  page = 1
	  
	  $.ajax({
		  url: "/product/research/"+category+"/"+page,
		  dataType: "json",
		  type: "POST",
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
	  
	}) 
	
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
			  url: "/product/research/"+category+"/"+page,
			  dataType: "json",
			  type: "POST",
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
	  	
	  	$(data.list).each(function(){
	  		var list = this;
	  		
	  		
	  		str += "<div class='col-md-3 col-sm-4 shop-grid-item'>"
	        str += "	<div class='product-slide-entry shift-image'>"
	        str += "		<div class='product-image'>"
	        	
	            // 진행 공구로 이동할 상품 데이터 출력 및 이미지 별도 표시	  
	            var flag = false;
	            
	            for(var i in data.golist) {
	            	if(data.golist[i] == list.gpurchaseNo) {
	            		flag = true;
	            		break;
	            	}
	            }
	            
	          if (flag) {
	    	  	    str += "<img src='"+list.frontImg+"' class='imgcl'/>"
	    	  	    str += "<img src='"+list.toggleImg+"' class='imgcl'/>"
	    	  	    str += "<div class='bottom-line'>"
	    	        str += "	<a class='bottom-line-a square2'>Research Complete</a>"
	    	        str += "</div>"
	    		} else {
	    			str += "<img src='"+list.frontImg+"'/>"
	    		  	str += "<img src='"+list.toggleImg+"'/>"
	    		}
	            
  			str += "		</div>"
  			str += "		<a class='tag'>"+list.cname+"</a>"
  			
  				// 회원 로그인 했는지 체크
              if(!memberNo){
            	str += "      <a class='title nloginTitle' title='"+list.gpurchaseNo+"' data-toggle='modal' data-target='#login-modal'>"+list.gname+"</a>"
              } else {
            	str += "      <a class='title loginTitle' title='"+list.gpurchaseNo+"' data-toggle='modal' data-target='#gpurchaseInfo'>"+list.gname+"</a>"
              }
  			
  			str += "		<div class='price gpurchasePrice'>"
	  	    str += "        	<div class='current gpurchasePrice'> ￦"+numberfmt(list.price)+"</div>"
	  	    str += "      	</div>"
	  	    str += "		<a class='goods-regdate'>"+list.startDate+" ~ "+list.endDate+"</a>"
	  	    str += "      	<div class='list-buttons'>"
	  	    str += "      	</div> "
	  	    str += "	</div>"
	  	    str += "	<div class='clear'></div>"
	  	    str += "</div>"
	  	            	  
	  	})
	  	
	  	return str;
	  };
	  	
	  
	  
	  /** 가격 데이터 포맷 */
	  function numberfmt(value){
          return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }
	  
	  
	  /** 공구 조사 상세보기 modal 띄우기 */
	  function modalSelect(){
	  $(".loginTitle").on("click", function(){
		  var gpurchaseNo = $(this).attr("title")
		  
		  $.getJSON("/product/"+gpurchaseNo, function(data){
			  var gpurchase = data.gpurchase;
			  var gwishCheck = data.gwishCheck;
			  var size = data.size;
			  
			  var str = "";
			  
			  str += "<div class='modal-header'>";
			  str += "	<button type='button' class='close' data-dismiss='modal'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button>";
			  str += "	<h4 class='modal-title goods-name'>"+gpurchase.gname+"</h4>";
			  str += "</div>";
			  str += "<div class='modal-body'>";
			  str += "	<div class='form-group'>";
			  str += "		<img class='modal-image' src='"+gpurchase.frontImg+"' alt='' data-zoom='/resources/img/ex/cat-zoom.png' />";
			  str += "		<div class='product-detail-box'>"
			  str += "			<div class='price detail-info-entry modal-price'>";
			  str += "				<div class='current'>￦"+numberfmt(gpurchase.price)+"</div>";
			  str += "			</div>";
			  str += "		<div class='size-selector detail-info-entry'>";
			  str += "				<div class='detail-info-entry-title size-text'>구입 가능 사이즈</div>";
				  str += "<center>"
			  for (var i = 0; i < size.length; i++) {
				  str += "<div class='entry'>"+size[i].SIZES+"</div>"; 
			}
			  str += "</center>"
			  str += "			</div>";
			  str += "		</div>";
			  str += "	</div>";
			  str += "</div>"
			  str += "<div class='modal-footer'>";
			  str += "	<input type='hidden' id='puNo' value='"+gpurchase.gpurchaseNo+"'>";
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


