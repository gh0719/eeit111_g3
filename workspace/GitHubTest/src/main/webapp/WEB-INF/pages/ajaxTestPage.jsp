<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="init/bootstrap.jsp" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/testCss.css" >
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>

</head>
<body>
<form action="registerMember" method="post" enctype="multipart/form-data">
*信箱 (包含 @ 信箱)  :<br>
<input type="text" name="memberEmail" id="memberEmail" placeholder="Email" class="border border-danger">
<small id="memberEmailRegular" class="text-danger"></small>
<br>

*密碼  (6~12長度 ,包含數字及英文字母):<br>
<input type="text" name="memberPwd" id="registerPwd"><br>
*姓名 :<br>
<input type="text" name="memberFname" id="registerFName"><br>
*暱稱 :<br>
<input type="text" name="memberSname" id="registerSName"><br>
*身分證字號 (第一字母為英文大寫):<br>
<input type="text" name="memberTwid" id="registerTwid"><br>
*生日 :<br>
<input type="text" name="memberHb" id="registerHb"><br>
*性別 :<br>
<input type="text" name="memberGd" id="registerGd""><br>
電話 :<br>
<input type="text" name="memberTel" id="registerTel""><br>
*手機 (為09開頭的10位數電話號碼):<br>
<input type="text" name="memberCel" id="registerPhone"><br>
<input type="button" value="ajaxTest" id="ajaxBtn">
</form>


<script src="${pageContext.request.contextPath}/js/memberRegular.js"></script>
</body>
</html>