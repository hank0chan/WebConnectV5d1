<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的资料</title>
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
	<table align="center" width="778" height="100" border="0" cellpadding="0" cellspacing="1">
		<tr bgcolor="#F7FDED" style="padding: 5px">
			<td>
				<div>
				<p>
					<font color="" size="2px">我的用户名:&nbsp;</font>${requestScope.personalInfo.username }
				</p>
				<p>
					<font color="" size="2px">性别:&nbsp;</font>
					<c:set var="personalInfo.gender" scope="request"/>
					<c:if test="${personalInfo.gender == 1}">
				   		<c:out value="男"/>
					</c:if>
					<c:if test="${personalInfo.gender == 0}">
				   		<c:out value="女"/>
					</c:if>
				</p>
				<p>
					<font color="" size="2px">年龄:&nbsp;</font>${requestScope.personalInfo.age }
				</p>
				<p>
					<font color="" size="2px">院校:&nbsp;</font>${requestScope.personalInfo.college }
				</p>
				<p>
					<font color="" size="2px">电话:&nbsp;</font>${requestScope.personalInfo.tel }
				</p>
				<p>
					<font color="" size="2px">邮箱:&nbsp;</font>${requestScope.personalInfo.email }
				</p>
				<p>
					<font color="" size="2px">微信:&nbsp;</font>${requestScope.personalInfo.weixin }
				</p>
				<p>
					<font color="" size="2px">QQ:&nbsp;</font>${requestScope.personalInfo.qq }
				</p>
				</div>
			</td>
		</tr>
		<tr bgcolor="#F7FDED" style="padding: 5px" height="10">
			<td><button onclick="window.location='changeInfo'" style="color: Grey">
					修改资料
				</button></td>
		</tr>
	</table>
</body>
</html>