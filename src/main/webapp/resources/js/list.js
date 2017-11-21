$(document).ready(function(){
	var memberNo = $("#loginMemberNo").val()
	listHtml()
	
	/** 공구진행/완료 버튼 클릭 시 버튼 변환 이벤트 */
	$(".ongoing").click(function(){
		listHtml()
		$(".end").removeClass('style-14').addClass('style-40')
		$(this).removeClass('style-40').addClass('style-14')
	})
	$(".end").click(function(){

		$(this).removeClass('style-40').addClass('style-14')
		$(".ongoing").removeClass('style-14').addClass('style-40')
	})
	
	/** 글 정렬 후 진행중인 공고리스트 처음 붙이기 .html */
	function listHtml(){
		page = 1
		$.post("/product/list/"+page, function(data){
			printList(data)
		})
	}
	
   $("#productOrder").on('change',(function(){
	  productOrder = this.value
	  page = 1
	  
	  $.ajax({
		  url: "/product/list/"+page,
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
			  url: "/product/list/"+page,
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
	  	              str += "    <div class='product-slide-entry shift-image eee'>"
	  	              str += "      <div class='product-image'>"
	  	              str += "        <img src='/resources/img/ex/KakaoTalk_20171115_220127147.jpg' alt='totoro' />"
	  	              str += "        <img src='/resources/img/ex/cat.jpg' alt='image' />"
	  	              str += "      </div>"
	  	              str += "      <a class='tag'>Enter Company Name </a>"
	  	              str += "      <a class='title' href='/product/gpurchase/"+gpurchase.gpurchaseNo+"' title='"+gpurchase.gpurchaseNo+"'>"+goods.name+"</a>"
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
	  
	  
	  
	  
	  
 	  
/** document.readt End */	  
})


