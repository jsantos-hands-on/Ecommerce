<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
	<h1>Welcome to the Brines shop!</h1>
	<c:if test="${empty user}">
		<c:import url="WEB-INF/pages/login.html" />	
	</c:if>
	<c:if test="${not empty user}">
		<c:import url="accessing.jsp" />
	</c:if>	
	<br/>
	<form method="post">
		<input type="hidden" name="taskName" value="ReadProduct" />
		<input type="submit" value="Show" formaction="controller"/>
		<br/>
		<input type="submit" value="Register product" formaction="formProduct.html"/>
		<input type="submit" value="Register user" formaction="formUser.jsp"/>
	</form>
	</body>
</html>