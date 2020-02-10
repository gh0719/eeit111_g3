<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
<h4>使用者登入</h4>

<script>
$(document).ready(function(){
	$("form[name=subscribeform]").submit(function(ev){
		if(grecaptcha.getResponse()!=""){
			return true;
		}
		alert("請打勾");
		return false;
	});
});

    
</script>

<form action="loginMember" method="post" name="subscribeform">
User E-mail:<input type="text" name="memberEmail"><br>
PassWord:<input type="password" name="memberPwd" ><br>
    <div class="g-recaptcha" data-sitekey="6Le_YdUUAAAAAD5nxrA1HIK-E6xPCKbSgdNxCdgN"></div>
	<input type="submit" value="送出" name="submit">
	<input type="reset" value="清除">
	<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>





</body>
</html>