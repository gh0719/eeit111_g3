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
<form action="registerMember" method="post" enctype="multipart/form-data">
信箱  :<br><input type="text" name="memberEmail"><br>
密碼  :<br><input type="text" name="memberPwd"><br>
姓名 :<br><input type="text" name="memberFname"><br>
暱稱 :<br><input type="text" name="memberSname"><br>
身分證字號 :<br><input type="text" name="memberTwid"><br>
生日 :<br><input type="text" name="memberHb"><br>
性別 :<br><input type="text" name="memberGd"><br>
電話 :<br><input type="text" name="memberTel"><br>
手機 :<br><input type="text" name="memberCel"><br>
大頭照:<input type="file" name="file"><br>
<input type="submit" value="送出">
<input type="reset" value="清除">
<input type="button" value="首頁" onclick="location.href='Home.jsp'">
</form>

</body>
</html>