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


<img  src="${getMemberPic}" style="height: 100px;width: 120px"><br>
姓名 :${getMemberFname}<br> 
暱稱 :${getMemberSname}<br> 
身分證字號 : ${getMemberTwid}<br> 
性別 :${getMemberGd}
生日 :${getMemberHb}<br> 
市內電話 :${getMemberTel}<br> 
手機號碼 :${getMemberCel}<br> 


<input type="button" value="修改資料" onclick="location.href='getMember'">  
<input type="button" value="首頁" onclick="location.href='Home.jsp'">  

</body>
</html>