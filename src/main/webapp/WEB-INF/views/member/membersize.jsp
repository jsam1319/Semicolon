<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<style>
.info{
	display: block;
	font-size: 48px;
	line-height: 48px;
	color: #da75cb;
}

.cm{
	font-size:10px;
	color:#6f6e6e;
}
</style>

<script>


$(document).ready(function(){
    $(".memberNo").hide(); // hidden으로 처리하기 위해

    $("#bottom").change(function(){
      	var url = "/size/pants/"+$(this).val();
    	callAjax(url);
    	var url = "/size/shortPants/"+$(this).val();
    	callAjax(url);
    });
    
    $("#skirt").change(function(){
    	var url = "/size/skirt/"+$(this).val();
    	callAjax(url);
    });
    
    $("#top").change(function(){
    	var url = "/size/tops/"+$(this).val();
    	callAjax(url);
     });
    
    $("#height").change(function(){
        var size = $(this).val();
        
        if(size == 'xs'){  $("input[name=fullLength]").val(83);  } 
        if(size == 's'){  $("input[name=fullLength]").val(87);  } 
        if(size == 'm'){  $("input[name=fullLength]").val(90);  }
        if(size == 'l'){  $("input[name=fullLength]").val(92);  } 
    });
});

var callAjax = function(data){
    $.ajax({
  	    url: data,
  	    type:"get",
  	    dataType : "json",
  	    success : function(data){
  	       inputData(data);
  	    }
  	});
}

//사이즈에 따른 상세정보 입력
var inputData = function(data){
    console.log("Data:"+data);
    console.log(data.topsNo);
    
    if(data.types == "top"){ 
        $("input[name=sleeve]").val(data.sleeveLength); 
        $("input[name=top]").val(data.fullLength);
    }
    
    else if(data.types == "pants" || data.types == "shortPants" ){
        $("input[name=waist]").val(data.waist); 
        $("input[name=hip]").val(data.hip); 
        $("input[name=thigh]").val(data.thigh); 
        $("input[name=rise]").val(data.rise); 
        if(data.types == "pants") { $("input[name=pants]").val(data.fullLength); }
        if(data.types == "shortPants") { $("input[name=shortPants]").val(data.fullLength); }
    }
    
    else { //skirt
        $("input[name=waist]").val(data.waist); 
        $("input[name=hip]").val(data.hip); 
        $("input[name=skirt]").val(data.fullLength); 
    }
   
}


</script>
<div class="information-blocks">
	
	<div class="information-entry">
        <div class="sale-entry">
	        <div class="sale-price"><span>INFO</span></div>
	        <div class="sale-description" style="color:#000000">여러분의 상세 사이즈 정보를 입력해주세요. <br>
		        	귀하의 소중한 정보를 이용해 체형별로 맞춤 제품을 추천해주기 위해서 사용할 예정입니다.<br>
					자신의 정확한 사이즈를 모른다면 원하는 대략의 사이즈를 입력해주세요 :)	
			</div>
			 <div class="sale-description" style="color:#ff0000">
					바지·상의·치마 사이즈를 선택하시면 자동으로 상세 사이즈가 입력됩니다. <br>
					본인 사이즈를 알고 계실 때에는 값을 수정해서 저장하시면 됩니다.
			 </div>
     	</div>              
    	<br>
    	
    	<hr>
    	<div class="col-sm-12" style="padding-left:17%">
    		<img src="/resources/img/size.JPG"  align="center">
    		<hr><br>
    	</div>
    	
    
		<form action="/size/" method="post">
			<div class="row">
				<input type="number" value="${no}" name="memberNo" class="memberNo">
				<div class="col-sm-6">
					<label>바지사이즈</label>
					<div class="simple-drop-down simple-field ">
	                     <select id="bottom">
	                        <option value="none">None</option>
	                        <option value="24">24</option>
	                        <option value="25">25</option>
	                        <option value="26">26</option>
	                        <option value="27">27</option>
	                        <option value="28">28</option>
	                        <option value="29">29</option>
	                        <option value="30">30</option>
	                     </select>
	                </div>
	                <div class="clear"></div>
                </div>
                <div class="col-sm-6">
					<div class="simple-drop-down simple-field ">
					<label>치마사이즈</label>
	                     <select id="skirt">
	                     	<option value="none">None</option>
	                        <option value="xs">xs</option>
	                        <option value="s">s</option>
	                        <option value="m">m</option>
	                        <option value="l">l</option>
	                     </select>
	                </div>
	                <div class="clear"></div>
                </div>
                <div class="col-sm-6">
					<label>상의사이즈</label>
					<div class="simple-drop-down simple-field" >
	                     <select id="top">
	                     	<option value="none">None</option>
	                     	<option value="xs">xs</option>
	                     	<option value="s">s</option>
	                        <option value="m">m</option>
	                        <option value="l">l</option>
	                        <option value="xl">xl</option>
	                      </select>
	                      <div class="clear"></div>
	                </div>
	                <div class="clear"></div>
                </div>
                
                <div class="col-sm-6">
					<label>키</label>
					<div class="simple-drop-down simple-field" >
	                     <select id="height">
	                     	<option value="none">None</option>
	                     	<option value="xs">140~149</option>
	                     	<option value="s">150~159</option>
	                        <option value="m">160~169</option>
	                        <option value="l">170~179</option>
	                      </select>
	                      <div class="clear"></div>
	                </div>
	                <div class="clear"></div>
                </div>
				
				<hr>
				
				<div class="col-sm-6">
					<label> 허리둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="WAIST" name="waist" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 허벅지둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="THIGH" name="thigh" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 밑위둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="RISE" name="rise" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 엉덩이둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="HIP" name="hip" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 총 길이(원피스 또는 코트) <span class="cm">( cm )</span> </label> 
					<input class="simple-field" type="number" placeholder="TOTAL LENGTH" name="fullLength" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 긴바지 길이 <span class="cm">( cm )</span> </label> 
					<input class="simple-field" type="number" placeholder="PANTS LENGTH" name="pants" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 반바지 길이 <span class="cm">( cm )</span> </label> 
					<input class="simple-field" type="number" placeholder="SHORT PANTS LENGTH" name="shortPants" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 소매 길이 <span class="cm">( cm )</span> </label> 
					<input class="simple-field" type="number" placeholder="SLEEVE LENGTH" name="sleeve" step="any"> 
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 상의 총 길이 <span class="cm">( cm )</span> </label> 
					<input class="simple-field" type="number" placeholder="TOPS FULL LENGTH" name="top" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 치마 길이 <span class="cm">( cm )</span> </label> 
					<input class="simple-field" type="number" placeholder="SKIRT FULL LENGTH" name="skirt" step="any">
					<div class="clear"></div>
				</div>
				<div class="col-sm-12">
					<p class="text-right"><input type="submit" value="Submit" class="button style-10" step="any"><p>
				</div>
				</div><%--./row --%>
		</form>
	</div><%-- ./information-entry --%>
</div>

<div></div>