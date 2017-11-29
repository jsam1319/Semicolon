<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>
	<style>
	.moreView {
	  padding-left: 45%;
	  font-size: 80px;
	  color: black;
	}
	
	</style>
	
	<script>
	$(document).ready(function(){
	    var page = 1;
	    
	    getAppendData(page);
	    
	    $(".moreView").each(function(){
			$(this).click(function(ev){
				ev.preventDefault();
				page += 1;
				getAppendData(page);
			})
		})
	}); //end ready
	
	$(document).on("click",'.deletebtn',function(){
		      $.ajax({
		      url : "/gwish/"+$(this).val(),
		      type : "delete",
		      headers : {
		          "Content-Type":"application/json",
				  "X-HTTP-Method-Override" : "DELETE"
		      },
		   	  dataType:"text",
		   	  success: function(data){
		   	   $(this).parent().parent().remove();
		   	  }
		   });   
		   
		   $("#confirm-modal").modal();
	});
	
	function getAppendData(page){
        var print = "";
		$.ajax({
		    url : "/gwish/"+page,
		    type : "put",		      
		    headers : {
		          "Content-Type": "text/html; charset=utf-8",
		          "X-HTTP-Method-Override" : "PUT"
		      },
		    dataType : "json",
		    success : function(data){
		        console.log("data:"+data);
		        $.each(data, function(index, item){
		            print +=
		                '<div class="col-sm-4 portfolio-entry" >'+
							'<div class="image" style="height:20rem">'+
							'<img alt="" src="/resources/images/'+item.img+'" style="height:100%;"/>'+
								'<div class="hover-layer">'+
									'<div class="info">'+
										'<div class="actions">'+
											'<a class="action-button open-image" href="#"><i class="fa fa-heart"></i></a>'+
											'<a class="action-button" href="/"><i class="fa fa-search"></i></a>'+
										'</div>'+
									'</div>'+
								'</div>'+
							'</div>'+
							'<div style="display:inline;">'+
								'<a class="title" href="#"style="display:inline;">'+item.name+'</a>'+
								'<button class="deletebtn button style-14" style="display:inline; float:right; background:#f6b7b7; border-color:#FFFFFF;" value='+item.gwishNo+'><i class="fa fa-times"></i></button>'+
							'</div>'+
							'<div class="subtitle">'+
								'<a class="tag">'+item.company+'</a>'+
								'<div class="current gpurchasePrice">'+numberfmt(item.price)+'</div>'+
								'<span class="comments-number">'+ item.startDate +'~'+ item.endDate +'</span>'+
							'</div>'+
							'<div class="description">내가 찜한 날짜:'+item.regdate+'</div>'+
						'</div>'; 
								 
		        });
		        $(".listview").append(print);
		       
		    }//end success
		}); //end ajax
		
		function numberfmt(value){
		    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
		    
    }
   
	</script>
	
	<%-- Modal --%>
	<div class="modal fade" id="confirm-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog modal-sm">

      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title" style="text-align:center">알림</h4>
        </div>
        
        <div class="modal-body">
          <p style="text-align:center;"> 삭제되었습니다 </p>
        </div>

        <div class="modal-footer">
	       <button type="button" class="button style-10" data-dismiss="modal" style="text-align:center">Close</button>
	    </div>
       
      </div>
    </div>
  </div>
		
	<div class="row listview">
	 </div>

	 <div class="row shop-grid grid-view listView"></div>
		<div class="page-selector">
			<a class="moreView"><i class="fa fa-angle-down"></i></a>
			<div class="pages-box">
				<a href="#" class="square-button"><i class="fa fa-angle-up moreBtn"></i></a>
			</div>
			<div class="clear"></div>
		</div>
</body>	