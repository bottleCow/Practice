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
		<h2 class="text-primary">회원 가입 결과</h2>
		<form action="member" method="post">
			<table class="table table-bordered table-striped">
				<tr>
					<th>이름</th>
					<td>${member.name }</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${member.addr }</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>${member.age }</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${member.gender }</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>${member.hobby }</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>