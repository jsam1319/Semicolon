<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
</head>
<body class="style-10">
        <div class="information-blocks">
            <div class="row">
            	<div class="col-sm-3 information-entry">
            	</div>
                <div class="col-sm-6 information-entry">
                    <div class="login-box">
                        <div class="article-container style-1">
                            <h3>${name}님의 주문 정보</h3>
                            
                            <div class="enterContent-2"></div>
                            
                            <p>받으시는 분 &nbsp;: &nbsp;${orders.receiver}</p>
                            <p>연락처 : &nbsp;${orders.phone}</p>
                            <p>주소 : &nbsp; ${orders.address}</p>
                            <p>주문 가격 : &nbsp;<fmt:formatNumber value="${orders.price}" groupingUsed="true"/>원</p>
                            <p>배송 메세지 : &nbsp;${orders.message}</p>
                            
                            <div class="enterContent-1"></div>
                        </div>
                        <a href="/order/" class="button style-14">주문내역 보러가기</a>
                        <a href="/" class="button style-14">메인페이지</a>
                    </div>
                </div>
                <div class="col-sm-3 information-entry">
            	</div>
            </div><%-- ./row --%>
            <br>
            
           </div><%-- ./information-blocks --%>
           
          <div></div>
        
</body>