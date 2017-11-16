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
console.log("아이디"+"${login.memberNo}");
</script>
<div class="information-blocks">
	
	<div class="information-entry">
        <div class="sale-entry">
	        <div class="sale-price"><span>INFO</span></div>
	        <div class="sale-description" style="color:#000000">여러분의 상세 사이즈 정보를 입력해주세요. <br>
		        	귀하의 소중한 정보를 이용해 체형별로 맞춤 제품을 추천해주기 위해서 사용할 예정입니다.<br>
					자신의 정확한 사이즈를 모른다면 원하는 대략의 사이즈를 입력해주세요. :)		
		 	</div>
     	</div>              
    	<br>
    
		<form action="#" method="post">
			<div class="row">
				<input class="simple-field" type="number" value="${login.memberNo}" name="memberNo">
				<div class="col-sm-6">
					<label> 허리둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="WAIST" name="waist">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 허벅지둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="THIGH" name="thigh">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 밑위둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="RISE" name="rise">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 엉덩이둘레 <span class="cm">( cm )</span></label> 
					<input class="simple-field" type="number" placeholder="HIP" name="hip">
					<div class="clear"></div>
				</div>
				<div class="col-sm-6">
					<label> 총 길이(원피스 또는 코트) <span class="cm">( cm )</span> </label> 
					<input class="simple-field" type="number" placeholder="TOTAL LENGTH" name="totalLength">
					<div class="clear"></div>
				</div>
				<div class="col-sm-12">
					<p class="text-right"><input type="submit" value="Submit" class="button style-10"><p>
				</div>
				</div><%--./row --%>
		</form>
	</div><%-- ./information-entry --%>
</div>

<div></div>