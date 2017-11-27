<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

<!-- 키워드(Tags Input) -->
<meta name="keywords" content="">
<script src="/resources/tagsinput/bootstrap-tagsinput.js"></script>
<link href="/resources/tagsinput//bootstrap-tagsinput.css"
  rel="stylesheet">

<!-- CK EDITOR -->
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>

<script src="/resources/js/goodsInsert.js"></script>
<link href="/resources/css/goodsInsert.css" rel="stylesheet" type="text/css"></link>

</head>

<body class="style-10">
  <!-- LOADER -->
  <div id="loader-wrapper">
    <div class="bubbles">
      <div class="title">loading</div>
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>

<%-- 사이즈 Modal 영역 시작 --%>
  <div class="modal" id="sizeModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content modalSizing">
        <div class="modal-header">
          <button type="button" class="close" id="modalClose"
            data-dismiss="modal">
            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
          </button>
          <h4 class="modal-title">상세사이즈</h4>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>상품분류 <span>*</span></label>
            <div class="simple-drop-down simple-field">
              <select id="selectClothing" name="selectClothing" required>
                <option>분류</option>
                <option value="top">상의</option>
                <option value="bottom">하의</option>
              </select>
            </div>
            <div class="selectOption"></div>

            <div class="addOption"></div>
          </div>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-default addSizeBtn">Add
            Size</button>
          <button type="button" class="btn btn-default modalClose"
            data-dismiss="modal">Push</button>
        </div>
      </div>
    </div>
  </div>
<%-- 사이즈 Modal 영역 종료 --%>

<%-- Main 영역 시작 --%>
  <div class="content-push">
    <div class="contact-spacer"></div>
    <div class="information-blocks">
      <div class="row">
        <form id="registerForm" role="form" method="post">
          <div class="col-md-12 information-entry">
            <h3 class="block-title main-heading">Upload the Goods</h3>
            <div class="row">
              <div class="col-sm-6" id="dropDiv">
                <label>상품이름 <span>*</span></label> <input
                  class="simple-field" type="text" name="name" required />
              </div>
              <div class="col-sm-6" id="dropDiv">
                <label>상품가격 <span>*</span></label> <input
                  class="simple-field" type="number" name="price" required />
                <div class="clear"></div>
              </div>


            </div>

            <div class="row">
              <div class="col-sm-3" id="dropDiv">
                <label>Front Images (메인 이미지 2장 Drag&Drop) <span>*</span></label>
                <div class="mainImages"></div>
              </div>
              <div class="col-sm-9" id="dropDiv">
                <label>상품정보<span>*</span></label>
                <textarea class="simple-field" id="detail" name="detail" required
                  rows="15" placeholder="상품에 대한 설명과 상품 상세 이미지 추가"></textarea>
                <input type="hidden" name="col" value="black">
              </div>

              <div class="hiddenSize"></div>
            </div>
            <div class="col-sm-12">
              <label>키워드 <span>*</span></label> <input type="text"
                class="simple-field keyword" data-role="tagsinput"
                name="keywordName" id="keyword">
            </div>
          </div>
          <div id="imageButtonDiv">
            <a class='button style-12 sizing' data-toggle='modal'
              data-target='#sizeModal'>Size</a> <a
              class="button style-10">REGISTER<input type="submit"
              value="" /></a>
          </div>
        </form>
          
      </div>
      <br><br><br>
    </div>
  </div>
  <div class="clear"></div>

<%-- Main 영역 종료 --%>


</body>


