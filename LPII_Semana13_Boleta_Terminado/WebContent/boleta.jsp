<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>

<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<title>Boleta</title>
<script>
            $(document).ready(function() {                        
          		$("#btnBuscarAlumno").click(function(){
          			var apellido=$("#idBuscarApellido").val();
          			$("#divAlumno").load("ServletBoleta?tipo=buscarApellido&apellido="+apellido);
          			//$("#divAlumno").load("listaAlumno.jsp");
          		});
          		$("#btnBuscarConcepto").click(function(){
          			var nombre=$("#idNomConcepto").val();
          			//$("#divConcepto").load("listaConcepto.jsp");
          			$("#divConcepto").load("ServletBoleta?tipo=buscarConcepto&nombre="+nombre);
          		});
          		$("#btnAdicionar").click(function(){
          			var cod,nom,pre,can;
          			cod=$("#idCodigo").val();
                	nom=$("#idDescripcion").val();
                	pre=$("#idPrecio").val();
                	can=$("#idCantidad").val();
          			$("#divDetalle").load("ServletBoleta?tipo=adicionar&codigo="+cod+
          								 "&nombre="+nom+"&precio="+pre+"&cantidad="+can);
          		});
          		
          		
            });
            function verDatosAlumno(cod,nom,ape){
            	$("#idAlumno").val(cod);
            	$("#idNombre").val(nom);
            	$("#idApellido").val(ape);
            	$('#idModalBuscarAlumno').modal("hide");
            }
            function verDatosConcepto(cod,nom,pre){
            	$("#idCodigo").val(cod);
            	$("#idDescripcion").val(nom);
            	$("#idPrecio").val(pre);
            	$('#idModalBuscarConcepto').modal("hide");
            }
            function modalBuscarAlumno(){	
        		$('#idModalBuscarAlumno').modal("show");
        	}
            function modalBuscarConcepto(){	
        		$('#idModalBuscarConcepto').modal("show");
        	}
        </script>
