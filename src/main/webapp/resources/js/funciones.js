var __jquery = jQuery.noConflict();

__jquery(document).ready(function() {
	onReadyPortal(__jquery)
});

function onReadyPortal(__jquery) {
	if (__jquery(".inputLogin").length) {
		escape();
	}

	if (__jquery("#salidaMaterialesForm").length) {
		enter();
		callToolTipList();
		sendDate();
		CallPicker();
		valorEstimado();
		validaObligacion();
		validaObligacionTabla();
	}
	if (__jquery("#listaForm").length) {
		CallPicker1();
	}

	if (__jquery(".porteria").length) {
		var nameport = jQuery("#getPorteria").val();
		if (nameport != "") {
			__jquery(".submit2").css("display", "none");
		}
	}

	if (__jquery(".vistaPorterias").length) {
		var x = 1;
		while (null != jQuery("#fila" + x).val()
				&& jQuery("#fila" + x).val() != '') {
			var centro = jQuery("#centroId" + x).val();
			centro = centro.trim();
			if (centro == 'CO05' || centro == 'CO06' || centro == 'CO12'
					|| centro == 'CO60' || centro == 'CO61' || centro == 'CO10') {
				__jquery(".portsNoCol").css("display", "none");
				__jquery(".portsCol").css("display", "block");
				__jquery(".btnCol").css("display", "block");
				if (centro == 'CO05') {
					__jquery(".centro05").css("display", "block");
				} else if (centro == 'CO06') {
					__jquery(".centro06").css("display", "block");
				} else if (centro == 'CO12') {
					__jquery(".centro12").css("display", "block");
				} else if (centro == 'CO60' || centro == 'CO61') {
					__jquery(".centro60").css("display", "block");
				} else {
					__jquery(".centro10").css("display", "block");
				}
			} else {
				__jquery(".portsNoCol").css("display", "block");
				__jquery(".portsCol").css("display", "none");
				__jquery(".btnCol2").css("display", "block");
			}
			x++;
		}
	}

	if (__jquery("#formularioLogin").length) {
		var user = localStorage.getItem("usuario");
		var correo = localStorage.getItem("correo");
		document.getElementById("credencialCorreo").value = localStorage
				.getItem("correo");
		document.getElementById("credencial").value = localStorage
				.getItem("usuario");
		if (localStorage.getItem("correo") == null) {
			__jquery("#myModal").modal();
			escape();
		} else {
			__jquery("#bodyLogin").css("display", "none");
			logeando(user, correo);
		}
	}

	if (__jquery("#formularioLoginAprobar").length) {
		var user = localStorage.getItem("usuario");
		var correo = localStorage.getItem("correo");
		document.getElementById("credencialCorreo").value = localStorage
				.getItem("correo");
		document.getElementById("credencial").value = localStorage
				.getItem("usuario");
		if (localStorage.getItem("correo") == null) {
			__jquery("#myModal").modal();
		} else {
			__jquery("#bodyLogin").css("display", "none");
			var nameJefe = jQuery("#nameJefe").val();
			var nameAlm = jQuery("#nameAlm").val();
			if (user.trim() == nameJefe && nameAlm == "") {
				__jquery(".bloqueados").css("display", "block");
				__jquery(".mensaje").css("display", "none");
			} else {
				__jquery(".mensaje").css("display", "block");
				__jquery(".visualizar").attr("style",
						"margin-left: 50% !important");
			}
			logeandoAprobar(user, correo);
		}
	}

	if (__jquery("#formularioLoginVale").length) {
		var user = localStorage.getItem("usuario");
		var correo = localStorage.getItem("correo");
		document.getElementById("credencialCorreo").value = localStorage
				.getItem("correo");
		document.getElementById("credencial").value = localStorage
				.getItem("usuario");
		if (localStorage.getItem("correo") == null) {
			__jquery("#myModal").modal();
		} else {
			__jquery("#bodyLogin").css("display", "none");
			logeandoVale(user, correo);
		}
	}

	if (__jquery("#formVale").length) {
		validarCorreo();
		botonGuardar();
	}

	if (__jquery(".valeDetail").length) {
		var x = __jquery("#nameJef").val();
		var y = __jquery("#nameAlm").val();
		var jefe = __jquery("#nameAlmJ").val();
		if (x == "" || y == "") {
			__jquery(".ocultarr").css("display", "none");
			__jquery(".apro").css("display", "block");
			if (localStorage.getItem("correo") != null) {
				__jquery("#modalPorteria").attr("style",
						"border: 18px solid white !important");
				__jquery("#modalPorteria").modal();
				if(x == ""){
					__jquery("#mensajeAprobacion").text("Vale sin aprobar("+jefe+")");
				}else{
					__jquery("#mensajeAprobacion").text("Vale sin aprobar("+x+")");
				}

			}

		}
	}

	if (__jquery("#valesSalidaForm1").length) {

		if (window.location.search == ""
				&& window.location.pathname == "/ValesDeSalida/lista") {
			numPaginas();
			numResultados();
		} else if (window.location.pathname == "/ValesDeSalida/filtro"
				|| window.location.pathname == "/ValesDeSalida/FiltroFecha"
				|| window.location.pathname == "/ValesDeSalida/FiltroCentro") {

		} else {
			__jquery(".paginate").paginga({
				itemsPerPage : obtenerIdUrl("page")
			})
			document.getElementById("numResultados").value = obtenerIdUrl("page");
			numPaginas();
			numResultados();
		}
		numPaginas();
		numResultados();
	}

}

var pdf = function() {
	var valor = jQuery("#prueba").val();
	__jquery.ajax({
		url : "/ValesDeSalida/verPdf",
		data : {
			idValePdf : valor
		},
		type : "POST",
		async : false,
		success : function(evt) {

		}
	});
}

var redirectAprobar = function() {
	var x = __jquery("#nameJef").val();
	var y = __jquery("#nameAlm").val();
	var jefe = __jquery("#nameAlmJ").val();
	jefe = jefe.trim();
	x = x.trim();
	y = y.trim();
	var num = __jquery("#valeNum").val();
	var user = localStorage.getItem("usuario");
	user = user.trim();
	if (x == "") {
		if (user == jefe) {
			window.location = "http://danae:8081/ValesDeSalida/aprobarJ?valorFiltrado="
					+ num;
		} else {

		}

	} else if (y == "") {
		if (user == x) {
			window.location = "http://danae:8081/ValesDeSalida/aprobar?valorFiltrado="
					+ num;
		} else {

		}

	}
}

var pdfLista = function(x) {
	var valor = x.toString();
	__jquery.ajax({
		url : "/ValesDeSalida/verPdf",
		data : {
			idValePdf : x
		},
		type : "POST",
		async : false,
		success : function(evt) {

		}
	});
}

