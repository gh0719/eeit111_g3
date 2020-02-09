<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>喔歐~ 輸入格式有誤在檢查下</h1>

<div id="div1" style="float: left"></div><h4> 秒後返回上頁~</h4>

<img alt="life" src="images/life.gif">

 <div id="div1"></div>
<script type="text/javascript">
	var count = 3;//設定倒數秒數 
	function countDown(){//寫一個方法，顯示倒數秒數  數到0後跳轉頁面  
		document.getElementById("div1").innerHTML= count;//將count顯示在div中
		count -= 1;//執行一次，count減1
		if(count==-1){//count=0時，跳轉頁面
			history.go(-1); //返回上頁 window.location.href="index.html";                   
		}
		setTimeout("countDown()",900);//每秒執行一次,showTime()
	}
	countDown();
</script>
</body>
</html>