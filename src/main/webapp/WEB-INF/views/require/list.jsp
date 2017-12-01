<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

<script src="/resources/js/require/requireList.js"></script>
<link href="/resources/css/require/requireList.css" rel="stylesheet"
  type="text/css"></link>

</head>

<body class="style-10">

  <!-- LOADER -->
  <div id="loader-wrapper">
    <div class="bubbles">
      <div class="title">loading</div>
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>

  <%-- Modal 영역 시작 --%>
  <div class="modal" id="titleModal">
    <div class="modal-dialog modal-m">
      <div class="modal-content modalSizing">
        <div class="modal-header">
          <button type="button" class="close" id="modalClose"
            data-dismiss="modal">
            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
          </button>
          <h4 class="modal-title">공구요청 상세내용보기</h4>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <div class="row">
              <div class="col-sm-12">
                <label>상품이미지</label><img id="imageinmodal" src="">
                <label>제목</label><input class="simple-field" type="text"
                  id="titleinmodal" value="" readonly />
                <div class="col-sm-12 Outer">
                  <div class="col-sm-6 priceDiv">
                    <input type="hidden" id="requireNo" value="" /> <label>희망가격</label><input
                      class="simple-field" type="text" id="priceinmodal" value="" readonly />
                  </div>
                  <div class="col-sm-6 companyDiv">
                    <label>회사명(제조사)</label><input class="simple-field"
                      type="text" id="companyinmodal" value="" readonly />
                  </div>
                </div>
                <label>요청내용</label>
                  <textarea class="simple-field" id="contentinmodal" readonly></textarea>
                  <label>관리자 답변내용</label>
                  <textarea class="simple-field" id="commentsinmodal" readonly></textarea>
              </div>
            </div> 
          </div>
        </div>
        <c:if test="${no eq -1}">
          <div class="modal-footer" id="replyDiv">
            <label>관리자 답변등록 <span>*</span></label> <input
              class="simple-field" id="leaveComments" type="text"
              value="" />
          </div>
        </c:if>

        <div class="modal-footer">
          <c:if test="${no eq -1}">
            <button type="button" class="btn btn-default" id="addReply">Reply</button>
          </c:if>
          <button type="button" class="btn btn-default modalClose"
            data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  <%-- Modal 영역 종료 --%>

  <div class="content-push">

    <div class="breadcrumb-box">
      <a href="/">Home</a> <a href="#">공구 요청</a>
    </div>

    <div class="information-blocks">
      <div class="portfolio-container type-1">
        <div class="portfolio-navigation">
          <div class="links-drop-down">
            <div class="list">
              <a class="active" href="#">All</a>
              <a class="button style-7" id="writeBtn"
                href="/require/insert">Write</a>
            </div>
          </div>
        </div>
        <div class="row articleRow"></div>
      </div>

      <div class="row shop-grid grid-view listView"></div>
      <div class="page-selector">
        <a class="moreView"><i class="fa fa-angle-down"></i></a>
        <div class="pages-box">
          <a href="#" class="square-button"><i
            class="fa fa-angle-up"></i></a>
        </div>
        <div class="clear"></div>
      </div>
    </div>

  </div>
  <br>
  <br>
  <br>
  <div class="clear"></div>


</body>
