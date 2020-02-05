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
<h1>首頁</h1>


<a href="<c:url value="register.jsp"/>">註冊</a>
<a href="<c:url value="loginSystem.jsp"/>">登入</a>
<a href="getMember1">會員專區</a>


 ${user}

</body>
</html>