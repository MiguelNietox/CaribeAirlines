package co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers;

import co.edu.uniquindio.estructurasDatos.ProyectoFinal.excepciones.UsuarioException;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.model.Aerolinea;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.model.Usuario;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.persistencia.Persistencia;

public class ModelFactoryController implements Runnable {

	//Atributos de la clase ModelFactoryController

	Aerolinea aerolinea;
	Thread hiloGuardarResourceXML;


	//----------------------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu? al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M?todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	//-------------------------------------------Constructor-de-la-Clase-----------------------------------------

	/**
	 * Este es el meotodo constructor de la clase ModelFactoryController
	 */
	public ModelFactoryController() {
		System.out.println("invocaci?n clase singleton");

		//Inicializar datos y luego guardarlo en archivos
		//inicializarSalvarDatosPrueba();

		//Guardar y cargar el recurso serializable XML
		//guardarResourceXML();
		cargarResourceXML();


		if(aerolinea == null){
			System.out.println("Aerolinea es null");

		}
	}

	private void inicializarSalvarDatosPrueba() {

		//Inicializar datos
		aerolinea = new Aerolinea("CaribeAirlines");

	}

	@Override
	public void run() {
		Thread hiloActual = Thread.currentThread();

		if(hiloActual == hiloGuardarResourceXML){
			Persistencia.guardarRecursoMarketplaceXML(aerolinea);
		}
	}

	private void cargarResourceXML() {
		aerolinea = Persistencia.cargarRecursoMarketplaceXML();
	}

	private void guardarResourceXML() {
		Persistencia.guardarRecursoMarketplaceXML(aerolinea);
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Usuario obtenerUsuario(String nombreUsuario) {

		return getAerolinea().obtenerUsuario(nombreUsuario);
	}

	public boolean verificarUsuario(String nombreUsuario, String contrasenia) {

		return getAerolinea().verificarUsuario(nombreUsuario,contrasenia);
	}

	public void guardarDatos() {
		hiloGuardarResourceXML = new Thread(this);
		hiloGuardarResourceXML.start();
	}

	public Usuario registrarNuevoUsuario(String tipoUsuario, String nombreUsuario, String contrasenia) {

		Usuario usuarioNuevo = null;

		try {
			usuarioNuevo = getAerolinea().registrarUsuario(tipoUsuario, nombreUsuario, contrasenia);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}

		return usuarioNuevo;
	}

}
