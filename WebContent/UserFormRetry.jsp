<%@ page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<c:if test='<%=!request.getParameter("taskName").equals("EditUser")%>'>
			<input type="hidden" name="taskName" value="CreatUser" />
			Password: <input type="password" name="password" value="${user.password}"/>
			<%=user.getMistakes("password")%>
			<br/>
			</c:if>
			
			Name: <input type="text" name="name" value="${user.name}"/>
			<%=user.getMistakes("name") %>
			<br/>
			Date of birth: <input type="date" name="dateBirth" value="${user.dateBirth}"/>
			<%=user.getMistakes("dateBirth")%>
			<br/>
			<br/>
			Gender
			<br/> 
			male<input type="radio" name="gender" value="male" ${user.getGender().equals("male") ? "checked" : ""}/>
			female<input type="radio" name="gender" value="female" ${user.getGender().equals("female") ? "checked" : ""}/>
			<%=user.getMistakes("gender")%>
			<br/>
			<c:if test='<%=request.getParameter("taskName").equals("EditUser")%>'>
				<input type="hidden" name="taskName" value="UpdateUser" />
				<input type="hidden" name="id" value="${user.id}">
				<input type="hidden" name="password" value="${user.password}"/>
				<%=user.getMistakes("password")%>
				<br/>
				Password: <input type="password" name="tipedPassword" />
			</c:if>
			<br />
			<input type="submit" value="Edit password" formaction="NewPasswordForm.jsp">
			<br />
			<input type="submit" value="Save"/>
			<input type="submit" value="Back" formaction="index.jsp">
		</form>
	</body>
</html>