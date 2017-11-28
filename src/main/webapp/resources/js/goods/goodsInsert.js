
var i = 0;
var front = true;

$(document).ready(function(){ 
	 
  /* CK EDITOR */
  CKEDITOR.replace("detail", {'filebrowserUploadUrl' : '/goods/ckupload'});
  var imageValue = [];
  
  CKEDITOR.on('dialogDefinition', function (ev) {
	  
      var dialogName = ev.data.name;
      var dialog = ev.data.definition.dialog;
      var dialogDefinition = ev.data.definition;
      
      if (dialogName == 'image') {
          dialog.on('show', function (obj) {
        	  this.selectPage('Upload'); //업로드탭으로 시작
          });
          
          dialog.on('ok', function(obj) {
        	  imageValue.push($("input").filter(".cke_dialog_ui_input_text").first().val());
          })
          
          dialogDefinition.removeContents('advanced'); // 자세히탭 제거
          dialogDefinition.removeContents('Link'); // 링크탭 제거
      }
  });
	 
  $(".mainImages").on("dragenter dragover", function(event){
	    event.preventDefault();
  });
  
  var i = 0;
  
  $(".mainImages").on("drop", function(event){
	  
	    event.preventDefault();
	     
	    var files = event.originalEvent.dataTransfer.files;
	    var file = files[0];
	    
	    var formData = new FormData();
	    formData.append("file", file);
	    
	    
	   $.ajax({
		   
	    	url:'/goods/upload',
	    	data:formData,
	    	dataType:'text',
	    	processData:false,
	    	contentType:false,
	    	type:'POST',
	    	success: function(data){
	    		
	    		i += 1;
	    		var str="";
	    		str += "<div>";
	    		str += "<img class='images images"+i+"' src='"+data+"'/>";
	    		str += "<button type='button' class='close imageDelete'>";
		  		str += "<span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span>";
		  		str += "</button>";
		  		str += "</div>";
	    		$(".mainImages").append(str);
	    		
	    		$(".imageDelete").each(function(){
	    			  $(this).on("click", function(){
	    				  $(this).parent().remove();
	    			  });
	    		  });
	    	}
	    });
	   
	   var formData = new FormData();
	    formData.append("image", file);
	   
		  if(front) {
			   /* 파이썬 미들 서버 호출 (분류기)*/
			   $.ajax({
					  url : 'http://localhost:8000/polls/',
					  data : formData,
					  dataType : 'JSON',
					  crossDomain: true,
					  processData:false,
				    contentType:false,
				    type:'POST',
				    success: function(data){
				    	console.log(data);
				    	data = data[0];
				    	
				    	category = data.category;
				    	value = data.class;
				    	
				    	console.log(category + " : " + value);

				    	clothEvent(category);
				    	$("#selectClothing").val(category);
				    	$('.selectOption select').val(value);
				    	
				    	front = false;
				    	}, 
				    error : function(data, a, b ) {
				    	console.log(data);
				    	console.log(a);
				    	console.log(b);
				    }
			   })
		   }	
	});
  
  
  /** 사이즈 Modal 이벤트 영역 */
  $("#selectClothing").change(function() {
	  clothEvent($(this).val());
  	})
  
  $(".addSizeBtn").on("click", function(){
	  
	  var option = $("#selectClothing").val();
	  var str = "";
	  
	  if(option == 'top'){
		  str = topBase();
		  $(".addOption").append(str);
		  
	  }else{
		  
		  var bottomOption = $("select[name='option']");
		  
		  var data = "";
		  
		  if(bottomOption.val() == 'skirt'){
			  
			  data = "<option>사이즈 선택</option>" +
		  		 	 "<option value='xs'>XS</option>" +
		  		 	 "<option value='s'>S</option>" +
		  		 	 "<option value='m'>M</option>" +
		  		 	 "<option value='l'>L</option>" +
		  		 	 "<option value='xl'>XL</option>" +
		   		 	 "<option value='free'>FREE</option>";
		   		 
		  str = bottomBase(data);
			  
		  }else{
			  
			  data = "<option>사이즈 선택</option>" +
    	  		 	 "<option value='24'>24</option>" +
    	  			 "<option value='25'>25</option>" +
    	  			 "<option value='26'>26</option>" +
    	  			 "<option value='27'>27</option>" +
    	  			 "<option value='28'>28</option>" +
    	  			 "<option value='29'>29</option>" +
    	  			 "<option value='30'>30</option>" +
    	   			 "<option value='free'>FREE</option>";
	   	
		  str = bottomBase(data);
			  
		  }
		  
		  $(".addOption").append(str);
		  
	  }
  });
  
  function addingOp(value){
	  
	  var str = "";
	  
	  str += "<div class='upperdiv'>";
	  str += "<label>종류</label>";
  	  str += "<div class='simple-drop-down simple-field'>";
  	  str += "    <select class='option' name='option' required>";
	  str += value;
	  str += "    </select>";
  	  str += "</div>";
  	  str += "</div>";
  	  
  	  return str;
      	  
  }
  
  function topBase(){
	  
	  var str = "";
	 
	  str += "<div class='outerDiv'>";
	  str += "<button type='button' class='close optionDelete'>";
	  str += "<span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span>";
	  str += "</button>";
	  
	  str += "<div class='dividingThree'>"
	  str += 	"<label class='control-label'>사이즈</label>";
	  str += "	<div class='simple-drop-down simple-field addContext'>";
	  str += "		<select class='sizeSelect' name='sizeSelect' required>";
	  str += "			<option>사이즈 선택</option>";
	  str += "			<option value='xs'>XS</option>";
	  str += "			<option value='s'>S</option>";
	  str += "			<option value='m'>M</option>";
	  str += "			<option value='l'>L</option>";
	  str += "			<option value='xl'>XL</option>";
	  str += "			<option value='free'>FREE</option>";
	  str += "		</select>";
	  str += "	</div> ";
	  str += "</div> ";
	  
	  str += "<div class='form-group dividingThree'>";
	  str += "<label>팔길이(cm)</label>";
	  str += "<input class='simple-field sleeveLength' type='number' name='sleeve' required />";
	  str += "</div>";
	  str += "<div class='form-group dividingThree'>";
	  str += "<label>총길이(cm)</label>";
	  str += "<input class='simple-field fullLength' type='number' name='full' required />";
	  str += "</div> ";
	  
	  str += "</div> ";
	  
	  $(document).on("click", ".optionDelete", function(){
		  $(this).parent().remove();
	  });
	  
	  return str;
  }
  
  
  function bottomBase(data){
	  var str = "";
	  
	  str += "<div class='outerDiv'>"
	  str += "<button type='button' class='close optionDelete'>";
	  str += "<span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span>";
	  str += "</button>";
	  
	  str += "<div class='dividingSix'>";
	  str += "<label class='control-label'>사이즈</label>";
	  str += "<div class='simple-drop-down simple-field addContext'>";
	  str += "<select id='bottomSizeSelect' name='bottomSizeSelect' required >";
	  
	  str += data;
	  
	  str += "</select>";
	  str += "</div> ";
	  str += "</div> ";
	  
	  str += "<div class='form-group dividingSix'>";
	  str += "<label>허리둘레(cm)</label>";
	  str += "<input class='simple-field waist' type='text' name='waist' required />";
	  str += "</div>";
	  str += "<div class='form-group dividingSix'>";
	  str += "<label>밑위길이(cm)</label>";
	  str += "<input class='simple-field rise' type='text' name='rise' required />";
	  str += "</div>";
	  str += "<div class='form-group dividingSix'>";
	  str += "<label>엉덩이둘레(cm)</label>";
	  str += "<input class='simple-field hip' type='text' name='hip' required />";
	  str += "</div>";
	  str += "<div class='form-group dividingSix'>";
	  str += "<label>허벅지둘레(cm)</label>";
	  str += "<input class='simple-field thigh' type='text' name='thigh' required />";
	  str += "</div>";
	  str += "<div class='form-group dividingSix'>";
	  str += "<label>기장(cm)</label>";
	  str += "<input class='simple-field fullLength' type='text' name='fullLength' required />";
	  str += "</div>";
	  str += "</div>";
		
	  str += "</div>";
	  
	  $(document).on("click", ".optionDelete", function(){
		  $(this).parent().remove();
	  });
		  
	  return str;
	  
  }
  /** 사이즈 Modal 이벤트 영역 끝 */
  
  
  /* 모달창 Push버튼 눌렀을 때 발생하는 이벤트*/
  $(".modalClose").on("click", function(){
	  
	  var cloth = $("select[name='selectClothing']");
	  
	  if(cloth.val() == 'top'){
		  
		  var option = $("select[name='option']");
		  var sizeSelect = $("select[name='sizeSelect']");
		  var sleeve = $("input[name='sleeve']");
		  var full = $("input[name='full']");
		  
		  
		  for(var i=0; i<sizeSelect.length; i++) {
			  
		  	 	var sizeObj = {
		  			'types' : option.val(),
		  			'sizes' : sizeSelect[i].value,
		  			'sleeveLength' : sleeve[i].value,
		  			'fullLength' : full[i].value
		  		}
		  	 	
			 	 $.ajax({
			 		url : "/tops",
			 		type : "POST",
			 		dataType : "json",
			 		data : sizeObj ,
			 		success : function(data){
			 			
			 			var type = data.types;
			 			var size = data.sizes;
			 			var sleeveLength = data.sleeveLength;
			 			var fullLength = data.fullLength;
			 			
			 			var str = "";
			 			
			 			str += "<input type='hidden' name='types' value='"+type+"'></input>";
			 			str += "<input type='hidden' name='sizes' value='"+size+"'></input>";
			 			str += "<input type='hidden' name='sleeveLength' value='"+sleeveLength+"'></input>";
			 			str += "<input type='hidden' name='fullLength' value='"+fullLength+"'></input>";
			 			
			 			switch(type){
			 				case 'coat': 
			 					str += "<input type='hidden' name='category' value='110'></input>" 
			 					break;
			 				case 'jacket':
			 					str += "<input type='hidden' name='category' value='120'></input>" 
			 					break;
			 				case 'dress': 
			 					str += "<input type='hidden' name='category' value='130'></input>" 
			 					break;
			 				case 'knit':
			 					str += "<input type='hidden' name='category' value='140'></input>" 
			 					break;
			 				case 'sweatShirt': 
			 					str += "<input type='hidden' name='category' value='150'></input>" 
			 					break;
			 			}
			 			
			 		    $(".hiddenSize").append(str);
			 		    
			 		}
			 	});  
			 }
		  
	  }else{
		  
		  var option = $("select[name='option']");
		  var sizeSelect = $("select[name='bottomSizeSelect']");
		  var waist = $("input[name='waist']");
		  var rise = $("input[name='rise']");
		  var hip = $("input[name='hip']");
		  var thigh = $("input[name='thigh']");
		  var full = $("input[name='fullLength']");
		  
		  for(var i=0; i<bottomSizeSelect.length; i++) {
			  
		  	 	var sizeObj = {
		  	 			
		  			'types' : option.val(),
		  			'sizes' : sizeSelect[i].value,
		  			'waist' : waist[i].value,
		  			'rise' : rise[i].value,
		  			'hip' : hip[i].value,
		  			'thigh' : thigh[i].value,
		  			'fullLength' : full[i].value
		  		}
			 	
			 	 $.ajax({
			 		url : "/bottom",
			 		type : "POST",
			 		dataType : "json",
			 		data : sizeObj ,
			 		success : function(data){
			 			
			 			var type = data.types;
			 			var size = data.sizes;
			 			var waist = data.waist;
			 			var rise = data.rise;
			 			var hip = data.hip;
			 			var thigh = data.thigh;
			 			var fullLength = data.fullLength;
			 			
			 			var str = "";
			 			
			 			str += "<input type='hidden' name='types' value='"+type+"'></input>";
			 			str += "<input type='hidden' name='sizes' value='"+size+"'></input>";
			 			str += "<input type='hidden' name='waist' value='"+waist+"'></input>";
			 			str += "<input type='hidden' name='rise' value='"+rise+"'></input>";
			 			str += "<input type='hidden' name='hip' value='"+hip+"'></input>";
			 			str += "<input type='hidden' name='thigh' value='"+thigh+"'></input>";
			 			str += "<input type='hidden' name='fullLength' value='"+fullLength+"'></input>";
			 			
			 			switch(type){
    		 				case 'skirt': 
    		 					str += "<input type='hidden' name='category' value='210'></input>"
    		 					break;
    		 				case 'shortPants':
    		 					str += "<input type='hidden' name='category' value='220'></input>"
    		 					break;
    		 				case 'pants': 
    		 					str += "<input type='hidden' name='category' value='230'></input>"
    		 					break;
    		 			}
			 			
			 		    $(".hiddenSize").append(str);
			 		    
			 		}
			 	});  
			 }
	  }
	  
	  
  });
  
  /* 키워드 입력input태그의 엔터 이벤트 막음 */
  $('.bootstrap-tagsinput input').on('keydown', function(event) {
	    if (event.keyCode === 13) {
	    	$('#keyword').tagsinput('add', $('.bootstrap-tagsinput input').val(), {preventPost: true});
	    	$('.bootstrap-tagsinput input').val("")

	    	event.preventDefault();
	    }
  }); 
  
  /* 최종 submit버튼 */
  $("#registerForm").submit(function(event){
		event.preventDefault();  
		
		var imageSrc = "";
		var str = "";
		 
		/* 상품 테이블에 FrontImage, ToggleImage 넣기위해 <input type=hidden> 동적생성 */
		var img1= $(".images1").attr("src");
		var img2 = $(".images2").attr("src");
		
		var frontImg = getImageLink(img1);
		var endImg = getImageLink(img2);
		
		var frontAttachImg = getRealLink(img1);
		var toggleAttachImg = getRealLink(img2);
		
		var that = $(this);
		
		for(i=0; i<imageValue.length; i++){
			imageSrc = imageValue[i].substr(34);
			
			str += "<input type='hidden' name='attachFile' value='"+imageSrc+"'>";
	  	}
		
		str += "<input type='hidden' name='attachFile' value='"+frontAttachImg+"'>";
		str += "<input type='hidden' name='attachFile' value='"+toggleAttachImg+"'>";
		str += "<input type='hidden' name='frontImg' value='"+frontImg+"'>";
		str += "<input type='hidden' name='toggleImg' value='"+endImg+"'>";
		
		that.append(str);
		
		console.log(str);
		
		that.get(0).submit();  
	});
  
  function getImageLink(imgPath){
	  
	  var front = imgPath.substr(0, 18);
	  var end = imgPath.substr(20);
	  
	  return front + end;
  }
  
  function getRealLink(path){
	  var real = path.substr(20);
	  
	  return real;
  }
  
  function clothEvent(option){
	  var str = "";
	  var add = "";
	  var value = "";
	  
	  if(option == 'top'){
		  
		  value = "      <option>종류 선택</option>" +
		  		  "        <option value='coat'>Coat</option>" +
		  		  "        <option value='jacket'>Jacket</option>" +
		  		  "        <option value='dress'>Dress</option>" +
		  	  	"	 	     <option value='knit'>Knit</option>" +
		  		  "        <option value='sweatShirt'>SweatShirt</option>";
		  
		  add = addingOp(value);
		  
		  $(".selectOption").html(add);
		  
		  var topOption = $("select[name='option']");
		  
		  topOption.change(function(){
			  
			  str = topBase();
			  $(".addOption").html(str);
			  
		  });
		  
		  
	  }else{
		  
		  value = "        <option>종류 선택</option>" +
		  		  "        <option value='skirt'>Skirt</option>" +
		  		  "        <option value='shortPants'>Shorts</option>" +
		  		  "        <option value='pants'>Pants</option>";
		  
		  add = addingOp(value);
		  $(".selectOption").html(add);
		  
		  var bottomOption = $("select[name='option']");
		  
		  bottomOption.change(function(){
			  
			  var data = "";
			  
			  if(bottomOption.val() == 'skirt'){
				  
				  data = "<option>사이즈 선택</option>" +
				  		 "<option value='xs'>XS</option>" +
				  		 "<option value='s'>S</option>" +
				  		 "<option value='m'>M</option>" +
				  		 "<option value='l'>L</option>" +
				  		 "<option value='xl'>XL</option>" +
				   		 "<option value='free'>FREE</option>";
				   		 
				  str = bottomBase(data);
				  
			  }else{
				  
				  data = "<option>사이즈 선택</option>" +
			  		 	 "<option value='24'>24</option>" +
			  			 "<option value='25'>25</option>" +
			  			 "<option value='26'>26</option>" +
			  			 "<option value='27'>27</option>" +
			  			 "<option value='28'>28</option>" +
			  			 "<option value='29'>29</option>" +
			  			 "<option value='30'>30</option>" +
			   			 "<option value='free'>FREE</option>";
			   	
				  str = bottomBase(data);
			  }
			  
			  $(".addOption").html(str);
			  
		  });
		  
	  }
}
  
}); 