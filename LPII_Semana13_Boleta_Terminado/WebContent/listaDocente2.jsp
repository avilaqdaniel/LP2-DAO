<jsp:include page="menu.jsp"/>
<!DOCTYPE html>
<%@page import="entidad.Docente"%>
<%@page import="java.util.List"%>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.min.css"/>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>

<title>Docente</title>
<style>
	.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 20px;
	}
</style> 
</head>
<body>
<div class="container">
<form id="id_registra" action="CrudDocente?operador=consulta" method="post" class="form-inline">
			  <div class="form-group">
			    <label for="id_nombre">Nombre</label>
			    <input type="text" class="form-control" id="id_sueldo" name="sueldo" placeholder="Ingresar sueldo">
			    <button type="submit" data-toggle='modal' class='btn btn-primary' id="validateBtnw2">Consulta</button>
			  </div>
</form>
</div>
<%
	List<Docente> lista=(List<Docente>) request.getAttribute("docentes");
%>
	<div class="container">
		<h3 align="center">Lista Docentes</h3>	
			<div id="divEmpleado">
		 								<table id="id_table" class="table table-striped table-bordered" >
												<thead>
														<tr>
															<th>Codigo</th>
															<th>Nombre</th>
															<th>Paterno</th>
															<th>Materno</th>
															<th>Sexo</th>
															<th>Hijos</th>
															<th>Sueldo</th>
														</tr>
												</thead>
												<tbody>
												
													<%
													if(lista!=null){
														for(Docente doc:lista){
													%>
											        <tr>
											            <td><%=doc.getCodigo()%></td>
											            <td><%=doc.getNombre()%></td>
											            <td><%=doc.getPaterno()%></td>
											            <td><%=doc.getMaterno()%></td>
											            <td><%=doc.getSexo()%></td>
											            <td><%=doc.getNumHijos()%></td>
											            <td><%=doc.getSueldo()%></td>
											        </tr>
											        <%
														}
													}
											        %>
												</tbody>
											</table>	
			</div>	
	</div>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#id_table').DataTable();
	} );
</script>
</body>
</html>












