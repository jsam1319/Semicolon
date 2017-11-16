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

          <!-- Top Menu -->
          <div class="page-selector">
            <div class="shop-grid-controls">
              <div class="entry">
                <div class="inline-text">Sort by</div>
                <div class="simple-drop-down">
                  <select id="productOrder">
                    <option value='newProduct' selected>ì ìí</option>
                    <option value='endDate'>ëëëë ì§</option>
                    <option value='deadline'>ë§ê°ì¸ì</option>
                    <option value='lowPrice'>ë®ìê°ê²©</option>
                    <option value='highPrice'>ëìê°ê²©</option>
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

          <!-- Product List -->
          <div class="row shop-grid grid-view researchView"></div>

          <div class="page-selector">
            <center>
              <a class="moreView"><i class="fa fa-angle-down"></i></a>
            </center>
            <div class="pages-box">
              <a href="#" class="square-button"><i
                class="fa fa-angle-up"></i></a>
            </div>
            <div class="clear"></div>
          </div>
        </div>
        
        
        
<!-- modal -->
<div class="modal" id="gpurchaseInfo">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      
    </div>
  </div>
</div>
<!-- /.modal -->


        
        

        <!-- Left Side Menu -->
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
            <div class="block-title size-2">Sort by price</div>
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
            <div class="block-title size-2">Sort by brands</div>
            <div class="row">
              <div class="col-xs-6">
                <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span> Armani
                </label> <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span>
                  Bershka Co
                </label> <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span>
                  Nelly.com
                </label> <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span> Zigzag
                  Inc
                </label>
              </div>
              <div class="col-xs-6">
                <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span> Armani
                </label> <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span>
                  Bershka Co
                </label> <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span>
                  Nelly.com
                </label> <label class="checkbox-entry"> <input
                  type="checkbox" /> <span class="check"></span> Zigzag
                  Inc
                </label>
              </div>
            </div>
          </div>
        </div>
        <!-- /.Left Side Menu -->
      </div>
    </div>
  </div>

  <div class="clear"></div>


  <script src="/resources/js/research.js"></script>
  <link href="/resources/css/research.css" rel="stylesheet" type="text/css"></link>
</body>
