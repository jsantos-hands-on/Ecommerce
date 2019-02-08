<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="br.com.model.ProductBean"
%>

<!DOCTYPE html>

<jsp:useBean id="product" class="br.com.model.ProductBean" scope="request"/>
<html>
	<head>
	<meta charset="utf-8">
	<title>Retry...</title>
	</head>
	<body>
		<h1>Product registration!</h1>
		<form action="ProductProcessor.jsp" method="post">
			Name: <input type="text" name="name" value="${product.name}"/>
			<%=product.getMistakes("name")%>
			<br />
			Price: <input type="text" name="price" value="${product.price}"/>
			<%=product.getMistakes("price")%>
			<br />
			<input type="submit" value="Save"/>
			<input type="reset" value="Clean">
			<input type="submit" value="Back" formaction="index.html">
		</form>
	</body>
</html>