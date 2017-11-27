<%@ page language="java" pageEncoding="UTF-8"%>
 
<head>
<style>

th > select.yearselect{
    float:left;
}

#imageButtonDiv{
    float:right;
    margin-top:1%;
    margin-right:1%;
}

.contentDiv{
     border:1px solid #e6e6e6;
     width:100%;
     height:auto;
     color:#92AAB0;
     margin-bottom:5%;
     padding:2%;
}

.imageId{
    display:inline-block;
    width:200px;
    height:auto;
}

</style>

<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>

<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

</head>

<body class="style-10">
    <!-- LOADER -->
    <div id="loader-wrapper">
        <div class="bubbles">
            <div class="title">loading</div>
            <span></span>
            <span id="bubble2"></span>
            <span id="bubble3"></span>
        </div>
    </div>
            <div class="content-push">
                <div class="contact-spacer"></div>
                <div class="information-blocks">
                    <div class="row">
                    <form id="registerForm" role="form" method="post" action="/product/insert">
                        <div class="col-md-12 information-entry">
                            <h3 class="block-title main-heading">공구 사전조사 등록</h3>
                                <div class="row">
                                      <div class="col-sm-6" id="divmargin">
                                          <label>공구상품 <span>*</span></label>
                                          <input class="simple-field" type="text" name="title" value="${goods.name}" disabled readonly />
                                      </div>
                                      <div class="col-sm-6">
                                          <label>공구진행날짜 <span>*</span></label>
                                          <input class="simple-field" type="text" name="date" id="date" />
                                          <div class="clear"></div>
                                      </div>
                                      
                                      <div class="col-sm-6">
                                          <label>최소인원 <span>*</span></label>
                                          <input class="simple-field" type="number" name="min" placeholder="최소인원" value=""  required/>
                                          <div class="clear"></div>
                                      </div>
                                      <div class="col-sm-6">
                                          <label>가격(￦) <span>*</span></label>
                                          <input class="simple-field" type="number" name="price" value="" required />
                                          <div class="clear"></div>
                                      </div>
                                    <input type="hidden" name="goodsNo" value="${goods.goodsNo }">
                                    <input type="hidden" name="category" value="${goods.category}">
                                      
                              </div>
                        </div>
                        <div id="imageButtonDiv">
                           <a class="button style-10">REGISTER<input type="submit" id="" value="" /></a>
                        </div>
                       </form>
                    </div>
                </div>
                <br><br>
            </div>
        <div class="clear"></div>  

<script>

$(document).ready(function(){
	var start = "";
	var end = "";
	
	$("#date").daterangepicker({
		
		locale: { format: 'YYYY/MM/DD',  
				  daysOfWeek: [ "일", "월", "화", "수", "목", "금", "토" ],
                  monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
        },
		startDate: moment(),
		endDate: moment().add(7, 'days'),
		showDropdowns : true
		
		
	});
	
	$('#date').on('apply.daterangepicker', function(ev, picker) {
		  start = picker.startDate.format('YYYY-MM-DD');
		  end = picker.endDate.format('YYYY-MM-DD');
	});
	
	/* 최종 submit버튼 */
	  $("#registerForm").submit(function(event){
			event.preventDefault();  
			 
			var that = $(this);
			
			var str = "";
			
			str += "<input type='hidden' name='startDate' value='"+start+"'>";
			str += "<input type='hidden' name='endDate' value='"+end+"'>";
			
			that.append(str);
			
			that.get(0).submit();  
			
	   });
	

}); 

</script>

</body>