var pdfBrowser = function() {
	var valor = jQuery("#prueba").val();
	window.open('verPdfBrowser?idValePdf=' + valor);
	__jquery.ajax({
		url : "/ValesDeSalida/verPdfBrowser",
		data : {
			idValePdf : valor
		},
		type : "POST",
		async : false,
		success : function(evt) {

		}
	});
}

var pdfListaBrowser = function(x) {
	var valor = x.toString();
	window.open('verPdfBrowser?idValePdf=' + x);
	__jquery.ajax({
		url : "/ValesDeSalida/verPdfBrowser",
		data : {
			idValePdf : x
		},
		type : "GET",
		async : false,
		success : function(evt) {

		}
	});
}

function guardarMaterial(x) {
	var fecProrroga = jQuery("#fecProrroga" + x).val();
	var fecFinal = jQuery("#fecFinal" + x).val();
	var portero = jQuery("#fecFinalPort" + x).val();
	var idVales = jQuery("#valeNum").val();
	var fila = jQuery("#fila" + x).val();
	var apro = jQuery("#varRecibido" + x).val();
	var correo = jQuery("#correoUsuario").val();
	var cantidad = jQuery("#cantidadMat" + x).val();
	var recibido = jQuery("#cantidadRecibido" + x).val();
	if (cantidad == recibido) {
		angular.element(document.getElementById('cantidadRecibido' + x))
				.scope().mostrarFecha();
		var dt = new Date();
		var month = dt.getMonth() + 1;
		var day = dt.getDate();
		var year = dt.getFullYear();
		fecFinal = year + '-' + month + '-' + day;
	}
	if (parseInt(recibido) > parseInt(cantidad)) {
		recibido = 0;
	}
	__jquery.ajax({
		url : "/ValesDeSalida/valeEditar",
		data : {
			idVal : idVales,
			idFila : fila,
			fecPro : fecProrroga,
			fecFin : fecFinal,
			valApro : apro,
			Correo : correo,
			Port : portero,
			Cantidad : recibido
		},
		type : "POST",
		async : false,
		success : function(evt) {

		}
	});
}

function guardarMaterial2(x) {
	var fecProrroga = jQuery("#fecProrroga" + x).val();
	var fecFinal = jQuery("#fecFinal" + x).val();
	var portero = jQuery("#fecFinalPort" + x).val();
	var idVales = jQuery("#valeNum").val();
	var fila = jQuery("#fila" + x).val();
	var apro = jQuery("#varRecibido" + x).val();
	var correo = jQuery("#correoUsuario").val();
	var cantidad = jQuery("#cantidadMat" + x).val();
	var recibido = jQuery("#cantidadRecibido" + x).val();
	if (cantidad == recibido) {
		angular.element(document.getElementById('cantidadRecibido' + x))
				.scope().mostrarFecha();
		var dt = new Date();
		var month = dt.getMonth() + 1;
		var day = dt.getDate();
		var year = dt.getFullYear();
		fecFinal = year + '-' + month + '-' + day;
	}
	if (parseInt(recibido) > parseInt(cantidad)) {
		recibido = 0;
	}
	__jquery.ajax({
		url : "/ValesDeSalida/valeEditar2",
		data : {
			idVal : idVales,
			idFila : fila,
			fecPro : fecProrroga,
			fecFin : fecFinal,
			valApro : apro,
			Correo : correo,
			Port : portero,
			Cantidad : recibido
		},
		type : "POST",
		async : false,
		success : function(evt) {

		}
	});
}

function enter() {
	__jquery('#salidaMaterialesForm').on('keyup keypress', function(e) {
		var keyCode = e.keyCode || e.which;
		if (keyCode === 13) {
			e.preventDefault();
			return false;
		}
	});
}

function escape() {
	__jquery('.inputLogin').on('keyup keypress keydown', function(e) {
		var keyCode = e.keyCode || e.which;
		if (keyCode === 27) {
			e.preventDefault();
			return false;
		}
	});
}

function numPaginas() {
	__jquery(".paginate").paginga({});

	__jquery(".paginate-page-2").paginga({
		page : 2
	});

	__jquery(".paginate-no-scroll").paginga({
		scrollToTop : false
	});
	var ultimaPag = jQuery(".pageNumbers a:last-child").html();
	var primeraPag = jQuery(".pageNumbers a.active").html();
	document.getElementById("numPags").value = "P\xe0gina " + primeraPag
			+ " de " + ultimaPag;
}

function pagSiguiente() {
	var ultimaPag = jQuery(".pageNumbers a:last-child").html();
	var pagActual = jQuery(".pageNumbers a.active").html();
	if (pagActual == ultimaPag) {
		var next = pagActual;
	} else {
		var next = parseInt(pagActual) + 1;
	}
	document.getElementById("numPags").value = "P\xe0gina " + next + " de "
			+ ultimaPag;
}

function pagAnterior() {
	var ultimaPag = jQuery(".pageNumbers a:last-child").html();
	var primeraPag = jQuery(".pageNumbers a:first-child").html();
	var pagActual = jQuery(".pageNumbers a.active").html();
	if (pagActual == primeraPag) {
		var next = pagActual;
	} else {
		var next = parseInt(pagActual) - 1;
	}
	document.getElementById("numPags").value = "P\xe0gina " + next + " de "
			+ ultimaPag;
}

function pagInicial() {
	var ultimaPag = jQuery(".pageNumbers a:last-child").html();
	var primeraPag = jQuery(".pageNumbers a:first-child").html();
	document.getElementById("numPags").value = "P\xe0gina " + primeraPag
			+ " de " + ultimaPag;
}

function pagFinal() {
	var ultimaPag = jQuery(".pageNumbers a:last-child").html();
	document.getElementById("numPags").value = "P\xe0gina " + ultimaPag
			+ " de " + ultimaPag;
}

function numResultados() {
	__jquery(document).delegate(
			".numResultados",
			'change',
			function() {
				window.location.href = "/ValesDeSalida/lista" + "?page="
						+ __jquery(".numResultados").val();
			});
}

function obtenerIdUrl(name) {
	try {
		var regexS = "[\\?&]" + name + "=([^&#]*)";
		var regex = new RegExp(regexS);
		var tmpURL = window.location.href;
		var results = regex.exec(tmpURL);
		if (results == null) {
			return "";
		} else {
			return results[1];
		}
	} catch (excepcion) {
		dispararExcepcion(excepcion, "interna.min.js", "obtenerIdUrl()");
	}
}

function recarga() {
	location.reload();
}

function salidaPort() {
	var numeroVale = jQuery("#numeroDeVale").val();
	var firma = jQuery("#firmaPorteria").val();
	__jquery.ajax({
		url : "/ValesDeSalida/firmaPorteria",
		data : {
			idValePdf : numeroVale,
			firmaPorteria : firma
		},
		type : "POST",
		async : false,
		success : function(evt) {

		}
	});
}

