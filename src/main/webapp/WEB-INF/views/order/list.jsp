<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<!-- Include Date Range Picker -->
<script src="/resources/js/moment.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
<style>
.cart-table {
	text-align: center;
}

.cart-table th {
	padding: 10px 15px;

}

.cart-table td{
	padding: 10px 20px;
}

th > select.yearselect{
    float:left;
}

.tag:hover {
	text-decoration: none;
    color: #ca1515;
}


</style>

<script type="text/javascript">
$(document).ready(function() {
    var start = moment().subtract(1,'month'); // 한 달 전
    var end = moment();
    var list;
    
	//구매이력 리스트 출력
    list(start.format('YY-MM-DD'), end.format('YY-MM-DD'));

    function cb(start, end) {
        $('#reportrange span').html(start.format('YYYY/MM/DD') + ' - ' + end.format('YYYY/MM/DD'));
    }

    $('#reportrange').daterangepicker({
        locale: { format: 'YYYY/MM/DD',  
			  daysOfWeek: [ "일", "월", "화", "수", "목", "금", "토" ],
              monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
  			},
  		showDropdowns : true,
    }, function(start, end, label) {
      console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
      cb(start,end);
      list(start.format('YY-MM-DD'), end.format('YY-MM-DD'));
    });

    cb(start, end);
    
    //리스트뿌려주기
    function list(start, end){
	    $.ajax({
			url : "/order/"+start+"/"+end,
			type : "put",
			headers : {
			    "Content-Type":"application/json",
			    "X-HTTP-Method-Override" : "PUT"},
			dataType : "json",
			success : function(data){
			    console.log(data);
			    print(data);
			}
	    });
    }
    
    function print(data){
        var printHtml = "";
        var printXs = ""; //모바일 화면을 위한 html
        var totalPrice, status;
        
        //데이터가 없을 때
        if(data.length == 0){ 
            var str = 
            	'<div class="container-404">'+
           		 	'<div class="description hidden-xs" >이력이 없습니다.</div>'+
           		 	'<div class="text">날짜를 다시 선택하여 주십시오.</div>'
           		 '</div>';
           		 
            $(".letter").html(str);
            $(".letter").show();
            $(".order-table").hide();
            $(".xsView").hide();
         }
        
        //데이터가 있을 때
        else{
            //모바일 화면을 위한 html
            printXs +=
                '<div class="information-blocks hidden-md hidden-sm hidden-lg">'+
		    		'<div class="row">'+
    					'<div class="col-xs-12">'+
		    				'<div class="wishlist-box">';
            
	        printHtml += 
				   '<tr>'+
						'<th class="column-3">Number</th>'+
						'<th class="column-2">Product Name</th>'+
						'<th class="column-5">Size</th>'+
						'<th class="column-2">Unit Price</th>'+
						'<th class="column-4">Qty</th>'+
						'<th class="column-4">Subtotal</th>'+
						'<th class="column-4">Status</th>'+
					'</tr>';
	      
	        
	        $.each(data, function(index, list){
	            $.each(list, function(index, item){
	                var unitPrice = numberfmt(item.unitPrice);
	                var totalPrice = numberfmt(item.totalPrice);
	                
	                printHtml +='<tr>';
	                
	                if(index == 0){
	                    printXs += 
	                     '<div class="wishlist-entry">'+
	                        '<div class="column-1">'+
	    					'<div class="traditional-cart-entry">'+
	    						'<a class="image" href="#"><img src="/resources/images/'+item.img+'"alt=""></a>'+
	    						 '<div class="content">'+
	    							'<div class="cell-view">'+
	    								'<a class="tag" href="/order/'+item.ordersNo+'">'+item.ordersNo+'</a>'+
	    								'<a class="title" href="#">'+item.name+'</a>';
	    								
	                    if(list.length > 1) {
	                        printHtml += 
	              	          '<td rowspan="'+list.length+'">';
	                    }else{
	                        printHtml += '<td>';
	                    }
	                    printHtml +=    
	                        '<p class="text-right"><a class="tag"  href="/order/'+item.ordersNo+'">'+item.ordersNo+'</a></p>'+
	        	        	'</td>'+
	        	        	'<td rowspan="'+list.length+'">'+	
	        	        		'<div class="traditional-cart-entry">'+	
	        	        			'<a href="#" class="image"><img src="/resources/images/'+item.img+'"alt=""></a>'+
	        	        				'<div class="content">'+
	        	        				'<div class="cell-view">'+
	        	        					'<a href="#" class="title">'+item.name+'</a>'+
	        	        				'</div>'+
	        	        			'</div>'+
	        	        		'</div>'+
	        	        	'</td>';
	                }
	                
	                printHtml += 
		        	'<td><div class="inline-description">'+item.sizes+'</div></td>'+
		        	'<td><div class="inline-description">'+unitPrice+'원</div> </td>'+
		        	'<td>'+
		        		'<div class="quantity-selector detail-info-entry">'+
		        			'<div class="entry number">'+item.qty+'</div>'+
		        		'</div>'+
		        	'</td>';
		        	
		        	printXs +=
		        	    '<div class="inline-description">'+item.sizes+'</div>';
		        	
		        	if(index == 0){
	                    if(list.length > 1) {
	                        printHtml += 
	              	          '<td rowspan="'+list.length+'">';
	                    }else{
	                        printHtml += '<td>';
	                    }
	                    printHtml += '<div class="subtotal">'+totalPrice+'원</div></td>';
		    	        
	                    if(list.length > 1) {
		    	            printHtml += 
	              	          '<td rowspan="'+list.length+'">';
	                    }else{
	                        printHtml += '<td>';
	                    }
		    	        printHtml += item.status+'</td>';
		    	       
		        	}
		        	
		        '</tr>';
		        
		        totalPrice = item.totalPrice;
		        status = item.status;
		
		        });
	            
	            printXs += 	'<div class="inline-description  hidden-md hidden-sm hidden-lg">'+totalPrice +'원 </div>'+
				'<div class="inline-description hidden-sm  hidden-md hidden-sm hidden-lg">'+status+'</div>'+
	            '</div></div></div></div></div>';
	        });
	        
	        printXs += '</div></div></div></div>';
	        
	        $(".letter").hide();
	        $(".order-table").html(printHtml); 
	        $(".order-table").show();
	        
	        //모바일 화면을 위한 html
	        $(".xsView").html(printXs);
	        $(".xsView").show();
   		}
    }
    
}); //end ready


function numberfmt(value) {
    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}


</script>
</head>
<body>
<div class="content-push">

	
		
	<div class="breadcrumb-box">
		<a href="/">Home</a> <a href="/member/mypage">MyPage</a> <a href="/order/">Purchase List</a>
	</div>
	
	<div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 30%">
			<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>&nbsp;
			<span></span> <b class="caret"></b>
	</div>

	<div class="col-sm-12 information-blocks">
		<div class="table-responsive col-sm-12">
			<div class="letter"></div>
			<div class="xsView"></div>
			<table class="cart-table order-table col-sm-12 hidden-xs">
			</table>
		</div>
	</div>
	<div></div>
</div>
<div></div>
<div class="clear"></div>
</body>

