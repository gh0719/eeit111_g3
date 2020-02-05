<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	

</script>
<body>
                                              
<form action="initAnnouncement" method="post" enctype="multipart/form-data">
公告標題:<br>
<input type="text" name="announcementTital"><br>
公告內容:<br>
<textarea style="height: 100px;width: 400px" name="announcementPf"></textarea><br>
公告圖片:<br>
<input type="file" name="file"><br>
<input type="submit" value="送出">
<input type="reset" value="清除">
</form>


<c:forEach var="a11at" items="${allAt}" >
<form action="getAnnouncementById" method="get" >
${a11at.announcementTital} 公告日期${a11at.announcementDate}
<input type="hidden" value="${a11at.announcementId}" name="aaa">
<input type="submit" value="查詢">
</form>
<!-- Tital:<br>${a11at.announcementTital}<br>
Pf: <br>${a11at.announcementPf}<br>
Pic:<br> <img alt="123" src="${a11at.announcementPic}"> <br>
Date: <br>${a11at.announcementDate}<br>-->
</c:forEach>



</body>
</html>