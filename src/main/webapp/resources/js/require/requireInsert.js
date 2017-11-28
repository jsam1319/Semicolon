
$(document).ready(function(){
	
	var fileName;
	
	$("#uploadBtn").on('click', function(e){
		e.preventDefault();
		
		$("#fileUpload").click();
	});
	
    $("input[type=file]").change(function(event) {
    	
    	var formData = new FormData();
    	
    	var file = $('input[type=file]')[0].files[0];
    	fileName = $('input[type=file]')[0].files[0].name;
    	
    	formData.append("file", file);
    	
    	$.ajax({
    		url:'/require/upload',
    		data:formData,
    		dataType:'text',
    		processData:false,
	    	contentType:false,
	    	type:'POST',
	    	success:function(data){
	    		var str = "";
	    		str += "<div class='thumbnailDiv'>";
	    		str += "<img class='images' id='imageTag' src='"+data+"'/>";
	    		str += "<button type='button' class='close imageDelete'>";
		  		str += "<span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span>";
		  		str += "</button>";
		  		str += "</div>";
		  		
		  		$(".imageDiv").append(str);
		  		
		  		$(".imageDelete").each(function(){
	    			  $(this).on("click", function(){
	    				  $(this).parent().remove();
	    			  });
	    		  });
	    	}
    	});
    });
    
    $("#formTag").submit(function(event){
    	
    	event.preventDefault();
    	
    	var imageSrc = $(".images").attr("src");
    	console.log(imageSrc);
    	
    	var src = getImageLink(imageSrc);
    	console.log(src);
    	
    	var str = "<input type='hidden' name='image' value='"+src+"'>";
    	
    	var that = $(this);
    	that.append(str);
    	
    	that.get(0).submit();
    	
    });
    
    function getImageLink(imgPath){
  	  
  	  var front = imgPath.substr(0, 18);
  	  var end = imgPath.substr(20);
  	  
  	  return front + end;
    }
	
})