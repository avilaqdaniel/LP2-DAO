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
			<th></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.conceptos}" var="fila">
        <tr>
            <td>${fila.codigo}</td>
            <td>${fila.nombre}</td>
            <td>${fila.precio}</td>
            <td><a href="javascript:verDatosConcepto('${fila.codigo}','${fila.nombre}','${fila.precio}')"><img src="img/edit.gif"/></a></td>
        </tr>
     </c:forEach>
        
    </tbody>
</table>
</body>
</html>