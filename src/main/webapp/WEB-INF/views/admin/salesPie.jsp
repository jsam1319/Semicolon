
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script>
    $(document).ready(function () {
        var rs;
        getData();
        
        var myChart = Highcharts.chart('container', {
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: ' 회사 매출액 비교'
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
                data: rs
            }]
        });
        
        
        function getData(){
            $.ajax({
               url : "/chart/",
               dataType : "json",
               async : false,
               success : function(data){
                   rs = data;
               }
            });
        }
        
        
    }); //end ready
   

</script>
</head>
<body>
	<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
</body>