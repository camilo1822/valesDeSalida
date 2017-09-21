<%@ page import="jxl.*"%>
<%@ page import="jxl.write.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="application/vnd.ms-excel"
	pageEncoding="ISO-8859-1"%>
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
								<th colspan="3">VALE</th>
								<th colspan="3">Diligenciado / Autorizado por</th>
								<th colspan="3">Motivo</th>
								<th colspan="6">Justificacion</th>
								<th colspan="3">Proveedor</th>
								<th colspan="3">Nit</th>
								<th colspan="3">Empresa</th>
								<th colspan="3">Direccion</th>
								<th colspan="3">Nombre Contacto</th>
								<th colspan="3">Telefono</th>
								<th colspan="3">Ciudad</th>
								<th colspan="3">Nombre</th>
								<th colspan="3">CC</th>
								<th colspan="3">Empresa de Transporte</th>
								<th colspan="3">Placa vehiculo</th>

								<th colspan="1">Fila</th>
								<th colspan="2">Codigo</th>
								<th colspan="2">Centro</th>
								<th colspan="5">Descripcion</th>
								<th colspan="1">Cantidad</th>
								<th colspan="2">Vlr Unitario</th>
								<th colspan="2">Vlr Estimado</th>
								<th colspan="2">UM</th>
								<th colspan="2">Peso</th>
								<th colspan="2">Pertenece Maq.</th>
								<th colspan="2">OC servicio</th>
								<th colspan="2">OC adquisicion</th>
								<th colspan="2">Fecha regreso</th>

							</tr>
						</table>
						<c:forEach items="${model.vales}" var="i" varStatus="j">					
									<c:forEach items="${model.detVal}" var="l" varStatus="m">
										<c:if test="${i.getIdVale()eq l.getVale().getIdVale()}">
											<table style ="BORDER: #000000  solid">

												<tr>
												<td colspan="3" align='center'><c:out value="${i.getIdVale()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getNombreDiligencio()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getMotivo()}" /></td>
												<td colspan="6" align='center'><c:out value="${i.getJustificacion()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getDestinoProveedor()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getDestinoNit()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getDestinoEmpresa()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getDestinoDireccion()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getDestinoNombre()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getDestinoTel()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getDestinoCiudad()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getRetiraNombre()}" /></td>
												<td colspan="3"align='center'><c:out
														value="${i.getRetiraIdentificacion()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getRetiraEmpresa()}" /></td>
												<td colspan="3" align='center'><c:out value="${i.getRetiraPlaca()}" /></td>
	

												<td colspan="1" align="center" ><c:out
														value="${l.getFila()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getCodigo()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getCentro()}" /></td>
												<td colspan="5" align='center' ><c:out
														value="${l.getDescripcion()}" /></td>
												<td colspan="1" align='center' ><c:out
														value="${l.getCantidad()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getValorUni()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getValor()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getUnidad()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getPeso()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getPerteneceMaquina()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getNoOc()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getOcAd()}" /></td>
												<td colspan="2" align='center' ><c:out
														value="${l.getFechaEsperada()}" /></td>
													</tr>
												</table>

										</c:if>
									</c:forEach>

						




						</c:forEach>
					</tbody>

				</body>
				</html>