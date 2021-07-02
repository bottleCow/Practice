<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 class="text-primary">메뉴</h2>
	<table class="table">
		<tr>
			<td><a href="${path }/home/home" class="btn btn-success">Home</a></td>
		</tr>
		<tr>
			<td><a href="${path }/home/first" class="btn btn-info">BTS</a></td>
		</tr>
		<tr>
			<td><a href="${path }/test/second" class="btn btn-warning">Blackpink</a></td>
		</tr>
		<tr>
			<td><a href="${path }/test/third" class="btn btn-danger">Twice</a></td>
		</tr>
		<tr>
			<td><a href="${path }/nolay/test1" class="btn btn-default">no layout</a></td>
		</tr>
	</table>
</body>
</html>