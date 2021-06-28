<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2>전직원 목록</h2>
		<table class="table table-bordered table-striped">
			<tr>
				<td>사번</td>
				<td>이름</td>
				<td>업무</td>
				<td>관리자</td>
				<td>입사일</td>
				<td>급여</td>
				<td>COMM</td>
				<td>부서코드</td>
				<td>부서명</td>
				<td>근무지</td>
			</tr>
			<c:forEach var="emp" items="${list }">
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td>${emp.hiredate }</td>
					<td>${emp.sal }</td>
					<td>${emp.comm }</td>
					<td>${emp.deptno }</td>
					<!-- emp.xml에서 collection통해서 dept와 같이 join했기때문에 emp안에dept로 써줌 -->
					<td>${emp.dept.dname }</td>
					<td>${emp.dept.loc }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="deptList.html" class="btn btn-info">부서 목록</a>
	</div>
</body>
</html>