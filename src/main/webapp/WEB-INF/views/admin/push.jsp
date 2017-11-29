<%@ page language="java" pageEncoding="UTF-8"%>
<head>
<link href="/resources/css/semantic.css" rel="stylesheet" type="text/css" />
<script src="/resources/js/semantic.js"></script>
</head>

<body class="style-10">
        <div class="information-blocks">
            <div class="row">
                <div class="col-sm-3 information-entry" >
                </div>
                <div class="col-sm-6 information-entry" >
                    <div class="login-box">
                        <div class="article-container style-1">
                            <h3>Push Alarm Customizing</h3>
                        </div>
                         <form action="/admin/push" method="post" class="form">
                            <label>Title</label> 
                            <input class="simple-field" type="text" name="title" placeholder="Enter Title" value="" /> 
                            <label>Message</label>
                            <input class="simple-field" type="text"  name="message" placeholder="Enter Message" value="" />
                            <div class="row">
	                          <label class="col-sm-6 checkbox-entry">
                              </label>
	                          <div class="col-sm-4">
	                            <p class="text-right"><button type="submit" class="button style-10" style=""> Push </button></p>
	                          </div>
                            <input type="hidden" name="pushToken" value="/topics/ALL">
                            <input type="hidden" name="allPush" value="true">
                          	</div><%--./row--%>
                        </form> 
                    </div>
                </div>	
            </div><%-- ./row --%>
            <br>
            
           </div><%-- ./information-blocks --%>
           
          <div></div>
        
</body>
