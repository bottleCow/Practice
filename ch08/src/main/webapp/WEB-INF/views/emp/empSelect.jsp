<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function () {
		$('#empList').load("empList.html table", "deptno=${emp.deptno}")
	});
</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">직원정보 상세</h2>
		<table class="table table-bordered table-hover">
			<tr>
				<td>사번</td>
				<td>${emp.empno }</td>
				<td>이름</td>
				<td>${emp.ename }</td>
			</tr>
			<tr>
				<td>업무</td>
				<td>${emp.job }</td>
				<td>관지라</td>
				<td>${emp.mgr }</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>${emp.hiredate }</td>
				<td>급여</td>
				<td>${emp.sal }</td>
			</tr>
			<tr>
				<td>커미션</td>
				<td>${emp.comm }</td>
				<td>부서코드</td>
				<td>${emp.deptno }</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
				<a href="empList.html?deptno=${emp.deptno }" class="btn btn-default">직원 목록</a>
				<a href="empUpdateForm.html?emp=${emp.empno }" class="btn btn-default">수정</a>
				<a onclick="del(${emp.empno })" class="btn btn-default"> 삭제</a>
				<a href="deptList.html" class="btn btn-default">직원 목록</a>
				
			</tr>
		</table>
		<div id="empList"></div>	
	</div>
</body>
</html>