function salidaAlm() {
	var obligatorio = jQuery("#correoObligatorio").val();
	if (obligatorio != '') {
		var numeroVale = jQuery("#valeNum").val();
		var firma = jQuery("#almacenLogeado").val();
		var correo = jQuery("#credencialCorreo").val();
		
		var x = 1;
		while (null != jQuery("#fila" + x).val()
				&& jQuery("#fila" + x).val() != '') {
			var centro = jQuery("#centroId" + x).val();
			centro = centro.trim();
			if (centro == 'CO05' || centro == 'CO06' || centro == 'CO12'
					|| centro == 'CO60' || centro == 'CO61' || centro == 'CO10') {
				__jquery.ajax({
					url : "/ValesDeSalida/firmaAlmacen2",
					data : {
						correoRem : correo,
						correoPort : obligatorio,
						idValePdf : numeroVale,
						firmaAlmcen : firma
					},
					type : "POST",
					async : false,
					success : function(evt) {

					}
				});
				break;
			} else {
				__jquery.ajax({
					url : "/ValesDeSalida/firmaAlmacen",
					data : {
						correoRem : correo,
						correoPort : obligatorio,
						idValePdf : numeroVale,
						firmaAlmcen : firma
					},
					type : "POST",
					async : false,
					success : function(evt) {

					}
				});
				break;
			}
			x++;
		}		

		__jquery("#modalPorteria").attr("style",
				"border: 18px solid white !important");
		__jquery("#modalPorteria").modal();
	} else {
		__jquery(".obligatoriocorreoPorteria").css("display", "block");
	}
}

function salidaAlmJ() {
	var obligatorio = jQuery("#correoAlmacen").val();
	if (obligatorio != '') {
		var numeroVale = jQuery("#valeNum").val();
		var firma = jQuery("#almacenLogeado").val();
		var correo = jQuery("#credencialCorreo").val();
		__jquery.ajax({
			url : "/ValesDeSalida/correoJefe",
			data : {
				correoRem : correo,
				correoPort : obligatorio,
				idValePdf : numeroVale,
				firmaAlmcen : firma
			},
			type : "POST",
			async : false,
			success : function(evt) {

			}
		});
		__jquery("#modalPorteria").attr("style",
				"border: 18px solid white !important");
		__jquery("#modalPorteria").modal();
	} else {
		__jquery(".obligatoriocorreoPorteria").css("display", "block");
	}
}

function rechazar() {
	__jquery("#modalRechazo").attr("style",
			"border: 18px solid white !important");
	__jquery("#modalRechazo").modal();
	__jquery(".ocultar").attr("style", "display: block !important");
}

function coment(x) {
	__jquery("#modalRechazo").attr("style",
			"border: 18px solid white !important");
	__jquery("#modalRechazo").modal();
	__jquery(".ocultar").attr("style", "display: block !important");
	document.getElementById("idComentario").value = x;
	var id = "#textCom" + x;
	var comentario = jQuery(id).val();
	document.getElementById("justificacionRechazo").value = comentario;
}

function rechazado() {
	var numeroVale = jQuery("#valeNum").val();
	var firma = jQuery("#almacenLogeado").val();
	var correo = jQuery("#credencialCorreo").val();
	var cuerpo = jQuery("#justificacionRechazo").val();
	var remitente = jQuery("#credencialCorreo").val();
	__jquery.ajax({
		url : "/ValesDeSalida/rechazarVale",
		data : {
			correoRem : correo,
			idValePdf : numeroVale,
			firmaAlmcen : firma,
			cuerpoMsj : cuerpo,
			Remitente : remitente
		},
		type : "POST",
		async : false,
		success : function(evt) {
			window.location = "http://danae:8081/ValesDeSalida/lista";
		}
	});
	__jquery("#modalRechazo").modal('toggle');
	__jquery(".ocultar").attr("style", "display: none !important");
}

function envComentario() {
	var x = jQuery("#idComentario").val();
	var idVales = jQuery("#valeNum").val();
	var fila = jQuery("#fila" + x).val();
	var com = jQuery("#justificacionRechazo").val();
	var nom = "textCom" + x;
	document.getElementById(nom).value = com;
	__jquery.ajax({
		url : "/ValesDeSalida/saveComent",
		data : {
			idVal : idVales,
			idFila : fila,
			comentario : com
		},
		type : "POST",
		async : false,
		success : function(evt) {
			__jquery("#modalRechazo").modal('toggle');
		}
	});
}

function callToolTip() {
	setTimeout(showToolTip, 100);
	var x = __jquery("#nroFilas").val();
	setTimeout(function() {
		llenarTabla(x);
	}, 100);
}

function showToolTip() {
	__jquery("input.showTool").hover(function() {
		var tam = jQuery("#nroFilasTotales").val();
		for (i = 1; i < tam; i++) {
			var nom = "contenidoDescrip" + i;
			if (document.getElementById(nom) != null) {
				document.getElementById(nom).title = __jquery(this).val();
			}
		}
	});
	llevarFecha();
}

function callToolTipList() {
	setTimeout(toolTipList, 100);
}

function toolTipList() {
	__jquery("input.toolList").hover(function() {
		var tam = jQuery("#numFilass").text();
		for (i = 1; i <= tam; i++) {
			var nom = "descriList" + i;
			document.getElementById(nom).title = __jquery(this).val();
		}
	});
}

function llevarFecha() {
	var numero = __jquery("#nroFilas").val() - 1;
	var fec = "fecha" + numero;
	var valor = __jquery("#datepicker").val();
	if (valor != null) {
		document.getElementById(fec).value = valor;
	}
}

function CallPicker() {
	setTimeout(picker, 500);
}

function listaPorteros1() {
	setTimeout(listaPorteros, 1000);
}

function listaAlmacenes1() {
	setTimeout(listaAlmacenistas, 1000);
}

function picker() {

	__jquery(".datepicker").datepicker({
		dateFormat : 'dd/mm/yy',
		minDate : new Date()
	});
	var valor = __jquery("#datepicker").val();
	if (valor != null) {
		var fullDate = new Date()
		var twoDigitMonth = fullDate.getMonth() + 1;
		if (twoDigitMonth < 10) {
			twoDigitMonth = '0' + twoDigitMonth;
		}
		var currentDate = fullDate.getDate() + "/" + twoDigitMonth + "/"
				+ fullDate.getFullYear();
		document.getElementById("datepicker").value = currentDate;
	}

}

function CallPicker1() {
	setTimeout(picker1, 100);
}

function picker1() {
	__jquery(".datepicker").datepicker({
		dateFormat : 'dd/mm/yy'
	});
	var valor = __jquery("#fecFiltro").val();
	if (valor != null) {
		var fullDate = new Date()
		var twoDigitMonth = fullDate.getMonth() + 1;
		if (twoDigitMonth < 10) {
			twoDigitMonth = '0' + twoDigitMonth;
		}
		var currentDate = fullDate.getDate() + "/" + twoDigitMonth + "/"
				+ fullDate.getFullYear();
		document.getElementById("fecFiltro").value = currentDate;
	}

}

