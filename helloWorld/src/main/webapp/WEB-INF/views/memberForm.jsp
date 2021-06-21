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
		<h2 class="text-primary">Member Info.</h2>
		<!-- 입력받은 값을 controller member로 전송 -->
		<form action="member" method="post">
			<table class="table table-bordered table-striped">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="addr" required="required"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="age" required="required"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><label for="g1">남자</label><input type="radio" name="gender" value="남자" id="g1" checked="checked"><br>
						<label for="g2">여자</label><input type="radio" name="gender" value="여자" id="g2"></td>
				</tr>
				<tr>
					<th>취미</th>
					<td><select name="hobby">
							<option>게임</option>
							<option>음주</option>
							<option>가무</option>
							<option>울기</option>
							<option>싸우기</option>
					</select></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="확인"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>