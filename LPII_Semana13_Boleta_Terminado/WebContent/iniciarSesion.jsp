<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="css/bootstrap.min.css" rel="stylesheet"></link>
 
<link href="css/bootstrapValidator.min.css" rel="stylesheet"></link>

<script src="js/jquery.min.js"></script>
 
<script src="js/bootstrap.min.js"></script>
 
<script src="js/bootstrapValidator.min.js"></script>
 
<script type="text/javascript" src="js/validator.js"></script>

<title>Iniciar Sesion</title>
<script>
   $(document).ready(function()
   {
      $("#loginModal").modal("show");
   });
</script>
</head>

<body>
<%
	//recuperar el atributo msg
	String mensaje=(String)request.getAttribute("msg");
	if(mensaje==null)
		mensaje="";
	
%>


<div class="loginbtn" align="center" style="margin:100px;">
 
<button type="button" class="btn btn-default" data-toggle="modal" data-target="#loginModal">
 
<span class="glyphicon glyphicon-log-in"></span> Formulario de Login</button>
 
</div>
 
 
<div class="modal fade" id="loginModal"   tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 
<div class="modal-dialog">
 
	 <div class="modal-content">
 
		 <div class="modal-header">
 
			 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
 
			 <h4 class="modal-title">Inicio de Sesión</h4>
 
		 </div>
 
 
		 <div class="modal-body">
 
			 <form id="loginForm" method="post" class="form-horizontal" action="ServletUsuario?tipo=sesion">
 
				 <div class="form-group">
 
					 <label class="col-md-3 control-label">Usuario</label>
 
					 <div class="col-md-7">
 
						 <input type="text" class="form-control" name="login" />
 
					 </div>
 
				 </div>
 
				 <div class="form-group">
 
		 			<label class="col-md-3 control-label">Clave</label>
 
					 <div class="col-md-7">
 
						 <input type="password" class="form-control" name="clave" />
 
					 </div>
 
				 </div>
 
				 <div class="form-group">
 
					 <div class="col-md-5 col-md-offset-3">
 
						 <button type="submit" class="btn btn-default">Iniciar Sesión</button>
 
					 </div>
 					<font color="red"><%=mensaje%></font>
				 </div>
 
			 </form>
 
		 </div>
 
	 </div>
 
</div>
 
</div>

</body>
</html>




