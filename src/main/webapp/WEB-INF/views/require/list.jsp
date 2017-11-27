<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

<style>
#writeBtn{
    float:right;
    color:black;
    font-weight: bold;
}

.image{
    width:100%;
    height:auto;
}

.imageClass{
    width:68px;
    height:124px;
    margin:2%;
}

.middleDiv{
    padding:0%;
}

.moreView {
  padding-left: 45%;
  font-size: 80px;
  color: black;
}

#imageinmodal{
    width:50%;
    height:auto;
    padding-left: 10%;
    margin-left:15%;
}

#titleinmodal{
    margin-bottom:0%;
}

.col-sm-5{
    padding:0%;
    margin-right:1%
}

.Outer{
    margin-top:2%;
    padding:0%;
    margin-bottom:2%;
}

.priceDiv{
    padding-left:0%;
}

.simple-field{
    margin-bottom:1%;
}

.companyDiv{
    padding:0%;
}

#replyDiv{
    text-align: left;
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
    
    <%-- Modal 영역 시작 --%>
  <div class="modal" id="titleModal">
    <div class="modal-dialog modal-m">
      <div class="modal-content modalSizing">
        <div class="modal-header">
          <button type="button" class="close" id="modalClose"
            data-dismiss="modal">
            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
          </button>
          <h4 class="modal-title">공구요청 상세내용보기</h4>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <div class="row">
              <div class="col-sm-12">
                <label>상품이미지</label><img id="imageinmodal" src="">
                <label>제목</label><input class="simple-field" type="text" id="titleinmodal" value=""  />
              <div class="col-sm-12 Outer">
              <div class="col-sm-6 priceDiv">
                <input type="hidden" id="requireNo" value=""  />
                <label>희망가격</label><input class="simple-field" type="text" id="priceinmodal" value=""  />
              </div>
              <div class="col-sm-6 companyDiv">
                <label>회사명(제조사)</label><input class="simple-field" type="text" id="companyinmodal" value="" />
              </div>
              </div>
                <label>요청내용</label><input class="simple-field" type="text" id="contentinmodal" value="" />
                <label>관리자답변</label><input class="simple-field" type="text" id="commentsinmodal" value="" />
              </div>
            </div>
          </div>
        </div>
        
        <div class="modal-footer" id="replyDiv">
           <label>관리자 답변 <span>*</span></label> <input class="simple-field" id="leaveComments" type="text" value=""  /> 
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-default" id="addReply">Reply</button>
          <button type="button" class="btn btn-default modalClose"
            data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
<%-- Modal 영역 종료 --%>

 <%--
  <div class="modal" id="commentModal">
    <div class="modal-dialog modal-m">
      <div class="modal-content modalSizing">
        <div class="modal-header">
          <button type="button" class="close" id="modalClose"
            data-dismiss="modal">
            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
          </button>
          <h4 class="modal-title">관리자 댓글달기</h4>
        </div>
        <div class="modal-body">
          <div class="modal-footer" id="replyDiv">
          <label>관리자 답변 <span>*</span></label> <input class="simple-field" type="text" value=""  />              
          
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default modalClose"
            data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
--%>

   
            <div class="content-push">

                <div class="breadcrumb-box">
                    <a href="/">Home</a>
                    <a href="#">공구조사</a>
                </div>

                <div class="information-blocks">
                    <div class="portfolio-container type-1">
                        <div class="portfolio-navigation">
                            <div class="links-drop-down">
                                <div class="list">
                                    <a class="active" href="#">All</a>
                                    <!-- <a href="#">Hipster</a>
                                    <a href="#">Photography</a>
                                    <a href="#">Casual</a>
                                    <a href="#">Nature</a> -->
                                    <a class="button style-7" id="writeBtn" href="/require/insert">Write</a>
                                </div>
                            </div>
                        </div>
                        <div class="row articleRow">
                           
                        </div>
                    </div>
                    
                  <div class="row shop-grid grid-view listView"></div>
                  <div class="page-selector">
                      <a class="moreView"><i class="fa fa-angle-down"></i></a>
                    <div class="pages-box">
                      <a href="#" class="square-button"><i class="fa fa-angle-up"></i></a>
                    </div>
                    <div class="clear"></div>
                  </div>
                </div>
                
            </div>
            <br><br><br>
        <div class="clear"></div>

    
<script>

$(document).ready(function(){
	var page;
	
	/* 전체리스트 출력 위해 /require/list로 이동 (post방식) */
	page=1
	goPost(page);
	
	/* 더보기 클릭시 해당 페이지의 리스트 append */
	$(".moreView").each(function(){
		$(this).click(function(ev){
			ev.preventDefault();
			page += 1;
			goPost(page);
		})
	})
	
	$(document).on("click", ".toModal", function(e){
		var requireNum = $(this).parent().children()[1].value;
		$.ajax({
			url:"/require/modal/"+requireNum,
			data:{requireNo:requireNum},
			dataType:"json",
			method:"POST",
			success:putInModal
		});
		
	})
	
	$("#addReply").on("click", function(e){
		var re = $("#leaveComments").val();
		var requireNum = $("#requireNo").val();
		$.ajax({
			url:"/require/reply/"+requireNum,
			data:{comments:re},
			type:'PUT',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			success:function(data){
				alert(data)
			}
		}) 
	})
	
	function goPost(page){
		
		$.post("/require/list/"+page, function(data){
			var string = appending(data);
			$(".articleRow").append(string);
		});
		
	}
	
	function appending(data){
		var str = "";
		
		for (var i = 0; i < data.length; i++) {
			str += "<div class='col-sm-4 portfolio-entry'>";
			str += "<div class='col-sm-3 middleDiv'>";
			str += "<div class='image'>";
			str += "   <img class='imageClass' src='"+data[i].image+"'>";
			str += "   <div class='hover-layer'>";
			str += "        <div class='info'>";
			str += "            <div class='actions'>";
			str += "                <a class='action-button open-image' href='#'><i class='fa fa-search'></i></a>";
			str += "                <a class='action-button' href='#'><i class='fa fa-link'></i></a>";
			str += "            </div>";
			str += "        </div>";
			str += "    </div>";
			str += "</div>";
			str += "</div>";
			str += "<div class='col-sm-9'>";
			str += "<a class='title toModal' data-toggle='modal' data-target='#titleModal'>"+data[i].title+"</a>";
			str += "<input type='hidden' name='requireNo' value='"+data[i].requireNo+"'>";
			str += "<div class='subtitle'>"+data[i].regdate+"<span class='comments-number'>"+data[i].comments+"comment</span></div>";
			str += "<div class='description'>희망가격 : "+data[i].price+" <br> 회사명(제조사) : "+data[i].company+"</div>";
			str += "</div>";
			str += "</div>";
		}
		
		return str;
	}
	
	function putInModal(data){
		var image = $("#imageinmodal");
		var title = $("#titleinmodal");
		var price = $("#priceinmodal");
		var company = $("#companyinmodal");
		var content = $("#contentinmodal");
		var requireNo = $("#requireNo")
		
		image.attr('src', data.image);
		title.val(data.title)
		price.val(data.price)
		company.val(data.company)
		content.val(data.content)
		requireNo.val(data.requireNo)
	}
	
})


</script>    


</body>
