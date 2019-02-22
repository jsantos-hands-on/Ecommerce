<%@ page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="br.com.model.UserBean"
%>

<jsp:useBean id="user" class="br.com.model.UserBean" scope="request" />

<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<title>Retry...</title>
	</head>
	<body>
		<h1>User registration form:</h1>
		<%=user.getMistakes("result")%>
		<form action="UserProcessor.jsp" method="post">
			Login: <input type="text" name="login" value="${user.login}"/>
			<%=user.getMistakes("login")%>
			<br/>
			Password: <input type="password" name="password" value="${user.password}"/>
			<%=user.getMistakes("password")%>
			<br/>
			Name: <input type="text" name="name" value="${user.name}"/>
			<%=user.getMistakes("name") %>
			<br/>
			Date of birth: <input type="date" name="dateBirth" value="${user.dateBirth}"/>
			<%=user.getMistakes("dateBirth")%>
			<br/>
			<br/>
			Gender
			<br/> 
			male<input type="radio" name="gender" value="male"/>
			female<input type="radio" name="gender" value="female"/>
			<%=user.getMistakes("gender")%>
			<br/>
			<input type="submit" value="Save"/>
		</form>
	</body>
</html>