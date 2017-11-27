<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<style>
.btnDiv{
    float:right;
    margin: 2%;
}

.imageDiv{
     width:100%;
     height:auto;
     margin-top:2%;
     padding:1%;
}

#fileUpload{
    display:none;
}

.thumbnailDiv{
    padding-left:40%;
}

#imageLabel{
    text-align: center;
}
</style>
</head>

<body class="style-10">
  <!-- LOADER -->
  <div id="loader-wrapper">
    <div class="bubbles">
      <div class="title">loading</div>
      <span></span> <span id="bubble2"></span> <span id="bubble3"></span>
    </div>
  </div>


  <%-- Main 영역 시작 --%>
  
  <div class="breadcrumb-box">
    <a href="#">Home</a> <a href="#">공구요청</a>
  </div>

  <div class="content-push">
    <div class="information-blocks">
      <div class="row">
        <div class="col-md-10 col-md-push-1 information-entry">
          <div class="blog-landing-box type-1 detail-post">

            <div class="blog-entry">
              <h3 class="additional-blog-title">Ask For the Group Purchase</h3>
              <form id="formTag" method="post" action="/require/insert">
                <div class="row">
                  <div class="col-sm-6">
                    <label>상품이름 <span>*</span></label> <input
                      class="simple-field" type="text" name="title" value="" required />
                      
                    <label>희망가격 <span>*</span></label> <input
                      class="simple-field" type="number" name="price" value="" required />
                    
                    <label>회사명(제조사) <span>*</span></label> <input
                      class="simple-field" type="text" name="company" value="" required />
                        
                    <label>요청내용 <span>*</span></label>
                    <textarea class="simple-field" required name="content"
                      placeholder="상품정보 등을 입력해주세요."></textarea>
                    <div class="clear"></div>
                  </div>
                  
                  <div class="col-sm-6">
                      <label id="imageLabel">Image <span>*</span></label>
                      <div class="button style-11 col-sm-12" id="uploadBtn" data-toggle="tooltip" title="이미지는 한장만 업로드해주세요">
                        Upload Image
                      </div>
                      <input type="file" id="fileUpload">
                  </div>
                  <div class="col-sm-6">
                    <div class="imageDiv"></div>
                   </div>
                  
                  <div class="col-sm-12">
                    <div class="button style-10 btnDiv" id="sendBtn">
                      Send <input type="submit" value="" />
                    </div>
                  </div>
                </div>
              </form>
            </div>

          </div>
        </div>
        <br><br><br>
      </div>
    </div>
  </div>
 <div class="clear"></div>
 
<%-- Main 영역 종료 --%>


<script>

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

</script>

</body>




