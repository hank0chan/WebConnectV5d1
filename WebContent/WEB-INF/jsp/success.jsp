<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主界面</title>
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
		scrollWindow();
		var url = "online";  //"testjsp"
		var data = {"time" : new Date()};
	    $.get(url, function(datas){
			document.getElementById("online2").innerHTML = datas + new Date();
			document.wirte("<p>" + datas + "</p>");
	  	});
	    var url2 = "onlineMessage";
	    var data = {"time" : new Date()};
	    $.get(url2, data, function(datas){
			document.getElementById("contentMessages").innerHTML = datas;
			document.wirte("<p>" + datas + "</p>");
	  	});
	}
	/* 滚动条置底 */
	function scrollWindow(){
	var t = document.getElementById("contentMessages");
	t.scrollTop = t.scrollHeight;
	setTimeout('scrollWindow()', 20);
	}
	/* 搜索用户名不能为空 */
	function checksearch(){
		var searchname = $(":text[name='searchname']").val();
		if(searchname == ""){
			alert("搜索用户名不能为空！");
			return false;
		}
	}
	/* 不能发送空消息 */
	function checkcontent(){
		var content = $("textarea[name='testcontent']").val();
		if(content == ""){
			alert("请不要发送空消息！");
			return false;
		}
	}
</script>
</head>
<body>
	<table width="778" height="100" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr width="778" bgcolor="#F7FDED" style="padding: 5px">
			<td align="left">
				<h5>我的用户名:<button onclick=""><font id="user" color="blue">${sessionScope.user.username }</font></button></h5>
				<button id="userinfo_button" onclick="window.location='personalInfo'">我的资料</button>
				<button id="userfriends_button" onclick="window.location='myfriends'">关注好友(用户资料及私聊)</button>
			</td>
			<td align="right">
			<!-- 搜索用户 -->
				<form action="searchUser" method="post" onsubmit="return checksearch()">
					<input type="text" name="searchname"/><input type="submit" value="搜索用户"/>
				</form>
			</td>
			<td align="right">
				<button onclick="window.location='outLogin'" style="color: Grey">
					退出登录
				</button>
			</td>
		</tr>
	</table>
	<table bgcolor="black" align="center">
	<tr>
		<td id="online" width="165" valign="top" bgcolor="#F7FDED" style="padding: 5px">
			在线用户列表:
			<div id="online2" style="overflow: auto;">
				<!-- 
				<p>${requestScope.userList }</p>
				<c:forEach items="${requestScope.userList }" var="user">
					${user.username } <br>
				</c:forEach>
				 -->
			</div>
		</td>
		<td width="613" height="300" valign="top" bgcolor="#FFFFFF" style="padding: 5px">
			<div id="contentMessages" style="height: 400px; overflow:auto">聊天内容显示区</div>
		</td>
	</tr>
	</table>
	<table align="center">
			<tr><font style="color: red">${requestScope.abandon }</font></tr>
			<form action="sendMessage" method="post" onsubmit="return checkcontent()">
				<tr width="778" bgcolor="#F7FDED" style="padding: 5px">
					<td align="left">
						<textarea rows="5" cols="100" name="testcontent"></textarea>
						<!-- <input type="text" name="content" value=""/> -->
						<input type="submit" name="submit" value="发送"/>
					</td>
				</tr>
				<tr>
					<td align="right">
					</td>
				</tr>
			</form>
	</table>
</body>
</html>