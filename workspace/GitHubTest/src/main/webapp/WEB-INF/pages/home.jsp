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

<c:if test="${not empty sessionScope.get('memberSession').memberPic}"><!-- 如果不為空 才顯示 -->
<img onerror="nofind()" src="${sessionScope.get('memberSession').memberPic}" style="height: 50px;width: 50px;border-radius:50%">
${sessionScope.get('memberSession').memberSname}<br>
</c:if>

<input type="button" value="註冊" onclick="location.href='register'">
<input type="button" value="登入" onclick="location.href='loginSystem'">
<input type="button" value="會員專區" onclick="location.href='findMember'">

<c:if test="${not empty sessionScope.storeSession}"><!-- 如果不為空 才顯示 -->
<input type="button" value="查詢商家資料" onclick="location.href='findStore'">
</c:if>

<c:if test="${empty sessionScope.storeSession}"><!-- 如果不為空 才顯示 -->
<input type="button" value="註冊商家" onclick="location.href='registerStore'">
</c:if>

<script type="text/javascript">
function nofind(){
  var img=event.srcElement;
  img.src="images/memberPic/T1213121.jpg"; //替換的圖片
  img.onerror=null; //控制不要一直觸發錯誤
}
</script>

</body>
</html>