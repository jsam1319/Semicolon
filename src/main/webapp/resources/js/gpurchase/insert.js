
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