function sendDate() {
	setTimeout(dateSperada, 500);
}

function dateSperada() {
	var valor = __jquery("#datepicker").val();
	if (valor != null) {
		var fullDate = new Date()
		var twoDigitMonth = fullDate.getMonth() + 1;
		if (twoDigitMonth < 10) {
			twoDigitMonth = '0' + twoDigitMonth;
		}
		var currentDate = fullDate.getDate() + "/" + twoDigitMonth + "/"
				+ fullDate.getFullYear();
		document.getElementById("datepicker").value = currentDate;
	}
}

var deleteVales = function(x) {
	var valor = x.toString();
	__jquery.ajax({
		url : "/ValesDeSalida/borrarVale",
		data : {
			idVale : x
		},
		type : "POST",
		async : false,
		success : function(evt) {
		}
	});
}

var verificarDatos = function() {
	var nombre = __jquery("#usrname").val();
	var pass = __jquery("#psw").val();
	if (nombre.indexOf("@") != -1) {
		__jquery
				.ajax({
					url : "/ValesDeSalida/conectionLdap",
					data : {
						Usuario : nombre,
						Password : pass
					},
					type : "POST",
					async : false,
					success : function(evt) {
						if (evt.indexOf("fallido") != -1) {
							__jquery("#verifiDatos").css("display", "block");
						} else {
							__jquery("#myModal").modal('toggle');
							var r = evt.split("[").toString();
							var s = r.split("]").toString();
							var m = s.split(",");
							document.getElementById("correoUsuario").value = m[1];
							document.getElementById("nameUsuario").value = m[2];
							document.getElementById("solicitanteLogeado").value = m[2];
							document.getElementById("diligenciadoPor").value = m[2];
							document.getElementById("plantaUsuario").value = m[3];
							localStorage.setItem("correo", m[1]);
							localStorage.setItem("usuario", m[2]);
							localStorage.setItem("planta", m[3]);
							document.getElementById("credencialCorreo").value = localStorage
									.getItem("correo");
							document.getElementById("credencial").value = localStorage
									.getItem("usuario");
							validarSolicitante(m[2]);
						}
					}
				});
	} else {
		__jquery("#verifiDatos").css("display", "block");
	}

}

var aprobarDatos = function() {
	var nombre = __jquery("#usrname").val();
	var pass = __jquery("#psw").val();
	if (nombre.indexOf("@") != -1) {
		__jquery
				.ajax({
					url : "/ValesDeSalida/conectionLdap",
					data : {
						Usuario : nombre,
						Password : pass
					},
					type : "POST",
					async : false,
					success : function(evt) {
						if (evt.indexOf("fallido") != -1) {
							__jquery("#verifiDatos").css("display", "block");
						} else {
							__jquery("#myModal").modal('toggle');
							var r = evt.split("[").toString();
							var s = r.split("]").toString();
							var m = s.split(",");
							document.getElementById("correoUsuario").value = m[1];
							document.getElementById("nameUsuario").value = m[2];
							document.getElementById("almacenLogeado").value = m[2];
							document.getElementById("plantaUsuario").value = m[3];
							localStorage.setItem("correo", m[1]);
							localStorage.setItem("usuario", m[2]);
							localStorage.setItem("planta", m[3]);
							document.getElementById("credencialCorreo").value = localStorage
									.getItem("correo");
							document.getElementById("credencial").value = localStorage
									.getItem("usuario");
						}
						location.reload();
					}
				});
	} else {
		__jquery("#verifiDatos").css("display", "block");
	}

}

function validarCorreo() {
	var pass = __jquery("#correoUsuario").val();
	var correo = __jquery("#correoFiltrado").val();
	var ciclo = __jquery("#numFilass").text();
	if (correo == pass) {
		for (var i = 1; i <= ciclo; i++) {
			var nom = "checkRecibido1" + i;
			document.getElementById(nom).disabled = false;
		}
	} else {
		for (var i = 1; i <= ciclo; i++) {
			var nom = "checkRecibido1" + i;
			document.getElementById(nom).disabled = true;
		}
	}
}

var valeDatos = function() {
	var nombre = __jquery("#usrname").val();
	var pass = __jquery("#psw").val();
	if (nombre.indexOf("@") != -1) {
		__jquery
				.ajax({
					url : "/ValesDeSalida/conectionLdap",
					data : {
						Usuario : nombre,
						Password : pass
					},
					type : "POST",
					async : false,
					success : function(evt) {
						if (evt.indexOf("fallido") != -1) {
							__jquery("#verifiDatos").css("display", "block");
						} else {
							__jquery("#myModal").modal('toggle');
							var r = evt.split("[").toString();
							var s = r.split("]").toString();
							var m = s.split(",");
							document.getElementById("correoUsuario").value = m[1];
							document.getElementById("nameUsuario").value = m[2];
							document.getElementById("plantaUsuario").value = m[3];
							localStorage.setItem("correo", m[1]);
							localStorage.setItem("usuario", m[2]);
							document.getElementById("credencialCorreo").value = localStorage
									.getItem("correo");
							document.getElementById("credencial").value = localStorage
									.getItem("usuario");
							localStorage.setItem("planta", m[3]);
							var correo = __jquery("#correoFiltrado").val();
							var ciclo = __jquery("#numFilass").text();
							if (correo == m[1]) {
								for (var i = 1; i <= ciclo; i++) {
									var nom = "checkRecibido1" + i;
									document.getElementById(nom).disabled = false;
								}
							} else {
								for (var i = 1; i <= ciclo; i++) {
									var nom = "checkRecibido1" + i;
									document.getElementById(nom).disabled = true;
								}
							}
							validarAprobador(m[2]);
						}
					}
				});
	} else {
		__jquery("#verifiDatos").css("display", "block");
	}

}

var obtenerProveedor = function() {
	var proveedor = __jquery("#codProveedor").val();
	var cond = validaProv(proveedor);
	if (cond == true) {
		__jquery.ajax({
			url : "/ValesDeSalida/retornaProveedor",
			data : {
				CodProveedor : proveedor
			},
			type : "POST",
			async : false,
			success : function(evt) {
				var l = evt.split("?");
				for (var j = 1; j < l.length; j++) {
					if (l[j].length < 3) {
						l.splice(j, 1);
					}
				}
				document.getElementById("codProveedor").value = l[1];
				document.getElementById("nitSAP").value = parseInt(l[2]);
				document.getElementById("nombreSAP").value = l[3];
				document.getElementById("direccionSAP").value = l[4];
				document.getElementById("telefonoSAP").value = l[5];
				document.getElementById("nombresSAP").value = l[6];
				document.getElementById("ciudadSAP").value = l[7];
			}
		});
	} else {
		document.getElementById("codProveedor").value = "";
		__jquery("#errorModal").attr("style",
				"border: 18px solid white !important");
		__jquery("#errorModal").modal();
	}
	validaCampoObligatorios();
}

