	$(document).ready(function(){
		            	
		   var no = 0;
		   var gpurchaseNo = $("#gpurchaseNo").val()
		   var memberNo = $("#memberNo").val()
		   var goodsNo = $("#goodsNo").val()
		   var askCnt = $("#askCnt").val()
           var status = $("#status").val()
		   
		   /** 구매 / 공구재요청 버튼 */
           var string = "";
           
         	  if(status == 1) {
         		  string += "<a class='button style-15 purchaseBtn'><i class='fa fa-heart'></i>구매하기"
         		  string += "<input type='submit' value=''>"
         		  
         		  $(".btnDiv").html(string)
         	  } else {
         		  askBtn(askCnt)
         	  }
           
           function askBtn(askCheck) {
         	  var str = "";
         	  
         	  if(askCheck == 0) {
         		  str += "<a class='button style-10 askresale'>재공구요청</a>"
         	  } else {
         		  str += "<a class='button style-10 askcancle'>요청취소</a>"
         	  }
         	  
         	  $(".buttonDiv").html(str)
           }

           
           /** 재공구 요청 버튼 클릭시 이벤트 */
           $(document).on("click", ".askresale", function(event){
         	  askCheck(0, gpurchaseNo)
         	  event.stopImmediatePropagation()
           })
           $(document).on("click", ".askcancle", function(event){
         	  askCheck(1, gpurchaseNo)
         	  event.stopImmediatePropagation()
           })
           
           
           function askCheck(askCk, gpNo){ 
         	  $.ajax({
         		  url: "/product/askck/"+askCk+"/"+gpNo,
         		  type: "POST",
         		  data: {
         			  "memberNo" : memberNo
         		  },
         		  success: function(askCheck){
         			  askBtn(askCheck)
         		  },
         		  error: function(data){
         			  console.log(data)
         		  }
         	  })
         	  
           }
           
           
		            	
		   /** 주문항목 추가 */
		   $(".size").on("click", function(){
			   // 진행중인 공구이면 주문항목 추가 가능 / 마감공구라면 return
			   if (status == 1) {
				   var pSize = $(this).html()	// size 이름 (ex XS/S/M...)
				     var pNum = $(this).attr("id")	// 상의/하의 PK
				            		
				     $(this).addClass("active")
				            		
				     var str = "";
				     no = no-1
				            		
				     // 이미 선택한 사이즈인지 체크 / 선택한 사이즈면 return
				     if ($("#"+pNum+"qt").length == 1) {
						return;
						
					 } else {
				        str += "<div class='article-container style-1' id='"+no+"'>"
				        str += "	<div class='col-sm-4 checkDiv1 inline-product-column-title'> - "+pSize+" </div>"
				        str += "	<div class='col-sm-6 checkDiv2'>"
				        str += "		<div class='quantity-selector detail-info-entry qtnChoice'>"
				        str += "			<div class='entry number-minus minus'>&nbsp;</div>"
				        str += "			<div class='entry number quantity' name='quantity' id='"+pNum+"qt'>1</div>"
				        str += "			<div class='entry number-plus plus'>&nbsp;</div>"
				        str += "		</div>"
				        str += "	</div>"
				        str += "	<div class='col-sm-1 xMark'>"
				        str += "		<i class='fa fa-times '></i>"
				        str += "	</div>"
				        str += "</div>"
				            		
				        $(".orderItem").append(str)
				            		
				            		
				        var hiddenStr = "";
				        var qtP = $("#"+pNum+"qt").html()
				                    
				        if ($(".size").attr("name") == 'TOP') {
				            hiddenStr += "<input type='hidden' name='topsNo' value='"+pNum+"'>"
						} else {
				            hiddenStr += "<input type='hidden' name='bottomNo' value='"+pNum+"'>"
						}
				                    
				        hiddenStr += "<input type='hidden' class='"+pNum+"qt' name='qty' value='"+qtP+"'>"
				        hiddenStr += "<input type='hidden' name='sizes' value='"+pSize+"'>"
				            		
				        $("#"+no+"").append(hiddenStr)
				            		
				  		}
			} else {
					return
			}
		     
		            		
		   })
		            	
		   /** 상품 갯수 +/- */
		   $(document).on("click", ".plus", function(){
		       var qtIdP = $(this).prev().attr("id")	// 상의/하의 pk +qt
		       var qtP = $("#"+qtIdP).html()
		       qtP = Number(qtP)
		            		
		       qtP += 1
		            		
		       $("#"+qtIdP).html(qtP)	// +된 데이터 붙여주기
		       $("."+qtIdP+"").val(qtP)	// name='qty'의 value 넣어주기
		   })
		            	
		   $(document).on("click", ".minus", function(){
			   var qtIdM = $(this).next().attr("id")
			   var qtM = $("#"+qtIdM).html()
			   qtM = Number(qtM)
		            		
			   if (qtM > 1) {
				   qtM -= 1
		            			
				   $("#"+qtIdM).html(qtM)
				   $("."+qtIdM+"").val(qtM)
			   }
		   })
		            	
		           
		   /** 선택한 상품 삭제 */
		   $(document).on("click", ".xMark", function(){
			   $(this).parent().remove();
		   })
		            	
           
           /** 주문페이지로 데이터 전송 */
		   $("#orderForm").submit(function(e){
			   e.preventDefault();
			   
			   var qty = $("input[name='qty']")
			   var sizes = $("input[name='sizes']")
		                			
			   if ($(".size").attr("name") == 'TOP') {	
				   var topsNo = $("input[name='topsNo']")
				   var type = 'top'
			   } else {
				   var bottomNo = $("input[name='bottomNo']")
			   }
		                		 
		                		
			   var OrderList;
			   var OlList = new Array();
		            		
			   for (var i = 0; i < qty.length; i++) {
		            			  
				   if (type == 'top') {
					   OrderList = {
							   'topsNo' : topsNo[i].value,
							   'gpurchaseNo' : gpurchaseNo,
							   'qty' : qty[i].value,
							   'sizes' : sizes[i].value
					   }
				   } else {
					   OrderList = {
							   'bottomNo' : bottomNo[i].value, 
							   'gpurchaseNo' : gpurchaseNo,
							   'qty' : qty[i].value,
							   'sizes' : sizes[i].value
					   }
				   }
								 
				   OlList.push(OrderList)
			   }
		                		  
		            		 
			   var OLJson = JSON.stringify(OlList) 
		                		 
			   var submitStr = "<input type='hidden' name='orderList' value='"+OLJson+"'>"
		            		
			   $(this).append(submitStr)
		                		 
			   $(this).get(0).submit();
		            		
		   })
		   
		   
		   /** 사용자 체형 비교 추천 이벤트 호출 */
		   $(".compare").append();   
		    matchBest();
		    
		    $(".size").click(function(){
		       changeSizeGap($(this).text());
		    });
		    
		    
		    
			$.getJSON("/review/" + goodsNo, function(data){
		        
				var str = '';
				
				for(var i = 0; i < data; i++){
					str += '<div class="star">';
					str += '<i class="fa fa-star"></i>';
					str += '</div>';
				}
		        
				for(var j = 0; j < 5-data; j++){
					str += '<div class="star">';
					str += ' <i class="fa fa-star-o"></i>';
					str += '</div>';
				}
				
				
				$("#avgGrade").html(str);
		    });
			
		    $('#targetType').raty({
				cancel     : true,
				target     : '#targetType-hint',
				targetType : 'score'
			});
		    
		    
		    
		    
		    var page = 1;
		      
			$.getJSON("/review/" + goodsNo + "/" + page, function(data){
		        
				var str = printList(data);
		        
		        $("#reviewList").prepend(str);
		    });
		    
		    
			$("#reviewBtn").click(function(){
				
				var contentObj = $("#content");
				var fileObj = $("#attachFile");
				
				var grade = $("#targetType").raty("score");
				var content = contentObj.val();
				var attachFile = fileObj.val();

				var replyform = document.getElementById("replyform");
				
				var formdata = new FormData(replyform);
				formdata.append("memberNo", memberNo);
				formdata.append("goodsNo", goodsNo);
				formdata.append("grade", grade);
				
				$.ajax({
					type: "post",
					url: "/review/",
					data: formdata,
					processData: false,
					contentType: false,
					success: function(data){
		    				
		    			contentObj.val("");
		    			fileObj.val("");
		    			$ ('#targetType').raty('score', 0);
		    				
		    			page = 1;
		    		        
		    			var str = printList(data);
		    		        
		    		    $("#reviewList").prepend(str);
		    		    
		    		    $.getJSON("/review/" + goodsNo, function(data){
		    		        
		    				var str = '';
		    				
		    				for(var i = 0; i < data; i++){
		    					str += '<div class="star">';
		    					str += '<i class="fa fa-star"></i>';
		    					str += '</div>';
		    				}
		    		        
		    				for(var j = 0; j < 5-data; j++){
		    					str += '<div class="star">';
		    					str += ' <i class="fa fa-star-o"></i>';
		    					str += '</div>';
		    				}
		    				
		    				
		    				$("#avgGrade").html(str);
		    		    });
					}
					
				});
				
			});
			
			$('.moreView').each(function(i){
				  $(this).click(function(e){
					  e.preventDefault();
					  page++;
					  
					  $.ajax({
						  url: "/review/" + gpurchaseNo + "/" + page,
						  dataType: "json",
						  success: function(data){
							   console.log(data); 
							  var str = printList(data)
							  $("#reviewList").append(str);
						  },
						  error: function(data){
							   console.log(data) 
						  }
					  })
				  })
			  })
			
			$(document).on("click", "#removeBtn", function(event){
				
				var reviewNo = $(this).attr("title");
				
				var removetag = $(this).parent().parent().parent();
				
				$.ajax({
			        type:'delete',
			        url:'/review/'+reviewNo,	
			        headers: { 
			              "Content-Type": "application/json",
			              "X-HTTP-Method-Override": "DELETE" },
			        dataType:'text', 
			        success:function(result){
			          console.log(result);
			          if(result == 'SUCCESS'){
			            removetag.remove();
			          }
			      }});
			});
		      
		  
		function printList(data) {
		  
		  var str = "";
		  
		  $(data.list).each( function(){
			  
			  var regdate = this.regdate == undefined ? '' : this.regdate.trim();	
				
			  var date = regdate.split(" ")[0];
			  var time = regdate.split(" ")[1];
				
			  var mon = date.split("-")[1];
		      var day = date.split("-")[2];
		      
		      var timeString = "";
		      
		      var date1 = new Date();
		      var date2 = new Date(regdate);
		      
		      if( (date1 - date2 - 86400000) > 0) timeString = time;
		      else								  timeString = moment(regdate).fromNow();
		      
		      str += '<div class="wishlist-entry">';
			  str += '<div class="column-1">';
			  str += '<div class="comment">';
			  str += '<a class="comment-image" href="#"><img src="/resources/images/' + this.attachFile + '" /></a>';
			  str += '<div class="comment-content">';
			  str += '<div class="comment-title"><span>';
			    
			  var memNo = this.memberNo;
			  $(data.mlist).each( function(){
				  if(memNo == this.memberNo) str += this.id;
			  });
			    
			  str += '</span> Posted ' + timeString + ', ' + date + '</div>';
		    
			  var grade = this.grade;
			  var staro = 5 - grade;
		    
			  str += '<div class="rating-box">';
		    
			  for(var i = 0; i < grade; i++){
		    	
		    	str += '<div class="star">';
		        str += '<i class="fa fa-star"></i>';
		        str += '</div>';
		        
			  }
		    
			  for(var i = 0; i < staro; i++){
		    	str += '<div class="star">';
		        str += '<i class="fa fa-star-o"></i>';
		        str += '</div>';
			  }
		    
			  str += '</div>';
		    
			  str += '<div class="comment-text">' + this.content.replace(/\n/gi, "<br>") + ' </div>';
			  str += '</div>';
			  str += '</div>';
			  str += '</div>';
		      str += '<div class="column-2">';
		      str += '<a class="button style-14">더보기</a>';
		      str += '<a class="remove-button"><i class="fa fa-times" title="' + this.reviewNo + '" id="removeBtn"></i></a>';
		      str += '</div> ';
		      str += '</div>';
		  	});

		  return str;
		}
		    
		            	 
	}); //end ready
		
	
	
	//회원의 사이즈와 가장 적합한 사이즈를 반환
    function matchBest(){
         $.ajax({
        url : "/size/get/"+$("#memberNo").val()+"/"+$("#goodsNo").val(),
        type : "get",
        dataType : "json",
        success : function(data){
            print(data);
            $("#sizeAnnounce").html("가장 적합한 사이즈 : "+data.sizes);
        },
        error : function(xhr, statusText){
            console.log("("+xhr.status+", "+statusText+")"); 
        }
     }); 
    }
    
    //사이즈 비교 결과 띄어줌
    function print(data){
        
        $(".compare").html(data.sizes+"와 자신 사이즈와 비교결과<br>");
        
        if(data.types == 'pants' || data.types == 'shortPants' || data.types == 'skirt'){
            letter('허리',data.waist);
            
            if(data.types != 'skirt'){
                letter('밑위',data.rise);
                letter('허벅지',data.thigh);
            }
            
            letter('엉덩이',data.hip);
        }
        else{ //상의
            var num = productSize.sleeveLength - userSize.sleeve;
            letter('소매길이', data.sleeveLength);
        }
        
        letter('총 길이', data.fullLength);
    }
     


    function letter (body, num){
        $(".compare").append(body+" 사이즈 : "+num+"<br>");
    } 

    //사용자가 클릭할 때마다 사이즈 차이 변환
    function changeSizeGap(data){
         $.ajax({
           url : "/size/get/"+$("#memberNo").val()+"/"+data+"/"+$("#goodsNo").val(),
           type : "get",
           dataType : "json",
           success : function(data){
               print(data);
           },
           error : function(xhr, statusText){
               console.log("("+xhr.status+", "+statusText+")"); 
           }
        }); 
    }
    
    
		
		/** 상품 이미지 자동 슬라이드 */
		jQuery(function($) {
			var mySwiper = new Swiper('.swiper-container', {
				pagination : '.swiper-pagination',
				nextButton : '.swiper-button-next',
				prevButton : '.swiper-button-prev',
				paginationClickable : true,
				spaceBetween : 30,
				centeredSlides : true,
				autoplay : 3000,
				autoplayDisableOnInteraction : true, 
				loop : true
			});
		 
			/** 웹에서의 자동 슬라이드 */
			$(".swiper-container").on("focusout", function() {
				setTimeout(function() {
					if ($(this).find(":focus").length === 0) {
						mySwiper.startAutoplay();
					}
				}, 100);
			});
		
			/** 모바일에서의 자동 슬라이드 */
			$(document).on("touchmove", function() {
				mySwiper.startAutoplay();
			});
		
		});
