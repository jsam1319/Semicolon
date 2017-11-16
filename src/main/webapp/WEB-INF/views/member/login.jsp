<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>

<body class="style-10">


        <div class="information-blocks">
            <div class="row">
                <div class="col-sm-6 information-entry" >
                    <div class="login-box">
                        <div class="article-container style-1">
                            <h3>Registered Customers</h3>
                        </div>
                         <form action="/member/login" method="post" class="form">
                            <label>ID</label> <input class="simple-field" type="text" name="id" placeholder="Enter Email Address" value="" /> <label>Password</label>
                            <input class="simple-field" type="password"  name="password" placeholder="Enter Password" value="" />
                            <div class="row">
	                            <label class="col-sm-6 checkbox-entry">
                                      <input type="checkbox" value="true" name="autoLogin"/> <span class="check"></span> 자동로그인
                                 </label>
	                            <div class="col-sm-6">
	                            <p class="text-right"><button type="submit" class="button style-10" style=""> LOGIN </button></p>
	                          	</div>
                          	</div><%--./row--%>
                        </form> 
                    </div>
                </div>	
                <div class="col-sm-6 information-entry">
                    <div class="login-box">
                        <div class="article-container style-1">
                            <h3>New Customers</h3>
                            <p>By creating an account with our store, you will be able to
                                move through the checkout process faster, store multiple
                                shipping addresses, view and track your orders in your account
                                and more.</p>
                        </div>
                        <a class="button style-12">Register Account</a>
                    </div>
                </div>
            </div><%-- ./row --%>
            <br>
            
           </div><%-- ./information-blocks --%>
           
          <div></div>
        
</body>
