<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>厚积薄发，厚德载物</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	/*第一次读取最新通知*/
	setTimeout(function() {
		Push();  //目标函数
	}, 200);
	/*1秒 轮询读取函数*/
	setInterval(function() {
		Push();  //目标函数 
	},1000);
	/*请求函数的ajax*/
	function Push() {
		var url = this.href;
	    $.get(url, function(datas){
			document.getElementById("test").innerHTML = datas + new Date();
			document.wirte("<p>" + datas + "</p>");
	  });
	}
</script>
</head>
<body>
	<table width="100" height="50">
		<div id="test">
			<c:forEach items="${requestScope.userList }" var="user">
				<!-- <button onclick="alert('hello!')"></button> -->
				${user.username }<br>
			</c:forEach>
		</div>
	</table>
</body>
</html>