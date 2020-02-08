<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<h1>首頁</h1>


<img onerror="nofind()" src="${sessionScope.get('listMember').memberPic}" style="height: 50px;width: 50px;border-radius:50%">
${sessionScope.get('listMember').memberSname}<br>

<a href="<c:url value="register.jsp"/>">註冊</a>
<a href="<c:url value="loginSystem.jsp"/>">登入</a>
<a href="getMember1">會員專區</a>

<script type="text/javascript">
function nofind(){
  var img=event.srcElement;
  img.src="images/T1213121.jpg"; //替換的圖片
  img.onerror=null; //控制不要一直觸發錯誤
}
</script>

</body>
</html>