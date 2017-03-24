package com.familia.vales.exception;

/**
 * La Class ServicioException. La cual maneja las excepciones
 * en la capa de servicio
 * @author pcamacho
 * @since 30/01/2013
 *
 */
public class ServicioException extends Exception {

	private static final long serialVersionUID = -1344626988304888878L;

	/**
	 * Crea una nueva instancia de servicio exception.
	 */
	public ServicioException() {
		super();
	}

	/**
	 * Crea una nueva instancia de servicio exception.
	 * @param message
	 */
	public ServicioException(String message) {
		super(message);
	}

	/**
	 * Crea una nueva instancia de servicio exception.
	 * @param cause
	 */
	public ServicioException(Throwable cause) {
		super(cause);
	}

	/**
	 * Crea una nueva instancia de servicio exception.
	 * @param message
	 * @param cause
	 */
	public ServicioException(String message, Throwable cause) {
		super(message, cause);
	}
}
