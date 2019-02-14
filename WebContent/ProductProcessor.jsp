<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="br.com.model.ProductBean"
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
	<head>
	<meta charset="utf-8">
	<title>Processing...</title>
	</head>
	<body>
		<jsp:useBean id="product" class="br.com.model.ProductBean" scope="request">
			<jsp:setProperty name="product" property="id"/>
			<jsp:setProperty name="product" property="name"/>
			<jsp:setProperty name="product" property="price"/>
		</jsp:useBean>
		
		<c:if test="${product.isValid()}">
			<c:choose>
				<c:when test='<%= request.getParameter("taskName") != null %>'>
					<jsp:forward page="controller" />
				</c:when>
				<c:when test='<%= product.getId() == -1 %>'>
					<jsp:forward page="controller?taskName=CreatProduct" />
				</c:when>
			</c:choose>
		</c:if>
		
		<jsp:forward page="ProductFormRetry.jsp" />
	</body>
</html>