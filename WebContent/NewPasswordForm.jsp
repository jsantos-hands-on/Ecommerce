<%@ page 
language="java" 
contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"
%>

<jsp:useBean id="user" class="br.com.model.UserBean" scope="request" />

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New password...</title>
	</head>
	<body>
		<%request.setAttribute("user", user);%>
		<form action="controller?taskName=EditUser" method="post">
			<%=user.getMistakes("password")%>
			<input type="hidden" name="taskKey" value="password" />
			<br />
			New password: <input type="password" name="newPassword" />
			<br />
			New password again: <input type="password" name="newPasswordAgain" />
			<br />
			Old password: <input type="password" name="tipedPassword" />
			<br />
			<input type="submit" value="Save" />
		</form>
	</body>
</html>