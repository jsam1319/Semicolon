<%@ page language="java" pageEncoding="UTF-8"%>
<head>
<style type="text/css">
#imageSizing{
    width:195px;
    height:269px;
}
</style>
</head>

<body class="style-10">

<div class="content-push">
				<div class="parallax-slide fullwidth-block small-slide"
					style="margin-bottom: 30px; margin-top: -25px;">
					<div class="swiper-container" data-autoplay="5000" data-loop="1"
						data-speed="500" data-center="0" data-slides-per-view="1">
						<div class="swiper-wrapper">
							<div class="swiper-slide active" data-val="0"
								style="background-image: url(/resources/img/index/main_02.jpg);">
								<div class="parallax-vertical-align" style="margin-top: 0;">
								</div>
							</div>
							<div class="swiper-slide no-shadow" data-val="1"
								style="background-image: url(/resources/img/index/main_06.jpg);">
								<div class="parallax-vertical-align" style="margin-top: 0;">
								</div>
							</div>
						</div>
						<div class="pagination"></div>
					</div>
				</div>

				<div class="information-blocks">
					<div class="row">
						<div class="col-sm-4 information-entry">
							<div class="special-item-entry">
								<img src="/resources/img/index/index1.png" alt="" />
								<h3 class="title">
									Check Out for This Winter <span>COAT</span>
								</h3>
								<a class="button style-6" href="/product/research/110">shop now</a>
							</div>
						</div>
						<div class="col-sm-4 information-entry">
							<div class="special-item-entry">
								<img src="/resources/img/index/index2.png" alt="" />
								<h3 class="title">
									Check Out the NEW <span>DRESS</span>
								</h3>
								<a class="button style-6" href="/product/research/130">shop now</a>
							</div>
						</div>
						<div class="col-sm-4 information-entry">
							<div class="special-item-entry">
								<img src="/resources/img/index/index3.png" alt="" />
								<h3 class="title">
									Check out the NEW <span>Pants</span>
								</h3>
								<a class="button style-6" href="/product/research/230">shop now</a>
							</div>
						</div>
					</div>
				</div>

				<div class="information-blocks">
					<div class="tabs-container">
						<div class="swiper-tabs tabs-switch">
							<div class="title">Products</div>
							<div class="list">
							<a class="block-title tab-switcher active" id="recommandTab">회원님의 연관 상품</a>
								<a class="block-title tab-switcher" id="popularTab">최고 인기상품</a> 
								<div class="clear"></div>
							</div>
						</div>
						<div>
							<div class="tabs-entry">
								<div class="products-swiper">
									<div class="swiper-container" data-autoplay="0" data-loop="0"
										data-speed="500" data-center="0"
										data-slides-per-view="responsive" data-xs-slides="2"
										data-int-slides="2" data-sm-slides="3" data-md-slides="4"
										data-lg-slides="5" data-add-slides="5">
										<div class="swiper-wrapper" id="recommand">
										</div>
										
										<div class="pagination"></div>
										
									</div>
								</div>
							</div>
							<div class="tabs-entry" id="popularEntry">
								<div class="products-swiper">
									<div class="swiper-container" data-autoplay="0" data-loop="0"
										data-speed="500" data-center="0"
										data-slides-per-view="responsive" data-xs-slides="2"
										data-int-slides="2" data-sm-slides="3" data-md-slides="4"
										data-lg-slides="5" data-add-slides="5">
										<div class="swiper-wrapper" id="popular">
											
											
											
										</div>
										<div class="pagination"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="clear"></div>

			</div>
	
	
<script>
$(document).ready(function() {
	if("${no}".trim() == "") {
		$("#recommandTab").hide();
		$("#popularTab").attr("class", "block-title tab-switcher active");
		$("#popularEntry").toggle();
	}
	
	else {
		$.ajax({
			url : "/log/recommand/${no}",
			dataType : "json",
			success : function(data) {
				if(data.list.length == 0) {
					$("#recommandTab").hide();
					$("#popularTab").attr("class", "block-title tab-switcher active");
					$("#popularEntry").toggle();
				}
				
				console.log(data);
				$("#recommand").html(slideString(data))
			}, 
			error : function(data, a, b) {
				console.log(data);
				console.log(a);
				console.log(b);
			}
		})
	}
	
	$.ajax({
		url : "/log/popular",
		dataType : "json",
		success : function(data) {
			console.log(data);
			$("#popular").html(slideString(data))
		}, 
		error : function(data, a, b) {
			console.log(data);
			console.log(a);
			console.log(b);
		}
	})

	
})


function slideString(data) {
	str = "";
	list = data.list;
	for(var i in list) {
		
		str = str + "<div class=\"swiper-slide\">\n" + 
								"	<div class=\"paddings-container\">\n" + 
								"		<div class=\"product-slide-entry shift-image\">\n" + 
								"			<div class=\"\" style=\"height:16rem;\">\n" + 
								"				<img id=\"imageSizing\" src=\" "+ list[i].toggleImg + "\" alt=\"\"  style=\"height:100%;\"/> \n" + 
								"			</div>\n" + 
								"			<a class=\"tag\" href=\"#\"># COAT</a> <a class=\"title\"\n" + 
								"			href=\"#\">" + list[i].gname+ "</a>\n" + 
								"			<div class=\"price\">\n" + 
								"		<div class=\"current\">￦" + list[i].price+ "</div>\n" + 
								"		</div>\n" + 
								"	</div>\n" + 
								"</div>\n" + 
								"</div>"

					
	}
	
	return str;
}




</script>
</body>


</html>
