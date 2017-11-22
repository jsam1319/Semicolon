$(document).ready(function(){
	var memberNo = $("#loginMemberNo").val()
	var category = $("#category").val()
	listHtml()
	
	/** 글 정렬 후 진행중인 공고리스트 처음 붙이기 .html */
	function listHtml(){
		page = 1
		$.post("/product/list/"+category+"/"+page, function(data){
			printList(data)
		})
	}
	
   $("#productOrder").on('change',(function(){
	  productOrder = this.value
	  page = 1
	  
	  $.ajax({
		  url: "/product/list/"+category+"/"+page,
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
	  
	})) 
	
	  function printList(data){
		var str = returnStr(data)
	    $(".listView").html(str);
	  }
	  
	/** 글 정렬 후 더보기 버튼 클릭 시 진행중인 공고리스트 붙이기 .append  */
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
			  url: "/product/list/"+category+"/"+page,
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
		    $(".listView").append(str);
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
	  	              str += "    <div class='product-slide-entry shift-image'>"
	  	              str += "      <div class='product-image'>"
	  	              str += "        <img src='/resources/img/ex/KakaoTalk_20171115_220127147.jpg' alt='totoro' />"
	  	              str += "        <img src='/resources/img/ex/cat.jpg' alt='image' />"
	  	              str += "      </div>"
	  	            	  
	  	            	// 해당 공구 상품의 회사 이름 가져오기
			  	          for (var i in data.comlist) {
			  			  	if(data.comlist[i].GOODSNO == goods.goodsNo) {
			  			  		str += "<a class='tag'>"+data.comlist[i].NAME+"</a>"
			  			  	}
			  			  }
	  	              
		  	         // 회원 로그인 했는지 체크 - 
		  	              if(!memberNo){
		  	            	str += "<a class='title nloginTitle' title='"+gpurchase.gpurchaseNo+"' data-toggle='modal' data-target='#login-modal'>"+goods.name+"</a>"
		  	              } else {
		  	            	str += "<a href='/product/gpurchase/"+gpurchase.gpurchaseNo+"/"+memberNo+"' class='title loginTitle' title='"+gpurchase.gpurchaseNo+"'>"+goods.name+"</a>"
		  	              }
	  	              
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
	  
	  
	  
	  
	  
	  
	  /** ------------------------------------------End---------------------------------------- */
	  
	  $(".endTab").on("click", function(){
		  endListHtml()
	  })
	  
	  
	  /** 글 정렬 후 진행중인 공고리스트 처음 붙이기 .html */
		function endListHtml(){
			page = 1
			$.getJSON("/product/list/"+category+"/"+page, function(data){
				endprintList(data)
			})
		}
		
	   $("#endproductOrder").on('change',(function(){
		  productOrder = this.value
		  page = 1
		  
		  $.ajax({
			  url: "/product/list/"+category+"/"+page,
			  dataType: "json",
			  type: "get",
			  data: {
				  "productOrder" : productOrder
			  },
			  success: function(data){
				  endprintList(data)
			  },
			  error: function(data){
				  console.log(data)
			  }
		  })
		  
		})) 
		
		  function endprintList(data){
			var str = returnStr(data)
		    $(".endlistView").html(str);
		  }
		  
		/** 글 정렬 후 더보기 버튼 클릭 시 진행중인 공고리스트 붙이기 .append  */
		  $('.moreView').each(function(){
			  $(this).click(function(e){
				  e.preventDefault();
				  page += 1;
				  Eprint();  
			  })
		  })
		  
		  function Eprint(){
			  var productOrder = $("select option:selected").val(); 
			  $.ajax({
				  url: "/product/list/"+category+"/"+page,
				  dataType: "json",
				  type: "get",
				  data: {
					  "productOrder" : productOrder
				  },
				  success: function(data){
					  Eprintlist(data)
				  },
				  error: function(data){
					  console.log(data)
				  }
			  })
			  }
		
		  function Eprintlist(data){
				var str = returnStr(data)
			    $(".listView").append(str);
			  }
	  
	  
	  
	  
 	  
/** document.readt End */	  
})


