
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
	
	/* modal창 클릭시 ajax */
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
	
	/* modal창 안에서 관리자가 댓글 달았을 경우 */
	$("#addReply").on("click", function(e){
		var re = $("#leaveComments").val();
		var requireNum = $("#requireNo").val();
		$.ajax({
			url:"/require/reply/"+requireNum,
			type:'PUT',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			data:JSON.stringify({requireNo:requireNum,comments:re}),
			success:function(data){
				$("#commentsinmodal").val(data.comments)
				$("#leaveComments").val("");
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
			
			str += "<div class='image hidden-xs'>";
			str += "   <img class='imageClass' src='"+data[i].image+"'>";
			str += "</div>";
			
			str += "<div class='image hidden-md hidden-sm hidden-lg'>";
			str += "   <img class='imageMobileClass' src='"+data[i].image+"'>";
			str += "</div>";
			
			str += "</div>";
			str += "<div class='col-sm-9'>";
			str += "<a class='title toModal' data-toggle='modal' data-target='#titleModal'>"+data[i].title+"</a>";
			str += "<input type='hidden' name='requireNo' value='"+data[i].requireNo+"'>";
			if(data[i].comments != null){  //관리자 댓글이 달렸을 경우
				str += "<div class='subtitle'>"+data[i].regdate+"<span class='comments-number'> 1 comment</span></div>";
			}else{	//관리자 댓글이 달리지 않았을 경우
				str += "<div class='subtitle'>"+data[i].regdate+"<span class='comments-number'> 0 comment</span></div>";
			}
			
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
		var comments = $("#commentsinmodal");
		
		image.attr('src', data.image);
		title.val(data.title)
		price.val(data.price)
		company.val(data.company)
		content.val(data.content)
		requireNo.val(data.requireNo)
		comments.val(data.comments)
		
	}
	
})

