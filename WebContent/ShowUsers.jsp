<%@ page 
language="java" 
contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show users...</title>
</head>
<body>
	${user.name} - ${user.gender}
	<form action="ShowUsers.jsp">
		Filter:
		<br/>
			Male<input type="radio" name="gender" value="male"/>
			Female<input type="radio" name="gender" value="famale"/>
		<br/>
			<input type="submit" value="Filter">
	</form>
</body>
</html>