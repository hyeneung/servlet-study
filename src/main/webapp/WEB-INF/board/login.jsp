<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layout/header.jsp" %>
<center>
	<form action="login.do" method="post">
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="orange">아이디</td>
				<!-- value 하면 안되지만 귀찮아서 함-->
				<td><input type="text" name="id" value="neung" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">비밀번호</td>
				<td><input type="password" name="password" value="1234" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
</center>
<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layout/footer.jsp" %>