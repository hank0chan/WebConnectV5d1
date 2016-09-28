<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码修改界面</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function check(){ //验证输入信息：不能为空 
	var username1 = $(":text[name='username']").val();
	var password1 = $(":text[name='password']").val();
	var password2 = $(":text[name='newPassword']").val();
	var password3 = $(":text[name='newPassword2']").val();
	if(username1 == ""){
		alert("请输入用户名！");
		return false;
	}
	if(password1 == ""){
		alert("请输入密码！");
		return false;
	}
	if(password2 == ""){
		alert("请输入新密码！");
		return false;
	}
	if(password3 == ""){
		alert("请确认新密码！");
		return false;
	}
}
$(function(){
	$('#tips').fadeOut(4000); //淡出元素
});
</script>
</head>
<body>
	<!-- 重复登录及用户忘记密码时修改密码页面 -->
	<h3 align="center">密码修改界面</h3>
	<div align="center">
		<font style="color: red"><p>${requestScope.messages }</p></font>
		<font style="color: red"><p>${requestScope.changePasswordFailedMessages }</p></font>
	</div>
	<div align="center">
		<form action="changePassword" method="post" onsubmit="return check()">
		<table>
			<tr>
				<td>输入用户名：</td>
				<td><input type="text" name="username" value="" maxlength="20"/></td>
			</tr>
			<tr>
				<td>输入旧密码：</td>
				<td><input type="text" name="password" value="" maxlength="16"/></td>
			</tr>
			<tr>
				<td>输入新密码：</td>
				<td><input type="text" name="newPassword" value="" maxlength="16"/></td>
			</tr>
			<tr>
				<td>确认新密码：</td>
				<td><input type="text" name="newPassword2" value="" maxlength="16"/></td>
			</tr>
			<tr>
				<td><a href="backToIndex" style="color: lightgrey">返回首页</a></td>
				<td align="right"><input type="submit" name="submit" value="确认"/></td>
			</tr>
		</table>
	</form>
	<p id="tips"><font color="lightgrey" size="2px">当您的密码修改操作成功后将自动跳转至登录首页</font></p>
	</div>

</body>
</html>