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

<c:forEach var="a11at" items="${allAt}" >
Tital:<br>${a11at.announcementTital}<br>
Pf: <br>${a11at.announcementPf}<br>
Pic:<br> <img alt="123" src="${a11at.announcementPic}"> <br>
Date: <br>${a11at.announcementDate}<br>
</c:forEach>

</body>
</html>