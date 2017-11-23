<%@ page language="java" pageEncoding="UTF-8"%>

<head>
<style>
.dropbox{
     border:1px solid #f2f2f2;
     width:100%;
     height:200px;
     color:#92AAB0;
     text-align:center;
     font-size:24px;
     padding-top:10%;
     padding-bottom:10%;
     margin-top:10%;
     margin-bottom:5%;
}

.mainImages{
    border:1px solid #f2f2f2;
     width:100%;
     height:100px;
     color:#92AAB0;
     text-align:center;
     font-size:24px;
     padding-top:10%;
     padding-bottom:10%;
     margin-bottom:5%;
}

.imagelist{
     border:1px solid #f2f2f2;
     width:100%;
     height:150px;
     color:#92AAB0;
     text-align:center;
     font-size:24px;
     padding-top:10%;
     padding-bottom:10%;
     margin-bottom:5%;
}

.labelmargin{
    margin-top:10%;
}

#divmargin{
    margin-bottom:3%;
}

#uploadFile{
    display:none;
}

</style>
</head>


<body class="style-10">
    <!-- LOADER -->
    <div id="loader-wrapper">
        <div class="bubbles">
            <div class="title">loading</div>
            <span></span>
            <span id="bubble2"></span>
            <span id="bubble3"></span>
        </div>
    </div>
            <div class="content-push">
                <div class="contact-spacer"></div>
                <div class="information-blocks">
                    <div class="row">
                    <form>
                        <div class="col-md-8 information-entry">
                            <h3 class="block-title main-heading">Upload the Article</h3>
                                <div class="row">
                                    <div class="col-sm-12" id="divmargin">
                                        <label>Title <span>*</span></label>
                                        <input class="simple-field" type="text" name="title" value="${goods.name}" />
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Writer <span>*</span></label>
                                        <input class="simple-field" type="text" name="writer" value="" />
                                        <div class="clear"></div>
                                    </div>
                                    <div class="col-sm-3">
                                        <label>Start Date</label>
                                        <input class="simple-field" type="date" name="startDate" value="" />
                                        <div class="clear"></div>
                                    </div>
                                    <div class="col-sm-3">
                                        <label>End Date</label>
                                        <input class="simple-field" type="date" name="EndDate" value="" />
                                        <div class="clear"></div>
                                    </div>
                                      <div class="col-sm-6">
                                          <label>Minimum Number <span>*</span></label>
                                          <input class="simple-field" type="text" name="min" placeholder="최소인원" value="" />
                                          <div class="clear"></div>
                                      </div>
                                      <div class="col-sm-6">
                                          <label>Price</label>
                                          <input class="simple-field" type="text" name="price" value="" />
                                          <div class="clear"></div>
                                      </div>
                                      
                                    <div class="col-sm-12">
                                        <label>Content<span>*</span></label>
                                        <textarea class="simple-field" placeholder="상품에 대한 간략한 설명" value="${goods.detail}"></textarea>
                                    </div>
                                </div>
                        </div>
                        <div class="col-md-4 information-entry">
                            <h3 class="block-title main-heading">Upload Image File</h3>
                            <div class="article-container style-1">
                                <div class="dropbox">drag and drop <br> the file</div>
                                <input type="file" id="uploadFile">
                                <div class="mainImages"></div>
                                <div class="imagelist"></div>
                            </div>
                            <p class="text-right"><a class="button style-10">REGISTER<input type="submit" value="" /></a></p>  
                        </div>
                       </form>
                    </div>
                </div>
                <br><br>
            </div>
        <div class="clear"></div>  
        
        
       
    <div class="search-box popup">
        <form>
            <div class="search-button">
                <i class="fa fa-search"></i>
                <input type="submit" />
            </div>
            <div class="search-drop-down">
                <div class="title"><span>All categories</span><i class="fa fa-angle-down"></i></div>
                <div class="list">
                    <div class="overflow">
                        <div class="category-entry">Category 1</div>
                        <div class="category-entry">Category 2</div>
                        <div class="category-entry">Category 2</div>
                        <div class="category-entry">Category 4</div>
                        <div class="category-entry">Category 5</div>
                        <div class="category-entry">Lorem</div>
                        <div class="category-entry">Ipsum</div>
                        <div class="category-entry">Dollor</div>
                        <div class="category-entry">Sit Amet</div>
                    </div>
                </div>
            </div>
            <div class="search-field">
                <input type="text" value="" placeholder="Search for product" />
            </div>
        </form>
    </div>

<script>

/* $(document).ready(function(){
  $(".dropbox").on("click", function(){
    $("#uploadFile").click();
  });
  
  $(".dropbox").on("dragenter dragover", function(event){
	    event.preventDefault();
	});
  
  $(".dropbox").on("drop", function(event){
	    event.preventDefault();
	    
	    var files = event.originalEvent.dataTransfer.files;
	    var file = files[0];
	    var formData = new FormData();
	    formData.append("file", file);
	    
	    
	   $.ajax({
	    	url:'/product/research',
	    	data:formData,
	    	dataType:'text',
	    	processData:false,
	    	contentType:false,
	    	type:'POST',
	    	success: function(data){
	    		alert(data);
	    	}
	    	
	    });
	});
}); */

</script>

</body>


