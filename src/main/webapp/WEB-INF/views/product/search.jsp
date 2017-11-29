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
      <a href="/">Home</a> <a href="#">진행중인 공구</a>
    </div>

    <div class="information-blocks">
      <div class="row">
        <div class="col-md-9 col-md-push-3 col-sm-8 col-sm-push-4">

          <input type="hidden" id="loginMemberNo" value="${no}">
          <input type="hidden" id="category" value="${category}">

          <div class="information-blocks">
            <div class="tabs-container style-1">
              <div class="swiper-tabs tabs-switch">
                <div class="title">Gpurchase info</div>
                <div class="list">
                  <a class="tab-switcher active">진행중인 공구</a>
                   <a class="tab-switcher endTab">마감된 공구</a>
                  <div class="clear"></div>
                </div>
              </div>
              <div>


                <!-- /.ongoing Gpurchase -->
                <div class="tabs-entry ongoinGpurchase">
                  <!-- Top Menu -->
                  <div class="page-selector">
                    <div class="shop-grid-controls">
                      <div class="entry">
                        <div class="inline-text">Sorty by</div>
                        <div class="simple-drop-down">
                          <select id="productOrder">
                            <option value='newProduct' selected>등록순</option>
                            <option value='endDate'>마감날짜순</option>
                            <option value='deadline'>참여많은순</option>
                            <option value='lowPrice'>낮은가격순</option>
                            <option value='highPrice'>높은가격순</option>
                          </select>
                        </div>
                      </div>
                      <div class="entry">
                        <div class="view-button active grid">
                          <i class="fa fa-th"></i>
                        </div>
                        <div class="view-button list">
                          <i class="fa fa-list"></i>
                        </div>
                      </div>
                    </div>
                    <div class="clear"></div>
                  </div>
                  <!-- /.Top Menu -->
                  
                  <!-- Gpurchase List -->
                  <div class="row shop-grid grid-view listView"></div>
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


                <!-- End Gpurchase -->
                <div class="tabs-entry">
                  <!-- Top Menu -->
                  <div class="page-selector">
                    <div class="shop-grid-controls">
                      <div class="entry">
                        <div class="inline-text">Sorty by</div>
                        <div class="simple-drop-down">
                          <select id="endproductOrder">
                            <option value='newProduct' selected>등록순</option>
                            <option value='endDate'>마감날짜순</option>
                            <option value='deadline'>참여많은순</option>
                            <option value='lowPrice'>낮은가격순</option>
                            <option value='highPrice'>높은가격순</option>
                          </select>
                        </div>
                      </div>
                      <div class="entry">
                        <div class="view-button active grid">
                          <i class="fa fa-th"></i>
                        </div>
                        <div class="view-button list">
                          <i class="fa fa-list"></i>
                        </div>
                      </div>
                    </div>
                    <div class="clear"></div>
                  </div>
                  <!-- /.Top Menu -->

                  <!-- Gpurchase List -->
                  <div class="row shop-grid grid-view endlistView"></div>

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
              </div>
            </div>
          </div>
          <!-- /.End Gpurchase -->





        </div>



        <!-- Left Side Menu -->
        <div
          class="col-md-3 col-md-pull-9 col-sm-4 col-sm-pull-8 blog-sidebar">
          <div class="information-blocks categories-border-wrapper">
            <div class="block-title size-3"> 검색 결과 </div>
            <div class="accordeon">
             	<div class="accordeon-title"> <font style="font-weight: bold">${keyword}</font> 로 검색한 결과입니다.</div>
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
	
 	$.ajax({
		url : "/product/search/${keyword}",
		type : "post",
		dataType : "json",
		success : function(data) {
			console.log(data);
		},
		error : function(data, a, b) {
			console.log(data);
			console.log(a);
			console.log(b);
		}
	}) 
	
	
	$("#searchResult").html()
})


function getElementString(gpurchase, goods) {
	
	str += "  <div class='col-md-3 col-sm-4 shop-grid-item'>"
	str += "    <div class='product-slide-entry shift-image'>"
	str += "      <div class='product-image'>"
	str += "			<img src='/resources/images/"+goods.frontImg+"' class='imgcl'/>"
	str += "			<img src='/resources/images/"+goods.toggleImg+"' class='imgcl'/>"
	str += "			<div class='bottom-line'>"
	str += "				<a class='bottom-line-a square2'>Research Complete</a>"
	str += "			</div>"
		
	if(!memberNo){
	  str += "    <a class='title nloginTitle' title='"+gpurchase.gpurchaseNo+"' data-toggle='modal' data-target='#login-modal'>"+goods.name+"</a>"
	} else {
		str += "    <a class='title loginTitle' title='"+gpurchase.gpurchaseNo+"' data-toggle='modal' data-target='#gpurchaseInfo'>"+goods.name+"</a>"
	}
	          
	str += "      <div class='price gpurchasePrice'>"
	str += "      	<div class='current gpurchasePrice'> ￦"+numberfmt(gpurchase.price)+"</div>"
	str += "      </div>"
	str += "			<div class='date'>"
	str += " 				<div>"+gpurchase.startDate+" ~ "+gpurchase.endDate+"</div>"
	str += "			</div>"
	str += "     	<div class='list-buttons'></div>"
	str += "</div><div class='clear'></div></div>"
}
</script>
</body>
</html>
