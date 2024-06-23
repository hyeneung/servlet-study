<%-- <%@page import="com.multicampus.biz.board.BoardDAO"%>
<%@page import="com.multicampus.biz.board.BoardVO"%> --%>
<%@page contentType="text/html; charset=UTF-8"%>

<%-- <%
	// 1. request로부터 검색 결과를 꺼낸다.
	BoardVO board = (BoardVO) request.getAttribute("board");

	// 2. 응답 화면 구성
%> --%>

<%@include file="../layout/header.jsp"%>
<center>
	<form action="updateBoard.do" method="post">
		<%-- <input name="seq" type="hidden" value="<%=board.getSeq()%>" /> --%>
		<input name="seq" type="hidden" value="${requestScope.board.seq }" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input name="title" type="text"
					value="${board.title }" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left">${board.writer }</td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left">${board.regDate }</td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left">${board.cnt }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="글 수정" /></td>
			</tr>
		</table>
	</form>
	<!-- <a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;  -->
	<%-- <% if (user.getRole().equals("ADMIN")) { %> --%>
	<c:if test="${sessionScope.user.role == 'ADMIN' }">
	
	<hr>
	<a href="deleteBoard.do?seq=${board.seq }%>">글삭제</a>&nbsp;&nbsp;&nbsp;
	<%-- <% } %> --%>
	</c:if>
</center>
<%@include file="../layout/footer.jsp"%>