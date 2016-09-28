<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆首页</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function check(){ //验证输入信息：不能为空 
	var username = $(":text[name='username']").val();
	var password = $(":password[name='password']").val();
	if(username == ""){
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
	<br><br>
		<h3 align="center">登陆界面</h3>
	<!-- 密码修改成功的提示 -->
	<p align="center"><font style="color: red">${requestScope.repeatMessages }</font></p>
	<!-- 注册成功的提示 -->
	<p align="center"><font style="color: red">${requestScope.addUserMessages }</font></p>
	<div align="center">
	<form action="login" method="post" onsubmit="return check()">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="${requestScope.userForm.username }"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" value=""/></td>
			</tr>
			<tr>
				<td><a href="changePSW">修改密码</a></td>
				<td align="">
					&nbsp;&nbsp;<a href="addUser">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" name="submit" value="登陆"/>
				</td>
			</tr>
			<tr><font style="color: red;">${requestScope.messages }</font></tr>
			<tr align="right"><td></td><td align="right"><a href="rootIndex"><font color="lightgrey" size="3px">我是管理员</font></a></td></tr>
		</table>
	</form>
	</div>
</body>
</html>