var obtenerEmpresa = function(x) {
	var nombre = x;
	__jquery.ajax({
		url : "/ValesDeSalida/retornaProveedorNom",
		data : {
			nombreProv : nombre
		},
		type : "POST",
		async : false,
		success : function(evt) {
			var l = evt.split("?");
			for (var j = 1; j < l.length; j++) {
				if (l[j].length < 3) {
					l.splice(j, 1);
				}
			}
			var sinSpace = l[1].trim();
			document.getElementById("codProveedor").value = sinSpace;
			document.getElementById("nitSAP").value = parseInt(l[2]);
			document.getElementById("nombreSAP").value = l[3];
			document.getElementById("direccionSAP").value = l[4];
			document.getElementById("telefonoSAP").value = l[5];
			document.getElementById("nombresSAP").value = l[6];
			document.getElementById("ciudadSAP").value = l[7];
			var cond = validaProv(sinSpace);
			if (cond == true) {
				obtenerProveedor();
			}

		}
	});
	validaCampoObligatorios();
}

var obtenerNit = function(x, y) {
	var nit = x;
	var sociedad = y;
	__jquery.ajax({
		url : "/ValesDeSalida/retornaProveedorNit",
		data : {
			nitProv : nit,
			sociedadProv : sociedad
		},
		type : "POST",
		async : false,
		success : function(evt) {
			var l = evt.split("?");
			for (var j = 1; j < l.length; j++) {
				if (l[j].length < 3) {
					l.splice(j, 1);
				}
			}
			var sinSpace = l[1].trim();
			document.getElementById("codProveedor").value = sinSpace;
			document.getElementById("nitSAP").value = parseInt(l[2]);
			document.getElementById("nombreSAP").value = l[3];
			document.getElementById("direccionSAP").value = l[4];
			document.getElementById("telefonoSAP").value = l[5];
			document.getElementById("nombresSAP").value = l[6];
			document.getElementById("ciudadSAP").value = l[7];
			var cond = validaProv(sinSpace);
			if (cond == true) {
				obtenerProveedor();
			}

		}
	});
	validaCampoObligatorios();
}

function mostrarLista() {
	__jquery(".listaEmpresas div").remove();
	var nombre = __jquery("#nombreSAP").val();
	if (nombre.indexOf('*') != -1) {
		__jquery
				.ajax({
					url : "/ValesDeSalida/retornaProveedorLista",
					data : {
						nombreProveedor : nombre
					},
					type : "POST",
					async : false,
					success : function(evt) {
						var r = evt.split("[").toString();
						var s = r.split("]").toString();
						var m = s.split("?");
						var d = m.unique();

						for (var j = 1; j < d.length; j++) {
							if (d[j].length < 3) {
								d.splice(j, 1);
							}
						}
						for (var i = 1; i < d.length - 1; i++) {
							var ht = "<div class=\"bordeSel selectLista\" onclick=\"obtenerEmpresa("
									+ "\'"
									+ d[i]
									+ "\'"
									+ ")\">"
									+ d[i]
									+ "</div>"
							__jquery(".listaEmpresas").append(ht);
						}
						__jquery(".bordeSel").on("click", function() {
							if (__jquery(".colorSel").length) {
								__jquery(".colorSel").removeClass("colorSel");
								__jquery(this).addClass("colorSel");
							} else {
								__jquery(this).addClass("colorSel");
							}
						});
					}
				});
	} else {
		var cond = validaEmpresa(nombre);
		if (cond == true) {
			var ht = "<div class=\"bordeSel\" onclick=\"obtenerEmpresa(" + "\'"
					+ nombre + "\'" + ")\">" + nombre + "</div>"
			__jquery(".listaEmpresas").append(ht);
			__jquery.ajax({
				url : "/ValesDeSalida/retornaProveedorNom",
				data : {
					nombreProv : nombre
				},
				type : "POST",
				async : false,
				success : function(evt) {
					var l = evt.split("?");
					for (var j = 1; j < l.length; j++) {
						if (l[j].length < 3) {
							l.splice(j, 1);
						}
					}
					document.getElementById("codProveedor").value = l[1];
					document.getElementById("nitSAP").value = parseInt(l[2]);
					document.getElementById("nombreSAP").value = l[3];
					document.getElementById("direccionSAP").value = l[4];
					document.getElementById("telefonoSAP").value = l[5];
					document.getElementById("nombresSAP").value = l[6];
					document.getElementById("ciudadSAP").value = l[7];
				}
			});
		} else {
			var ht = "<div>No se encontro informacion</div>"
			__jquery(".listaEmpresas").append(ht);
		}

	}
}

function mostrarListaNit() {
	__jquery(".listaEmpresas div").remove();
	var nit = __jquery("#nitSAP").val();
	var cond = validaNit(nit);
	if (cond == true) {
		__jquery.ajax({
			url : "/ValesDeSalida/retornaNitLista",
			data : {
				nitProveedor : nit
			},
			type : "POST",
			async : false,
			success : function(evt) {
				var r = evt.split("[").toString();
				var s = r.split("]").toString();
				var d = s.split("?");
				// var d = m.unique();
				for (var j = 1; j < d.length; j++) {
					if (d[j].length < 3) {
						d.splice(j, 1);
					}
				}
				for (var i = 1; i < d.length - 2; i += 2) {
					var ht = "<div class=\"bordeSel\" onclick=\"obtenerNit("
							+ "\'" + nit + "\'" + "," + "\'" + d[i] + "\'"
							+ ")\">" + "Sociedad: " + d[i] + ",  "
							+ "  Codigo: " + d[i + 1] + "</div>";
					__jquery(".listaEmpresas").append(ht);
				}
				__jquery(".bordeSel").on("click", function() {
					if (__jquery(".colorSel").length) {
						__jquery(".colorSel").removeClass("colorSel");
						__jquery(this).addClass("colorSel");
					} else {
						__jquery(this).addClass("colorSel");
					}
				});
			}
		});
	} else {
		var ht = "<div>No se encontro informacion</div>"
		__jquery(".listaEmpresas").append(ht);
	}

}

Array.prototype.unique = function(a) {
	return function() {
		return this.filter(a)
	}
}(function(a, b, c) {
	return c.indexOf(a, b + 1) < 0
});

function validaEmpresa(x) {
	var nombre = x;
	var bandera;
	__jquery.ajax({
		url : "/ValesDeSalida/existeEmpresa",
		data : {
			nombreProv : nombre
		},
		type : "POST",
		async : false,
		success : function(evt) {
			if (evt.indexOf("true") != -1) {
				bandera = false;
			} else {
				bandera = true;
			}
		}
	});
	return bandera;
}

