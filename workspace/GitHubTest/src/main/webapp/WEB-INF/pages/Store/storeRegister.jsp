<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body style="background-image:url('images/test123.jpg'); ">


<h4>商家註冊</h4>

<p>* 為必填</p>
<form action="addStore" method="post" enctype="multipart/form-data">
*商家名稱:<br>
<input type="text" name="storeName" value="${storeInput.storeName}" id="storeName">${errorName} ${errorRepeat}<br>
*商家簡介:<br>
<input type="text" name="storePf" value="${storeInput.storePf}" id="storePf">${errorPf}<br>
*商家電話 :<br>
<input type="text" name=storeTel value="${storeInput.storeTel}" id="storeTel">${errorTel}<br>
商家地址(實體店面) :<br>
<input type="text" name="storeAddress" value="${storeInput.storeAddress}" id="storeAddress"><br>
*商行號碼 :<br>
<input type="text" name="storeNumber" value="${storeInput.storeNumber}" id="storeNumber">${errorNumber}<br>
*商行帳戶 :<br>
<input type="text" name="storeAccount" value="${storeInput.storeAccount}" id="storeAccount">${errorAccount}<br>
*商行負責人姓名 :<br>
<input type="text" name="storePiName" value="${storeInput.storePiName}" id="storePiName">${errorPiName}<br>
*商行負責人身分證 :<br>
<input type="text" name="storePiTwid" value="${storeInput.storePiTwid}" id="storePiTwid">${errorPiTwid}<br>
*商行負責人電話 :<br>
<input type="text" name="storePiTel" value="${storeInput.storePiTel}" id="storePiTel">${errorPiTel}<br>
*商行負責人地址 :<br>
<input type="text" name="storePiAddress" value="${storeInput.storePiAddress}" id="storePiAddress">${errorPiAddress}<br>
商行照片 : (為jpeg，gif檔 大小不可超過1M):<br>
<input type="file" name="file" id="storePic">${errorPicFormat}<br>
<input type="submit" value="送出">
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>
<h2 style="color: red">${errorFormat}</h2>
<h2 style="color: red">${errorPicFormat}</h2>
<h2 style="color: red">${errorPwd}</h2>
</body>
</html>