<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del() {
		
	}
</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">${member.name }님 환영합니다</h2>
		<table class="table table-striped">
			<tr>
				<td><a href="view.do" class="btn btn-success">조회</a></td>
			</tr>
			<tr>
				<td><a href="updateForm.do" class="btn btn-warning">수정</a></td>
			</tr>
			<tr>
				<td><a onclick="del()" class="btn btn-danger">탈퇴</a></td>
			</tr>
			<tr>
				<td><a href="logout.do" class="btn btn-info">로그 아웃</a></td>
			</tr>
		</table>
	</div>
</body>
</html>