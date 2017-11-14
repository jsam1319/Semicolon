$(document).ready(function(){
	var page = 1
	
	/** .html */
	$.getJSON("/product/"+page, function(data){ 
		printList(data)
	   }) 
	
   $("#productOrder").bind('change',(function(){
	  productOrder = this.value
	  page=1
	  $.ajax({
		  url: "/product/"+page,
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
	  }
	  
	
	/**  */
	  $('.moreView').each(function(i){
		  $(this).click(function(e){
			  e.preventDefault();
			  page += 1;
			  print();  
		  })
	  })
	  
	  function print(){
		  var productOrder = $("select option:selected").val(); 
		  $.ajax({
			  url: "/product/"+page,
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
		  }
	  
	})



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
	              str += "        <img src='/resources/img/ex/totoro.jpg' alt='totoro' />"
	              str += "        <img src='/resources/img/ex/totoro2.jpg' alt='image' />"
	              str += "        <div class='bottom-line left-attached'>"
	              str += "          <a class='bottom-line-a square'> <i class='fa fa-shopping-cart'></i></a>"
	              str += "          <a class='bottom-line-a square'><i class='fa fa-heart'></i></a>"
	              str += "          <a class='bottom-line-a square'><i class='fa fa-retweet'></i></a>"
	              str += "          <a class='bottom-line-a square'><i class='fa fa-expand'></i></a>"
	              str += "        </div>"
	              str += "      </div>"
	              str += "      <a class='tag' href='#'>Enter Company Name </a>"
	              str += "      <a class='title' href='product?gpurchaseNo="+gpurchase.gpurchaseNo+"'>"+goods.name+"</a>"
	              str += "      <div class='rating-box'>"
	              str += "        <div class='star'><i class='fa fa-star'></i></div>"
	              str += "        <div class='star'><i class='fa fa-star'></i></div>"
	              str += "        <div class='star'><i class='fa fa-star'></i></div>"
	              str += "        <div class='star'><i class='fa fa-star'></i></div>"
	              str += "        <div class='star'><i class='fa fa-star'></i></div>"
	              str += "        <div class='reviews-number'>25 reviews</div>"
	              str += "      </div>"
	              str += "      <div class='article-container style-1'>"
	              str += "        <p>"+goods.detail+"</p>"
	              str += "      </div>"
	              str += "      <div class='price'>"
	              str += "        <div class='current'>"+gpurchase.price+"</div>"
	              str += "        <i class='fa fa-heart'></i>"
	              str += "      </div>"
	              str += "      <div class='list-buttons'>"
	              str += "        <a class='button style-10'>Add to cart</a>" 
	              str += "        <a class='button style-11'><i class='fa fa-heart'></i> Add to Wishlist</a>"
	              str += "      </div></div><div class='clear'></div></div>"
	        }
	      })
	    });
	
	return str;
}