function validaProv(x) {
	var nombre = x;
	var bandera;
	__jquery.ajax({
		url : "/ValesDeSalida/existeProveedor",
		data : {
			CodProveedor : nombre
		},
		type : "POST",
		async : false,
		success : function(evt) {
			if (evt.indexOf("true") != -1) {
				bandera = false;
			} else {
				bandera = true;
			}
		}
	});
	return bandera;
}

function validaNit(x) {
	var nombre = x;
	var bandera;
	__jquery.ajax({
		url : "/ValesDeSalida/existeNit",
		data : {
			nitProveedor : nombre
		},
		type : "POST",
		async : false,
		success : function(evt) {
			if (evt.indexOf("true") != -1) {
				bandera = false;
			} else {
				bandera = true;
			}
		}
	});
	return bandera;
}

function cerrarModal() {
	__jquery("#errorModal").modal('toggle');
}

function cerrarModalCentro() {
	__jquery("#centroObligatorio").modal('toggle');
}

function cerrarModalTodos() {
	__jquery("#todosObligatorio").modal('toggle');
}

function cerrarModalIncorrecto() {
	__jquery("#centroIncorrecto").modal('toggle');
}

function cerrarModalPorteria() {
	__jquery("#modalPorteria").modal('toggle');
	window.location = "http://danae:8081/ValesDeSalida/lista";
}

function cerrarModalPorteria1() {
	__jquery("#modalPorteria").modal('toggle');
}

function cerrarModalRechazado() {
	__jquery("#modalRechazo").modal('toggle');
}

function buscarMaterial() {
	var centro = __jquery("#centro").val();
	var codigo = __jquery("#codigoConsultar").val();
	var piciz = __jquery("#controladoPiciz").val();
	if (centro == "") {
		__jquery("#centroObligatorio").attr("style",
				"border: 18px solid white !important");
		__jquery("#centroObligatorio").modal();
	} else if ((piciz == "Si" && centro != "CO05")
			&& (piciz == "Si" && centro != "CO60")
			&& (piciz == "Si" && centro != "CO61")) {
		__jquery("#centroIncorrecto").attr("style",
				"border: 18px solid white !important");
		__jquery("#centroIncorrecto").modal();
	} else {
		var cond = validaMaterial(centro, codigo);
		if (cond == true) {
			__jquery
					.ajax({
						url : "/ValesDeSalida/obtenerMaterial",
						data : {
							centroMaterial : centro,
							codigoMaterial : codigo
						},
						type : "POST",
						async : false,
						success : function(evt) {
							var l = evt.split("?");
							for (var j = 1; j < l.length; j++) {
								if (l[j].length < 3) {
									l.splice(j, 1);
								}
							}
							document.getElementById("descripcionSAP").value = l[3];
							var numero = findAndReplace(l[4]);
							document.getElementById("vlrUnitarioSAP").value = parseInt(numero);
							document.getElementById("umSOAP").value = l[5];
						}
					});
			valorEstimado2();
			validaCampoObligatorios();
		} else {
			document.getElementById("codProveedor").value = "";
			__jquery("#errorModal").attr("style",
					"border: 18px solid white !important");
			__jquery("#errorModal").modal();
		}
	}
}

function msgError() {
	__jquery("#todosObligatorio").attr("style",
			"border: 18px solid white !important");
	__jquery("#todosObligatorio").modal();
}

function errorFaltantes() {
	__jquery("#faltantes").attr("style", "border: 18px solid white !important");
	__jquery("#faltantes").modal();
}

function buscarMaterialListaJS(x) {
	var NomCentro = "#centro" + x;
	var NomCodigo = "#codigoConsultar" + x;
	var centro = __jquery(NomCentro).val();
	var codigo = __jquery(NomCodigo).val();
	if (centro == "") {
		__jquery("#centroObligatorio").attr("style",
				"border: 18px solid white !important");
		__jquery("#centroObligatorio").modal();
	} else {
		var cond = validaMaterial(centro, codigo);
		if (cond == true) {
			__jquery.ajax({
				url : "/ValesDeSalida/obtenerMaterial",
				data : {
					centroMaterial : centro,
					codigoMaterial : codigo
				},
				type : "POST",
				async : false,
				success : function(evt) {
					var l = evt.split("?");
					for (var j = 1; j < l.length; j++) {
						if (l[j].length < 3) {
							l.splice(j, 1);
						}
					}
					var descri = "contenidoDescrip" + x;
					var vlr = "vlrUnitario" + x;
					var um = "umsoap" + x;
					document.getElementById(descri).value = l[3];
					var numero = findAndReplace(l[4]);
					document.getElementById(vlr).value = parseInt(numero);
					document.getElementById(um).value = l[5];
				}
			});
			valorEstimadoLista2(x);
		} else {
			__jquery("#errorModal").attr("style",
					"border: 18px solid white !important");
			__jquery("#errorModal").modal();
		}
	}
}

function findAndReplace(string) {
	var i = 0;
	length = string.length;
	for (i; i < length; i++) {
		string = string.replace(".", '');
	}
	return string;
}

function valorEstimado() {
	__jquery(document).delegate(".cantMat", 'change', function() {
		try {
			var x = __jquery("#cantMat").val();
			var y = __jquery("#vlrUnitarioSAP").val();
			var mult = x * y;
			document.getElementById("vlrEstimado").value = mult;
		} catch (excepcion) {
			dispararExcepcion(excepcion, "funciones.js", "valorEstimado");
		}
	});
}

function valorEstimado2() {
	try {
		var x = __jquery("#cantMat").val();
		var y = __jquery("#vlrUnitarioSAP").val();
		var mult = x * y;
		document.getElementById("vlrEstimado").value = mult;
	} catch (excepcion) {
		dispararExcepcion(excepcion, "funciones.js", "valorEstimado");
	}
}

function valorEstimadoLista2(x) {
	try {
		var nom = "#cantidad" + x;
		var nom2 = "#vlrUnitario" + x;
		var nom3 = "valor" + x;
		var x = __jquery(nom).val();
		var y = __jquery(nom2).val();
		var mult = x * y;
		document.getElementById(nom3).value = mult;
	} catch (excepcion) {
		dispararExcepcion(excepcion, "funciones.js", "valorEstimado2Lista");
	}
}

