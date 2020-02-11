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
<form action="storeUpdate" method="post" enctype="multipart/form-data">
商行照片:<br>
<img  src="${getstore.storePic}" style="height: 100px;width: 120px"><br>
<input type="file" name="file"  ><br>
商家名稱 :<br> 
<input type="text" value="${getstore.storeName}" name="memberFname"><br> 
商家簡介 :<br> 
<input type="text" value="${getstore.storePf}" name="memberSname"><br> 
商家電話 :<br> 
<input type="text" value="${getstore.storeTel}" name="memberTwid"><br> 
商家地址(實體店面):<br> 
<input type="text" value="${getstore.storeAddress}" name="memberGd"><br> 
商行號碼 :<br> 
<input type="text" value="${getstore.storeNumber}" name="memberHb"><br> 
商行帳戶 :<br> 
<input type="text" value="${getstore.storeAccount}" name="memberTel"><br> 
商行負責人姓名 :<br> 
<input type="text" value="${getstore.storePiName}" name="memberCel"><br> 
商行負責人身分證  :<br> 
<input type="text" value="${getstore.storePiTwid}" name="memberCel"><br> 
商行負責人電話 :<br> 
<input type="text" value="${getstore.storePiTel}" name="memberCel"><br> 
商行負責人地址 :<br> 
<input type="text" value="${getstore.storePiAddress}" name="memberCel"><br> 

<input type="submit" value="儲存">               
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>          





</body>
</html>