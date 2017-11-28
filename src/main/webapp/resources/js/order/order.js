$(document).ready(function(){
	
	/** totalOrder, qty 출력하기 */
	var orderQty = $("input[name='orderQty']")
	var op = $("#orderPrice").val()
    var oq = 0;
    
    for (var i = 0; i < orderQty.length; i++) {
    	oq += Number(orderQty[i].value)
	}
    
	$(".qty").html(oq)
	
	var total = Number(oq) * Number(op)
	$(".totalPrice").html("₩ "+total)
	
	
	
	
	/** 결제 방법_카드 선택 시 .html */
      $("input[name='method']").change(function(){
        var checked = $(this).val()
        
        if(checked == 'card') {
          var str = "";
          str += ""
          str += "<form> <div class='row col-sm-2'> <label>카드 종류</label>"
          str += "</div><div class='row col-sm-3'><div class='simple-drop-down simple-field-size-1'>"
          str += "<select id='cardType'>"
          str += "<option selected>종류</option>"
          str += "<option>롯데</option>"
          str += "<option>신한</option>"
          str += "<option>농협</option>"
          str += "<option>우리</option>"
          str += "<option>현대</option>"
          str += "<option>국민</option>"
          str += "<option>BC</option>"
          str += "<option>삼성</option>"
          str += "<option>우리</option>"
          str += "</select></div></div> <div class='row col-sm-4'>"
          str += "<label class='order-alertMsg'>※결제하실 카드의 종류를 선택해주세요</label>"
          str += "</div></form>"
          
          $(".cardChoice").show();
          $(".cardChoice").html(str);
          
        } else {
          $(".cardChoice").hide();
        }
      })
      
      
      /** 선택하는 card의 정보 */
     $(document).on("change", "#cardType", function(){
    	 cardType = this.value
    	 
    	 var cardInfo = "<input type='hidden' name='cardInfo' value='"+cardType+"'>"
         $(".cardInfo").html(cardInfo)
    	 
     }) 
     
     
     $("#orderForm").submit(function(e){ 
        e.preventDefault();
        
        /** 기본주소+상세주소 */
        var add1 = $("#receiverAddress1").val()
        var add2 = $("#receiverAddress2").val()
        var add3 = " ";
        var add = add1 + add3 + add2
        
		var orderItem = $("#orderlist").val()
		console.log(orderItem)
		var orderJSON = JSON.stringify(orderItem)
		
		console.log(orderJSON)
        
        var submitStr = "";
        submitStr += "<input type='hidden' name='address' value='"+add+"'>";
        submitStr += "<input type='hidden' name='payPrice' value='"+total+"'>";
        submitStr += "<input type='hidden' name='price' value='"+total+"'>";
        submitStr += "<input type='hidden' name='orderlist' value='"+orderJSON+"'>";

        $(this).append(submitStr)
        
      //  $(this).get(0).submit();
     })
     
     
     
     			/** 주문정보 = 배송정보 */
            	var orderName = $("#orderName").val()
            	var orderPhone = $("#orderPhone").val()
            	var orderPost = $("#orderPost").val()
            	var orderAddress = $("#orderAddress").val()
            	var empty = "";
            	
              $("#orderInfoCk").change(function(){
                if($("#orderInfoCk").is(":checked")){
                	$("#receiverName").val(orderName)
                	$("#receiverPhone").val(orderPhone)
                	$("#receiverPost").val(orderPost)
                	$("#receiverAddress1").val(orderAddress)
                } else {
                	$("#receiverName").val(empty)
                	$("#receiverPhone").val(empty)
                	$("#receiverPost").val(empty)
                	$("#receiverAddress1").val(empty)
                }
              })
              
              
              $(document).on("click", ".daumPost", function(){
            	  daumPostcode()
              })
              
              
              
              
              /** 주소 API */
                 function daumPostcode() {
                     new daum.Postcode({
                         oncomplete: function(data) {
                             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
             
                             // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                             var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                             var extraRoadAddr = ''; // 도로명 조합형 주소 변수
             
                             // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                             // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                             if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                                 extraRoadAddr += data.bname;
                             }
                             // 건물명이 있고, 공동주택일 경우 추가한다.
                             if(data.buildingName !== '' && data.apartment === 'Y'){
                                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                             }
                             // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                             if(extraRoadAddr !== ''){
                                 extraRoadAddr = ' (' + extraRoadAddr + ')';
                             }
                             // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                             if(fullRoadAddr !== ''){
                                 fullRoadAddr += extraRoadAddr;
                             }
             
                             // 우편번호와 주소 정보를 해당 필드에 넣는다.
                             document.getElementById('receiverPost').value = data.zonecode; //5자리 새우편번호 사용
                             document.getElementById('receiverAddress1').value = fullRoadAddr;
                            /*  document.getElementById('addressDetail').removeAttribute('disabled');
             					
                             document.getElementById('guide').innerHTML = '(상세주소 예 : 101동 101호)'; */
                             
                         }
                     }).open();
                 }
              
              
});