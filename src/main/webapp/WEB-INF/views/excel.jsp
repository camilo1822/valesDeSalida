<%@ page import="jxl.*"%>
<%@ page import="jxl.write.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="application/vnd.ms-excel"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Disposition", "attachment; filename=vales.xls");
%>



<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<html>
<head> --%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
			<title>Salida de materiales</title> <!-- CSS -->
			<link rel="stylesheet" type="text/css"
				href="resources/css/styles.css">

				<!-- JS -->

				<script src="resources/js/angular/angular.min.js"></script>
				<script src="resources/js/angular/app.js"></script>
				<script src="resources/js/angular/angular-ui-bootstrap-modal.js"></script>
				<script src="resources/js/jquery-1.11.3.min.js"></script>
				<script src="resources/js/paginga.jquery.min.js"></script>
				<script src="resources/js/jquery-ui.js"></script>
				<script src="resources/js/funciones.js"></script>
				</head>
				<body id="listaForm" ng-app="validationApp"
					ng-controller="mainController">
					<tbody class="items">
						<table>
							<tr>
								<th>VALE</th>
								<th>Diligenciado / Autorizado por</th>
								<th>Motivo</th>
								<th>Justificacion</th>
								<th>Proveedor</th>
								<th>Nit</th>
								<th>Empresa</th>
								<th>Direccion</th>
								<th>Nombre Contacto</th>
								<th>Telefono</th>
								<th>Ciudad</th>
								<th>Nombre</th>
								<th>CC</th>
								<th>Empresa de Transporte</th>
								<th>Placa vehiculo</th>

								<th>Fila</th>
								<th>Codigo</th>
								<th>Centro</th>
								<th>Descripcion</th>
								<th>Cantidad</th>
								<th>Vlr Unitario</th>
								<th>Vlr Estimado</th>
								<th>UM</th>
								<th>Peso</th>
								<th>Pertenece Maq.</th>
								<th>OC servicio</th>
								<th>OC adquisicion</th>
								<th>Fecha regreso</th>

							</tr>
						</table>
						<c:forEach items="${model.vales}" var="i" varStatus="j">
							<c:forEach items="${model.detVal}" var="l" varStatus="m">
								<c:if test="${i.getIdVale()eq l.getVale().getIdVale()}">
									<table style="BORDER: #000000 solid">

										<tr>
											<td align='center'><c:out value="${i.getIdVale()}" /></td>
											<td align='center'><c:out
													value="${i.getNombreDiligencio()}" /></td>
											<td align='center'><c:out value="${i.getMotivo()}" /></td>
											<td align='center'><c:out
													value="${i.getJustificacion()}" /></td>
											<td align='center'><c:out
													value="${i.getDestinoProveedor()}" /></td>
											<td align='center'><c:out value="${i.getDestinoNit()}" /></td>
											<td align='center'><c:out
													value="${i.getDestinoEmpresa()}" /></td>
											<td align='center'><c:out
													value="${i.getDestinoDireccion()}" /></td>
											<td align='center'><c:out
													value="${i.getDestinoNombre()}" /></td>
											<td align='center'><c:out value="${i.getDestinoTel()}" /></td>
											<td align='center'><c:out
													value="${i.getDestinoCiudad()}" /></td>
											<td align='center'><c:out value="${i.getRetiraNombre()}" /></td>
											<td align='center'><c:out
													value="${i.getRetiraIdentificacion()}" /></td>
											<td align='center'><c:out
													value="${i.getRetiraEmpresa()}" /></td>
											<td align='center'><c:out value="${i.getRetiraPlaca()}" /></td>


											<td align="center"><c:out value="${l.getFila()}" /></td>
											<td align='center'><c:out value="${l.getCodigo()}" /></td>
											<td align='center'><c:out value="${l.getCentro()}" /></td>
											<td align='center'><c:out value="${l.getDescripcion()}" /></td>
											<td align='center'><c:out value="${l.getCantidad()}" /></td>
											<td align='center'><c:out value="${l.getValorUni()}" /></td>
											<td align='center'><c:out value="${l.getValor()}" /></td>
											<td align='center'><c:out value="${l.getUnidad()}" /></td>
											<td align='center'><c:out value="${l.getPeso()}" /></td>
											<td align='center'><c:out
													value="${l.getPerteneceMaquina()}" /></td>
											<td align='center'><c:out value="${l.getNoOc()}" /></td>
											<td align='center'><c:out value="${l.getOcAd()}" /></td>
											<td align='center'><c:out
													value="${l.getFechaEsperada()}" /></td>
										</tr>
									</table>

								</c:if>
							</c:forEach>






						</c:forEach>
					</tbody>

				</body>
				</html>