<%@ taglib prefix= "c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Docente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>CODIGO</th>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>CANTIDAD</th>
			<th>IMPORTE</th>
			<th></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.boleta }" var="fila">
        <tr>
            <td>${fila.codProducto }</td>
            <td>${fila.nomProducto }</td>
            <td>${fila.precio }</td>
            <td>${fila.cantidad }</td>
            <td>${fila.importe }</td>
        </tr>
     </c:forEach>
            
    </tbody>
</table>

</body>
</html>