function llenarTabla(x) {
	var descripcion = __jquery("#descripcionSAP").val();
	var valrUnitario = __jquery("#vlrUnitarioSAP").val();
	var vlrEstimado = __jquery("#vlrEstimado").val();
	var um = __jquery("#umSOAP").val();
	var nomDescri = "contenidoDescrip" + x;
	var nomUni = "vlrUnitario" + x;
	var nomEsti = "valor" + x;
	var nomUm = "umsoap" + x;
	document.getElementById(nomDescri).value = descripcion;
	document.getElementById(nomUni).value = valrUnitario;
	document.getElementById(nomEsti).value = vlrEstimado;
	document.getElementById(nomUm).value = um;
	document.getElementById("vlrUnitarioSAP").value = "";
	document.getElementById("vlrEstimado").value = "NaN";
	document.getElementById("codigoConsultar").value = "0";
	document.getElementById("cantMat").value = "";
	document.getElementById("umSOAP").value = "";
	document.getElementById("peso").value = "";
	document.getElementById("descripcionSAP").value = "";
	document.getElementById("codigoConsultar").value = "";
}

function vlrEstimadoListaJQ(valor) {
	var nomCan = "#cantidad" + valor;
	var nomVlr = "#vlrUnitario" + valor;
	var nomVlrEst = "valor" + valor;
	var x = __jquery(nomCan).val();
	var y = __jquery(nomVlr).val();
	var mult = x * y;
	document.getElementById(nomVlrEst).value = mult;
}

function vlrEstimadoListaJQ1(valor) {
	var nomCan = "#cantidad" + valor;
	var nomVlr = "#vlrUnitario" + valor;
	var nomVlrEst = "valor" + valor;
	var x = __jquery(nomCan).val();
	var y = __jquery(nomVlr).val();
	var mult = x * y;
	document.getElementById(nomVlrEst).value = mult;
}

function validaMaterial(x, y) {
	var centro = x;
	var codigo = y;
	var bandera;
	__jquery.ajax({
		url : "/ValesDeSalida/existeMaterial",
		data : {
			codigoMaterial : codigo,
			centroMaterial : centro
		},
		type : "POST",
		async : false,
		success : function(evt) {
			if (evt.indexOf("true") != -1) {
				bandera = false;
			} else {
				bandera = true;
			}
		}
	});
	return bandera;
}

function mostrarAlmacenistas() {
	__jquery(".listaAlmacenistas div").remove();
	var nombre = __jquery("#lugarAprobante").val();
	__jquery
			.ajax({
				url : "/ValesDeSalida/aprobadoresLdap",
				data : {
					lugarAlmacenista : nombre
				},
				type : "POST",
				async : false,
				success : function(evt) {
					var r = evt.split("[").toString();
					var s = r.split("]").toString();
					var m = s.split("?");
					var d = m.unique();

					for (var j = 1; j < d.length; j++) {
						if (d[j].length < 3) {
							d.splice(j, 1);
						}
					}
					for (var i = 1; i < d.length - 1; i++) {
						var ht = "<div class=\"bordeSel selectLista\" onclick=\"llevarAlmacenista("
								+ "\'" + d[i] + "\'" + ")\">" + d[i] + "</div>"
						__jquery(".listaAlmacenistas").append(ht);
					}
					__jquery(".bordeSel").on("click", function() {
						if (__jquery(".colorSel").length) {
							__jquery(".colorSel").removeClass("colorSel");
							__jquery(this).addClass("colorSel");
						} else {
							__jquery(this).addClass("colorSel");
						}
					});
				}
			});
}

function llevarAlmacenista(x) {
	document.getElementById("correoAlmacen").value = x;
}

function mailPorteria() {
	__jquery(".listaPorteros div").remove();
	var nombre = __jquery("#lugarPorteria").val();
	__jquery.ajax({
		url : "/ValesDeSalida/porteriasLdap",
		data : {
			lugarPorteria : nombre
		},
		type : "POST",
		async : false,
		success : function(evt) {
			var r = evt.split("[").toString();
			var s = r.split("]").toString();
			var m = s.split("?");
			var d = m.unique();

			for (var j = 1; j < d.length; j++) {
				if (d[j].length < 3) {
					d.splice(j, 1);
				}
			}
			for (var i = 1; i < d.length - 1; i++) {
				var ht = "<div class=\"bordeSel\" onclick=\"llevarPorteria("
						+ "\'" + d[i] + "\'" + ")\">" + d[i] + "</div>"
				__jquery(".listaPorteros").append(ht);
			}
			__jquery(".bordeSel").on("click", function() {
				if (__jquery(".colorSel").length) {
					__jquery(".colorSel").removeClass("colorSel");
					__jquery(this).addClass("colorSel");
				} else {
					__jquery(this).addClass("colorSel");
				}
			});
		}
	});
}

function mailPorteria2() {
	var y = __jquery("#lugarPorteria2").val();
	var x = document.getElementById("correoObligatorio");
	x.value = y;
}

function listaPorteros() {
	var nombre = __jquery("#nameUsuario").val();
	var ciclo = __jquery("#numFilass").text();
	for (var i = 1; i <= ciclo; i++) {
		var nom = "checkRecibidoPort" + i;
		document.getElementById(nom).disabled = true;
	}
	__jquery.ajax({
		url : "/ValesDeSalida/aprobadoresPorteriaLdap",
		data : {},
		type : "POST",
		async : false,
		success : function(evt) {
			var r = evt.split("[").toString();
			var s = r.split("]").toString();
			var m = s.split("?");
			var d = m.unique();

			for (var j = 1; j < d.length; j++) {
				if (d[j].length < 3) {
					d.splice(j, 1);
				}
			}
			for (var i = 1; i < d.length - 1; i++) {
				nombre = nombre.trim();
				if (nombre == d[i]) {
					__jquery("#conPort").attr("style",
							"display: block !important");
					__jquery("#sinPort").attr("style",
							"display: none !important");

					for (var i = 1; i <= ciclo; i++) {
						var nom = "checkRecibidoPort" + i;
						document.getElementById(nom).disabled = false;
					}
					break;
				} else {
					__jquery("#conPort").attr("style",
							"display: none !important");

				}
			}

		}
	});
}

function listaAlmacenistas() {
	var nombre = __jquery("#nameUsuario").val();
	var ciclo = __jquery("#numFilass").text();
	document.getElementById("btnRecha").disabled = true;
	__jquery.ajax({
		url : "/ValesDeSalida/aprobadoresAlmacenLdap",
		data : {},
		type : "POST",
		async : false,
		success : function(evt) {
			var r = evt.split("[").toString();
			var s = r.split("]").toString();
			var m = s.split("?");
			var d = m.unique();

			for (var j = 1; j < d.length; j++) {
				if (d[j].length < 3) {
					d.splice(j, 1);
				}
			}
			for (var i = 1; i < d.length - 1; i++) {
				nombre = nombre.trim();
				if (nombre == d[i]) {
					document.getElementById("btnRecha").disabled = false;
					break;
				} else {
					document.getElementById("btnRecha").disabled = true;

				}
			}

		}
	});
}

