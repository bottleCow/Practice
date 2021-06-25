<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">부서 목록</h2>	
		<table class="table table-striped">
			<tr>
				<td>부서코드</td>
				<td>부서명</td>
				<td>근무지</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			
			<!-- 받아온 값이 없을때 -->
			<c:if test="${empty deptList }">
				<tr><th colspan="5">부서정보가 없습니다</th>
			</c:if>
			
			<!-- 받아온 값이 존재할때 -->
			<c:if test="${not empty deptList }">
				<c:forEach var="dept" items="${deptList }">
					<tr>
						<td>${dept.deptno }</td>
						<td>${dept.dname }</td>
						<td>${dept.loc }</td>
						<td><a>수정</a></td>
						<td><a>삭제</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<a>부서정보 입력</a>
		<a>전 직원 목록</a>
	</div>
</body>
</html>