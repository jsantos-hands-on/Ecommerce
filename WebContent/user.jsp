<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
	<body>
		<%=request.getParameter("taskName")%>
		<br/>
		${user.login}
		<br/>
		${user.name}
	</body>
</html>