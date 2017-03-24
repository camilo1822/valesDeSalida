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
	
	<body id="cuerpo" ng-app="validationApp" ng-controller="mainController">
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
					<input type="text" id="credencial" name="credencial" style="display:none" readonly/>
                 <input type="text" id="credencialCorreo" name="credencialCorreo" style="display:none" readonly/>
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
						<label class="label">N�MERO DE VALE:</label>
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
								  /*
								    form input.ng-valid.ng-touched {
								      border-color: #78FA89;
								    }
								  */  
								  </style>

						
					</div> 
		</section>
		<form id="salidaMaterialesForm2" name="salidaMaterialesForm" method="post" action="aprobar">
			<section>
				<div class="form-row" id="formularioLoginAprobar">
					
					<div class="input-block col-quarter">
						<label class="label">Estado:</label>						
						<input type="text" value="${model.vale.getEstadoVale().getEstado()}" name="estado"  readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-quarter">
						<label class="label">Material contratado en PICIZ:</label>
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
					<div class="input-block col-quarter">
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
			<!--Aquí va la tabla-->
			<section class="table-container">
			<h3>Materiales</h3>
			<div class="paginate 1">
				<table class="tablaDetalles">
					<thead>
						<tr>
							<th class="column-one">Nro. Fila</th>
							<th>C&oacute;digo</th>
							<th>Descripci&oacute;n</th>
							<th>UM unidad de medida</th>
							<th>Cantidad</th>
							<th>Valor Unitario</th>
							<th>Valor estimado</th>
							<th>Peso(kg) si es controlado</th>
							<th>Regresa</th>
							<th>Repuesto pertenece a m&aacute;quina</th>
							<th>No. OC servicio</th>
							<th>Fecha esperada de regreso</th>
							<th ng-if="data.prorroga=='Si'">Fecha de prorroga</th>
							<th ng-if="data.prorroga=='Si'">Recibido</th>
							<th>Fecha final</th>								
							<th ng-if="'${model.vale.getEstadoVale().getEstado()}'!='CERRADO'">Acciones</th>
						</tr>
					</thead>
					<tbody  class="items"> 
						<tr> 
						<c:forEach items="${model.detVales}" var="i">
							<tr>
							<td class="column-one"><input id="fila<c:out value="${i.getFila()}"/>" class="in-descri" type="text" value="<c:out value="${i.getFila()}"/>" readonly/></td>
							<td class="column-two"><input class="in-descri" type="text" value="<c:out value="${i.getCodigo()}"/>" readonly/></td>
							<td class="column-three"><input class="in-descri" type="text" value="<c:out value="${i.getDescripcion()}"/>" readonly/></td>
							<td class="column-four"><input class="in-descri" type="text" value="<c:out value="${i.getUnidadMedidaVale().getUnidadMedida()}"/>" readonly/></td>
							<td class="column-five"><input class="in-descri" type="text" value="<c:out value="${i.getCantidad()}"/>" readonly/></td>
							<td class="column-five"><input class="in-descri" type="text" value="<c:out value="${i.getValorUni()}"/>" readonly/></td>
							<td class="column-six"><input class="in-descri" type="text" value="<c:out value="${i.getValor()}"/>" readonly/></td>
							<td class="column-seven"><input class="in-descri" type="text" value="<c:out value="${i.getPeso()}"/>" readonly/></td>
							<td class="column-eight"><input class="in-descri" type="text" value="<c:out value="${i.getRegresa()}"/>" readonly/></td>
							<td class="column-nine"><input class="in-descri" type="text" value="<c:out value="${i.getPerteneceMaquina()}"/>" readonly/></td>
							<td class="column-ten"><input class="in-descri" type="text" value="<c:out value="${i.getNoOc()}"/>" readonly/></td>
							<td class="column-eleven"><input class="in-descri fec" type="date" value="<c:out value="${i.getFechaEsperada()}"/>" readonly/></td>
							<td ng-if="data.prorroga=='Si'" class="column-eleven"><input id="fecProrroga<c:out value="${i.getFila()}"/>" class="in-descri fec" type="date" name="fecProrroga<c:out value="${i.getFila()}"/>" value="<c:out value="${i.getFechaProrroga()}"/>" min="${model.fechaHoy }"/></td>
              				<td ng-if="data.prorroga=='Si'"><input type="checkbox"  id="checkRecibido<c:out value="${i.getFila()}"/>" class="checkbox"  ng-model="chekRecibido<c:out value="${i.getFila()}"/>" ng-init="chekRecibido<c:out value="${i.getFila()}"/>=false" ng-change="mostrarFecha('${i.getFila()}','{{chekRecibido<c:out value="${i.getFila()}"/>}}')"/>
              				<a  ng-if="'<c:out value="${i.getFechaFinal()}"/>' != ''" class="recibido"></a>
              				<label ng-if="'<c:out value="${i.getFechaFinal()}"/>' == ''" for="checkRecibido<c:out value="${i.getFila()}"/>" class="elemento imgCheck imgCheckCond" id="checkRecibido<c:out value="${i.getFila()}"/>"/>

              				</td>
							<td class="column-six"><input id="fecFinal<c:out value="${i.getFila()}"/>" class="in-descri" type="text" name="fecFinal<c:out value="${i.getFila()}"/>" value="fechaFinal<c:out value="${i.getFila()}"/>" ng-model="fechaFinal<c:out value="${i.getFila()}"/>" ng-init="fechaFinal<c:out value="${i.getFila()}"/>='<c:out value="${i.getFechaFinal()}"/>'" readonly/>
							<input  Style="Display:none" class="in-descri" type="text" name="fecFinali<c:out value="${i.getFila()}"/>" value="fechaFinali<c:out value="${i.getFila()}"/>" ng-model="fechaFinali<c:out value="${i.getFila()}"/>" ng-init="fechaFinali<c:out value="${i.getFila()}"/>='<c:out value="${i.getFechaFinal()}"/>'" readonly/>
							</td>
							<td ng-if="'${model.vale.getEstadoVale().getEstado()}'!='CERRADO'" class="column-fifteen">
								
								<a class="edite" title="Editar" ng-click="editarMaterial()"></a>
								<a class="save" title="Guardar" onclick="guardarMaterial(${i.getFila()})" ng-click="mensajeExito()"></a>

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
						<input type="text" name="almacen" id="almacenLogeado" readonly/>
					</div>

					<div class="input-block col-quarter">
						<label class="label">Retira:</label>
						<input type="text" name="retira" value="${model.vale.getRetiraNombre()}" readonly/>
					</div>
					
					<div class="input-block col-quarter">
                   		<label class="label">Porteria:</label>
	                   	<select class="lugarPorteria" id="lugarPorteria" ng-model="lugarPorteria" ng-change="listaAlmacenistas()" onchange="mailPorteria()">
						  <option value=""></option>
						  <option value="SalidaPorteriaCaloto">Caloto</option>
						  <option value="SalidaPorteriaMedPpal">Medell�n Principal</option>
						  <option value="SalidaPorteriaMedSur">Medell�n Sur</option>
						  <option value="SalidaPorteriaCajicaNorte">Cajica Norte</option>
						  <option value="SalidaPorteriaCajicaSur">Cajica Sur</option>
						  <option value="SalidaPorteriaCajicaPpal">Cajica Principal</option>
						  <option value="SalidaPorteriaCajicaZF">Cajica ZF</option>
						  <option value="SalidaPorteriaRionegro">Rionegro</option>
						  <option value="SalidaPorteriaEcuador">Ecuador</option>
						  <option value="SalidaPorteriaArgentinaWilde">Argentina</option>
						  <option value="SalidaPorteriaRepDom">Republica Dominicana</option>
						</select>
                  </div>
					
					<div class="input-block col-quarter">
                     <label class="label">Correo Porteria:</label>
                     <input class="correoObligatorio" id="correoObligatorio" type="text" name="correoPorteria" id="correoPorteria"/>
                     <p class="obligatorio obligatoriocorreoPorteria" style="display:none">Obligatorio</p>
                    <!--  <p class="obligatorio" ng-show="(salidaMaterialesForm2.correoPorteria.$invalid && show) || (salidaMaterialesForm2.correoPorteria.$invalid && salidaMaterialesForm2.correoPorteria.$touched)">Obligatorio</p> -->
                  </div>
				</div>
			</section>
			<section class="buttons">
				<br>
				<input type="button" name="Guardar" value="Aprobar" class="submit2" onclick="salidaAlm()"/>
				<!-- <input ng-if="salidaMaterialesForm2.$invalid" type="button" name="Guardar1" value="Aprobar" class="submit2 buttonSalida" ng-click="submitForm()"/>
				<input ng-if="!salidaMaterialesForm2.$invalid" type="button" id="Guardar" name="Guardar" value="Aprobar" class="submit2" onclick="salidaAlm()" ng-click="mensajeExito()"/> -->
			</section>
				<input type="text" id="prueba" name="idFiltrado" value="${model.vale.getIdVale()}" Style="Display:none"/>
				<input type="number" id="numFilas" name="numFilas" value="" ng-init="filaCont='${model.numFila}'" Style="Display:none"/>			
				<h1  Style="Display:none">{{filaCont}}</h1>
				

				<!-- <input type="submit" name="verPdf" value="verPdf"/> -->
			<input type="text" id="correoUsuario" name="correoUsuario" value="<%= request.getUserPrincipal() %>" Style="display:none"/>
      		<input type="text" id="descripcionUsuario" name="descripcionUsuario" value="" Style="display:none"/>
      		<input type="text" id="nameUsuario" name="nameUsuario" value="" Style="display:none"/>
      		<input type="text" id="plantaUsuario" name="plantaUsuario" value="" Style="display:none"/>
		</form>
		
	<form id="generarPdf" name="generarPdf" method="post" action="/familia/verPdf">
			<input type="button" name="verPdf" value="Ver Pdf" class="pdf visualizar" onclick="pdfBrowser()">
			<input type="text" id="prueba" name="idFiltrado" value="${model.vale.getIdVale()}" Style="Display:none"/>	
		</form>
		</div>
		
      
         <div class="modal fade" id="modalPorteria" role="dialog">
         <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
         <div class="cancelar">
            <button class="btnCancel" onclick="cerrarModalPorteria()"></button>
         </div>
         <div class="modal-header1 headerError">
            <h4>Vale Aprobado Exitosamente</h4>
                 </div>
      </div>
         </div>
      </div>
       <!-- Modal lista Aprobadores -->
      <div modal="showModal4" close="cancel()" class="modalLista" >
         <div class="modal-header modal-header2">
                     <h4>Porterias:</h4>
         </div>
         <div class="listaPorteros" style="overflow-y:scroll">
            
         </div>
         <div class="modal-footer">
             <button id="cerrarS" class="btn btn-success" ng-click="okk4()">Aceptar</button>
         </div>
      </div>
      <!-- Fina Aprobadores -->
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
	            </div>
	              <button type="submit" class="btn btn-success btn-block" onclick="aprobarDatos()"> Login</button>
	          </form>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  <!-- Fin modal login -->
      		    
</body>

</html>