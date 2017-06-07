<%@ page import="jxl.*"%> 
<%@ page import="jxl.write.*"%> 
<%@ page import="java.io.*"%> 
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="application/vnd.ms-excel"
    pageEncoding="ISO-8859-1"%>
<% response.setHeader("Content-Disposition", "attachment; filename=vales.xls"); %> 
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
</head>
	<body id="listaForm" ng-app="validationApp" ng-controller="mainController">
		<tbody class="items">
			<c:forEach items="${model.vales}" var="i" varStatus="j">
					<h4>VALE No <c:out value="${i.getIdVale()}"/></h4>	
					<h6>Solicitud de Salida</h6>
					<table>
				  		<tr>
						    <th colspan="3">Diligenciado / Autorizado por</th>
						    <th colspan="3">Motivo</th>
				 		 </tr>
						  <tr>
						    <td colspan="3"><c:out value="${i.getNombreDiligencio()}"/></td>
						    <td colspan="3"><c:out value="${i.getMotivo()}"/></td>
						  </tr>
					</table>
					<table>
				  		<tr>
						    <th colspan="6">Justificacion</th>
				 		 </tr>
						  <tr>
						    <td colspan="6"><c:out value="${i.getJustificacion()}"/></td>
						  </tr>	
					</table>
					<h6>Solicitud de Destino</h6>					  
					<table>
				  		<tr>
						    <th colspan="3">Proveedor</th>
						    <th colspan="3">Nit</th>		  
				 		 </tr>
						  <tr>
						    <td colspan="3"><c:out value="${i.getDestinoProveedor()}"/></td>
						    <td colspan="3"><c:out value="${i.getDestinoNit()}"/></td>
						  </tr>						  
					</table>
					<table>
				  		<tr>
						    <th colspan="3">Empresa</th>
						    <th colspan="3">Direccion</th>		  
				 		 </tr>
						  <tr>
						    <td colspan="3"><c:out value="${i.getDestinoEmpresa()}"/></td>
						    <td colspan="3"><c:out value="${i.getDestinoDireccion()}"/></td>
						  </tr>						  
					</table>
					<table>
				  		<tr>
						    <th colspan="3">Nombre Contacto</th>
						    <th colspan="3">Telefono</th>
						    <th colspan="3">Ciudad</th>
				 		 </tr>
						  <tr>
						    <td colspan="3"><c:out value="${i.getDestinoNombre()}"/></td>
						    <td colspan="3"><c:out value="${i.getDestinoTel()}"/></td>
						    <td colspan="3"><c:out value="${i.getDestinoCiudad()}"/></td>
						  </tr>					  
					</table>
			
					<h6>Datos de quien retira</h6>
					<table>
				  		<tr>
						    <th  colspan="3">Nombre</th>
						    <th  colspan="3">CC</th>
				 		 </tr>
						  <tr>
						    <td  colspan="3"><c:out value="${i.getRetiraNombre()}"/></td>
						    <td  colspan="3"><c:out value="${i.getRetiraIdentificacion()}"/></td>
						  </tr>				
					</table>
					<table>
				  		<tr>
						    <th  colspan="3">Empresa de Transporte</th>
						    <th  colspan="3">Placa vehiculo</th>
				 		 </tr>
						  <tr>
						    <td  colspan="3"><c:out value="${i.getRetiraEmpresa()}"/></td>
						    <td  colspan="3"><c:out value="${i.getRetiraPlaca()}"/></td>
						  </tr>						
					</table>	
			</c:forEach>					
		</tbody>
		
	</body>
</html>