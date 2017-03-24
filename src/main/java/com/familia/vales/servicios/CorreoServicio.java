package com.familia.vales.servicios;

import javax.servlet.http.HttpServletResponse;

import com.familia.vales.exception.ServicioException;

/**
 * Interfaz que expone la funcionalidad para leer las paginas desde WPS
 * 
 */
public interface CorreoServicio {

	/**
	 * Se realiza el env�o del correo enviando la informacion recopilada en el objeto Contactenos y la plantilla de correo definida.
	 * 
	 * @param contactenos
	 * @param plantilla
	 * @throws ServicioException
	 */
	void enviarCorreo(String correoDestino,String remitente,String id, String plantilla, HttpServletResponse response) throws ServicioException;
}
