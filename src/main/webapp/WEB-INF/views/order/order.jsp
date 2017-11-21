<%@ page contentType="text/html; charset=utf-8"%>
<body class="style-10">

  <!-- LOADER -->
  <div id="loader-wrapper">
    <div class="bubbles">
      <div class="title">loading</div>
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>
  <div class="clear"></div>
  <div class="clear"></div>

  <div class="content-push orderinfomation-blocks">

    <div class="row page-selector hidden-xs">
      <div class="col-md-2 col-sm-1"></div>
      <div class="col-md-3 col-sm-2 form-group">
        <label>상품명</label>
      </div>
      <div class="col-md-2 col-sm-1 ">
        <label>상품가격</label>
      </div>
      <div class="col-md-2 col-sm-1 ">
        <label>수량</label>
      </div>
      <div class="col-md-2 col-sm-1 ">
        <label>합계</label>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-5 form-group">
        <div class="traditional-cart-entry">
          <div class="col-md-3 col-sm-1">
            <a href="#" class="image"><img class="order-image"
              src="/resources/img/ex/cat.jpg" alt=""></a>
          </div>
          <div class="order-content">
            <div class="cell-view order-content">
              <a href="#" class="tag">CompanyName</a> <a href="#"
                class="title">GoodsName</a>
              <div class="inline-description">Size / Color</div>
            </div>
          </div>
        </div>

      </div>
      <div class="col-sm-2 form-group">
        <label>8000</label>
      </div>
      <div class="col-sm-2 form-group">
        <label>2</label>
      </div>
      <div class="col-sm-2 form-group">
        <label>16000</label>
      </div>
    </div>


  </div>
  <div class="inline-order-entry"></div>
  <div class="clear"></div>
<div class="enterContent-1"></div>

  <div class="orderinfomation-blocks">
    <div class="accordeon">
      <div class="accordeon-title active">
        <h3 class="block-title order-main-heading">주문자 정보</h3>
      </div>
      <div style="display: block;" class="accordeon-entry">
        <div class="article-container style-1">

          <form>

            <div class="row">
              <div class="col-sm-4 form-group">
                <label>성명<span>*</span></label> <input
                  class="simple-field" type="text" required value="" />
              </div>
              <div class="col-sm-4 form-group">
                <label>전화번호<span>*</span></label> <input
                  class="simple-field" type="text" required value="" />
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 form-group">
                <label>주소 <span>*</span></label> <input
                  class="simple-field" type="text" value="" />
              </div>
              <div class="col-sm-4 form-group">
                <label><span></span></label>
                <div class="button style-10">
                  우편번호 찾기<input type="submit" value="" />
                </div>
              </div>
              <div class="clear"></div>
              <div class="col-sm-4 form-group">
                <input class="simple-field" type="text" required
                  value="" />
              </div>
              <div class="col-sm-5 form-group">
                <input class="simple-field" type="text" required
                  value="" />
              </div>
            </div>
          </form>

        </div>
      </div>

<div class="enterContent-1"></div>

      <div class="accordeon-title active">
        <h3 class="block-title order-main-heading">배송지 정보</h3>
      </div>
      <div class="accordeon-entry">
        <div class="article-container style-1">

          <form>

            <div class="row">
              <div class="col-sm-4 form-group">
                <label>성명<span>*</span></label> <input
                  class="simple-field" type="text" required value="" />
              </div>
              <div class="col-sm-4 form-group">
                <label>전화번호<span>*</span></label> <input
                  class="simple-field" type="text" required value="" />
              </div>
            </div>
            <div class="row">
              <div class="col-sm-3 form-group">
                <label>주소 <span>*</span></label> <input
                  class="simple-field" type="text" value=""
                  placeholder="우편번호" />
              </div>
              <div class="col-sm-4 form-group">
                <label><span></span></label>
                <div class="button style-10">
                  우편번호 찾기<input type="submit" value="" />
                </div>
              </div>
              <div class="clear"></div>
              <div class="col-sm-4 form-group">
                <input class="simple-field" type="text" required
                  value="" placeholder="기본주소" />
              </div>
              <div class="col-sm-5 form-group">
                <input class="simple-field" type="text" required
                  value="" placeholder="상세주소" />
              </div>
            </div>
            <div class="row">
              <div class="col-sm-10 form-group">
                <label>배송 메세지 <span>*</span></label>
                <textarea class="simple-field" required></textarea>
              </div>
            </div>

          </form>

        </div>
      </div>

      <div class="clear"></div>

      <div class="enterContent-1"></div>

      <div class="accordeon-title">
        <h3 class="block-title order-main-heading">결제 정보</h3>
      </div>
      <div class="accordeon-entry">
        <div class="article-container style-1">
          <div class="row">
            <div class="col-sm-2 form-group">
              <label class="checkbox-entry radio"> <input
                type="radio" name="method" value="card"> <span
                class="check"></span> 신용카드
              </label>
            </div>
            <div class="col-sm-2 form-group">
              <label class="checkbox-entry radio"> <input
                type="radio" name="method" value="phone"> <span
                class="check"></span> 휴대폰결제
              </label>
            </div>
            <div class="col-sm-2 form-group">
              <label class="checkbox-entry radio"> <input
                type="radio" name="method" value="bankbook"> <span
                class="check"></span> 무통장입금
              </label>
            </div>
            <div class="col-sm-2 form-group">
              <label class="checkbox-entry radio"> <input
                type="radio" name="method" value="creditTransfer"> <span
                class="check"></span> 계좌이체
              </label>
            </div>
            <div class="col-sm-2 form-group">
              <label class="checkbox-entry radio"> <input
                type="radio" name="method" value="kakaoPay"> <span
                class="check"></span> 카카오페이
              </label>
            </div>
          </div>
        </div>
      </div>

<div class='col-sm-10 cardChoice'></div>


    </div>

<div>
<div class="col-sm-10"></div>
<div class="button style-10">결제하기<input type="submit" value="" /></div>
</div>

  </div>

<div class="enterContent-2"></div>

  <div class="clear"></div>
  
  <script src="/resources/js/order.js"></script>

</body>
