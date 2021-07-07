<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function empNoChk() {
		if (!frm.empno.value) {
			alert("사번 입력한 후에 체크 하시오");
			frm.empno.focus();
			return false;
		}
		$.post('empNoChk.html', 'empno='+frm.empno.value, function(data) {
			$('#empNoChk').html(data);
		});
	}
</script>
</head><body>
<div class="container" align="center">
	<h2 class="text-primary">직원정보 입력</h2>
<form action="empInsert.html" method="post" name="frm">
<table class="table table-bordered">
	<tr><td>사번</td><td><input type="number" name="empno" 
		required="required" autofocus="autofocus"> <input type="button"
		value="중복체크" onclick="empNoChk()" class="btn btn-sm btn-warning">
		<div id="empNoChk" class="err"></div></td></tr>
	<tr><td>이름</td><td><input type="text" name="ename" 
		required="required"></td></tr>	
	<tr><td>업무</td><td><input type="text" name="job" 
		required="required"></td></tr>
	<tr><td>관리자 사번</td><td>
		<select name="mgr">
			<c:forEach var="emp" items="${empList }">
				<option value="${emp.empno }">${emp.ename}(${emp.empno})</option>
			</c:forEach>
		</select>
	</td></tr>	
	<tr><td>입사일</td><td><input type="date" name="hiredate" 
		required="required"></td></tr>
	<tr><td>급여</td><td><input type="number" name="sal" 
		required="required"></td></tr>
	<tr><td>커미션</td><td><input type="number" name="comm" 
		required="required"></td></tr>	
	<tr><td>부서코드</td><td>
		<select name="deptno">
			<c:forEach var="dept" items="${deptList }">
				<c:if test="${dept.deptno == deptno }">
					<option value="${dept.deptno }" selected="selected">${dept.dname}(${dept.deptno})</option>
				</c:if>
				<c:if test="${dept.deptno != deptno }">
					<option value="${dept.deptno }">${dept.dname}(${dept.deptno})</option>
				</c:if>				
			</c:forEach>
		</select>
	</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="확인"
		class="btn btn-danger"></td></tr>					
</table>
</form>
</div>
</body>
</html>