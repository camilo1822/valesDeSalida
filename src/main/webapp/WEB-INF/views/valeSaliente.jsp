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
	
	<body ng-app="validationApp" ng-controller="mainController">
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
					</div>
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
						<input type="text" id="numeroDeVale" name="radicado" value="${model.vale.getIdVale()}" readonly/>
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
		<form id="salidaMaterialesForm2" class="porteria" name="salidaMaterialesForm" method="post" action="valeSaliente">

			<section>
				<div class="form-row">
					
					<div class="input-block col-quarter">
						<label class="label">Estado:</label>						
						<input type="text" value="${model.vale.getEstadoVale().getEstado()}" name="estado"  readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-quarter">
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
					<div class="input-block col-half">
						<label class="label">Nit:</label>						
						<input type="text" name="nit" value="${model.vale.getDestinoNit()}" readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Empresa:</label>						
						<input type="text" name="empresa" value="${model.vale.getDestinoEmpresa()}" readonly/>
					</div>
					<div class="input-block col-half">
						<label class="label">Direcci&oacute;n:</label>						
						<input type="text" name="direccion" value="${model.vale.getDestinoDireccion()}" readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Nombre contacto:</label>						
						<input type="text" name="nombreContacto" value="${model.vale.getDestinoNombre()}" readonly/>
					</div>
					<div class="input-block col-quarter">
						<label class="label">Tel&eacute;fono:</label>						
						<input type="text" name="telefonoContacto" value="${model.vale.getDestinoTel()}" readonly/>
					</div>
					<div class="input-block col-quarter">
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
					<div class="input-block col-half">
						<label class="label">C.C:</label>						
						<input class="numeros" type="text" name="ccRetira" value="${model.vale.getRetiraIdentificacion()}" readonly/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-block col-half">
						<label class="label">Empresa transporte:</label>						
						<input type="text" name="empresaTransporte" value="${model.vale.getRetiraEmpresa()}" readonly/>
					</div>
					<div class="input-block col-half">
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
							<th>Repuesto pertenece a m&aacute;quina</th>
							<th>OC servicio</th>
							<th>OC adquisici&oacute;n</th>
							<th>Fecha esperada de regreso</th>
							<th>Fecha final</th>
						</tr>
					</thead>
					<tbody  class="items"> 
						<tr> 
						<c:forEach items="${model.detVales}" var="i">
							<tr>
							<td class="column-one"><input class="in-descri" type="text" value="<c:out value="${i.getFila()}"/>" readonly/></td>
							<td class="column-two"><input class="in-descri" type="text" value="<c:out value="${i.getCentro()}"/>" readonly/></td>
							<td class="column-two"><input class="in-descri" type="text" value="<c:out value="${i.getCodigo()}"/>" readonly/></td>
							<td class="column-three"><input class="in-descri" type="text" value="<c:out value="${i.getDescripcion()}"/>" readonly/></td>
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
							<td class="column-eleven"><input class="in-descri fec" type="date" value="<c:out value="${i.getFechaFinal()}"/>" readonly/></td>
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
						<textarea name="observaciones"  rows="7" readonly><c:out value="${model.vale.getObservaciones()}"/></textarea>
					</div>
				</div>
			</section>
			<span class="separator"></span>
			<section>
				<div class="form-row">
					<div class="input-block col-quarter">
						<label class="label">Solicitante:</label>
						<input type="text" value="${model.vale.getSolicitante()}" name="solicitante" readonly/>
					</div>
				<div class="input-block col-quarter">
						<label class="label">Control porter&iacute;a:</label>
						<input ng-if="'${model.vale.getPorteria()}'!=''" type="text" value="${model.vale.getPorteria()}" readonly/>
						<input ng-if="'${model.vale.getPorteria()}'==''" type="text" id="firmaPorteria" name="controlPorteria" ng-model="vale.controlPorteria" ng-model-options="{ updateOn: 'blur' }" required/>
						<p class="obligatorio" ng-show="(salidaMaterialesForm.controlPorteria.$invalid && show) || (salidaMaterialesForm.controlPorteria.$invalid && salidaMaterialesForm.controlPorteria.$touched)">Obligatorio</p>
					</div>
				</div>
				
			</section>
			<section class="buttons">
				<br>
					<!-- Guardar -->
					<input ng-if="salidaMaterialesForm.$invalid" type="button" name="Guardar1" value="Guardar" class="submit2 buttonSalida" ng-click="submitForm()"/>
					<input ng-if="!salidaMaterialesForm.$invalid" type="button" id="Guardar" name="Guardar" value="Guardar" class="submit2" onclick="salidaPort()" ng-click="mensajeExito()"/>
					<!-- Guardar -->
					<a href="lista">
					<input type="button" name="Guardar1" value="Ver Lista" class="submit verLista"/>
					</a>				
			</section>	
				<h1  Style="Display:none">{{filaCont}}</h1>
				<input type="text" id="getPorteria" name="getPorteria" value="${model.vale.getPorteria()}" Style="Display:none"/>
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
	</body>

</html>