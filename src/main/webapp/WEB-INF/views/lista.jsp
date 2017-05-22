<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<title>Salida de materiales</title>
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/styles.css">	
	
	 <!-- JS -->

     <script src="resources/js/angular/angular.min.js"></script>
    <script src="resources/js/angular/app.js"></script>
    <script src="resources/js/angular/angular-ui-bootstrap-modal.js"></script>
    <script src="resources/js/jquery-1.11.3.min.js"></script>
   	<script src="resources/js/paginga.jquery.min.js"></script>
   	<script src="resources/js/jquery-ui.js"></script>
    <script src="resources/js/funciones.js"></script>
    <script>
			function Irr(x){
			    document.getElementById("prueba").value = x;
			}
		</script>
</head>
<body id="listaForm" ng-app="validationApp" ng-controller="mainController">
		<header>
		<div id="logo">
				<div id="Custom_Logo">
					<img id="ctl00_x63829de2201a4365a3904788f682d0a3" src="resources/img/logo.png" alt="Back to Home">
				</div>
			</div>
			<section class="form-row">
				<section id="breadcrumb-client">
				    <div id="content-breadcrumb-client">
				    <a href="/ValesDeSalida">			
						<span>Crear Vale</span>
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
		</section>
		<form id="valesSalidaForm" name="valesSalidaForm" method="post" action="filtro" novalidate>
	
				<div class="form-row">
					<div class="input-block col-quarter">
						<label class="label">NÚMERO DE VALE:</label>
						<input type="text" name="radicadoFiltro" ng-model="numVale" nit="item = numVale: ''}"/>

					</div>

					<div class="input-block col-quarter">
						<label class="label">Estado:</label>
						<select name="estadoFiltro" ng-model="data.estadoFiltro">
							<option value="ABIERTO">ABIERTO</option>
							<option value="CERRADO">CERRADO</option>
							<option value="TODOS">TODOS</option>
						</select>
					</div>
					<input type="submit" name="Consultar" value="Consultar" class="add" ng-click="consultar()"/>
				</div>
			</form>
			
			<form id="valesSalidaForm" name="valesSalidaForm" method="post" action="FiltroFecha" novalidate>
	
				<div class="form-row">
					
					<!-- Filtrar por fecha -->
					<div class="input-block1 fechaFiltro">
						<label>Fecha de Regreso:</label>
						<input id="fecFiltro" class="fec datepicker" type="text" name="fecFiltro" readonly/>
					</div>
					<input type="submit" name="Consultar" value="Consultar por Fecha" class="add fecFiltro"/>
					<!-- Fin Filtrar por fecha -->				
				</div>
			</form>
			
			<form id="valesSalidaForm" name="valesSalidaForm" method="post" action="FiltroCentro" novalidate>
	
				<div class="form-row">
					<!-- Filtrar por Centro -->
					<div class="input-block1 fechaFiltro">
						<label>Centro:</label>
						<input id="centroFiltro" class="" type="text" name="centFiltro"/>
					</div>
					<input type="submit" name="Consultar" value="Consultar por Centro" class="add fecFiltro"/>
					<!-- Fin Filtrar por centro -->
				</div>	

			</form>
				
