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
	<div class="container" align="center">
		<h2 class="text-primary">회원 가입</h2>
		<form action="join.do" method="post" enctype="multipart/form-data" name="frm">
		<table class="table table-bordered table-hover">
			<tr>
				<td>아이디<span class="glyphicon glyphicon-user"></span></td>
				<td><input type="text" name="id" required="required" autofocus="autofocus"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>