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


<h4>使用者註冊</h4>

<p>* 為必填</p>
<form action="registerMember" method="post" enctype="multipart/form-data">
*信箱 (包含 @ 信箱)  :<br><input type="text" name="memberEmail"><br>
<c:if test="${not empty errorAccount}">
帳號已註冊 可更改為:
<c:forEach var="a11at" items="${errorAccount}" >
<br>${a11at}<br>
</c:forEach>
</c:if>
*密碼  (6~12長度 ,包含數字及英文字母):<br>
<input type="text" name="memberPwd"><br>
*確認密碼 :<br>
<input type="text" name="confirmPwd"><br>
*姓名 :<br>
<input type="text" name="memberFname" value="${inputMember.memberFname}"><br>
*暱稱 :<br>
<input type="text" name="memberSname" value="${inputMember.memberSname}"><br>
*身分證字號 (第一字母為英文大寫):<br>
<input type="text" name="memberTwid" value="${inputMember.memberTwid}"><br>
*生日 :<br>
<input type="text" name="memberHb" value="${inputMember.memberHb}"><br>
*性別 :<br>
<input type="text" name="memberGd" value="${inputMember.memberGd}"><br>
電話 :<br>
<input type="text" name="memberTel" value="${inputMember.memberTel}"><br>
*手機 (為09開頭的10位數電話號碼):<br>
<input type="text" name="memberCel" value="${inputMember.memberCel}"><br>
大頭照 (為jpeg，gif檔 大小不可超過1M):<br>
<input type="file" name="file"><br>
<input type="submit" value="送出">
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>
<h2 style="color: red">${errorFormat}</h2>
<h2 style="color: red">${errorPicFormat}</h2>
<h2 style="color: red">${errorPwd}</h2>
</body>
</html>