<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>


<script>
    $(document).ready(function () {
        var comData;
        var catData;
        
        //회사별 매출 데이터 저장
        getComData();
		//카테고리별 매출 데이터 저장
        getCatData();

        // Create the first chart
        $('#chart-A').highcharts({
            chart : {
                type : 'pie' 
            },
            title : {
                text : '회사별 매출' // Title for the chart
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            },
            series: [{
                name: '매출액',
                colorByPoint: true,
                data: comData
            }]
        });

        $('#chart-B').highcharts({
            chart : {
                type : 'pie' 
            },
            title : {
                text : '카테고리 판매율' // Title for the chart
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            },
            series: [{
                name: '매출액',
                colorByPoint: true,
                data: catData
            }]
        });
        
        //회사별 매출 데이터
        function getComData(){
            $.ajax({
               url : "/chart/",
               dataType : "json",
               type : "get",
               async : false,
               success : function(data){
                   comData = data;
               }
            });
        }
        
        //카테고리별 매출 데이터
        function getCatData(){
            $.ajax({
               url : "/chart/",
               type : "put",
               dataType : "json",
               async : false,
               success : function(data){
                   catData = data;
               }
            });
        }
    });//end ready
</script>

</head>
<body>
	<div class="row">

		<div class="col-sm-6">
			<div id="chart-A" class="chart"></div>
			<!-- Container for Chart A -->
		</div>
		<div class="col-sm-6">
			<div id="chart-B" class="chart"></div>
			<!-- Container for Chart B -->
		</div>
	</div>
</body>