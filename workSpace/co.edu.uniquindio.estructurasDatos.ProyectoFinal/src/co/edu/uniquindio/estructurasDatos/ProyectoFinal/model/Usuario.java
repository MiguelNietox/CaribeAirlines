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
	String contraseñaUsuario ;

	//------------------------------------------------------Metodos-Constructores---------------------------------------------------------------

	public Usuario() {
		super();
	}

	public Usuario(String tipoUsuario, String nombreUsuario, String contraseñaUsuario) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseñaUsuario = contraseñaUsuario;
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

	public String getContraseñaUsuario() {
		return contraseñaUsuario;
	}

	public void setContraseñaUsuario(String contraseñaUsuario) {
		this.contraseñaUsuario = contraseñaUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [tipoUsuario=" + tipoUsuario + ", nombreUsuario=" + nombreUsuario + ", contraseñaUsuario="
				+ contraseñaUsuario + "]";
	}


}
