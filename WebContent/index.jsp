<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
	<h1>Welcome to the Brines shop!</h1>
	<%@include file="WEB-INF/pages/login.html"%>
	<br/>
	<form>
		<input type="hidden" name="taskName" value="ReadProduct" />
		<input type="submit" value="Show" formaction="controller"/>
		<br/>
		<input type="submit" value="Register product" formaction="formProduct.html"/>
		<input type="submit" value="Register user" formaction="formUser.jsp"/>
	</form>
	</body>
</html>