function botonGuardar() {
	var nombre = __jquery("#nameUsuario").val();
	var ciclo = __jquery("#numFilass").text();
	__jquery
			.ajax({
				url : "/ValesDeSalida/aprobadoresPorteriaLdap",
				data : {},
				type : "POST",
				async : false,
				success : function(evt) {
					var r = evt.split("[").toString();
					var s = r.split("]").toString();
					var m = s.split("?");
					var d = m.unique();

					for (var j = 1; j < d.length; j++) {
						if (d[j].length < 3) {
							d.splice(j, 1);
						}
					}
					for (var i = 1; i <= d.length - 1; i++) {
						nombre = nombre.trim();
						if (nombre == d[i]) {

							for (var l = 1; l <= ciclo; l++) {
								var nom = "#conPort" + l;
								var nom1 = "#sinPort" + l;
								__jquery(nom).attr("style",
										"display: block !important");
								__jquery(nom1).attr("style",
										"display: none !important");
							}
							break;
						} else {
							for (var m = 1; m <= ciclo; m++) {
								var nom = "#conPort" + m;
								var nom1 = "#sinPort" + m;
								__jquery(nom).attr("style",
										"display: none !important");
								__jquery(nom1).attr("style",
										"display: block !important");
							}

						}
					}

				}
			});
}

function llevarPorteria(x) {
	document.getElementById("correoObligatorio").value = x;
	__jquery(".obligatoriocorreoPorteria").css("display", "none");
}

function validarSolicitante(x) {
	x = x.substring(1);
	__jquery
			.ajax({
				url : "/ValesDeSalida/solicitantesLdap",
				data : {
					Solicitante : x
				},
				type : "POST",
				async : false,
				success : function(evt) {
					if (evt.indexOf("si") == -1) {
						__jquery("#Guardar1").attr("style",
								"display: none !important");
						__jquery("#Guardar").attr("style",
								"display: none !important");
					}
				}
			});
}

function validarAprobador(x) {
	x = x.substring(1);
	var ciclo = __jquery("#numFilass").text();
	__jquery.ajax({
		url : "/ValesDeSalida/aprobadorLdap",
		data : {
			Aprobador : x
		},
		type : "POST",
		async : false,
		success : function(evt) {
			if (evt.indexOf("si") == -1) {
				window.location = "http://danae:8081/ValesDeSalida/lista";
			}
		}
	});
}

function obligatoriedad() {
	camposTexto = document.querySelectorAll(".obligatoriedad");
	var nombre = "obligatorio";
	var cont = 0;
	for (var i = 0; i < camposTexto.length; i++) {
		if (camposTexto[i].value == '') {
			var identi = "." + nombre + camposTexto[i].id;
			__jquery(identi).css("display", "block");
			cont += 1;
		}
	}
	if (cont == 0) {
		return "si";
	} else {
		msgError();
		return "no";
	}
}

function validaObligacion() {
	__jquery(document).delegate(".obligatoriedad", 'change', function() {
		camposTexto = document.querySelectorAll(".obligatoriedad");
		var nombre = "obligatorio";
		for (var i = 0; i < camposTexto.length; i++) {
			if (camposTexto[i].value != '') {
				var identi = "." + nombre + camposTexto[i].id;
				__jquery(identi).css("display", "none");
			}
		}
	});
}

function validaCampoObligatorios() {
	camposTexto = document.querySelectorAll(".obligatoriedad");
	var nombre = "obligatorio";
	for (var i = 0; i < camposTexto.length; i++) {
		if (camposTexto[i].value != '') {
			var identi = "." + nombre + camposTexto[i].id;
			__jquery(identi).css("display", "none");
		}
	}

	camposTabla = document.querySelectorAll(".obligacionTabla");
	var nombre1 = "obligatoriedad";
	for (var j = 0; j < camposTabla.length; j++) {
		if (camposTabla[j].value != '') {
			var identi = "." + nombre1 + camposTabla[j].id;
			__jquery(identi).css("display", "none");
		}
	}
}

function obligatoriedadTabla() {
	camposTabla = document.querySelectorAll(".obligacionTabla");
	var nombre = "obligatoriedad";
	var cont = 0;
	var centro = __jquery("#centroSelect").val();
	if(centro == "? undefined:undefined ?"){
		return "no";
	}
	for (var i = 0; i < camposTabla.length; i++) {
		if (camposTabla[i].value == '') {
			var identi = "." + nombre + camposTabla[i].id;
			__jquery(identi).css("display", "block");
			cont += 1;
		}
	}
	if (cont == 0) {

		return "si";
	} else {
		return "no";
	}
}

function validaObligacionTabla() {
	__jquery(document).delegate(".obligacionTabla", 'change', function() {
		camposTabla = document.querySelectorAll(".obligacionTabla");
		var nombre = "obligatoriedad";
		for (var i = 0; i < camposTabla.length; i++) {
			if (camposTabla[i].value != '') {
				var identi = "." + nombre + camposTabla[i].id;
				__jquery(identi).css("display", "none");
			}
		}
	});
}

function convMayusculas() {
	var x = document.getElementById("centro");
	x.value = x.value.toUpperCase();
}

function convMayusculasLista(x) {
	var nombre = "centro" + x;
	var x = document.getElementById(nombre);
	x.value = x.value.toUpperCase();
}

function logeando(x, y) {
	document.getElementById("correoUsuario").value = y;
	document.getElementById("nameUsuario").value = x;
	document.getElementById("solicitanteLogeado").value = x;
	document.getElementById("diligenciadoPor").value = x;
	document.getElementById("credencialCorreo").value = localStorage
			.getItem("correo");
	document.getElementById("credencial").value = localStorage
			.getItem("usuario");
	document.getElementById("plantaUsuario").value = localStorage
			.getItem("planta");
}

function logeandoVale(x, y) {
	document.getElementById("correoUsuario").value = y;
	document.getElementById("nameUsuario").value = x;
	var correo = __jquery("#correoFiltrado").val();
	document.getElementById("credencialCorreo").value = localStorage
			.getItem("correo");
	document.getElementById("credencial").value = localStorage
			.getItem("usuario");
	var ciclo = __jquery("#numFilass").text();
	if (correo == y) {
		for (var i = 1; i <= ciclo; i++) {
			var nom = "checkRecibido1" + i;
			document.getElementById(nom).disabled = false;
		}
	} else {
		for (var i = 1; i <= ciclo; i++) {
			var nom = "checkRecibido1" + i;
			document.getElementById(nom).disabled = true;
		}
	}
}

function logeandoAprobar(x, y) {
	document.getElementById("correoUsuario").value = y;
	document.getElementById("nameUsuario").value = x;
	document.getElementById("almacenLogeado").value = x;
	document.getElementById("credencialCorreo").value = localStorage
			.getItem("correo");
	document.getElementById("credencial").value = localStorage
			.getItem("usuario");
}

function logout() {
	localStorage.clear();
	location.reload();
}