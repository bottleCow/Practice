<!-- 사진 여러장 업로드 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function idChk() {
			if (!frm.id.value) {
				alert("아이디를 입력한 후 체크하세요")
				frm.id.focus();
				return false;
			}
			//id를 입력했던 jquery ajax를 사용
			//data는 controller에서 보내준 값-->idChk.jsp에서 ${msg}값
			$.post('idChk.do', 'id='+frm.id.value, function(data) {
				$('#idChk').html(data);// jsp에서 id가 idChk에 값을 넘겨줌
			});
		}
		function chk() {
			if (frm.password.value != frm.password2.value) {
				alert("암호를 다시 확인해주세요");
				frm.password.focus(); // password로 커서 이동
				frm.password.value=""; // 입력된 password칸에 있는 데이터 지우기
				return false; // form action을 실행 안함
			}
		}
	</script>

</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">회원 가입</h2>
		<!-- onsubmit="return chk() >> submit하기 전에 암호 암호확인 일치 확인 -->
		<form action="join2.do" method="post" enctype="multipart/form-data"
			name="frm" onsubmit="return chk()">
			<table class="table table-bordered table-hover">
				<tr>
					<td>아이디 <span class="glyphicon glyphicon-user"></span></td>
					<td><input type="text" name="id" required="required" autofocus="autofocus">
						<!-- 아이디 중복 체크 -->
						<input type="button" onclick="idChk()" class="btn btn-info btn-sm" value="중복체크">
						<div id="idChk" class="err"></div></td>
				</tr>
				<tr>
					<td>암호 <span class="glyphicon glyphicon-lock"></span></td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td>암호확인 <span class="glyphicon glyphicon-lock"></span></td>
					<td><input type="password" name="password2"
						required="required"></td>
				</tr>
				<tr>
					<td>이름 <span class="glyphicon glyphicon-user"></span></td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td>이메일 <span class="glyphicon glyphicon-envelope"></span></td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td>사진 <span class="glyphicon glyphicon-picture"></span></td>
					<td><input type="file" name="file" required="required" multiple="multiple"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"
						class="btn btn-danger"></td>
				</tr>
			</table>
			<a href="loginForm.do" class="btn btn-success">로그인</a>
		</form>
	</div>
</body>
</html>