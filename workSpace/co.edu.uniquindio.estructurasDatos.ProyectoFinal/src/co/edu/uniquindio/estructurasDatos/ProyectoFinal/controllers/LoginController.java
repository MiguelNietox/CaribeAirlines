package co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers;

import co.edu.uniquindio.estructurasDatos.ProyectoFinal.model.Aerolinea;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.model.Usuario;

/**
 * Esta es la clase LoginController
 * @author Universidad
 *
 */
public class LoginController {

	//Atributos de la clase LoginController

		ModelFactoryController modelFactoryController;
		Aerolinea aerolinea;


		//-------------------------------------------------------------Constructor-de-la-Clase------------------------------------------------------------

		/**
		 * Este es el metodo constructor de la clase LoginController
		 * @param modelFactoryController
		 */
		public LoginController(ModelFactoryController modelFactoryController) {
			this.modelFactoryController = modelFactoryController;
			aerolinea = modelFactoryController.getAerolinea();
		}

		//--------------------------------------------------------------Metodos-Sets-Y-Gets---------------------------------------------------------------

		/**
		 * Este metodo permite obtener el valor del atributo marketOnline de la clase ModelFactoryController
		 * @return el valor del atributo marketOnline
		 */
		public Aerolinea getMarketOnline() {
			return aerolinea;
		}

		/**
		 * Este metodo permite modificar el valor del atributo marketOnline de la clase ModelFactoryController
		 * @param marketOnline
		 */
		public void setMarketOnline(Aerolinea aerolinea) {
			this.aerolinea = aerolinea;
		}

		/**
		 * Este metodo permite obtener un usuario por su nombre de usuario
		 * @param nombreUsuario
		 * @return el usuario encontrado
		 */
		public Usuario obtenerUsuario(String nombreUsuario) {
			return modelFactoryController.obtenerUsuario(nombreUsuario);
		}

		/**
		 * Este metodo permite verificar los datos de un usuario
		 * @param nombreUsuario
		 * @param contrasenia
		 * @return un true o false
		 */
		public boolean verificarUsuario(String nombreUsuario, String contrasenia) {
			return modelFactoryController.verificarUsuario(nombreUsuario,contrasenia);
		}

		/**
		 * Este metodo permite guardar los datos en un archivo xml
		 */
		public void guardarDatos() {
			modelFactoryController.guardarDatos();
		}

		/**
		 * Este metodo permite registrar un nuevo usuario en la aerolinea
		 * @param tipoUsuario
		 * @param nombreUsuario
		 * @param contrasenia
		 * @return el usuario registrado o null
		 */
		public Usuario registrarNuevoUsuario(String tipoUsuario, String nombreUsuario, String contrasenia) {

			return modelFactoryController.registrarNuevoUsuario(tipoUsuario,nombreUsuario,contrasenia);
		}
}
