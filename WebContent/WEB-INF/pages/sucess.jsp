<%@page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<jsp:useBean id="user" class="br.com.model.UserBean" scope="request" />

<DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<h1>Your action was a sucess!</h1>
		<%=user.getDateBirth()%>
	</body>
</html>	