<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
			<title>Salida de materiales</title> <!-- CSS -->
			<link rel="stylesheet" type="text/css"
				href="resources/css/styles.css">
				<link rel="stylesheet" type="text/css"
					href="resources/css/bootstrap/bootstrap1.css">
					<!-- JS -->
					<script src="resources/js/angular/angular.min.js"></script>
					<script src="resources/js/angular/app.js"></script>
					<script src="resources/js/angular/angular-ui-bootstrap-modal.js"></script>
					<script src="resources/js/jquery-1.11.3.min.js"></script>
					<script src="resources/js/jquery-ui.js"></script>
					<script src="resources/js/funciones.js"></script>
					<script src="resources/js/bootstrap.min.js"></script>


					<body id="cuerpo" ng-app="validationApp"
						ng-controller="mainController" class="blockInspect">
						
						<!-- Evitar inspección -->
						<script language="Javascript">
							document.oncontextmenu = function() {
								return false
							}
						</script>
						
						<header>
						<div id="logo">
							<div id="Custom_Logo">
								<a href="/proveedores/"><img
									id="ctl00_x63829de2201a4365a3904788f682d0a3"
									src="resources/img/logo.png" alt="Back to Home"></a>
							</div>
						</div>
						<section class="form-row"> <section
							id="breadcrumb-client">
						<div id="content-breadcrumb-client">
							<a href="lista"> <input class="botonHome" type="button"
								id="redirect" name="redirect" value="Ver Lista" class="submit" />
							</a> <a class="logout" onclick="logout()"> <span>DESCONECTARSE</span>
							</a> <input type="text" id="credencial" name="credencial"
								style="display: none" readonly /> <input type="text"
								id="credencialCorreo" name="credencialCorreo"
								style="display: none" readonly />
						</div>
						</section> </section> </header>
						<div class="relleno"></div>
						<div class="main-container">
							<section class="form-row">
							<h2 class="ms-rteElement-HeadingGreen">
								Salida de materiales y/o equipos <a href="#"
									title="&#191;C&oacute;mo registrar las &oacute;rdenes de salida?"
									target="_blank"> <resources /img/ alt="alert"
										src="./resources/img//icon-ayuda.png"></a>
								<!-- <label class="label"><i>22 de agosto de 2016, 12:00m</i></label> -->
								<label class="label"><i>${model.fecha}</i></label>
							</h2>
							<div class="input-block col-quarter noVale" id="solicita">
								<label class="label">NÚMERO DE VALE:</label> <input type="text"
									id="radicado" name="radicado" value="${model.numVale}" readonly />
								<input type="text" id="isSolicitante" name="isSolicitante"
									value="${model.esSolicitante}" style="display: none" />
								<style type="text/css">
.messages {
	color: #FA787E;
}

