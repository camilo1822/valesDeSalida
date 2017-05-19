<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<title>Salida de materiales</title>
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap1.css">	
	
	 <!-- JS -->
     <script src="resources/js/angular/angular.min.js"></script>
      <script src="resources/js/angular/app.js"></script>
      <script src="resources/js/angular/angular-ui-bootstrap-modal.js"></script>
      <script src="resources/js/jquery-1.11.3.min.js"></script>
      <script src="resources/js/jquery-ui.js"></script>
      <script src="resources/js/funciones.js"></script>
	  <script src="resources/js/bootstrap.min.js"></script>
	
	<body id="formVale" ng-app="validationApp" ng-controller="mainController">
		<header>
			<div id="logo">
				<div id="Custom_Logo">
					<img id="ctl00_x63829de2201a4365a3904788f682d0a3" src="resources/img/logo.png" alt="Back to Home">
				</div>
			</div>
			<section class="form-row">
				<section id="breadcrumb-client">
				    <div id="content-breadcrumb-client">			
						<a href="lista">			
						<span>Lista</span>
					</a>
					<a class="logout" onclick="logout()">			
						<span>DESCONECTARSE</span>
					</a>
					</div>
					<input type="text" id="credencial" name="credencial" value="${model.credencial}" style="display:none" readonly/>
                 <input type="text" id="credencialCorreo" name="credencialCorreo" value="${model.credencialCorreo}" style="display:none" readonly/>
				</section>
			</section>
		</header>
		<div class="relleno">
		</div>
		<div class="main-container">
		<section class="form-row">
			<h2 class="ms-rteElement-HeadingGreen">Salida de materiales y/o equipos
				<a href="#" title="&#191;C&oacute;mo registrar las &oacute;rdenes de salida?" target="_blank"> 
			    	<resources/img/ alt="alert" src="./resources/img//icon-ayuda.png"> 
			    </a>
			    <label class="label"><i>${model.fecha}</i></label>
			</h2>
			<div class="input-block col-quarter noVale">
						<label class="label">NÚMERO DE VALE:</label>
						<input id="valeNum" type="text" name="radicado" value="${model.vale.getIdVale()}" readonly/>
						        <style type="text/css">
  
								    .messages {
								      color: #FA787E;
								    }
								    form.ng-submitted input.ng-invalid{
								      border-color: #FA787E;
								    }
								    form input.ng-invalid.ng-touched {
								      border-color: #FA787E;
								    }

								  </style>

						
					</div> 
		</section>
		<form id="salidaMaterialesForm" name="salidaMaterialesForm" method="post" action="valeEditar" novalidate>
		    <input type="text" id="correoUsuario" name="correoUsuario" value="<%= request.getUserPrincipal() %>" Style="display:none"/>
      		<input type="text" id="descripcionUsuario" name="descripcionUsuario" value="" Style="display:none"/>
      		<input type="text" id="nameUsuario" name="nameUsuario" value="" Style="display:none"/>
      		<input type="text" id="plantaUsuario" name="plantaUsuario" value="" Style="display:none"/>
      		
      		<input type="text" id="correoFiltrado" value="${model.operacion.getUsuario().getEmail()}" Style="display:none"/>
			<section>
				<div class="form-row" id="formularioLoginVale">
					
					<div class="input-block col-quarter">
						<label class="label">Estado:</label>						
						<input type="text" value="${model.vale.getEstadoVale().getEstado()}" name="estado"  readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-quarter material">
						<label class="label">Material controlado en PICIZ:</label>
						<input type="text" name="contratadoEnPiciz" value="${model.vale.getMaterialPiciz()}" readonly/>
					</div>
					<span><div class="input-block col-quarter" ng-style="visible">
						<label class="label">Se&#241;ores:</label>						
						<input type="text" name="senhores" value="${model.vale.getPlanta()}" readonly/>
					</div></span>
				</div>
			<section>
			<span class="separator"></span>

			<section>
				<h3>Solicitud de salida</h3>
				<div class="form-row">
					<div class="input-block col-quarter material">
						<label class="label">Diligenciado / Autorizado por:</label>						
						<input type="text" name="autorizadoPor" value="${model.vale.getNombreDiligencio()}" readonly/>
					</div>
					<div class="input-block col-quarter">
						<label class="label">Motivo:</label>

						<input type="text" name="selectMotivo" value="${model.vale.getMotivo()}" readonly/>

					</div>
		

				</div>
			
				<div class="form-row">
					<div class="input-block col-full">
						<label class="label">Justificaci&oacute;n expl&iacute;cita de la salida:</label>
						<textarea name="justificacion" rows="7" readonly>${model.vale.getJustificacion()}</textarea>
					</div>
				</div>
			</section>
			<span class="separator"></span>

			<section>
				<h3>Solicitud de destino</h3>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Proveedor:</label>						
						<input type="text" name="codigo" value="${model.vale.getDestinoProveedor()}" />
						
					</div>
					<div class="input-block col-half izqui">
						<label class="label">Nit:</label>						
						<input type="text" name="nit" value="${model.vale.getDestinoNit()}" readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Empresa:</label>						
						<input type="text" name="empresa" value="${model.vale.getDestinoEmpresa()}" readonly/>
					</div>
					<div class="input-block col-half izqui">
						<label class="label">Direcci&oacute;n:</label>						
						<input type="text" name="direccion" value="${model.vale.getDestinoDireccion()}" readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Nombre contacto:</label>						
						<input type="text" name="nombreContacto" value="${model.vale.getDestinoNombre()}" readonly/>
					</div>
					<div class="input-block col-quarter trio">
						<label class="label">Tel&eacute;fono:</label>						
						<input type="text" name="telefonoContacto" value="${model.vale.getDestinoTel()}" readonly/>
					</div>
					<div class="input-block col-quarter trio2">
						<label class="label">Ciudad:</label>						
						<input type="text" name="ciudadContacto" value="${model.vale.getDestinoCiudad()}" readonly/>
					</div>
				</div>
			</section>
			<span class="separator"></span>

			<section>
			<h3>Datos de quien retira</h3>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Nombre:</label>						
						<input type="text" name="nombreRetira" value="${model.vale.getRetiraNombre()}" readonly/>
					</div>
					<div class="input-block col-half izqui">
						<label class="label">C.C:</label>						
						<input class="numeros" type="text" name="ccRetira" value="${model.vale.getRetiraIdentificacion()}" readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Empresa transporte:</label>						
						<input type="text" name="empresaTransporte" value="${model.vale.getRetiraEmpresa()}" readonly/>
					</div>
					<div class="input-block col-half izqui">
						<label class="label">Placa veh&iacute;culo:</label>						
						<input type="text" name="placaVehiculo" value="${model.vale.getRetiraPlaca()}" readonly/>
					</div>
				</div>
			</section>
			<span class="separator"></span>
			<div class="form-row">
				
			</div>
			<!--AquÃ­ va la tabla-->
			<section class="table-container">
			<h3>Materiales</h3>
			<div class="paginate 1">
				<table class="tablaDetalles">
					<thead>
						<tr>
							<th class="column-one">Nro. Fila</th>
							<th>Centro</th>
							<th>C&oacute;digo</th>
							<th>Descripci&oacute;n</th>
							<th>UM unidad de medida</th>
							<th>Cantidad</th>
							<th>Valor Unitario</th>
							<th>Valor estimado</th>
							<th>Peso(kg) si es controlado</th>
							<th>Regresa</th>
							<th>Pertenece a m&aacute;quina</th>
							<th>OC servicio</th>
							<th>OC adquisici&oacute;n</th>
							<th>Fecha esperada de regreso</th>
							<th ng-if="data.prorroga=='Si'">Comentario</th>
							<th class ="prorrogaTh" ng-if="data.prorroga=='Si'">Fecha de prorroga</th>							
							<th ng-if="data.prorroga=='Si'">Recibido</th>
							<th ng-if="data.prorroga=='Si'">Recibido Porteria</th>
							<th>Fecha final</th>	
							<!-- <th ng-if="data.prorroga=='Si'">Aprobado</th> -->
							<th id="campoAprobado">Aprobado</th>							
							<th ng-if="'${model.vale.getEstadoVale().getEstado()}'!='CERRADO'">Acciones</th>
						</tr>
					</thead>
					<tbody  class="items"> 
						<tr> 
						<c:forEach items="${model.detVales}" var="i">
							<tr>
							<td class="column-one"><input id="fila<c:out value="${i.getFila()}"/>" class="in-descri" type="text" value="<c:out value="${i.getFila()}"/>" readonly/></td>
							<td class="column-two"><input class="in-descri" type="text" value="<c:out value="${i.getCentro()}"/>" readonly/></td>
							<td class="column-two"><input class="in-descri" type="text" value="<c:out value="${i.getCodigo()}"/>" readonly/></td>
							<td class="column-three"><input id="descriList<c:out value="${i.getFila()}"/>" class="in-descri toolList" type="text" data-toggle="tooltip" title="" value="<c:out value="${i.getDescripcion()}"/>" readonly/></td>
							<td class="column-four"><input class="in-descri" type="text" value="<c:out value="${i.getUnidad()}"/>" readonly/></td>
							<td class="column-five"><input class="in-descri" type="text" value="<c:out value="${i.getCantidad()}"/>" readonly/></td>
							<td class="column-five"><input class="in-descri" type="text" value="<c:out value="${i.getValorUni()}"/>" readonly/></td>
							<td class="column-six"><input class="in-descri" type="text" value="<c:out value="${i.getValor()}"/>" readonly/></td>
							<td class="column-seven"><input class="in-descri" type="text" value="<c:out value="${i.getPeso()}"/>" readonly/></td>
							<td class="column-eight"><input class="in-descri" type="text" value="<c:out value="${i.getRegresa()}"/>" readonly/></td>
							<td class="column-nine"><input class="in-descri" type="text" value="<c:out value="${i.getPerteneceMaquina()}"/>" readonly/></td>
							<td class="column-ten"><input class="in-descri" type="text" value="<c:out value="${i.getNoOc()}"/>" readonly/></td>
							<td class="column-ten"><input class="in-descri" type="text" value="<c:out value="${i.getOcAd()}"/>" readonly/></td>
							<td class="column-eleven"><input class="in-descri fec" type="date" value="<c:out value="${i.getFechaEsperada()}"/>" readonly/></td>
							
							<td ng-if="data.prorroga=='Si'"><input type="button"  id="botCom<c:out value="${i.getFila()}"/>" class=""  ng-model="botCom<c:out value="${i.getFila()}"/>" onclick="coment('${i.getFila()}')"/>
              				<textarea id="textCom<c:out value="${i.getFila()}"/>" rows="" cols="" Style="display:none">${i.getComentario()}</textarea>
              				</td>
							
							<td ng-if="data.prorroga=='Si'" class="column-eleven">
							<input ng-if="'<c:out value="${i.getFechaProrroga()}"/>' == ''" id="fecProrroga<c:out value="${i.getFila()}"/>" class="fec datepicker" type="text" name="fecProrroga<c:out value="${i.getFila()}"/>" value="<c:out value="${i.getFechaProrroga()}"/>" readonly/>
							<input ng-if="'<c:out value="${i.getFechaProrroga()}"/>' != ''" id="fecProrroga<c:out value="${i.getFila()}"/>" class="fec in-descri" type="text" name="fecProrroga<c:out value="${i.getFila()}"/>" value="<c:out value="${i.getFechaProrroga()}"/>" readonly/>
							</td>  
							 				             				
              				<td ng-if="data.prorroga=='Si'"><input type="checkbox"  id="checkRecibido<c:out value="${i.getFila()}"/>" class="checkbox"  ng-model="chekRecibido<c:out value="${i.getFila()}"/>" ng-init="chekRecibido<c:out value="${i.getFila()}"/>=false" ng-change="mostrarFecha('${i.getFila()}','{{chekRecibido<c:out value="${i.getFila()}"/>}}')"/>
              				<a  ng-if="'<c:out value="${i.getFechaFinal()}"/>' != ''" class="recibido"></a>
              				<label ng-if="'<c:out value="${i.getFechaFinal()}"/>' == ''" for="checkRecibido<c:out value="${i.getFila()}"/>" class="elemento imgCheck imgCheckCond" id="checkRecibido<c:out value="${i.getFila()}"/>"/>
              				</td>
              				
              				
              				<td ng-if="data.prorroga=='Si'"><input type="checkbox"  id="checkRecibidoPort<c:out value="${i.getFila()}"/>" class="checkbox"  ng-model="chekRecibidoPort<c:out value="${i.getFila()}"/>" ng-init="chekRecibidoPort<c:out value="${i.getFila()}"/>=false" ng-change="mostrarPort('${i.getFila()}','{{chekRecibidoPort<c:out value="${i.getFila()}"/>}}')"/>
              				<a  ng-if="'<c:out value="${i.getPort()}"/>' != ''" class="recibido"></a>
              				<label ng-if="'<c:out value="${i.getPort()}"/>' == ''" for="checkRecibidoPort<c:out value="${i.getFila()}"/>" class="elemento imgCheck imgCheckCond" id="checkRecibidoPort<c:out value="${i.getFila()}"/>"/>
              				</td>
              				
              				
              				
							<td class="column-six"><input id="fecFinal<c:out value="${i.getFila()}"/>" class="in-descri" type="text" name="fecFinal<c:out value="${i.getFila()}"/>" value="fechaFinal<c:out value="${i.getFila()}"/>" ng-model="fechaFinal<c:out value="${i.getFila()}"/>" ng-init="fechaFinal<c:out value="${i.getFila()}"/>='<c:out value="${i.getFechaFinal()}"/>'" readonly/>
							<input  Style="Display:none" class="in-descri" type="text" name="fecFinali<c:out value="${i.getFila()}"/>" value="fechaFinali<c:out value="${i.getFila()}"/>" ng-model="fechaFinali<c:out value="${i.getFila()}"/>" ng-init="fechaFinali<c:out value="${i.getFila()}"/>='<c:out value="${i.getFechaFinal()}"/>'" readonly/>
							</td>
							
							<td class="column-six" style="display:none"><input id="fecFinalPort<c:out value="${i.getFila()}"/>" class="in-descri" type="text" name="fecFinalPort<c:out value="${i.getFila()}"/>" value="fechaFinalPort<c:out value="${i.getFila()}"/>" ng-model="fechaFinalPort<c:out value="${i.getFila()}"/>" ng-init="fechaFinalPort<c:out value="${i.getFila()}"/>='<c:out value="${i.getPort()}"/>'" readonly/>
							<input  Style="Display:none" class="in-descri" type="text" name="fecFinali<Port<c:out value="${i.getFila()}"/>" value="fechaFinaliPort<c:out value="${i.getFila()}"/>" ng-model="fechaFinaliPort<c:out value="${i.getFila()}"/>" ng-init="fechaFinaliPort<c:out value="${i.getFila()}"/>='<c:out value="${i.getPort()}"/>'" readonly/>
							</td>
							
							
							<!-- Aprobado -->
              				<!-- <td  ng-if="data.prorroga=='Si'"> -->
              				<td id="campoAprobado">
              				<input name="aprobado<c:out value="${i.getFila()}"/>" type="checkbox"  id="checkRecibido1<c:out value="${i.getFila()}"/>" class="enableAprobado" ng-model="chekRecibido1<c:out value="${i.getFila()}"/>" ng-change="recibido('{{chekRecibido1<c:out value="${i.getFila()}"/>}}','${i.getFila()}')"/>
              				<a  ng-if="'<c:out value="${i.getAprobado()}"/>' == 'Si'" class="recibido"></a>
              				<label for="checkRecibido1<c:out value="${i.getFila()}"/>" class="elemento imgCheck imgCheckCond"></label>             				
              				<input type="text" id="varRecibido<c:out value="${i.getFila()}"/>" ng-model="varRecibido<c:out value="${i.getFila()}"/>" Style="Display:none"/>
              				</td>
              				<!-- Fin Aprobado -->
							
							
							<td ng-if="'${model.vale.getEstadoVale().getEstado()}'!='CERRADO'" class="column-fifteen">
								
								<a class="edite" title="Editar" onclick="CallPicker()" ng-click="editarMaterial()"></a>
								<a id="sinPort<c:out value="${i.getFila()}"/>" class="save" title="Guardar" onclick="guardarMaterial(${i.getFila()})" ng-click="mensajeExito()"></a>
								<a id="conPort<c:out value="${i.getFila()}"/>" class="save" title="Guardar" onclick="guardarMaterial2(${i.getFila()})" ng-click="mensajeExito()"></a>

							</td>
							</tr>
							</c:forEach>
						</tr>
			
					</tbody>
				</table>
				 <div class="pager">
                  <div class="firstPage">&laquo;</div>
                  <div class="previousPage">Anterior</div>
                  <div class="pageNumbers"></div>
                  <div class="nextPage">Siguiente</div>
                  <div class="lastPage">&raquo;</div>
                </div>
                
                
				<script src="resources/js/jquery-1.11.3.min.js"></script>
				<script src="resources/js/paginga.jquery.min.js"></script>

				<script>
				        $(function() {
				        $(".paginate").paginga({
				          // use default options
				        });
				        
				        $(".paginate-page-2").paginga({
				          page: 2
				        });
				
				        $(".paginate-no-scroll").paginga({
				          scrollToTop: false
				        });
				      });
				</script>
				
			</section>
			<span class="separator"></span>
			<section>
				<div class="form-row">
					<div class="input-block col-full">
						<label class="label">Observaciones:</label>
						<textarea name="observaciones" rows="7" readonly><c:out value="${model.vale.getObservaciones()}"/></textarea>
					</div>
				</div>
			</section>
			<span class="separator"></span>
			<section>
				<div class="form-row">
					<div class="input-block col-quarter">
						<label class="label">Solicitante:</label>
						<input type="text" value="${model.vale.getSolicitante()}"name="solicitante" readonly/>
					</div>
					<div class="input-block col-quarter">
						<label class="label">Almac&eacute;n:</label>
						<input type="text" name="almacen"  value="${model.vale.getAlmacen()}" readonly/>
					</div>
					<div class="input-block col-quarter">
						<label class="label">Control porter&iacute;a:</label>
						<input type="text" name="controlPorteria" value="${model.vale.getPorteria()}" readonly/>
					</div>
					<div class="input-block col-quarter">
						<label class="label">Retira:</label>
						<input type="text" name="retira" value="${model.vale.getRetiraNombre()}" readonly/>
					</div>
				</div>
			</section>
			<!-- <section class="buttons">
				<br>
				<input type="submit" name="Guardar" value="Aprobar" class="submit" ng-click="submitForm()"/>
			</section> -->
				<input type="text" id="prueba" name="idFiltrado" value="${model.vale.getIdVale()}" Style="Display:none"/>
				<input type="number" id="numFilas" name="numFilas" value="" ng-init="filaCont='${model.numFila}'" Style="Display:none"/>			
				<h1  id="numFilass" Style="Display:none">{{filaCont}}</h1>
				

				<!-- <input type="submit" name="verPdf" value="verPdf"/> -->
		</form>
		
	<form id="generarPdf" name="generarPdf" method="post" action="verPdf">
	<section class="buttons">
			<!-- <input type="button" name="verPdf" value="Ver Pdf" class="pdf visualizar" onclick="pdf()"> -->
			<input type="button" name="verPdf" value="Ver Pdf" class="pdf visualizar" onclick="pdfBrowser()">
			<input type="text" id="prueba" name="idFiltrado" value="${model.vale.getIdVale()}" Style="Display:none"/>
	</section>
	
	 <!-- Modal comentario -->
       <div class="modal fade" id="modalRechazo" role="dialog">
         <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content ocultar">
	      <div><h3 id="titJustifi">Comentario</h3></div>        
         <div class="modal-header1 headerError errorJust">
            <textarea name="justificacionRechazo" id="justificacionRechazo" maxlength="1000" rows="7"></textarea>
         </div>
         <div>
         <input type="button" id="btnRecha" name="aceptarRechazo" value="Aceptar" class="submit2 rechazado" onclick="envComentario()"/>
        <input type="button" id="btnRecha" name="aceptarRechazo" value="Cancelar" class="submit2 rechazado" onclick="cerrarModalRechazado()"/>
         </div>
      </div>
         </div>
      </div>
      <!-- Fin modal comentario -->	
      <input type="text" id="idComentario" Style="display:none"/>
		</form>
		</div>
		
		
		<div modal="showModal2" close="cancel()" class="modalExito">
			<div class="cancelar">
			 	<button class="btnCancel" ng-click="okk()" onclick="recarga()"></button>
			</div>
			<div class="modal-header1">
			  	<h4>Se actualizaron los datos</h4>			          
			</div>			      
		</div>
		
		 <!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header headerLogin" style="padding:35px 50px;">
	          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
	        </div>
	        <div class="modal-body bodyLogin" id="bodyLogin" style="padding:40px 50px;">
	          <form role="form">
	            <div class="form-group">
	              <label for="usrname" class="labelLogin"><span class="glyphicon glyphicon-user"></span> Usuario:</label>
	              <input type="text" class="form-control inputLogin" id="usrname">
	            </div>
	            <div class="form-group">
	              <label for="psw" class="labelLogin"><span class="glyphicon glyphicon-eye-open"></span> Password:</label>
	              <input type="password" class="form-control inputLogin" id="psw">
	              <p id="verifiDatos" class="obligatorio" Style="display:none">Verifique sus datos</p>
	              <!-- <input type="text" class="form-control inputLogin" id="psw" placeholder="Enter password"> -->
	            </div>
	              <button type="submit" class="btn btn-success btn-block" onclick="valeDatos()"><span class="glyphicon glyphicon-off"></span> Login</button>
	          </form>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	      <!-- Fin modal login -->
	      
	      

</body>

</html>