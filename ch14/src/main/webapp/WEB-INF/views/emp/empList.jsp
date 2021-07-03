<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() { // 브라우저에 화면을 출력할 준비가 되면 실행
	// id가 deptList의 위치에 'deptList.html'을 실행한 결과를 출력하라
		$('#deptList').load("deptList.html table");
	});
</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">${dept.dname}직원 목록</h2>
		<table class="table table-striped">
			<tr>
				<td>사번</td>
				<td>이름</td>
				<td>업무</td>
				<td>입사일</td>
			</tr>
			<c:if test="${empty empList }">
				<tr>
					<th colspan="4">직원이 없습니다</th>
				</tr>
			</c:if>
			<c:if test="${not empty empList }">
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td>${emp.empno }</td>
						<td><a class="btn btn-success btn-sm"
							href="empSelect.html?empno=${emp.empno }">${emp.ename }</a></td>
						<td>${emp.job }</td>
						<td>${emp.hiredate }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<a href="deptList.html" class="btn btn-info">부서 목록</a> <a
			href="empInsertForm.html?deptno=${dept.deptno }"
			class="btn btn-warning">직원정보 입력</a>
		<div id="deptList"></div>
	</div>
</body>
</html>