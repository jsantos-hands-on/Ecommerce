<%@page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<c:forEach items="${products}" var="product">
			<form method="post">
				${product}
				<input type="hidden" name="id" value="${product.id}" />
				<input type="submit" value="Edit" formaction="controller?UpdateProduct" />
				<input type="submit" value="Remove" formaction="controller?DeleteProduct" />
			</form>
			<br />
		</c:forEach>
		<input type="button" value="Back" onClick="history.go(-1)">
	</body>
</html>