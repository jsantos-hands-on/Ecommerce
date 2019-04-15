<%@ page 
language="java" 
contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"
%>

<%@taglib prefix="ex" uri="WEB-INF/custom.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show products...</title>
</head>
<body>
	<ex:show whatType="120" />
	<c:forEach items="${products}" var="product">
		${product.name}
	</c:forEach>
</body>
</html>