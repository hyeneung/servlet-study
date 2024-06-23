<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layout/header.jsp" %>
<center>
	<form action="insertBoard.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td><input type="text" name="title"/></td>				
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td><input type="text" name="writer" size="12" value="<%=user.getName()%>" disabled/></td>	
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td><textarea name="content" rows="5" cols="50"></textarea></td>	
			</tr>			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="전송버튼"/>
					<input type="reset" value="취소버튼"/>
				</td>	
			</tr>					
		</table>
	</form>
</center>
<%@include file="../layout/footer.jsp" %>