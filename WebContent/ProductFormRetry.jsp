<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="br.com.model.ProductBean"
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<jsp:useBean id="product" class="br.com.model.ProductBean" scope="request"/>
<html>
	<head>
	<meta charset="utf-8">
	<title>Retry...</title>
	</head>
	<body>
		<h1>Product registration!</h1>
		<form method="post">
		
			<input type="hidden" name="id" value="${product.id}"/>
			Name: <input type="text" name="name" value="${product.name}"/>
			<%=product.getMistakes("name")%>
			<br />
			Price: <input type="text" name="price" value="${product.price}"/>
			<%=product.getMistakes("price")%>
			<br />
			<c:if test="${product.id == -1}">
				<input type="submit" value="Save" formaction="ProductProcessor.jsp?taskName=CreatProduct"/>
			</c:if>
			<c:if test="${product.id != -1}">
				<input type="submit" value="Save" formaction="ProductProcessor.jsp?taskName=UpdateProduct"/>
			</c:if>
				<input type="reset" value="Clean">
			<input type="submit" value="Back" formaction="index.html">
		</form>
	</body>
</html>