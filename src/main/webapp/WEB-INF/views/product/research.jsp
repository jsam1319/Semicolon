<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8"%>
<body class="style-10">

	<!-- LOADER -->
	<div id="loader-wrapper">
		<div class="bubbles">
			<div class="title">loading</div>
			<span></span> <span id="bubble2"></span> <span id="bubble3"></span>
		</div>
	</div>

	<div class="content-push">

		<div class="breadcrumb-box">
			<a href="#">Home</a> <a href="#">Bags &amp; Accessories</a>
		</div>

		<div class="information-blocks">
			<div class="row">
				<div class="col-md-9 col-md-push-3 col-sm-8 col-sm-push-4">
					<div class="page-selector">
						<div class="shop-grid-controls">
							<div class="entry">
								<div class="inline-text">Sort by</div>
								<div class="simple-drop-down">
									<select id="productOrder" onchange="window.location='http://localhost/product/list?productOrder='+this.value;">
										<option>ㅡ</option>
										<option value='newProduct'>신상품</option>
										<option value='endDate'>끝나는날짜</option>
										<option value='deadline'>마감인원</option>
										<option value='lowPrice'>낮은가격</option>
										<option value='highPrice'>높은가격</option>
									</select>
								</div>
								<div class="sort-button"></div>
							</div>
							<div class="entry">
								<div class="view-button active grid">
									<i class="fa fa-th"></i>
								</div>
								<div class="view-button list">
									<i class="fa fa-list"></i>
								</div>
							</div>
							<div class="entry">
								<div class="inline-text">Show</div>
								<div class="simple-drop-down" style="width: 75px;">
									<select id="pageSize" onchange="window.location='http://localhost/product/list?pageSize=' + this.value;">
										<option>ㅡ</option>
										<option value="12">12</option>
										<option value="20">20</option>
										<option value="32">32</option>
										<option value="40">40</option>
										<option value="all">all</option>
									</select>
								</div>
								<div class="inline-text">per page</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="row shop-grid grid-view">

						<!-- Product List -->
						<c:forEach items="${gplist}" var="gpurchase">
							<c:forEach items="${glist}" var="goods">
								<c:if test="${gpurchase.goodsNo eq goods.goodsNo}">
									<div class="col-md-3 col-sm-4 shop-grid-item">
										<div class="product-slide-entry shift-image">
											<div class="product-image">
												<img src="${pageContext.request.contextPath}/img/totoro.jpg" alt="totoro" /> <img
													src="img/totoro.jpg" alt="image" />
												<div class="bottom-line left-attached">
													<a class="bottom-line-a square"><i
														class="fa fa-shopping-cart"></i></a> <a
														class="bottom-line-a square"><i class="fa fa-heart"></i></a>
													<a class="bottom-line-a square"><i
														class="fa fa-retweet"></i></a> <a class="bottom-line-a square"><i
														class="fa fa-expand"></i></a>
												</div>
											</div>
											<a class="tag" href="#">Enter Company Name </a> <a class="title"
												href="product?gpurchaseNo=${gpurchase.gpurchaseNo}">${goods.name}
											</a>
											<div class="rating-box">
												<div class="star">
													<i class="fa fa-star"></i>
												</div>
												<div class="star">
													<i class="fa fa-star"></i>
												</div>
												<div class="star">
													<i class="fa fa-star"></i>
												</div>
												<div class="star">
													<i class="fa fa-star"></i>
												</div>
												<div class="star">
													<i class="fa fa-star"></i>
												</div>
												<div class="reviews-number">25 reviews</div>
											</div>
											<div class="article-container style-1">
												<p>${goods.detail}</p>
											</div>
											<div class="price">
												<div class="current">${gpurchase.price}</div>
												<i class="fa fa-heart"></i>
											</div>
											<div class="list-buttons">
												<a class="button style-10">Add to cart</a> <a
													class="button style-11"><i class="fa fa-heart"></i> Add
													to Wishlist</a>
											</div>
										</div>
										<div class="clear"></div>
									</div>
								</c:if>
							</c:forEach>
						</c:forEach>
					</div>
					
					
					
					<div class="page-selector">
						<div class="description">Showing: 1-3 of 16</div>

						<div class="pages-box">
							<c:if test="${pageBuilder.isShowFirst()}">
								<a href="${pageBuilder.getQueryString(1)}" class="square-button"><i
									class="fa fa-angle-double-left"></i></a>
							</c:if>

							<c:if test="${pageBuilder.isShowPrevious()}">
								<a
									href="${pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())}"
									class="square-button"><i class="fa fa-angle-left"></i></a>
							</c:if>

							<c:forEach var="i" begin="${pageBuilder.currentStartPage }"
								end="${pageBuilder.currentEndPage}" varStatus="status">
								<c:choose>
									<c:when test="${i==params.page}">
										<a class="square-button active">${i}</a>
									</c:when>
									<c:otherwise>
										<a href="${pageBuilder.getQueryString(i)}"
											class="square-button">${i}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${pageBuilder.isShowNext()}">
								<a
									href="${pageBuilder.getQueryString(pageBuilder.getNextStartPage())}"
									class="square-button"><i class="fa fa-angle-right"></i></a>
							</c:if>

							<c:if test="${pageBuilder.isShowLast()}">
								<a
									href="${pageBuilder.getQueryString(pageBuilder.getTotalPageCount())}"
									class="square-button"><i class="fa fa-angle-double-right"></i></a>
							</c:if>
						</div>
						<div class="clear"></div>
					</div>
					
				</div>
				<div
					class="col-md-3 col-md-pull-9 col-sm-4 col-sm-pull-8 blog-sidebar">
					<div class="information-blocks categories-border-wrapper">
						<div class="block-title size-3">Categories</div>
						<div class="accordeon">
							<div class="accordeon-title">Bags &amp; Accessories</div>
							<div class="accordeon-entry">
								<div class="article-container style-1">
									<ul>
										<li><a href="#">Bags &amp; Accessories</a></li>
										<li><a href="#">Man's Products</a></li>
										<li><a href="#">Woman's Products</a></li>
										<li><a href="#">Top Brands</a></li>
										<li><a href="#">Special Offer</a></li>
										<li><a href="#">Leather's Products</a></li>
									</ul>
								</div>
							</div>
							<div class="accordeon-title">Man's Products</div>
							<div class="accordeon-entry">
								<div class="article-container style-1">
									<ul>
										<li><a href="#">Bags &amp; Accessories</a></li>
										<li><a href="#">Man's Products</a></li>
										<li><a href="#">Woman's Products</a></li>
										<li><a href="#">Top Brands</a></li>
										<li><a href="#">Special Offer</a></li>
										<li><a href="#">Leather's Products</a></li>
									</ul>
								</div>
							</div>
							<div class="accordeon-title">Woman's Products</div>
							<div class="accordeon-entry">
								<div class="article-container style-1">
									<ul>
										<li><a href="#">Bags &amp; Accessories</a></li>
										<li><a href="#">Man's Products</a></li>
										<li><a href="#">Woman's Products</a></li>
										<li><a href="#">Top Brands</a></li>
										<li><a href="#">Special Offer</a></li>
										<li><a href="#">Leather's Products</a></li>
									</ul>
								</div>
							</div>
							<div class="accordeon-title">Top Brands</div>
							<div class="accordeon-entry">
								<div class="article-container style-1">
									<ul>
										<li><a href="#">Bags &amp; Accessories</a></li>
										<li><a href="#">Man's Products</a></li>
										<li><a href="#">Woman's Products</a></li>
										<li><a href="#">Top Brands</a></li>
										<li><a href="#">Special Offer</a></li>
										<li><a href="#">Leather's Products</a></li>
									</ul>
								</div>
							</div>
							<div class="accordeon-title">Special Offer</div>
							<div class="accordeon-entry">
								<div class="article-container style-1">
									<ul>
										<li><a href="#">Bags &amp; Accessories</a></li>
										<li><a href="#">Man's Products</a></li>
										<li><a href="#">Woman's Products</a></li>
										<li><a href="#">Top Brands</a></li>
										<li><a href="#">Special Offer</a></li>
										<li><a href="#">Leather's Products</a></li>
									</ul>
								</div>
							</div>
							<div class="accordeon-title">Leather's Products</div>
							<div class="accordeon-entry">
								<div class="article-container style-1">
									<ul>
										<li><a href="#">Bags &amp; Accessories</a></li>
										<li><a href="#">Man's Products</a></li>
										<li><a href="#">Woman's Products</a></li>
										<li><a href="#">Top Brands</a></li>
										<li><a href="#">Special Offer</a></li>
										<li><a href="#">Leather's Products</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="information-blocks">
						<div class="block-title size-2">Sort by sizes</div>
						<div class="range-wrapper">
							<div id="prices-range"></div>
							<div class="range-price">
								Price:
								<div class="min-price">
									<b>&pound;<span>0</span></b>
								</div>
								<b>-</b>
								<div class="max-price">
									<b>&pound;<span>200</span></b>
								</div>
							</div>
							<a class="button style-14">filter</a>
						</div>
					</div>

					<div class="information-blocks">
						<div class="block-title size-2">Sort by sizes</div>
						<div class="size-selector">
							<div class="entry active">xs</div>
							<div class="entry">s</div>
							<div class="entry">m</div>
							<div class="entry">l</div>
							<div class="entry">xl</div>
							<div class="spacer"></div>
						</div>
					</div>

					<div class="information-blocks">
						<div class="block-title size-2">Sort by brands</div>
						<div class="row">
							<div class="col-xs-6">
								<label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Armani
								</label> <label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Bershka Co
								</label> <label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Nelly.com
								</label> <label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Zigzag Inc
								</label>
							</div>
							<div class="col-xs-6">
								<label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Armani
								</label> <label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Bershka Co
								</label> <label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Nelly.com
								</label> <label class="checkbox-entry"> <input type="checkbox" />
									<span class="check"></span> Zigzag Inc
								</label>
							</div>
						</div>
					</div>

					<div class="information-blocks">
						<div class="block-title size-2">Sort by colours</div>
						<div class="color-selector detail-info-entry">
							<div style="background-color: #cf5d5d;" class="entry active"></div>
							<div style="background-color: #c9459f;" class="entry"></div>
							<div style="background-color: #689dd4;" class="entry"></div>
							<div style="background-color: #68d4aa;" class="entry"></div>
							<div style="background-color: #a8d468;" class="entry"></div>
							<div style="background-color: #d4c368;" class="entry"></div>
							<div style="background-color: #c2c2c2;" class="entry"></div>
							<div style="background-color: #000000;" class="entry"></div>
							<div style="background-color: #f0f0f0;" class="entry"></div>
							<div class="spacer"></div>
						</div>
					</div>

				</div>
			</div>
		</div>

		<div class="information-blocks">
			<div class="row">
				<div class="col-sm-4 information-entry">
					<h3 class="block-title inline-product-column-title">Featured
						products</h3>
					<div class="inline-product-entry">
						<a href="#" class="image"><img alt=""
							src="img/product-image-inline-1.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
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
							src="img/product-image-inline-2.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
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
							src="img/product-image-inline-3.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
								<div class="price">
									<div class="prev">$199,99</div>
									<div class="current">$119,99</div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="col-sm-4 information-entry">
					<h3 class="block-title inline-product-column-title">Featured
						products</h3>
					<div class="inline-product-entry">
						<a href="#" class="image"><img alt=""
							src="img/product-image-inline-1.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
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
							src="img/product-image-inline-2.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
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
							src="img/product-image-inline-3.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
								<div class="price">
									<div class="prev">$199,99</div>
									<div class="current">$119,99</div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="col-sm-4 information-entry">
					<h3 class="block-title inline-product-column-title">Featured
						products</h3>
					<div class="inline-product-entry">
						<a href="#" class="image"><img alt=""
							src="img/product-image-inline-1.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
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
							src="img/product-image-inline-2.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
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
							src="img/product-image-inline-3.jpg"></a>
						<div class="content">
							<div class="cell-view">
								<a href="#" class="title">Ladies Pullover Batwing Sleeve
									Zigzag</a>
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

	<div class="clear"></div>


	<div class="overlay-popup" id="image-popup">

		<div class="overflow">
			<div class="table-view">
				<div class="cell-view">
					<div class="close-layer"></div>
					<div class="popup-container">
						<img class="gallery-image" src="img/portfolio-1.jpg" alt="" />
						<div class="close-popup"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="search-box popup">
		<form>
			<div class="search-button">
				<i class="fa fa-search"></i> <input type="submit" />
			</div>
			<div class="search-drop-down">
				<div class="title">
					<span>All categories</span><i class="fa fa-angle-down"></i>
				</div>
				<div class="list">
					<div class="overflow">
						<div class="category-entry">Category 1</div>
						<div class="category-entry">Category 2</div>
						<div class="category-entry">Category 2</div>
						<div class="category-entry">Category 4</div>
						<div class="category-entry">Category 5</div>
						<div class="category-entry">Lorem</div>
						<div class="category-entry">Ipsum</div>
						<div class="category-entry">Dollor</div>
						<div class="category-entry">Sit Amet</div>
					</div>
				</div>
			</div>
			<div class="search-field">
				<input type="text" value="" placeholder="Search for product" />
			</div>
		</form>
	</div>

	<div class="cart-box popup">
		<div class="popup-container">
			<div class="cart-entry">
				<a class="image"><img src="img/product-menu-1.jpg" alt="" /></a>
				<div class="content">
					<a class="title" href="#">Pullover Batwing Sleeve Zigzag</a>
					<div class="quantity">Quantity: 4</div>
					<div class="price">$990,00</div>
				</div>
				<div class="button-x">
					<i class="fa fa-close"></i>
				</div>
			</div>
			<div class="cart-entry">
				<a class="image"><img src="img/product-menu-1_.jpg" alt="" /></a>
				<div class="content">
					<a class="title" href="#">Pullover Batwing Sleeve Zigzag</a>
					<div class="quantity">Quantity: 4</div>
					<div class="price">$990,00</div>
				</div>
				<div class="button-x">
					<i class="fa fa-close"></i>
				</div>
			</div>
			<div class="summary">
				<div class="subtotal">Subtotal: $990,00</div>
				<div class="grandtotal">
					Grand Total <span>$1029,79</span>
				</div>
			</div>
			<div class="cart-buttons">
				<div class="column">
					<a class="button style-3">view cart</a>
					<div class="clear"></div>
				</div>
				<div class="column">
					<a class="button style-4">checkout</a>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>

	<script src="js/jquery-2.1.3.min.js"></script>
	<script src="js/idangerous.swiper.min.js"></script>
	<script src="js/global.js"></script>

	<!-- custom scrollbar -->
	<script src="js/jquery.mousewheel.js"></script>
	<script src="js/jquery.jscrollpane.min.js"></script>

	<!-- range slider -->
	<script src="js/jquery-ui.min.js"></script>

</body>
