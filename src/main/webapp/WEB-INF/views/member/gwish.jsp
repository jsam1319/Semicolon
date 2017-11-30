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
	
	//삭제
	$(document).on("click",'.deletebtn',function(){
	    var removeDiv = $(this).parent().parent();
	    console.log("delete btn : "+$(this).val());
		       $.ajax({
		      url : "/gwish/"+$(this).val(),
		      type : "delete",
		      headers : {
		          "Content-Type":"application/json",
				  "X-HTTP-Method-Override" : "DELETE"
		      },
		   	  dataType:"text",
		   	  success: function(data){
		   	  	removeDiv.remove();
		   		$("#confirm-modal").modal();
		   	  }
		   });   
		   
		   
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
		        
		         if(data == "" && page == 1){
		            print +=
		            '<div class="col-sm-12 information-blocks">'+
			    		'<div class="table-responsive col-sm-12">'+
			    			'<div class="letter">'+
			    				'<div class="container-404">'+
			    					'<div class="description">목록이 없습니다.</div>'+
			    				'</div>'+
			    			'</div>'+
			    		'</div>'+
		    		'</div>';
		    		
		            $(".listview").html(print); 
		        }
		        
		        
		        
		       
		        $.each(data, function(index, item){
		            var status;
					
		            print +=
		                '<div class="col-sm-4 portfolio-entry" >'+
							'<div class="image" style="height:20rem">';
								
								  
								if(item.status == 0){
								    print += '<a href="#" data-toggle="modal" data-target="#research-modal"><img alt="" src="'+item.img+'" style="height:100%;"/></a>'+
										    '</div>'+
											'<div style="display:inline;">'+
												'<a class="title" href="#" data-toggle="modal" data-target="#research-modal" style="display:inline;">'+item.name+'</a>';
								    status = "공구 조사 중";
								}else{
								    print += '<a href="/product/gpurchase/'+item.gpurchaseNo+'"><img alt="" src="'+item.img+'" style="height:100%;"/></a>'+
										    '</div>'+
											'<div style="display:inline;">'+
												'<a class="title" href="/product/gpurchase/'+item.gpurchaseNo+'"style="display:inline;">'+item.name+'</a>';
									status = "공구 진행 중";
								}
								
					print +=			
							
								'<button class="deletebtn button style-14" style="display:inline; float:right; background:#f6b7b7; border-color:#FFFFFF;" value='+item.gwishNo+'><i class="fa fa-times"></i></button>'+
							'</div>'+
							'<div class="subtitle">'+
								'<div class="tag">'+item.company+' / '+numberfmt(item.price)+'</div>'+
								'<div class="description" style="color:#ff0000;">'+status+'</div>'+
								'<div class="tag">내가 찜한 날짜:'+item.regdate+'</div>'+
								'<span class="comments-number">'+ item.startDate +'~'+ item.endDate +'</span>'+
							'</div>'+
						'</div>'; 
								 
		        });
		        
		       
		        $(".listview").append(print);
		        
		       
		    }//end success
		}); //end ajax
		    
    }//end appendData
    
    //숫자 세자리단위로 , 찍기
    function numberfmt(value){
	    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
    
	
	</script>
	
	<%-- 삭제 Modal --%>
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
  
  <%-- 공구조사중 알림 Modal --%>
	<div class="modal fade" id="research-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog modal-sm">

      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title" style="text-align:center">알림</h4>
        </div>
        
        <div class="modal-body">
          <p style="text-align:center;"> 아직 공구 조사 중 입니다. </p>
        </div>

        <div class="modal-footer">
	       <button type="button" class="button style-10" data-dismiss="modal" style="text-align:center">Close</button>
	    </div>
       
      </div>
    </div>
  </div>
		
	<%-- 리스트 동적으로 생기는 부분 --%>	
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