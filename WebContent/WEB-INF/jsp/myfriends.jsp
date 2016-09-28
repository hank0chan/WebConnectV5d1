<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的好友</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		//$('#tips').delay(4000).hide(0);//隐藏元素
		$('#tips').fadeOut(4000); //淡出元素
		//alert("温馨提示：点击在线用户的用户名就可以查看他们的资料并且添加好友哦");
	});
</script>
</head>
<body>
	<table align="center" width="778" height="100" border="0" cellpadding="0" cellspacing="1">
		<tr bgcolor="#F7FDED" style="padding: 1px" height="30">
		
			<td align="right">
				<h5 align="left">我的用户名:<button onclick=""><font id="user" color="blue">${sessionScope.user.username }</font></button></h5>
				<button onclick="window.location='${pageContext.request.contextPath }/backToSuccess'">
					返回主界面
				</button>
				<button onclick="window.location='${pageContext.request.contextPath }/outLogin'" style="color: Grey">
					退出登录
				</button>
			</td>
		</tr>
	</table>
	<table align="center" width="778" height="10" border="0" cellpadding="0" cellspacing="1">
		<tr bgcolor="#F7FDED" style="padding: 4px">
			<div id="tips" align="center"><font color="grey" size="3px">温馨提示：点击在线用户的用户名就可以查看他们的资料并且添加关注哦</font></div>
		</tr>
		<tr bgcolor="#F7FDED" style="padding: 4px">
			<td>
				<ul>
					<li><font size="2px">在线用户</font></li>
				</ul>
			</td>
			<td>
				<ul>
					<li><font size="2px">我的关注(点击用户私聊)</font></li>
				</ul>
			
			</td>
		</tr>
		<tr>
			<td valign="top">
				<div id="onlineUserList">
				<c:forEach items="${requestScope.onlineUsers }" var="user">
					<c:forEach items="${user.username }" var="username">
						<p onclick="window.location='${pageContext.request.contextPath }/publicpersonalInfo/${user.id}'">
							<font style="color: blue">${username }</font>
						</p>
					</c:forEach>
				</c:forEach>
				</div>
			</td>
			<td valign="top">
				<div id="myfriendList">
				<c:forEach items="${requestScope.friends }" var="username">
					<!-- 选择私聊对象功能开发部分 -->
					<p onclick="window.location='${pageContext.request.contextPath }/privateChat/${username}'">${username }</p>
					<!-- <p>${username }</p> -->
				</c:forEach>
				</div>
			</td>
		</tr>
	</table>

</body>
</html>