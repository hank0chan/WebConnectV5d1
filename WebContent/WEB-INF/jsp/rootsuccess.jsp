<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<h3>管理员用户名: <font color="blue">${requestScope.rootname }</font></h3>
	<button onclick="window.location='${pageContext.request.contextPath }/rootlogout'" style="color: Grey">
					退出登录
	</button>
	<table align="center" border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>用户名</th>
			<th>用户消息管理</th>
			<th>用户账号管理</th>
		</tr>
		<!-- 输出每个用户列表 -->
		<c:forEach items="${requestScope.userlist }" var="user">
		<tr>
			<td>${user.username }</td>
			<td><button onclick="window.location='${pageContext.request.contextPath }/cancelMessage/${user.id }'">清空消息</button></td>
			<td><button onclick="window.location='${pageContext.request.contextPath }/cancelUser/${user.id }'">双击注销用户</button></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>