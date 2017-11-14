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

  <!-- HEADER -->
  <div class="header-wrapper style-10">
    <div class="clear"></div>
  </div>

  <div class="content-push">

    <div class="breadcrumb-box">
      <a href="#">Home</a> <a href="#">Shop</a> <a href="#">T-shirts</a>
      <a href="#">Careers</a> <a href="#">T-shirt Stampata</a>
    </div>

    <div class="information-blocks">
      <div class="row">
        <div class="col-sm-5 col-md-4 col-lg-5 information-entry">
          <div class="product-preview-box">
            <div class="swiper-container product-preview-swiper slider"
              data-autoplay="0" data-loop="1" data-speed="500"
              data-center="0" data-slides-per-view="1">
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
            <h3 class="product-subtitle">Enter Company Name</h3>
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
                <i class="fa fa-star-o"></i>
              </div>
              <div class="star">
                <i class="fa fa-star-o"></i>
              </div>
              <div class="rating-number">25 Reviews</div>
            </div>
            <div class="price detail-info-entry">
              <div class="current">￦ ${gpurchase.price}</div>
            </div>
            <div class="size-selector detail-info-entry">
              <div class="detail-info-entry-title">Size</div>
              <div class="entry active">xs</div>
              <div class="entry">s</div>
              <div class="entry">m</div>
              <div class="entry">l</div>
              <div class="entry">xl</div>
              <div class="spacer"></div>
            </div>
            <div class="color-selector detail-info-entry">
              <div class="detail-info-entry-title">Color</div>
              <div class="entry active"
                style="background-color: #d23118;">&nbsp;</div>
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
            <div class="detail-info-entry">
              <a class="button style-10"><i class="fa fa-heart"></i>
                Buy</a>
              <div class="clear"></div>
            </div>
            <div class="tags-selector detail-info-entry">
              <div class="detail-info-entry-title">Tags:</div>
              <a href="#">bootstrap</a>/ <a href="#">collections</a>/ <a
                href="#">color/</a> <a href="#">responsive</a>
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
                      src="img/product-image-inline-1.jpg"></a>
                    <div class="content">
                      <div class="cell-view">
                        <a href="#" class="title">Pullover Batwing
                          Sleeve Zigzag</a>
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
                        <a href="#" class="title">Pullover Batwing
                          Sleeve Zigzag</a>
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
                        <a href="#" class="title">Pullover Batwing
                          Sleeve Zigzag</a>
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
      <div>
        <a class="button style-14" href="#productInfo1">상세 정보</a> <a
          class="button style-40" href="#productInfo2">상품 리뷰</a> <a
          class="button style-40" href="#productInfo3">유의 사항</a>
      </div>
      <div class="inline-product-entry">
        ${goods.detail}
        <h1>Section 1</h1>
        <p>Try to scroll this section and look at the navigation bar
          while scrolling! Try to scroll this section and look at the
          navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar
          while scrolling! Try to scroll this section and look at the
          navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar
          while scrolling! Try to scroll this section and look at the
          navigation bar while scrolling!</p>
      </div>
      <div id="productInfo2"></div>
      <br>
      <br>
      <br>
      <br>
      <br>
      <div>
        <a class="button style-40" href="#productInfo1">상세 정보</a> <a
          class="button style-14" href="#productInfo2">상품 리뷰</a> <a
          class="button style-40" href="#productInfo3">유의 사항</a>
      </div>
      <div class="inline-product-entry">
        <h1>Enter Reviews</h1>
        <p>리뷰</p>
        <p>리뷰~~</p>
        <p>리뷰~~~~</p>
      </div>
      <div id="productInfo3"></div>
      <br>
      <br>
      <br>
      <br>
      <br>
      <div id="productInfo1">
        <a class="button style-40" href="#productInfo1">상세 정보</a> <a
          class="button style-40" href="#productInfo2">상품 리뷰</a> <a
          class="button style-14" href="#productInfo3">유의 사항</a>
      </div>
      <div class="inline-product-entry">
        <h1>Section 3</h1>
        <p>Try to scroll this section and look at the navigation bar
          while scrolling! Try to scroll this section and look at the
          navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar
          while scrolling! Try to scroll this section and look at the
          navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar
          while scrolling! Try to scroll this section and look at the
          navigation bar while scrolling!</p>
      </div>
    </div>
  </div>

  <div class="clear"></div>

  <br>
  <br>
  
  <script src="/resources/js/product.js"></script>
</body>
