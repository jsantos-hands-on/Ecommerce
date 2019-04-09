<%@ page 
language="java" 
contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="user" class="br.com.model.UserBean" scope="request" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Password processor...</title>
	</head>
	<body>
	<%=user.getPassword()%>
	${user.password}
	<c:choose>
		<c:when test='<%=request.getParameter("newPassword").equals(request.getParameter("newPasswordAgain"))%>'>
			<c:if test='<%=request.getParameter("tipedPassword").equals(user.getPassword())%>'>
				<%user.setPassword(request.getParameter("newPassword"));%>
				<c:if test="${user.passIsValid()}">
					<jsp:forward page="user.jsp" />
				</c:if>
			</c:if>
			<c:if test='<%=!request.getParameter("tipedPassword").equals(user.getPassword())%>'>
				<%user.setMistakes("password", "Wrong passwrod!");%>
				<jsp:forward page="NewPasswordForm.jsp" />
			</c:if>
		</c:when>
		<c:otherwise>
			<%user.setMistakes("password", "Passwords divergent!");%>
			<jsp:forward page="NewPasswordForm.jsp" />
		</c:otherwise>
	</c:choose>
	
	</body>
</html>