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
<form action="updateStore" method="post" enctype="multipart/form-data">
商行照片:<br>
<img  src="${getstore.storePic}${storeInput.storePic}" style="height: 100px;width: 120px" ><br>
<input type="file" name="file" >${errorPic}<br>
商家名稱 :<br> 
<input type="text" value="${getstore.storeName}${storeInput.storeName}" name="storeName"> ${errorName} ${errorRepeat}<br>
商家簡介 :<br> 
<input type="text" value="${getstore.storePf}${storeInput.storePf}" name="storePf"> ${errorPf}<br>
商家電話 :<br> 
<input type="text" value="${getstore.storeTel}${storeInput.storeTel}" name="storeTel"> ${errorTel}<br>
商家地址(實體店面):<br> 
<input type="text" value="${getstore.storeAddress}${storeInput.storeAddress}" name="storeAddress"><br> 
商行號碼 :<br> 
<input type="text" value="${getstore.storeNumber}${storeInput.storeNumber}" name="storeNumber"> ${errorNumber}<br>
商行帳戶 :<br> 
<input type="text" value="${getstore.storeAccount}${storeInput.storeAccount}" name="storeAccount"> ${errorAccount}<br>
商行負責人姓名 :<br> 
<input type="text" value="${getstore.storePiName}${storeInput.storePiName}" name="storePiName"> ${errorPiName}<br>
商行負責人身分證  :<br> 
<input type="text" value="${getstore.storePiTwid}${storeInput.storePiTwid}" name="storePiTwid"> ${errorPiTwid}<br>
商行負責人電話 :<br> 
<input type="text" value="${getstore.storePiTel}${storeInput.storePiTel}" name="storePiTel"> ${errorPiTel}<br>
商行負責人地址 :<br> 
<input type="text" value="${getstore.storePiAddress}${storeInput.storePiAddress}" name="storePiAddress"> ${errorPiAddress}<br>

<input type="hidden" value="${getstore.storeId}${storeInput.storeId}" name="storeId">
<input type="hidden" value="${getstore.storeStatus}${storeInput.storeStatus}" name="storeStatus">
<input type="hidden" value="${getstore.storePic}${storeInput.storePic}" name="storePic">


<input type="submit" value="儲存">               
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>          





</body>
</html>