<form id="valesSalidaForm1" name="valesSalidaForm1" method="get" action="valeDetail" novalidate> 
				<span ng-if="data.mostrar=='No'"><a id="selColumnas "ng-click="clicColumn()" ng-style="estSel" value="data.mostrar"><div class="selColum">
				Seleccionar columnas a mostrar
				</div></a></span>


				<span ng-if="data.mostrar=='Si'"><a id="sel2Columnas "ng-click="clicColumn()" ng-style="estSel" value="data.mostrar"><div class="sel2Colum">
				Seleccionar columnas a mostrar
				</div></a></span>


				<span ng-if="data.mostrar=='Si'"><div class="selectores"><div class="divSelec"><ul>
					<li><label>
						<input type="checkbox" ng-model="checkboxModel.valueMot">
						<span>Motivo</span>
					</label></li>
					<li><label>
						<input type="checkbox" ng-model="checkboxModel.valueDest">
						<span>Ciudad Destino</span>
					</label></li>
					<li><label>
						<input type="checkbox" ng-model="checkboxModel.valueEst">
						<span>Estado</span>
					</label></li>
				</ul></div>
				<div class="divSelec"><ul>
					<li><label>
						<input type="checkbox" ng-model="checkboxModel.valueEmp">
						<span>Empresa</span>
					</label></li>
					<li><label>
						<input type="checkbox" ng-model="checkboxModel.valueNit">
						<span>NIT</span>
					</label></li>
					<li><label>
						<input type="checkbox" ng-model="checkboxModel.valueCiu">
						<span>Ciudad</span>
					</label></li>
				</ul></div></div></span>
			</section>	
				<hr>
			<section>
		<div class="paginate 1">
			<table class="tablaVales">
					<thead>
						<tr>
							<th>Número de Vale</th>
							<th>Solicitante</th>
							<th ng-if="checkboxModel.valueEst==true">Estado</th>
							<th>Fecha de Creación</th>
							<th ng-if="checkboxModel.valueDest==true">Ciudad Destino</th>
							<th ng-if="checkboxModel.valueMot==true">Motivo</th>
							<th ng-if="checkboxModel.valueNit==true">NIT</th>
							<th ng-if="checkboxModel.valueEmp==true">Empresa Destino</th>
							<th ng-if="checkboxModel.valueCiu==true">Ciudad</th>					
							<th></th>
						</tr>
					</thead>
					<tbody class="items">
						<tr> 
						<c:forEach items="${model.vales}" var="i" varStatus="j">
							<tr ng-if="'<c:out value="${i.getAlmacen()}"/>' != ''">
								<td name="<c:out value="${i.getIdVale()}"/>" ng-model="vale.valeId"/><c:out value="${i.getIdVale()}"/></td>
								<td ng-model="vale.valeId"/><c:out value="${i.getSolicitante()}"/></td>
								<td ng-if="checkboxModel.valueEst==true" ng-model="vale.valeEst"><c:out value="${i.getEstadoVale().getEstado()}"/></td>
								<td ng-model="vale.valeFec"><c:out value="${i.getFechaCreacion()}"/></td>
								<td ng-if="checkboxModel.valueDest==true" ng-model="vale.valeDest"><c:out value="${i.getDestinoCiudad()}"/></td>
								<td ng-if="checkboxModel.valueMot==true" ng-model="vale.valeMot"><c:out value="${i.getMotivo()}"/></td>
								<td ng-if="checkboxModel.valueNit==true" ng-model="vale.valeNit"><c:out value="${i.getDestinoNit()}"/></td>
								<td ng-if="checkboxModel.valueEmp==true" ng-model="vale.valeEmp"><c:out value="${i.getDestinoEmpresa()}"/></td>
								<td ng-if="checkboxModel.valueCiu==true" ng-model="vale.valeCiu"><c:out value="${i.getDestinoCiudad()}"/></td>
								<td>
									<button id="ir" onclick="Irr(${i.getIdVale()})">Ir</button>
									<%-- <input type="button" id="pdf" class="pdf visualizar" onclick="pdfLista(${i.getIdVale()})"></input> --%>
									<!-- delete vale -->
									<%-- <input type="button" id="deleteVale" class="borrar pdf" onclick="deleteVales(${i.getIdVale()})"/></input>		 --%>
									<!-- Fin delete vale -->
									<!-- <input type="button" id="pdf" class="pdf visualizar" onclick="window.open('verPdfBrowser')"/> -->
									<input type="button" id="pdf" class="pdf visualizar" onclick="pdfListaBrowser(${i.getIdVale()})"/>
								</td>
							</tr>
							</c:forEach>
						</tr>
					</tbody>
				</table>
				 <div class="pager">
                  <div class="firstPage" onclick="pagInicial()">&laquo; Primero</div>
                  <div class="previousPage" onclick="pagAnterior()">Anterior</div>
              		<div class="pageNumbers" Style="Display:none"></div>
              		<input id="numPags" class="numPags" readonly></input>
              		<select id="numResultados" class="numResultados">
              			<option value="5">5</option>
              			<option value="15">15</option>
              			<option value="25">25</option>
              			<option value="50">50</option>
              			<option value="100">100</option>
              		</select>
                  <div class="nextPage" onclick="pagSiguiente()">Siguiente</div>
                  <div class="lastPage" onclick="pagFinal()">Ultimo &raquo;</div>
                </div>
              </div>
				
				

			</section>
			<input type="text" id="prueba" name="valorFiltrado" Style="Display:none"/>
			</form>
		</div>
		<!-- </form> -->
	</body>
</html>