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
頭像:<br>
<img  src="${getMember.memberPic}${memberInput.memberPic}" style="height: 100px;width: 120px"><br>
<input type="file" name="file"  ><br>${errorPic}
姓名 :<br> 
<input type="text" value="${getMember.memberFname}${memberInput.memberFname}" name="memberFname">${errorFname}<br> 
暱稱 :<br> 
<input type="text" value="${getMember.memberSname}${memberInput.memberSname}" name="memberSname">${errorSname}<br> 
身分證字號 :<br> 
<input type="text" value="${getMember.memberTwid}${memberInput.memberTwid}" name="memberTwid">${errorTwId}<br> 
性別 :<br> 
<input type="text" value="${getMember.memberGd}${memberInput.memberGd}" name="memberGd">${errorGd}<br> 
生日 :<br> 
<input type="text" value="${getMember.memberHb}${memberInput.memberHb}" name="memberHb">${errorHb}<br> 
市內電話 :<br> 
<input type="text" value="${getMember.memberTel}${memberInput.memberTel}" name="memberTel"><br> 
手機號碼 :<br> 
<input type="text" value="${getMember.memberCel}${memberInput.memberCel}" name="memberCel">${errorCel}<br> 

<input type="hidden" value="${getMember.memberId}${memberInput.memberId}"  name="memberId">
<input type="hidden" value="${getMember.memberPic}${memberInput.memberPic}"  name="memberPic">
<input type="hidden" value="${getMember.memberStatus}${memberInput.memberStatus}" name="memberStatus">
<input type="hidden" value="${getMember.memberEmail}${memberInput.memberEmail}" name="memberEmail">
<input type="hidden" value="${getMember.memberPwd}${memberInput.memberPwd}" name="memberPwd">

<input type="submit" value="儲存">               
<input type="button" value="首頁" onclick="location.href='${pageContext.request.contextPath}'">
</form>          





</body>
</html>