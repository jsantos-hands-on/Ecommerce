<%@page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<title>User form</title>
	</head>
	<body>
		<h1>User registration form:</h1>
		<form action="UserProcessor.jsp" method="post">
			Login: <input type="text" name="login"/>
			<br/>
			Password: <input type="password" name="password"/>
			<br/>
			Name: <input type="text" name="name"/>
			<br/>
			Date of birth: <input type="date" name="dateBirth"/>
			<br/>
			<br/>
			Gender
			<br/> 
			male<input type="radio" name="gender" value="male"/>
			female<input type="radio" name="gender" value="female"/>
			<br/>
			<input type="submit" value="Save"/>
		</form>
	</body>
</html>