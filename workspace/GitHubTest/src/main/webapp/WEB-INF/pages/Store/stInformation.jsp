<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
商行照片 :<br>
<img  src="${getstore.storePic}" style="height: 100px;width: 120px"><br>
商家名稱:${getstore.storeName}<br> 
商家簡介:${getstore.storePf}<br> 
商家電話 : ${getstore.storeTel}<br> 
商家地址(實體店面) :${getstore.storeAddress}<br>
商行號碼 :${getstore.storeNumber}<br> 
商行帳戶 :${getstore.storeAccount}<br> 
商行負責人姓名 :${getstore.storePiName}<br> 
商行負責人身分證 :${getstore.storePiTwid}<br> 
商行負責人電話 :${getstore.storePiTel}<br> 
商行負責人地址 :${getstore.storePiAddress}<br> 

<input type="button" value="修改資料" onclick="location.href='findStoreToUpdate'">  
<input type="button" value="商城管理" onclick="location.href=''">  
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">  

</body>
</html>