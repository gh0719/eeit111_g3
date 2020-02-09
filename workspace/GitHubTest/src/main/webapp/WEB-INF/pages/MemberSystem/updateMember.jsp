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

<h4>資料更新</h4>
<form action="memberUpdate" method="post" enctype="multipart/form-data">
頭像:<br>
<img  src="${getMember.memberPic}" style="height: 100px;width: 120px"><br>
<input type="file" name="file"  ><br>
姓名 :<br> 
<input type="text" value="${getMember.memberFname}" name="memberFname"><br> 
暱稱 :<br> 
<input type="text" value="${getMember.memberSname}" name="memberSname"><br> 
身分證字號 :<br> 
<input type="text" value="${getMember.memberTwid}" name="memberTwid"><br> 
性別 :<br> 
<input type="text" value="${getMember.memberGd}" name="memberGd"><br> 
生日 :<br> 
<input type="text" value="${getMember.memberHb}" name="memberHb"><br> 
市內電話 :<br> 
<input type="text" value="${getMember.memberTel}" name="memberTel"><br> 
手機號碼 :<br> 
<input type="text" value="${getMember.memberCel}" name="memberCel"><br> 

<input type="submit" value="儲存">               
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>          





</body>
</html>