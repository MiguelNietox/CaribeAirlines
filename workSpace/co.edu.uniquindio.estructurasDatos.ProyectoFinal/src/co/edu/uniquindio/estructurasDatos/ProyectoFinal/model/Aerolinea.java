package co.edu.uniquindio.estructurasDatos.ProyectoFinal.model;

import java.io.Serializable;

import co.edu.uniquindio.estructurasDatos.ProyectoFinal.excepciones.UsuarioException;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.librerias.ListaSimple;

/**
 * Esta es la clase Aerolinea
 * @author
 */
public class Aerolinea implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//Atributos de la clase Aerolinea

	String nombre;


	ListaSimple<Usuario> listaUsuarios = new ListaSimple<Usuario>();

	//------------------------------------------------------Metodos-Constructores---------------------------------------------------------------

	/**
	 * Este es el metodo constructor vacio de la clase Aerolinea
	 */
	public Aerolinea() {
		super();
	}

	/**
	 * Este es el metodo constructor de la clase Aerolinea
	 * @param string
	 */
	public Aerolinea(String string) {
		this.nombre = string;
	}

	//------------------------------------------------------Metodos-Set-&-Get---------------------------------------------------------------

	/**
	 * Este metodo permite obtener la lista de usuarios de la aerolinea
	 * @return la lista de usuarios
	 */
	public ListaSimple<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * Este metodo permite modificar la lista de usuarios de la aerolinea
	 * @param listaUsuarios
	 */
	public void setListaUsuarios(ListaSimple<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}





	//###############################################################################################################################
	//##################################################### Metodos del Usuario #####################################################

	/**
	 * Este metodo crea y registra un nuevo usuario y lanza una excepcion en caso de que ya exista un usuario
	 * registrado con ese nombre de usuario
	 * @param tipoUsuario
	 * @param nombreUsuario
	 * @param contrasenia
	 * @return El usuario creado y registrado
	 * @throws UsuarioException
	 */
	public Usuario registrarUsuario(String tipoUsuario, String nombreUsuario, String contrasenia) throws UsuarioException {

		Usuario usuario = obtenerUsuario(nombreUsuario);

		if(usuario != null){
			throw new UsuarioException("Ya existe un usuario con nombre: "+nombreUsuario);
		}else{

			usuario = new Usuario();
			usuario.setTipoUsuario(tipoUsuario);
			usuario.setNombreUsuario(nombreUsuario);
			usuario.setContrase?aUsuario(contrasenia);

			listaUsuarios.agregarfinal(usuario);
		}

		return usuario;
	}

	/**
	 * Este metodo permite obtener un usuario por medio de su nombre de usuario
	 * @param nombreUsuario
	 * @return el usuario encontrado
	 */
	public Usuario obtenerUsuario(String nombreUsuario) {

		for (int i = 0; i < listaUsuarios.getTamanio(); i++) {

			Usuario usuario = listaUsuarios.obtenerValorNodo(i);

			if(usuario.getNombreUsuario().equals(nombreUsuario)){
				return usuario;
			}
		}
        return null;
	}

	/**
	 * Este metodo verifica los datos de un usuario segun su nombre de usuario y clave
	 * @param nombreUsuario
	 * @param contrasenia
	 * @return un true o false
	 */
	public boolean verificarUsuario(String nombreUsuario, String contrasenia) {

		for (int i = 0; i < listaUsuarios.getTamanio(); i++) {

			Usuario usuario = listaUsuarios.obtenerValorNodo(i);

			if(usuario.getNombreUsuario().equals(nombreUsuario)){
				if(usuario.getContrase?aUsuario().equals(contrasenia)){
					return true;
				}
			}
		}
		return false;
	}
}
