package co.edu.uniquindio.estructurasDatos.ProyectoFinal.excepciones;

public class UsuarioException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioException(String mensaje){
		super("Problema: "+mensaje);
	}
}