</head>
<body>
	<div class="container">
			<div class="modal-dialog" style="width: 100%">
				<div class="modal-content">
					<div class="modal-header" style="padding: 5px 20px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Boleta</h4>
					</div>
				<div class="modal-body" style="padding: 20px 10px;">
					<form id="idRegistra" accept-charset="UTF-8" class="form-inline" method="post" action="ServletBoleta?tipo=grabar">	
		                    <div class="panel panel-default">
		                            <div class="panel-heading" style="text-align: center;font-size: 14px">
		                               ALUMNO
		                            </div>
	
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Codigo</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idAlumno" name="codigoAlumno" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idNombre" name="nombre" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <button type="button" data-toggle='modal' onclick="modalBuscarAlumno();"  
												class='btn btn-primary' id="validateBtnw2" >Buscar Alumno</button><br>&nbsp;<br>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Apellido</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idApellido" name="apellidoAlumno" readonly="readonly" />
		                                        </div>
		                                    </div>
		                           
		                  		</div>
		                  </div>	
		                  
		                  <div class="panel panel-default">
		                            <div class="panel-heading" style="text-align: center;font-size: 14px">
		                               CONCEPTO
		                            </div>
		                                <div class="panel-body">
		                               
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Codigo</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idCodigo" name="codigo" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idDescripcion" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                    	<div class="col-lg-5">
				                                    <button type="button" data-toggle='modal' onclick="modalBuscarConcepto();"  
														class='btn btn-primary' id="validateBtnw2" >Buscar Concepto</button>
												</div>		
											</div><p>		
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Precio</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idPrecio" readonly="readonly" />
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Cantidad</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idCantidad"/>
		                                        </div>
		                                    </div>
		                                     <div class="form-group">
		                                     	<div class="col-lg-5">
				                                    <button type="button" data-toggle='modal'   
														class='btn btn-primary' id="btnAdicionar" >Adicionar</button>
												</div>		
											</div>	
		                              
		                  		</div>
		                  </div>	
		                  
		                   <div class="panel panel-default">
		                            <div class="panel-heading" style="text-align: center;font-size: 14px">
		                               DETALLE
		                            </div>
		                                <div class="panel-body">
		                                	<div id="divDetalle">
						 								<table id="id_tableDetalle" class="table table-striped table-bordered" >
																<thead>
																		<tr>
																			<th>Codigo</th>
																			<th>Nombre</th>
																			<th>Precio</th>
																			<th>Cantidad</th>
																			<th>Importe</th>
																		</tr>
																</thead>
																<tbody>
																
																</tbody>
															</table>											
											</div>
		                  				</div>
		                  				<div class="modal-footer" style="padding: 5px 20px; text-align:center">
											<button type="submit" class="btn btn-primary">Registrar Boleta</button>
										</div>
		                  </div>	
		                  </form> 
				 		</div>
				 	</div>
				 </div>              	               
	</div>
	
	<!-- INICIO DIV CONSULTA ALUMNO -->
	 <div class="modal fade" id="idModalBuscarAlumno" >
				<div class="modal-dialog" style="width: 50%">
					<!-- Modal content-->
					<div class="modal-content">
					<div class="modal-header" style="padding: 5px 20px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Buscar Alumno</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="idRegistra" accept-charset="UTF-8"  class="form-inline"
								 method="post">						
			                    <div class="panel-group" id="steps">
			                        <!-- Step 1 -->
			                        <div class="panel panel-default">
			                            <div class="panel-heading" style="text-align: center;font-size: 14px">
			                               
			                            </div>
			                                <div class="panel-body">
			                                    <div class="form-group">
			                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Apellido</label>
			                                        <div class="col-lg-5">
														<input class="form-control" id="idBuscarApellido"/>
			                                        </div>
			                                    </div>
			                                
												<button type="button" class="btn btn-primary" id="btnBuscarAlumno">Buscar</button><p>
											
													<div id="divAlumno">
						 								<table id="id_tableAlumno" class="table table-striped table-bordered" >
																<thead>
																		<tr>
																			<th>Codigo</th>
																			<th>Nombre</th>
																			<th>Apellido</th>
																			<th></th>
																		</tr>
																</thead>
																<tbody>
																
																</tbody>
															</table>											
													</div>
			                                </div>		                        
			                  		</div>
			                  </div>
			            </form>      
					</div>
				</div>
			</div>
	  </div>
	<!-- FIN DIV CONSULTA ALUMNO -->

	<!-- INICIO DIV CONSULTA CONCEPTO -->
	 <div class="modal fade" id="idModalBuscarConcepto" >
				<div class="modal-dialog" style="width: 50%">
					<!-- Modal content-->
					<div class="modal-content">
					<div class="modal-header" style="padding: 5px 20px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Buscar Concepto</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="idRegistra" accept-charset="UTF-8" class="form-inline"
								 method="post">						
			                    <div class="panel-group" id="steps">
			                        <!-- Step 1 -->
			                        <div class="panel panel-default">
			                            <div class="panel-heading" style="text-align: center;font-size: 14px">
			                               
			                            </div>
			                                <div class="panel-body">
			                                    <div class="form-group">
			                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
			                                        <div class="col-lg-5">
														<input class="form-control" id="idNomConcepto"/>
			                                        </div>
			                                    </div>
			                                
												<button type="button" class="btn btn-primary" id="btnBuscarConcepto">Buscar</button><p>
											
													<div id="divConcepto">
						 								<table id="id_tableConcepto" class="table table-striped table-bordered" >
																<thead>
																		<tr>
																			<th>Codigo</th>
																			<th>Nombre</th>
																			<th>Precio</th>
																			<th></th>
																		</tr>
																</thead>
																<tbody>
																
																</tbody>
															</table>											
													</div>
			                                </div>		                        
			                  		</div>
			                  </div>
			            </form>      
					</div>
				</div>
			</div>
	  </div>
	<!-- FIN DIV CONSULTA CONCEPTO -->

</body>
</html>