form.ng-submitted input.ng-invalid {
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
							<form id="salidaMaterialesForm" name="salidaMaterialesForm"
								method="post" action="vale" novalidate>
								<section>
								<div class="form-row" id="formularioLogin">
									<div class="input-block col-quarter">
										<label class="label">Estado:</label> <input type="text"
											value="${model.estado}" name="estado" readonly />
									</div>
								</div>
								<div class="form-row">
									<div class="input-block col-quarter">
										<label class="label">Material controlado en PICIZ:</label> <select
											id="controladoPiciz" name="contratadoEnPiciz"
											name="singleSelect" ng-model="data.singleSelect">
											<option value="No">No</option>
											<option value="Si">Si</option>
										</select>
									</div>
									<span ng-if="data.singleSelect=='Si'">
										<div class="input-block col-quarter" ng-style="visible">
											<label class="label">Se&#241;ores:</label> <input type="text"
												name="senhores" ng-model="vale.senhores"
												ng-model-options="{ updateOn: 'blur' }" required />
											<p class="obligatorio"
												ng-show="salidaMaterialesForm.senhores.$invalid && salidaMaterialesForm.senhores.$touched">Obligatorio</p>
										</div>
									</span>
								</div>
								<section> <span class="separator"></span> <section>
								<h3>Solicitud de salida</h3>
								<div class="form-row">
									<div class="input-block col-quarter">
										<label class="label"><span class="obligatio">*</span>Diligenciado
											/ Autorizado por:</label> <input type="text" id="diligenciadoPor"
											name="autorizadoPor" ng-model="vale.autorizadoPor" />
										<!--                      <p class="obligatorio" ng-show="(salidaMaterialesForm.autorizadoPor.$invalid && show) || (salidaMaterialesForm.autorizadoPor.$invalid && salidaMaterialesForm.autorizadoPor.$touched)">Obligatorio</p>
 -->
									</div>
									<div class="input-block col-quarter">
										<label class="label respon"><span class="obligatio">*</span>Motivo:</label>
										<select name="selectMotivo" ng-model="data.selectMotivo"
											ng-model-options="{ updateOn: 'blur' }" required>
											<c:forEach items="${model.motivos}" var="i">
												<option value=<c:out value="${i}"/>>
													<c:out value="${i}" />
												</option>
											</c:forEach>
										</select>
										<p class="obligatorio"
											ng-show="(salidaMaterialesForm.selectMotivo.$invalid && show) || (salidaMaterialesForm.selectMotivo.$invalid && salidaMaterialesForm.selectMotivo.$touched)">Obligatorio</p>
									</div>
									<span ng-if="data.selectMotivo=='Otro'">
										<div class="input-block col-half">
											<label class="label respon">Otro - &#191;Cu&aacute;l?</label>
											<input type="text" name="cual" ng-model="vale.cual"
												ng-model-options="{ updateOn: 'blur' }" required />
											<p class="obligatorio"
												ng-show="salidaMaterialesForm.cual.$invalid && salidaMaterialesForm.cual.$touched">Obligatorio</p>
										</div>
									</span>
								</div>
								<div class="form-row">
									<div class="input-block col-full">
										<label class="label">Justificaci&oacute;n
											expl&iacute;cita de la salida:</label>
										<textarea name="justificacion"
											ng.model="material.justificacion" maxlength="1000" rows="7"
											ng-model-options="{ updateOn: 'blur' }" required></textarea>
										<p class="obligatorio"
											ng-show="(salidaMaterialesForm.justificacion.$invalid && show) || (salidaMaterialesForm.justificacion.$invalid && salidaMaterialesForm.justificacion.$touched)">Obligatorio</p>
									</div>
								</div>
								</section> <span class="separator"></span> <section>
								<h3>Solicitud de destino</h3>
								<div class="form-row">
									<div class="input-block col-half">
										<div class="input-interno">
											<label class="label"><span class="obligatio">*</span>Proveedor:</label>
											<input class="input-lupa obligatoriedad" type="text"
												id="codProveedor" name="proveedorId" ng-model="vale.codigo" />
											<img class="imgLupa" src="resources/img/lupa.png"
												alt="Buscar" onclick="obtenerProveedor()" />
											<p class="obligatorio obligatoriocodProveedor"
												style="display: none">Obligatorio</p>
											<!--                         <p class="obligatorio lupa" ng-show="(salidaMaterialesForm.proveedorId.$invalid && show) || (salidaMaterialesForm.proveedorId.$invalid && salidaMaterialesForm.proveedorId.$touched)">Obligatorio</p>
 -->
										</div>
									</div>
									<div class="input-block col-half izqui">
										<div class="input-interno">
											<label class="label"><span class="obligatio">*</span>Nit:</label>
											<input class="input-lupa numerico obligatoriedad" id="nitSAP"
												type="number" name="nit" ng-model="vale.nit" /> <img
												class="imgLupa" src="resources/img/lupa.png" alt="Buscar"
												onclick="mostrarListaNit()" ng-click="listaMensajes()" />
											<p class="obligatorio obligatorionitSAP"
												style="display: none">Obligatorio</p>
											<!--                         <p class="obligatorio lupa" ng-show="(salidaMaterialesForm.nit.$invalid && show) || (salidaMaterialesForm.nit.$invalid && salidaMaterialesForm.nit.$touched)">Obligatorio</p>
 -->
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="input-block col-half">
										<div class="input-interno">
											<label class="label"><span class="obligatio">*</span>Empresa:</label>
											<input class="input-lupa obligatoriedad" type="text"
												name="empresa" id="nombreSAP" ng-model="vale.empresa" /> <img
												class="imgLupa" src="resources/img/lupa.png" alt="Buscar"
												onclick="mostrarLista()" ng-click="listaMensajes()" />
											<p class="obligatorio obligatorionombreSAP"
												style="display: none">Obligatorio</p>
											<!--                         <p class="obligatorio lupa1" ng-show="(salidaMaterialesForm.empresa.$invalid && show) || (salidaMaterialesForm.empresa.$invalid && salidaMaterialesForm.empresa.$touched)">Obligatorio</p>
 -->
										</div>
									</div>
									<div class="input-block col-half izqui">
										<label class="label"><span class="obligatio">*</span>Direcci&oacute;n:</label>
										<input class="obligatoriedad" type="text" id="direccionSAP"
											name="direccion" ng-model="vale.direccion" />
										<p class="obligatorio obligatoriodireccionSAP"
											style="display: none">Obligatorio</p>
										<!-- <p class="obligatorio" ng-show="(salidaMaterialesForm.direccion.$invalid && show) || (salidaMaterialesForm.direccion.$invalid && salidaMaterialesForm.direccion.$touched)">Obligatorio</p> -->
									</div>
								</div>
								<div class="form-row">
									<div class="input-block col-half">
										<label class="label"><span class="obligatio">*</span>Nombre
											contacto:</label> <input class="obligatoriedad" type="text"
											id="nombresSAP" name="nombreContacto"
											ng-model="vale.nombreContacto" />
										<p class="obligatorio obligatorionombresSAP"
											style="display: none">Obligatorio</p>
										<!--                      <p class="obligatorio" ng-show="(salidaMaterialesForm.nombreContacto.$invalid && show) || (salidaMaterialesForm.nombreContacto.$invalid && salidaMaterialesForm.nombreContacto.$touched)">Obligatorio</p>
 -->
									</div>
									<div class="input-block col-quarter trio">
										<label class="label"><span class="obligatio">*</span>Tel&eacute;fono:</label>
										<input type="number" id="telefonoSAP"
											class="numerico obligatoriedad" name="telefonoContacto"
											ng-model="vale.telefonoContacto" />
										<p class="obligatorio obligatoriotelefonoSAP"
											style="display: none">Obligatorio</p>
										<!--                      <p class="obligatorio" ng-show="(salidaMaterialesForm.telefonoContacto.$invalid && show) || (salidaMaterialesForm.telefonoContacto.$invalid && salidaMaterialesForm.telefonoContacto.$touched)">Obligatorio</p>
 -->
									</div>
									<div class="input-block col-quarter trio2">
										<label class="label"><span class="obligatio">*</span>Ciudad:</label>
										<input class="obligatoriedad" type="text" id="ciudadSAP"
											name="ciudadContacto" ng-model="vale.ciudadContacto" />
										<p class="obligatorio obligatoriociudadSAP"
											style="display: none">Obligatorio</p>
										<!--                      <p class="obligatorio" ng-show="(salidaMaterialesForm.ciudadContacto.$invalid && show) || (salidaMaterialesForm.ciudadContacto.$invalid && salidaMaterialesForm.ciudadContacto.$touched)">Obligatorio</p>
 -->
									</div>
								</div>
								</section> <span class="separator"></span> <section>
								<h3>Datos de quien retira</h3>
								<div class="form-row">
									<div class="input-block col-half">
										<label class="label"><span class="obligatio">*</span>Nombre:</label>
										<input type="text" name="nombreRetira"
											ng-model="vale.nombreRetira"
											ng-model-options="{ updateOn: 'blur' }" required />
										<p class="obligatorio"
											ng-show="(salidaMaterialesForm.nombreRetira.$invalid && show) || (salidaMaterialesForm.nombreRetira.$invalid && salidaMaterialesForm.nombreRetira.touched)">Obligatorio</p>
									</div>
									<div class="input-block col-half izqui">
										<label class="label"><span class="obligatio">*</span>C.C:</label>
										<input class="numeros" type="number" name="ccRetira"
											ng-model="vale.ccRetira"
											ng-model-options="{ updateOn: 'blur' }" required />
										<p class="obligatorio"
											ng-show="(salidaMaterialesForm.ccRetira.$invalid && show) || (salidaMaterialesForm.ccRetira.$invalid && salidaMaterialesForm.ccRetira.$touched)">Obligatorio</p>
									</div>
								</div>
								<div class="form-row">
									<div class="input-block col-half">
										<label class="label"><span class="obligatio">*</span>Empresa
											transporte:</label> <input type="text" name="empresaTransporte"
											ng-model="vale.empresaTransporte"
											ng-model-options="{ updateOn: 'blur' }" required />
										<p class="obligatorio"
											ng-show="(salidaMaterialesForm.empresaTransporte.$invalid && show) || (salidaMaterialesForm.empresaTransporte.$invalid && salidaMaterialesForm.empresaTransporte.$touched)">Obligatorio</p>
									</div>
									<div class="input-block col-half izqui">
										<label class="label"><span class="obligatio">*</span>Placa
											veh&iacute;culo:</label> <input type="text" name="placaVehiculo"
											ng-model="vale.placaVehiculo"
											ng-model-options="{ updateOn: 'blur' }" required />
										<p class="obligatorio"
											ng-show="(salidaMaterialesForm.placaVehiculo.$invalid && show) || (salidaMaterialesForm.placaVehiculo.$invalid && salidaMaterialesForm.placaVehiculo.$touched)">Obligatorio</p>
									</div>
								</div>
								</section> <span class="separator"></span>
								<div class="form-row"></div>
								<!--AquÃ­ va la tabla--> <section class="table-container">
								<h3>Materiales</h3>
								<div class="agregar">

									<input type="button" name="Agregar" value="Agregar" class="add"
										ng-click="addMaterial()" />

								</div>
								<table name="tabla-materiales" class="tabla-materiales">
									<thead>
										<tr>
											<th class="column-one">Nro. Fila</th>
											<th class="centr">Centro</th>
											<th class="cod">C&oacute;digo</th>
											<th id="thDescr">Descripci&oacute;n</th>
											<th>UM unidad de medida</th>
											<th>Valor Unitario</th>
											<th>Cantidad</th>
											<th>Valor estimado</th>
											<th>Peso(kg) si es controlado</th>
											<th>Regresa</th>
											<th>Pertenece a m&aacute;quina</th>
											<th>OC servicio</th>
											<th>OC adquisici&oacute;n</th>
											<th class="esperadaTh">Fecha esperada de regreso</th>
											<th ng-if="contador1!=1" class="fecFinalTh">Fecha final</th>
											<th ng-if="contador1!=1">Acciones</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="column-eight"><input id="nroFilas"
												class="contFila" type="text" value="contador1" name="fila"
												ng-model="contador1" readonly /></td>

											<td class=""><select name="centro"
												class="obligacionTabla inputCentro" id="centroSelect"
												name="selectMotivo" ng-model="material.centro">
													<c:forEach items="${model.centros}" var="i">
														<option value=<c:out value="${i}"/>>
															<c:out value="${i}" />
														</option>
													</c:forEach>
											</select>

												<td>
													<div class="lupCod">
														<input class="input-lupa1" type="text"
															id="codigoConsultar" name="codigo"
															ng-model="material.codigo"
															ng-model-options="{ updateOn: 'blur' }" /> <img
															class="imgLupa" src="resources/img/lupa.png" alt="Buscar"
															onclick="buscarMaterial()" />
														<p class="obligatorio obligatoriedadcodigoConsultar"
															style="display: none">Obligatorio</p>
														<!--  <p class="obligatorio" ng-show="salidaMaterialesForm.codigo.$invalid && salidaMaterialesForm.codigo.$touched">Obligatorio</p> -->
													</div>
											</td>

												<td><input type="text"
													class="descriMaterial obligacionTabla" id="descripcionSAP"
													name="descripcion" ng-model="material.descripcion" />
													<p class="obligatorio obligatoriedaddescripcionSAP"
														style="display: none">Obligatorio</p></td>
												<td><input type="text"
													class="selectUm UmHome obligacionTabla" id="umSOAP"
													name="um" ng-model="material.um" />
													<p class="obligatorio obligatoriedadumSOAP"
														style="display: none">Obligatorio</p> <!-- <p class="obligatorio" ng-show="salidaMaterialesForm.um.$invalid && salidaMaterialesForm.um.$touched">Obligatorio</p> -->
											</td>
												<td><input class="obligacionTabla cantMat"
													type="number" name="vlrUnitario" id="vlrUnitarioSAP"
													ng-model="material.vlrUnitario" />
													<p class="obligatorio obligatoriedadvlrUnitarioSAP"
														style="display: none">Obligatorio</p></td>
												<td><input type="number" name="cantidad"
													class="cantMat obligacionTabla" id="cantMat"
													ng-model="material.cantidad"
													ng-model-options="{ updateOn: 'blur' }" required min="1" />
													<p class="obligatorio obligatoriedadcantMat"
														style="display: none">Obligatorio</p> <!-- <p class="obligatorio" ng-show="salidaMaterialesForm.cantidad.$invalid && salidaMaterialesForm.cantidad.$touched">Obligatorio</p> -->
											</td>
												<td><input type="text" name="valorEstimado"
													id="vlrEstimado"
													ng-value="material.cantidad * material.vlrUnitario"
													ng-model="estimado" readonly />
													<p class="obligatorio obligatoriedadvlrEstimado"
														style="display: none">Obligatorio</p> <!-- <p class="obligatorio" ng-show="salidaMaterialesForm.valorEstimado.$invalid && salidaMaterialesForm.valorEstimado.$touched">Obligatorio</p> -->
											</td>
												<td><input class="obligacionTabla" type="number"
													name="peso" id="peso" ng-model="material.peso"
													ng-model-options="{ updateOn: 'blur' }" required />
													<p class="obligatorio obligatoriedadpeso"
														style="display: none">Obligatorio</p> <!-- <p class="obligatorio" ng-show="salidaMaterialesForm.peso.$invalid && salidaMaterialesForm.peso.$touched">Obligatorio</p> -->
											</td>
												<td class="column-eight"><select class="selectForm"
													name="regresa" id="regresa" ng-model="data.regresa"
													ng-change="clicRegresa()" onchange="CallPicker()">
														<option value="Si">Si</option>
														<option value="No">No</option>
												</select>
													<p class="obligatorio"
														ng-show="salidaMaterialesForm.regresa.$invalid && salidaMaterialesForm.regresa.$touched">Obligatorio</p>
											</td>
												<td class="column-eight selectFormTd"><select
													class="selectForm" name="repuesto" ng-model="data.repuesto"
													ng-model-options="{ updateOn: 'blur' }" required>
														<option value="Si">Si</option>
														<option value="No">No</option>
												</select>
													<p class="obligatorio"
														ng-show="salidaMaterialesForm.repuesto.$invalid && salidaMaterialesForm.repuesto.$touched">Obligatorio</p>
											</td>
												<td><input class="obligacionTabla" id="ocN1"
													ng-if="data.singleSelect=='Si'" type="number" name="noOC"
													ng-model="material.noOC"
													ng-model-options="{ updateOn: 'blur' }" required /> <input
													ng-if="data.singleSelect=='No'" type="text" name="noOC"
													value="N/A" readOnly />
													<p class="obligatorio obligatoriedadocN1"
														style="display: none">Obligatorio</p> <!--  <p class="obligatorio" ng-show="salidaMaterialesForm.noOC.$invalid && salidaMaterialesForm.noOC.$touched">Obligatorio</p> -->
											</td>


												<td><input class="obligacionTabla" id="ocN"
													ng-if="data.singleSelect=='Si'" type="number" name="noOCa"
													ng-model="material.noOCa"
													ng-model-options="{ updateOn: 'blur' }" required /> <input
													ng-if="data.singleSelect=='No'" type="text" name="noOCa"
													value="N/A" readOnly />
													<p class="obligatorio obligatoriedadocN"
														style="display: none">Obligatorio</p> <!--  <p class="obligatorio" ng-show="salidaMaterialesForm.noOCa.$invalid && salidaMaterialesForm.noOCa.$touched">Obligatorio</p> -->
											</td> <%-- <td>
                        <!-- <input ng-if="data.regresa=='Si'" class="fec" type="date" id="fecEsp" name="fechaEsperada" ng-model="material.fechaEsperada.value"  min="${model.fechaHoy}" ng-model-options="{ updateOn: 'blur' }" required/> -->
                        <input ng-if="data.regresa=='Si'" class="fec" type="date" id="fecEsp" name="fechaEsperada" ng-model="data.fechaEsperada.value" min="${model.fechaHoy}" ng-model-options="{ updateOn: 'blur' }" required/>
                        <input ng-if="data.regresa=='No'" class="fec" type="date" ng-model="material.fechaEsperada" readonly/>
                        <p class="obligatorio" ng-show="salidaMaterialesForm.fechaEsperada.$invalid && salidaMaterialesForm.fechaEsperada.$touched">Obligatorio</p>
                    	</td> --%> <!-- datepicker -->

												<td><input ng-if="data.regresa=='Si'" type="text"
													id="datepicker" name="datepicker" class="fec datepicker"
													readonly /> <input ng-if="data.regresa=='No'" class="fec"
													type="date" ng-model="material.fechaEsperada" readonly /></td>
												<!-- datepicker -->

												<td Style="Display: none"><input type="text"
													value="fechaFinalHome" ng-model="fechaFinalHome" readonly />
											</td>
										</tr>
										<tr ng-repeat="material in materiales">
											<td class="column-one"><input class="in-descri"
												type="text" value="material.fila"
												name="fila{{material.ide}}" ng-model="material.fila"
												readonly /></td>

											<td class="column-two"><input class="in-descri"
												type="text" value="material.centro"
												id="centro{{material.ide}}" name="centro{{material.ide}}"
												ng-model="material.centro"
												ng-change="convMayusculasListaAng(material.ide)"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /></td>
											<td class="column-two"><input ng-if="!habEdit"
												class="in-descri" type="text" value="material.codigo"
												name="codigo{{material.ide}}" ng-model="material.codigo"
												readonly /> <input ng-if="habEdit"
												class="input-lupa1 obligacionTabla" type="text"
												id="codigoConsultar{{material.ide}}"
												name="codigo{{material.ide}}" ng-model="material.codigo"
												ng-model-options="{ updateOn: 'blur' }" required /> <img
												ng-if="habEdit" class="imgLupa" src="resources/img/lupa.png"
												alt="Buscar" ng-click="buscarMaterialLista(material.ide)" /></td>






											<td class="column-three"><input
												id="contenidoDescrip{{material.ide}}"
												class="in-descri showTool" type="text" data-toggle="tooltip"
												title="" value="material.descripcion"
												name="descri{{material.ide}}"
												ng-model="material.descripcion"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /></td>
											<td class="column-four"><input
												id="umsoap{{material.ide}}" class="in-descri" type="text"
												value="material.um" name="um{{material.ide}}"
												ng-model="material.um"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /></td>

											<td class="column-five"><input class="in-descri"
												type="number" id="vlrUnitario{{material.ide}}"
												name="vlrUnitario{{material.ide}}"
												ng-model="material.vlrUnitario"
												ng-change="vlrEstimadoLista1(material.ide)"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /></td>
											<td class="column-five"><input class="in-descri"
												type="number" id="cantidad{{material.ide}}"
												name="cantidad{{material.ide}}" ng-model="material.cantidad"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit"
												ng-change="vlrEstimadoLista(material.ide)" /></td>
											<td class="column-six"><input class="in-descri"
												type="text" id="valor{{material.ide}}"
												name="valor{{material.ide}}"
												ng-value="material.vlrUnitario * material.cantidad" readonly />
											</td>
											<td class="column-seven"><input class="in-descri"
												type="number" name="peso{{material.ide}}"
												ng-model="material.peso"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /></td>
											<td class="column-eight"><input ng-if="!habEdit"
												class="in-descri" type="text" value="material.regresa"
												name="regresa{{material.ide}}" ng-model="material.regresa"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /> <select ng-if="habEdit"
												name="regresa{{material.ide}}" id="regresaList"
												ng-model="material.regresa" onchange="CallPicker()">
													<option value="Si">Si</option>
													<option value="No">No</option>
											</select></td>
											<td class="column-nine"><input ng-if="!habEdit"
												class="in-descri" type="text" value="material.repuesto"
												name="repuesto{{material.ide}}" ng-model="material.repuesto"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /> <select ng-if="habEdit"
												name="repuesto{{material.ide}}" ng-model="material.repuesto">
													<option value="Si">Si</option>
													<option value="No">No</option>
											</select></td>
											<td class="column-ten"><input
												ng-if="data.singleSelect=='Si'" class="in-descri"
												type="text" value="material.noOC"
												name="noOc{{material.ide}}" ng-model="material.noOC"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /> <input
												ng-if="data.singleSelect=='No'" class="in-descri"
												type="text" value="N/A" name="noOc{{material.ide}}" readonly />
											</td>

											<td class="column-ten"><input
												ng-if="data.singleSelect=='Si'" class="in-descri"
												type="text" value="material.noOCa"
												name="noOca{{material.ide}}" ng-model="material.noOCa"
												ng-class="{'campo-editable': habEdit}"
												ng-readonly="!habEdit" /> <input
												ng-if="data.singleSelect=='No'" class="in-descri"
												type="text" value="N/A" name="noOca{{material.ide}}"
												readonly /></td>


											<td class="column-eleven"><input
												ng-if="material.regresa=='No'" name="fecha{{material.ide}}"
												class="in-descri fec" type="date" value="dd/mm/aaaa"
												readonly /> <!-- picker --> <input
												ng-if="material.regresa=='Si'" id="fecha{{material.ide}}"
												name="fecha{{material.ide}}"
												class="in-descri fec datepicker" type="text"
												value="material.fechaEsperada"
												ng-model="material.fechaEsperada"
												ng-class="{'campo-editable': habEdit}" readonly /></td>
											<td><input
												ng-if="material.regresa=='No' && material.fechaFinal != null"
												type="text" class="in-descri fec"
												value="material.fechaFinal" ng-model="material.fechaFinal"
												readonly /> <input
												ng-if="material.regresa=='No' && material.fechaFinal == null"
												type="text" class="in-descri fec"
												value="data.fechaFinalisima" ng-model="fechaFinalisima"
												readonly /></td>
											<td class="column-fifteen bote"><input
												id="chechkPrueba{{material.ide}}" type="checkbox"
												ng-model="habEdit" /> <label class="edit"
												name="prueba{{material.ide}}"
												for="chechkPrueba{{material.ide}}"></label> <a
												class="delete" title="Eliminar"
												ng-click="removeMaterial(material.fila)"></a></td>
										</tr>
									</tbody>
								</table>
								<p class="obligatorio" ng-show="contador1 === 1 && show">Ingrese
									por lo menos un material</p>
								</section> <span class="separator"></span> <section>
								<div class="form-row">
									<div class="input-block col-full">
										<label class="label">Observaciones:</label>
										<textarea name="observaciones"
											ng-model="material.observaciones" rows="7" maxlength="1000"
											ng-model-options="{ updateOn: 'blur' }" required></textarea>
										<p class="obligatorio"
											ng-show="(salidaMaterialesForm.observaciones.$invalid && show) || (salidaMaterialesForm.observaciones.$invalid && salidaMaterialesForm.observaciones.$touched)">Obligatorio</p>
									</div>
								</div>
								</section> <span class="separator"></span> <section>
								<div class="form-row">
									<div class="input-block col-quarter">
										<label class="label"><span class="obligatio">*</span>Solicitante:</label>
										<input type="text" id="solicitanteLogeado" name="solicitante" />
									</div>

									<div class="input-block col-quarter">
										<label class="label">Jefe:</label> <select
											class="lugarAprobante" name="almacenOrigen"
											id="lugarAprobante" ng-model="lugarAprobante"
											ng-change="listaAlmacenistas()"
											onchange="mostrarAlmacenistas()">
											<option value=""></option>
											<option value="Aprobación Jefe Salma Medellín">Medellín</option>
											<option value="Aprobación Jefe Salma Cajicá">Cajica</option>
											<option value="Aprobación Jefe Salma ZF Cajicá">ZFCajica</option>
											<option value="Aprobación Jefe Salma Rionegro">Rionegro</option>
											<option value="Aprobación Jefe Salma Cauca">Cauca</option>
											<option value="Aprobación Jefe Salma Pacífico">Pacífico</option>
											<option value="Aprobación Jefe Salma Ecuador">Ecuador</option>
											<option value="Aprobación Jefe Salma Argentina">Argentina</option>
											<option value="Aprobación Jefe Salma Republica Dominicana">Republica
												Dominicana</option>
										</select>
									</div>

									<div class="input-block col-quarter">
										<label class="label">Correo del Almac&eacute;n:</label> <input
											class="obligatoriedad" type="text" id="correoAlmacen"
											name="correoAlmacen" readonly />
										<p class="obligatorio obligatoriocorreoAlmacen"
											style="display: none">Obligatorio</p>
									</div>

									<div class="input-block col-quarter" Style="Display: none">
										<label class="label">Almac&eacute;n:</label> <input
											type="text" name="almacen" />
									</div>
									<div class="input-block col-quarter" Style="Display: none">
										<label class="label">Control porter&iacute;a:</label> <input
											type="text" name="controlPorteria" />
									</div>
									<div class="input-block col-quarter" Style="Display: none">
										<label class="label">Retira:</label> <input type="text"
											name="retira" />
									</div>
								</div>
								</section> <section class="buttons"> <br> <input
									ng-if="salidaMaterialesForm.$invalid || contador1 === 1"
									type="button" id="Guardar1" name="Guardar1" value="Guardar"
									class="submit" ng-click="submitForm()" /> <input
									ng-if="!salidaMaterialesForm.$invalid && contador1 > 1"
									type="button" id="Guardar" name="Guardar" value="Guardar"
									class="submit" ng-click="redireccionar()" />

									<div modal="showModal" close="cancel()">
										<div class="modal-header">
											<h4>Vale Creado Exitosamente</h4>
										</div>
										<div class="modal-body">
											<p>Desea Ingresar un nuevo vale?</p>
										</div>
										<div class="modal-footer">
											<button class="btn btn-success" ng-click="ok()">Si</button>
											<button class="btn" ng-click="cancel()">No</button>
										</div>
									</div>
								</section> <input type="text" id="idFiltrado" name="idFiltrado"
									value="${model.numVale}" Style="Display: none" /> <input
									type="text" id="direccionFiltrada" name="direccionFiltrada"
									ng-model="redirecion" Style="Display: none" /> <input
									type="text" id="correoUsuario" name="correoUsuario"
									Style="display: none" /> <input type="text"
									id="descripcionUsuario" name="descripcionUsuario" value=""
									Style="display: none" /> <input type="text" id="nameUsuario"
									name="nameUsuario" value="" Style="display: none" /> <input
									type="text" id="plantaUsuario" name="plantaUsuario" value=""
									Style="display: none" /> <input id="nroFilasTotales"
									class="contFila" type="text" value="contador2" name="filaTotal"
									ng-model="contador2" Style="display: none" />
							</form>
						</div>
						<div modal="showModal1" close="cancel()" class="modalError">
							<div class="cancelar">
								<button class="btnCancel" ng-click="okk()"></button>
							</div>
							<div class="modal-header1">
								<h4>Verifique todos los campos</h4>
							</div>
						</div>
						<!-- Modal Error -->
						<div class="modal fade" id="errorModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="cancelar">
										<button class="btnCancel" onclick="cerrarModal()"></button>
									</div>
									<div class="modal-header1 headerError">
										<h4>No se encontraron datos</h4>
									</div>
								</div>
							</div>
						</div>
						<!-- Modal centro -->
						<div class="modal fade" id="centroObligatorio" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="cancelar">
										<button class="btnCancel" onclick="cerrarModalCentro()"></button>
									</div>
									<div class="modal-header1 headerError">
										<h4>Campo "centro" es requerido</h4>
									</div>
								</div>
							</div>
						</div>

						<!-- Modal codigo -->
						<div class="modal fade" id="codeObligatorio" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="cancelar">
										<button class="btnCancel" onclick="cerrarModalCode()"></button>
									</div>
									<div class="modal-header1 headerError">
										<h4>Campo "Código" es requerido</h4>
									</div>
								</div>
							</div>
						</div>


						<!-- Modal centro -->
						<div class="modal fade" id="todosObligatorio" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="cancelar">
										<button class="btnCancel" onclick="cerrarModalTodos()"></button>
									</div>
									<div class="modal-header1 headerError">
										<h4>Verifique todos los campos</h4>
									</div>
								</div>
							</div>
						</div>



						<div class="modal fade" id="faltantes" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="cancelar">
										<button class="btnCancel" onclick="cerrarModalCentro()"></button>
									</div>
									<div class="modal-header1 headerError">
										<h4>Verifique todos los campos</h4>
									</div>
								</div>
							</div>
						</div>

						<!-- Fin modal centro -->
						<!-- Modal centroIncorrecto -->
						<div class="modal fade" id="centroIncorrecto" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="cancelar">
										<button class="btnCancel" onclick="cerrarModalIncorrecto()"></button>
									</div>
									<div class="modal-header1 headerError">
										<h4>Solo se aceptan los centros</h4>
										<h4>CO05,CO60 y CO61</h4>
									</div>
								</div>
							</div>
						</div>
						<!-- Fin modal centroIncorrecto -->
						<!-- Fin Modal Error -->
						<!-- Modal Lista -->
						<div modal="showModal3" close="cancel()" class="modalLista">
							<div class="modal-header modal-header2">
								<h4>Empresas:</h4>
							</div>
							<div class="listaEmpresas" style="overflow-y: scroll"></div>
							<div class="modal-footer">
								<button id="cerrarS" class="btn btn-success" ng-click="okk()">Aceptar</button>
							</div>
						</div>
						<!-- Fin Modal Lista -->
						<!-- Modal lista Aprobadores -->
						<div modal="showModal4" close="cancel()" class="modalLista">
							<div class="modal-header modal-header2">
								<h4>Almacenistas:</h4>
							</div>
							<div class="listaAlmacenistas" style="overflow-y: scroll">

							</div>
							<div class="modal-footer">
								<button id="cerrarS" class="btn btn-success" ng-click="okk4()">Aceptar</button>
							</div>
						</div>
						<!-- Fina Aprobadores -->

						<!-- Modal Login-->
						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header headerLogin"
										style="padding: 35px 50px;">
										<h4>
											<span class="glyphicon glyphicon-lock"></span> Login
										</h4>
									</div>
									<div class="modal-body bodyLogin" id="bodyLogin"
										style="padding: 40px 50px;">
										<form role="form">
											<div class="form-group">
												<label for="usrname" class="labelLogin"><span
													class="glyphicon glyphicon-user"></span> Usuario:</label> <input
													type="text" class="form-control inputLogin" id="usrname">
											</div>
											<div class="form-group">
												<label for="psw" class="labelLogin"><span
													class="glyphicon glyphicon-eye-open"></span> Password:</label> <input
													type="password" class="form-control inputLogin" id="psw">
													<p id="verifiDatos" class="obligatorio"
														Style="display: none">Verifique sus datos</p>
											</div>
											<button type="submit" class="btn btn-success btn-block"
												onclick="verificarDatos()">
												<span class="glyphicon glyphicon-off"></span> Login
											</button>
										</form>
									</div>
								</div>

							</div>
						</div>
						<!-- Fin modal login -->


						</div>
					</body>
</html>