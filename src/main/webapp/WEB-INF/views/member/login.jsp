<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>

<body class="style-10">


<!-- <script>
$(document).ready(function(){
   $("#kakao-login-btn").click(function(){
       console.log("로그인버튼 클릭");
       loginWithKakao();
   });
});

Kakao.init('6999f101118fdebb1055a7b4b14ccd33');
function loginWithKakao() {
  // 로그인 창을 띄웁니다.
  Kakao.Auth.login({
    success: function(authObj) {
      alert(JSON.stringify(authObj));
      console.log(JSON.stringify(authObj));
    },
    fail: function(err) {
      alert(JSON.stringify(err));
    }
  });
};
</script> -->

        <div class="information-blocks">
            <div class="row">
                <div class="col-sm-6 information-entry" >
                    <div class="login-box">
                        <div class="article-container style-1">
                            <h3>Registered Customers</h3>
                        </div>
                       <!--  <div class="article-container">
                        <label></label>
							<button class="button style-12 mb-5-xs col-sm-12" style="background:#3f5c9a; border-color:#3f5c9a;">Log-in with Facebook</button>
							<button class="button style-12 col-sm-12" style="background:#ffe600; border-color:#ffe600; color:#000000" id="kakao-login-btn">Log-in with KaKao</button>
							<button class="button style-12 col-sm-12" style="background:#ffffff; border:1px #e6e6e6 solid; color:#000000">Log-in with Google+</button>
						<label></label>
						</div>	 -->			
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
