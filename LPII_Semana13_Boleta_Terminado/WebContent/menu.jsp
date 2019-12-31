<!DOCTYPE html>
<%@page import="entidad.Menu"%>
<%@page import="java.util.List"%>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="css/bootstrap.min.css" rel="stylesheet"></link>
<title>Menu</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">GSCREATIVAS</a>
    </div>
    <ul class="nav navbar-nav">
      <%
      	//recuperar atributo permisos
      	List<Menu> data=(List<Menu>)session.getAttribute("permisos");
        for(Menu m:data){
      %>
      	<li><a href="<%=m.getUrl()%>"><%=m.getDescripcion() %></a></li>
      <%
        }
      %>
    </ul>
    <div style="color: white;float:right;padding-top: 20px " >
    	Usuario: 
    	<a href="">Cerrar</a>
    </div>
  </div>
</nav>
</body>
</html>




