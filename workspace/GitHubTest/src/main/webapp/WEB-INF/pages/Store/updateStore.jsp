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
商行照片:<br>
<img  src="${getMember.memberPic}" style="height: 100px;width: 120px"><br>
<input type="file" name="file"  ><br>
商家名稱 :<br> 
<input type="text" value="${getMember.memberFname}" name="memberFname"><br> 
商家簡介 :<br> 
<input type="text" value="${getMember.memberSname}" name="memberSname"><br> 
商家電話 :<br> 
<input type="text" value="${getMember.memberTwid}" name="memberTwid"><br> 
商家地址(實體店面):<br> 
<input type="text" value="${getMember.memberGd}" name="memberGd"><br> 
商行號碼 :<br> 
<input type="text" value="${getMember.memberHb}" name="memberHb"><br> 
商行帳戶 :<br> 
<input type="text" value="${getMember.memberTel}" name="memberTel"><br> 
商行負責人姓名 :<br> 
<input type="text" value="${getMember.memberCel}" name="memberCel"><br> 
商行負責人身分證  :<br> 
<input type="text" value="${getMember.memberCel}" name="memberCel"><br> 
商行負責人電話 :<br> 
<input type="text" value="${getMember.memberCel}" name="memberCel"><br> 
商行負責人地址 :<br> 
<input type="text" value="${getMember.memberCel}" name="memberCel"><br> 

<input type="submit" value="儲存">               
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>          





</body>
</html>