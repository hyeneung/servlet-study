<%@page contentType="text/html; charset=UTF-8"%>

<%-- <%
	// 1. request에 등록된 검색 결과 추출
	List<BoardVO> boardList = (List) request.getAttribute("boardList");
	// 2. 응답 화면 구성
%>
 --%>
<%@include file="../layout/header.jsp" %>

<center>
<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<%-- <%
				String condition = (String) session.getAttribute("condition");
			%> --%>			
			<option value="TITLE" <c:if test="${sessionScope.condition == 'TITLE'}">selected</c:if>>제목
			<option value="CONTENT" <c:if test="${sessionScope.condition == 'CONTENT'}">selected</c:if>>내용
			</select>
			<input name="searchKeyword" value="${sessionScope.keyword}" type="text"/>
			<input type="submit" value="검색"/>
		</td>
	</tr>
	</table>
</form>
<!-- 검색 종료 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">번호</th>
	<th bgcolor="orange" width="200">제목</th>
	<th bgcolor="orange" width="150">작성자</th>
	<th bgcolor="orange" width="150">등록일</th>
	<th bgcolor="orange" width="100">조회수</th>
</tr>

<%-- <% for(BoardVO board : boardList) { %> --%>
<c:forEach var="board" items="${boardList }"> <!-- "boardList"로 하면 안됨  -->
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq } %>">${board.title }</a></td>
	<td>${board.writer }</td>
	<td>${board.regDate }</td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>
<%-- <% } %> --%>

</table>
</center>

<%@include file="../layout/footer.jsp" %>