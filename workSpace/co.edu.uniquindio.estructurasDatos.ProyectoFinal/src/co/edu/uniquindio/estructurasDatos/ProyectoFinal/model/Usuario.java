package co.edu.uniquindio.estructurasDatos.ProyectoFinal.model;

import java.io.Serializable;

public class Usuario implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	//Atributos de la clase Usuario

	String tipoUsuario       ;
	String nombreUsuario     ;
	String contrase�aUsuario ;

	//------------------------------------------------------Metodos-Constructores---------------------------------------------------------------

	public Usuario() {
		super();
	}

	public Usuario(String tipoUsuario, String nombreUsuario, String contrase�aUsuario) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrase�aUsuario = contrase�aUsuario;
	}

	//------------------------------------------------------Metodos-Set-&-Get---------------------------------------------------------------

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrase�aUsuario() {
		return contrase�aUsuario;
	}

	public void setContrase�aUsuario(String contrase�aUsuario) {
		this.contrase�aUsuario = contrase�aUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [tipoUsuario=" + tipoUsuario + ", nombreUsuario=" + nombreUsuario + ", contrase�aUsuario="
				+ contrase�aUsuario + "]";
	}


}