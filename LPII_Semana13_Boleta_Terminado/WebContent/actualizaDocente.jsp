<jsp:include page="menu.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrapValidator.min.css"/>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
  
<script src="js/bootstrap.min.js"></script>
 <script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>




</head>
<body>
	<div class="container">
		<h1>Actualiza Docente</h1>
		<form id="id_registra" action="CrudDocente?operador=actualizar" method="post">
			  <input type="hidden" value="${requestScope.docente.codigo}" name="codigo">
			  <input type="hidden" value="${requestScope.docente.sexo}" id="idSexo">
			  <input type="hidden" value="${requestScope.docente.codDistrito}" id="idDistrito">
			  
			  <div class="form-group">
			    <label for="id_nombre">Nombre</label>
			    <input type="text" class="form-control" id="id_nombre" 
			    		name="nombre" placeholder="Ingresar nombre" value="${requestScope.docente.nombre }">
			  </div>
			  <div class="form-group">
			    <label for="id_paterno">Paterno</label>
			    <input type="text" class="form-control" id="id_paterno" 
			    		name="paterno" placeholder="Ingresar apellido paterno" value="${requestScope.docente.paterno }">
			  </div>
			  <div class="form-group">
			    <label for="id_materno">Materno</label>
			    <input type="text" class="form-control" id="id_materno" 
			    		name="materno" placeholder="Ingresar apellido materno" value="${requestScope.docente.materno }">
			  </div>
			  <div class="form-group">
			    <label for="id_sexo">Sexo</label>
			  	<select class="form-control" id="id_sexo" name="sexo">
				  <option value="">[Seleccione]</option>
				</select>
			  </div>
			  <div class="form-group">
			    <label for="id_hijos">Hijos</label>
			    <input type="text" class="form-control" id="id_hijos" 
			    		name="hijos" placeholder="Ingresar número de hijos" value="${requestScope.docente.numHijos }">
			  </div>
			  <div class="form-group">
			    <label for="id_sueldo">Sueldo</label>
			    <input type="text" class="form-control" id="id_sueldo" 
			    		name="sueldo" placeholder="Ingresar sueldo" value="${requestScope.docente.sueldo }">
			  </div>
			  <div class="form-group">
			  	<label for="id_sueldo">Fecha Nacimiento</label>
				  <div class='input-group date' id='divMiCalendario'>
	                      <input type='text' id="txtFecha" 
	                      	name="fecha" 
	                      	class="form-control"
	                      	value="${requestScope.docente.fecNacimiento}" />
	                      <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
	                      </span>
	              </div>
			  </div>
			  <div class="form-group">
			    <label for="id_distrito">Distrito</label>
			    <select class="form-control" id="id_distrito" name="distrito">
				  <option value="">[Seleccione]</option>
				</select>
			  </div>
			  <div class="form-group">
			    <label for="id_direccion">Dirección</label>
			    <input type="text" class="form-control" id="id_direccion" 
			    name="direccion" value="${requestScope.docente.direccion}" 
			    placeholder="Ingresar dirección">
			  </div>
			  <div style="text-align: center">
			  	<button type="submit" class="btn btn-primary">Registrar</button>
			  	<a href="CrudDocente?operador=listar"><button type="button" class="btn btn-danger">Cancelar</button></a>
			  </div>
		</form>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
	
	    $('#id_registra').bootstrapValidator({
	        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
			fields:{
				nombre:{
					validators:{
						notEmpty:{
							message: 'Ingresar nombre',
						},
						regexp:{
							regexp:/^[a-zA-Z\s\á\é\í\ó\s\ú\ñ\Á\É\Í\Ó\Ú\Ñ]+$/,
							message:'solo letras'
						}
					}
				},	
				paterno:{
					validators:{
						notEmpty:{
							message:'Ingresar apellido paterno'
						},
						regexp:{
							regexp:/^[a-zA-Z\s\á\é\í\ó\s\ú\ñ\Á\É\Í\Ó\Ú\Ñ]+$/,
							message:'solo letras apellido paterno'
						}
					}
				},
				materno:{
					validators:{
						notEmpty:{
							message:'Ingresar apellido materno'
						},
						regexp:{
							regexp:/^[a-zA-Z\s\á\é\í\ó\s\ú\ñ\Á\É\Í\Ó\Ú\Ñ]+$/,
							message:'solo letras apellido materno'
						}
					}
				},
				sexo:{
					validators:{
						notEmpty:{
							message:'Seleccione sexo'
						}
					}
				},
				hijos:{
					validators:{
						notEmpty:{
							message:'Ingresar número de hijos'
						},
						digits:{
							message:'Solo digito'
						},
						regexp:{
							regexp:/^((\d)||([1][0-5]))$/,
							message:'número de hijos hasta 15'
						}
					}
				},
				sueldo:{
					validators:{
						notEmpty:{
							message:'Ingresar sueldo'
						},
						regexp:{
							regexp:/^\d+\.\d{2}$/,
							message:'Sueldo real con dos decimales'
						}
					}
				},
				fecha:{
					validators:{
						notEmpty:{
							message:'Ingresar fecha de nacimiento'
						},
						date: {
	                        format: 'YYYY-MM-DD',
	                        message: 'fecha invalida'
	                    }
					}
				}
			}
	    });
	   
	    $('#txtFecha').on('click', function(e) {	
	        $('#id_registra').bootstrapValidator('revalidateField', 'fecha');
	        
	    });
	    $('#txtFecha').on('change', function(e) {	
	        $('#id_registra').bootstrapValidator('revalidateField', 'fecha');
	    });
	})
	</script>
  	<script type="text/javascript">
		function cargarDistrito(){
			//recuperar el valor de la caja idDistrito
			var idDis=$("#idDistrito").val();
			//variable para almacenar el valor de selected
			var seleccion="";
			$.getJSON("DistritoJSON",{},function(data){
				$.each(data,function(index,item){
					if(item.codigo==idDis)
						seleccion="selected";
					else
						seleccion="";
					
					$("#id_distrito").append("<option value='"+
								item.codigo+"' "+seleccion+">"+item.nombre+"</option>");
				})
			
			});
			
		}
		function cargarSexo(){
			var sexo=["Masculino","Femenino"];
			var sexoActual=$("#idSexo").val();
			var seleccion="";
			for(var i=0;i<2;i++){
				if(sexo[i]==sexoActual)
					seleccion="selected";
				else
					seleccion="";
				$("#id_sexo").append("<option value='"+sexo[i]+"' "+seleccion+">"+
									sexo[i]+"</option>");
			}
		}
		$(document).ready(function() {
			cargarDistrito();
			cargarSexo();
		})
	</script>


  
   <script src="js/moment.min.js"></script>
   <script src="js/bootstrap-datetimepicker.min.js"></script>
   <script src="js/bootstrap-datetimepicker.es.js"></script>
   <script type="text/javascript">
     $('#divMiCalendario').datetimepicker({
    	 format: 'YYYY-MM-DD'    
      });
   </script>
</body>
</html>