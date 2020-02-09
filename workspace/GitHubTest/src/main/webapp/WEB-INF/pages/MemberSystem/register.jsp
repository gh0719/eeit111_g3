<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body style="background-image:url('images/test.jpg'); ">


<h4>使用者註冊</h4>
<p>* 為必填</p>
<form action="registerMember" method="post" enctype="multipart/form-data">
*信箱 (包含 @ 信箱)  :<br><input type="text" name="memberEmail"><br>
${errorAccount}<br>
*密碼  (6~12長度 ,包含數字及英文字母):<br>
<input type="text" name="memberPwd"><br>
*姓名 :<br>
<input type="text" name="memberFname" value="${sessionScope.get('name').memberFname}"><br>
*暱稱 :<br>
<input type="text" name="memberSname" value="${sessionScope.get('name').memberSname}"><br>
*身分證字號 (第一字母為英文大寫):<br>
<input type="text" name="memberTwid" value="${sessionScope.get('name').memberTwid}"><br>
*生日 :<br>
<input type="text" name="memberHb" value="${sessionScope.get('name').memberHb}"><br>
*性別 :<br>
<input type="text" name="memberGd" value="${sessionScope.get('name').memberGd}"><br>
電話 :<br>
<input type="text" name="memberTel" value="${sessionScope.get('name').memberTel}"><br>
*手機 (為09開頭的10位數電話號碼):<br>
<input type="text" name="memberCel" value="${sessionScope.get('name').memberCel}"><br>
大頭照 (為jpeg，gif檔 大小不可超過1M):<br>
<input type="file" name="file"><br>
<input type="submit" value="送出">
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>
<h2 style="color: red">${errorFormat}</h2>
<h2 style="color: red">${errorPicFormat}</h2>
</body>
</html>