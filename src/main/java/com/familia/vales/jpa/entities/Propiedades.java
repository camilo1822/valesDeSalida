package com.familia.vales.jpa.entities;

import java.io.Serializable;

/**
 * Informaci�n que se consulta desde un contenido del WCM
 * 
 * @author <a href="mailto:daniel.mejia@pragma.com.co">Daniel Mejia</a> - Pragma
 *         S.A. <br>
 * @date 2/08/2015
 * 
 */
public class Propiedades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String smtpHost;
	private int smtpPort;
	private String asunto;
	private String textoSaludo;
	private String textoPie;

	public String getTextoSaludo() {
		return textoSaludo;
	}

	public void setTextoSaludo(String textoSaludo) {
		this.textoSaludo = textoSaludo;
	}

	public String getTextoPie() {
		return textoPie;
	}

	public void setTextoPie(String textoPie) {
		this.textoPie = textoPie;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public int getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}


	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

}