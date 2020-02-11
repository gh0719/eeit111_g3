<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Insert title here</title>
</head>
<body>


<img  src="${getMember.memberPic}" style="height: 100px;width: 120px"><br>
姓名 :${getMember.memberFname}<br> 
暱稱 :${getMember.memberSname}<br> 
身分證字號 : ${getMember.memberTwid}<br> 
性別 :${getMember.memberGd}
生日 :${getMember.memberHb}<br> 
市內電話 :${getMember.memberTel}<br> 
手機號碼 :${getMember.memberCel}<br> 


<input type="button" value="修改資料" onclick="location.href='getMemberToUpdate'">  
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">  

<c:if test="${not empty sessionScope.storeId}"><!-- 如果不為空 才顯示 -->
<input type="button" value="查詢商家資料" onclick="location.href='findStore'">
</c:if>

<c:if test="${empty sessionScope.storeId}"><!-- 如果不為空 才顯示 -->
<input type="button" value="註冊商家" onclick="location.href='registerStore'">
</c:if>


</body>
</html>