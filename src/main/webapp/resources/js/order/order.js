$(document).ready(function(){
	
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
      
      
     $(document).on("change", "#cardType", function(){
    	 cardType = this.value
    	 
    	 console.log(cardType)
     }) 
      
      
});