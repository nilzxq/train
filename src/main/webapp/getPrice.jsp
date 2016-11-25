<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车票价格结果</title>

</head>

<body>
<center>
	<table border="1" width="50%" style="text-align: center;">
		<tr>
			<td>车次</td>
			<td>出发地</td>
			<td>目的地</td>
			<td>价格</td>
		</tr>
		<tr>
		<td>${trainnum}</td>
		<td>${startStation}</td>
		<td>${endStation}</td>
		<td>${calcuSartToEndPrice}</td>
		</tr>
	</table>
	</center>
</body>
</html>
