-
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="/resources/js/moment.js"></script>

<script>
    $(document).ready(function () {
        var seriesData;  //차트 y축
        var xAxisData; //차트 x축
        
        getData();  //그래프를 그리는데 필요한 data를 받아온다
        
        //차트 그림
        var myChart = Highcharts.chart('container', {
            chart: {
                type: 'line'
            },
            title: {
                text: '회사별 매출액'
            },
            subtitle: {
                text: '각 회사의 달 별 매출액'
            },
            xAxis: {
                categories: xAxisData
            },
            yAxis: {
                title: {
                    text: 'sales'
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: true
                }
            },
            series: seriesData
            
        });
     
        
        //차트를 그리는데 필요한 data를 받아온다
        function getData(){
            var sDate = $("#start").text();
    		var eDate = $("#end").text();
            var diff = moment(eDate).diff(sDate, "months") + 1;
            
            console.log("sDate:"+sDate+",eDate:"+eDate+",diff:"+diff);
            
            $.ajax({
               url : "/chart/",
               type : "post",
               dataType : "json",
               async : false,
               data : { start : sDate, end : eDate, size : diff },
               success : function(data){
                	seriesData = data.seriesData;
                	console.log(seriesData);
                	
                	xAxisData = data.xAxisData;
                	console.log(xAxisData);
               }         
            });
        }
        
        //차트 업데이트
        function update(){
            alert("update");
            myChart.update({
                xAxis: {
                    categories:xAxisData  
                },
                series: seriesData
                    /* [{
                }] */
                    
            });
        }
        

        //시작 날짜 감소
        $(".start.reduce").click(function(){
           $("#start").text(changeDate($("#start").text(),-1));
           getData();
           update();
        });
        
        //시작 날짜 증가
        $(".start.implove").click(function(){
            if(moment($("#start").text()).isBefore(moment($("#end").text()))){ //endDate보다 숫자가 올라가는 것을 막기 위해
	            $("#start").text(changeDate(dateStr,1));
	            getData();
	            update();
            }
         });
        
        //종료 날짜 감소
        $(".end.reduce").click(function(){
            if( moment($("#start").text()).isBefore(moment($("#end").text())) ){//startDate보다 숫자가 내려가는 것을 막기 위해
	            $("#end").text(changeDate(dateStr, -1));
	            getData();
	            update();
            }
         });
        
        //종료 날짜 증가
        $(".end.implove").click(function(){
            $("#end").text(changeDate($("#end").text(), 1));
            getData(); 
            update();
         });
        
    }); //end ready
    
    
    //date 감소,증가시켜서 string 값으로 반환
    function changeDate(dateStr, size){
        var originalM = moment(dateStr);
        var resultM = originalM.add(size,'M');
        
        return resultM.format('YYYY/MM');
    }
</script>

</head>
<body>
	<div class="container">
		<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		
		<div class="row information-entry" style="text-align:center;">
				<a class="square-button start reduce"> <i class="fa fa-angle-left"></i></a>
				<a class="square-button start implove"><i class="fa fa-angle-right"></i></a>
				<button class="button style-2" id="start">2017/06</button>
				<button class="button style-2" id="end">2017/12</button>
				<a class="square-button end reduce"> <i class="fa fa-angle-left"></i></a>
				<a class="square-button end implove"><i class="fa fa-angle-right"></i></a>
		</div>
		<div></div>
	</div>
</body>