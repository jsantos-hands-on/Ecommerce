<%@ page 
language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
	<meta charset="utf-8">
	<title>User processor...</title>
	</head>
	<body>
		<jsp:useBean id="user" class="br.com.model.UserBean" scope="request">
			<jsp:setProperty name="user" property="id" />
			<jsp:setProperty name="user" property="login" />
			<jsp:setProperty name="user" property="password" />
			<jsp:setProperty name="user" property="name" />
			<jsp:setProperty name="user" property="dateBirth" />
			<jsp:setProperty name="user" property="gender" />
		</jsp:useBean>
		
		<c:choose>
			<c:when test='<%=request.getParameter("taskName").equals("CreatUser")%>'>
				<c:if test="${user.isValid()}">
					<c:if test="${user.passIsValid()}">
						<jsp:forward page="controller?taskName=CreatUser" />
					</c:if>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test='<%=request.getParameter("tipedPassword").equals(user.getPassword())%>'>
					<c:choose>
						<c:when test="${user.isValid()}">
							<jsp:forward page="controller?taskName=UpdateUser" />
						</c:when>
						<c:otherwise>
							<jsp:forward page="UserFormRetry.jsp" />
						</c:otherwise>
					</c:choose>
				</c:if>
				<%user.setMistakes("password", "Wrong password!");%>
				<jsp:forward page="UserFormRetry.jsp?taskName=EditUser" />
			</c:otherwise>
		</c:choose>
		
			<jsp:forward page="UserFormRetry.jsp" />
	</body>
</html>