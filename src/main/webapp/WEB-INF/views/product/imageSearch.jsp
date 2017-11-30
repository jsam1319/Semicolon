<%@ page contentType="text/html; charset=utf-8"%>
<body class="style-10">
  <link href="/resources/css/gpurchase.css" rel="stylesheet" type="text/css"></link>
  <!-- LOADER -->
  <div id="loader-wrapper">
    <div class="bubbles">
      <div class="title">loading</div>
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>
  <div class="content-push">

    <div class="breadcrumb-box">
      <a href="/">Home</a> <a href="#">키워드 검색</a>
    </div>

    <div class="information-blocks">
      <div class="row">
        <div class="col-md-9 col-md-push-3 col-sm-8 col-sm-push-4">

          <input type="hidden" id="loginMemberNo" value="${no}">
          <input type="hidden" id="category" value="${category}">

          <div class="information-blocks">
          
              <div>


                <!-- /.ongoing Gpurchase -->
                <div class="tabs-entry ongoinGpurchase">
                 
                  
                  <!-- Gpurchase List -->
                  <div class="row shop-grid grid-view listView" id="goingList"></div>
                  <div class="page-selector">
                      <a class="moreView"><i
                        class="fa fa-angle-down"></i></a>
                    <div class="pages-box">
                      <a href="#" class="square-button"><i
                        class="fa fa-angle-up"></i></a>
                    </div>
                    <div class="clear"></div>
                  </div>
                  <!-- /.Gpurchase List -->
                </div>
                <!-- /.ongoing Gpurchase -->


                  <!-- Gpurchase List -->

                </div>
          </div>
          <!-- /.End Gpurchase -->
        </div>
        
        <!-- Left Side Menu -->
        <div
          class="col-md-3 col-md-pull-9 col-sm-4 col-sm-pull-8 blog-sidebar">
          <div class="information-blocks categories-border-wrapper">
            <div class="block-title size-3"> 검색 사진 </div>
            <div class="accordeon">
             	<div> <img id="inputImage" style="width : 200px; height: 250px"></div>
            </div>
          </div>

        </div>
        <!-- /.Left Side Menu -->
      </div>
    </div>
  </div>

  <div class="clear"></div>


<script>

$(document).ready(function() {
	var image = "";
	
	if('${method}' == 'get')
		image = '${imageName}';
	else
		image = "http://localhost:8081/resources/images/${imageName}";	
	
	$("#inputImage").attr("src", image);

	$.ajax({
		url : "http://localhost:8000/polls/search/",
		dataType : 'json',
		type : 'POST',
		data : {
			image : image,
		},
		success : function(data) {
			console.log(data);
		},
		error : function(data) {
			console.log(data);
		}
	})
})




</script>
<!-- 
<script>
var goingPage = 1;
var endPage = 1;
/* tabStatus -> 0 goingtab
 * tabStatus -> 1 endTab
 */
var tabStatus = 0;

$(document).ready(function() {
	goingListLoad();
	
	$(".goingTab").click(function() {
		$("#goingList").html(" ");
		
		tabStatus = 0;
		goingListLoad();
	})
	
	
	$(".endTab").click(function() {
		$("#endList").html(" ");
		
		tabStatus = 1;
		endListLoad();
	})
	
		/** 글 정렬 후 더보기 버튼 클릭 시 붙이기 .append  */
	  $('.moreView').each(function(){
		  $(this).click(function(e){
			  e.preventDefault();
			  
				if(tabStatus == 1) {
					goingPage++;
					goingListLoad();
				}
				
				else {
					endPage++;
					endListLoad();
				}
		  })
	  })
})

function returnStr(data) {
	  	var str = "";
	  	
	  	$(data.list).each(function(){
	  		var list = this;
	  		
	  		str += "<div class='col-md-3 col-sm-4 shop-grid-item'>"
	      str += "	<div class='product-slide-entry shift-image'>"
	      str += "		<div class='product-image'>"
	      str += "			<img src='/resources/images"+list.frontImg+"'/>"
  			str += "			<img src='/resources/images"+list.toggleImg+"'/>"
  			str += "		</div>"
  			str += "		<a class='tag' href='/product/gpurchase/" + list.gpurchaseNo + "'>"+list.cname+"</a>"
  			str += "		<a class='title' href='/product/gpurchase/" + list.gpurchaseNo + "' title='"+list.gpurchaseNo+"'>"+list.gname+"</a>"
  			str += "		<div class='price gpurchasePrice'>"
	  	  str += "        	<div class='current gpurchasePrice'> ￦"+numberfmt(list.price)+"</div>"
	  	  str += "      	</div>"
	  	  str += "		<div class='date'>"
	  	  str += " 			<div>"+list.startDate+" ~ "+list.endDate+"</div>"
	  	  str += "		</div>"
	  	  str += "      	<div class='list-buttons'>"
	  	  str += "      	</div> ";
		    str += "	</div>"
	  	  str += "	<div class='clear'></div>"
		    str += "</div>"
	  	            	  
	  	    
	  	})
	  	return str;
	  };

function goingListLoad() {
	$.ajax({
		url : "/product/search/${keyword}",
		type : "post",
		data : {
			'page' : goingPage,
			'status' : 1
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			
			if(data.ResponseCode == 1) {
				$("#goingList").append(returnStr(data));
			}
		},
		error : function(data, a, b) {
			console.log(data);
			console.log(a);
			console.log(b);
		}
	}) 
}

function endListLoad() {
	$.ajax({
		url : "/product/search/${keyword}",
		type : "post",
		data : {
			'page' : endPage,
			'status' : 2
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			
			if(data.ResponseCode == 1) {
				$("#endList").append(returnStr(data));
			}
		},
		error : function(data, a, b) {
			console.log(data);
			console.log(a);
			console.log(b);
		}
	}) 
}

/** 가격 데이터 포맷 */
function numberfmt(value){
    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
} -->

</script>
</body>
</html>
