<%@page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="br.com.model.ProductBean"
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
				<input type="hidden" name="name" value="${product.name}" />
				<input type="hidden" name="price" value="${product.price}" />
				<input type="submit" value="Edit" formaction="ProductProcessor.jsp" />
				<input type="submit" value="Remove" formaction="controller?taskName=DeleteProduct" />
			</form>
			<br />
		</c:forEach>
		<a href="index.html"> Home page</a>
	</body>
</html>