<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>privateChat</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
		setTimeout(function() {
			Push();  //目标函数
		}, 200);
		setInterval(function() {
			Push();  //目标函数 
		},1000);
		function Push(){
			var url = "${pageContext.request.contextPath }/privatemessages";
		    var data = {"time" : new Date()};
		    $.get(url, data, function(datas){
		    	document.getElementById("contentArea").innerHTML = datas;
				document.wirte("<p>" + datas + "</p>");
		  	});
		}
	function checkcontent(){
		var content = $(":text[name='content']").val();
		if(content == ""){
			alert("请不要发送空消息！");
			return false;
		}
	}
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
	<table align="center" width="778" height="100" border="0" cellpadding="0" cellspacing="1">
		<tr bgcolor="#F7FDED" style="padding: 1px" height="30" align="left">
			<td>聊天对象：${sessionScope.searchusername }</td>
		</tr>
		<tr bgcolor="#F7FDED" style="padding: 1px" height="30" align="center">
			<td>
			<div id="contentArea" style="height: 400px; overflow:auto">
				私聊信息显示
			</div>
			</td>
		</tr>
		<tr bgcolor="#F7FDED" style="padding: 1px" height="30">
			<td>
				<form action="${pageContext.request.contextPath }/sendPrivate" method="post" onsubmit="return checkcontent()">
					<input type="text" name="content" value=""/>
					<input type="submit" name="submit" value="发送"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>