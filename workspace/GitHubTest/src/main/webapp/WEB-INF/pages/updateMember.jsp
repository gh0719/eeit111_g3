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
window.location.replace(location.href)
<h4>資料更新</h4>
<form action="memberUpdate" method="post" enctype="multipart/form-data">
頭像:<br>
<img  src="${getMemberPic}" style="height: 100px;width: 120px"><br>
<input type="file" name="file"  ><br>
姓名 :<br> 
<input type="text" value="${getMemberFname}" name="memberFname"><br> 
暱稱 :<br> 
<input type="text" value="${getMemberSname}" name="memberSname"><br> 
身分證字號 :<br> 
<input type="text" value="${getMemberTwid}" name="memberTwid"><br> 
性別 :<br> 
<input type="text" value="${getMemberGd}" name="memberGd"><br> 
生日 :<br> 
<input type="text" value="${getMemberHb}" name="memberHb"><br> 
市內電話 :<br> 
<input type="text" value="${getMemberTel}" name="memberTel"><br> 
手機號碼 :<br> 
<input type="text" value="${getMemberCel}" name="memberCel"><br> 

<input type="submit" value="儲存">               
<input type="button" value="首頁" onclick="location.href='Home.jsp'">
</form>          





</body>
</html>