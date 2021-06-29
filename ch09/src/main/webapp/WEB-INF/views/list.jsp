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
		<h2 class="text-primary">게시글 목록</h2>
		<table class="table table-striped">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:if test="${empty list }">
				<tr>
					<th colspan="5">게시글이 없습니다</th>
				</tr>
			</c:if>
			<c:if test="${not empty list }">
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${num}<c:set var="num" value="${num - 1}"></c:set>
						<%-- ${board.num } --%></td>
						<c:if test="${board.del == 'y' }">
							<th colspan="4">삭제된 글 입니다</th>
						</c:if>
						<c:if test="${board.del != 'y' }">
							<td title="${board.content }">
								
								<!-- 답변글 -10 px씩 들여쓰기 -->
								<c:if test="${board.re_level > 0 }">
									<img alt="" src="resources/images/level.gif" height="5" width="${board.re_level*10 }">
									<img alt="" src="resources/images/re.gif">
								</c:if>
								
								<a href="view.do?num=${board.num }&pageNum=${pb.currentPage}" class="btn btn-info btn-sm">${board.subject }</a>
								
								<!-- 조회수가 10이 넘으면 인기 글 -->
								<c:if test="${board.readcount > 10 }">
									<img alt="" src="resources/images/hot.gif">
								</c:if>
							</td>
							<td>${board.writer }</td>
							<td>${board.readcount }</td>
							<td>${board.reg_date }</td>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<div align="center">
			<!-- pagination= 스타일 부여, ul li 사용 -->
			<ul class="pagination">
				<!-- 시작 페이지가 pagePerBlock보다 크면 앞에 보여줄 페이지 표시 "<"버튼 생성-->
				<c:if test="${pb.startPage > pb.pagePerBlock }">
					<li><a href="list.do?pageNum=1"><span
							class="glyphicon glyphicon-triangle-backward"></span></a></li>
					<li><a href="list.do?pageNum=${pb.startPage - 1 }"><span
							class="glyphicon glyphicon-triangle-left"></span></a></li>
				</c:if>

				<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }">
					<c:if test="${pb.currentPage == i }">
						<!-- active = 현재 보고있는 페이지 표시 -->
						<li class="active"><a href="list.do?pageNum=${i }">${i }</a></li>
					</c:if>
					<c:if test="${pb.currentPage != i }">
						<li><a href="list.do?pageNum=${i }">${i }</a></li>
					</c:if>
				</c:forEach>

				<!-- endPage보다 totalPage가 크면 앞에 보여줄 페이지 표시 ">"버튼 생성-->
				<c:if test="${pb.endPage < pb.totalPage}">
					<li><a href="list.do?pageNum=${pb.endPage+1 }"> <span
							class="glyphicon glyphicon-triangle-right"></span></a></li>
					<li><a href="list.do?pageNum=${pb.totalPage}"> <span
							class="glyphicon glyphicon-forward"></span></a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<div align="center">
		<a href="insertForm.do?num=0&pageNum=1" class="btn btn-success">게시글 입력</a>
	</div>
</body>
</html>