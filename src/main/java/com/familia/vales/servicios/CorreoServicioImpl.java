package com.familia.vales.servicios;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.familia.vales.correo.Correo;
import com.familia.vales.exception.ServicioException;

public class CorreoServicioImpl implements CorreoServicio {

	@Override
	public void enviarCorreo(String correoDestino,String remitente,String id, String plantilla, HttpServletResponse response) throws ServicioException {
		Correo correo = new Correo("correoapps.familia.com.co", 25);
		
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Exception exceptionEnvio = null;
		boolean envioExitoso = false;

		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");

			VelocityContext contextConfirmacionAdmin = new VelocityContext();
			contextConfirmacionAdmin.put("datosPlantilla", id);

			Template templateConfirmacionAdmin = ve.getTemplate(plantilla);
			Writer writerConfirmacionAdmin = new StringWriter();
			templateConfirmacionAdmin.merge(contextConfirmacionAdmin, writerConfirmacionAdmin);
			String cuerpoHtml = writerConfirmacionAdmin.toString();

			String correoAdministrador = correoDestino;
			try {
				out.println(remitente + correoAdministrador  + cuerpoHtml + response);
				correo.enviarCorreoHtml(remitente, correoAdministrador, "Vale", cuerpoHtml,
						response);
				envioExitoso = true;
			} catch (Exception e) {
				System.out.println("Falloooo el envioooo");
			}
		} catch (Exception e) {
			exceptionEnvio = e;
		}
		if (!envioExitoso) {
			throw new ServicioException("Error enviando correo", exceptionEnvio);
		}
	}

}
