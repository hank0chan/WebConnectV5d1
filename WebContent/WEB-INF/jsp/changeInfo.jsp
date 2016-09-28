<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改我的个人资料</title>
</head>
<body>
	<table align="center" width="778" height="100" border="0" cellpadding="0" cellspacing="1">
		<tr bgcolor="#F7FDED" style="padding: 1px" height="30">
			<td align="right">
			<h5 align="left">我的用户名:<button onclick=""><font id="user" color="blue">${sessionScope.user.username }</font></button></h5>
				<button onclick="window.location='backToSuccess'">
					返回主界面
				</button>
				<button onclick="window.location='outLogin'" style="color: Grey">
					退出登录
				</button>
			</td>
		</tr>
	</table>
	
	<table align="center" width="778" height="100" border="0" cellpadding="0" cellspacing="1">
		<tr bgcolor="#F7FDED" style="padding: 5px" align="center">
			<td>
			<br>
			<form action="changeInfoSuccess" method="post">
				<!-- 昵称<input type="text" name="nickname" value=""/> -->
				<!-- 性别:<input type="text" name="gender" value=""/><br><br> -->
				&nbsp;&nbsp;<select name="gender" onchange="" style="width: 180px;height: 20px;">
					<option value="1">男</option>
					<option value="0">女</option>
				</select><br><br>
				年龄:<input type="text" name="age" value="${sessionScope.user.age }"/><br><br>
				院校:<input type="text" name="college" value="${sessionScope.user.college }"/><br><br>
				电话:<input type="text" name="tel" value="${sessionScope.user.tel }"/><br><br>
				邮箱:<input type="text" name="email" value="${sessionScope.user.email }"/><br><br>
				微信:<input type="text" name="weixin" value="${sessionScope.user.weixin }"/><br><br>
				QQ:&nbsp;<input type="text" name="qq" value="${sessionScope.user.qq }"/><br><br>
				<input type="submit" name="submit" value="保存" align="right"/><br>
				<br><br>
			</form>
			</td>
		</tr>
	</table>
</body>
</html>