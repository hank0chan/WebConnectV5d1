<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆界面</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function check(){
		var rootname = $(":text[name='rootname']").val();
		var password = $(":password[name='password']").val();
		if(rootname == ""){
			alert("请输入用户名");
			return false;
		}
		if(password == ""){
			alert("请输入密码");
			return false;
		}
	}
</script>
</head>
<body>
	<h3 align="center">管理员登陆</h3>
	<div align="center">
	<form action="rootlogin" method="post" onsubmit="return check()">
		<table>
			<tr>
				<td></td>
				<td align="right"><a href="${pageContext.request.contextPath }/backToIndex" style="color: lightgrey">返回用户登陆首页</a></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="rootname" value="${param.rootname }"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" value=""/></td>
			</tr>
			<tr>
				<td>
				</td>
				<td align="right">
					<input type="submit" name="submit" value="登陆"/>
				</td>
			</tr>
			<tr><font color="red">${requestScope.messages }</font></tr>
		</table>
	</form>
	</div>
</body>
</html>