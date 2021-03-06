package co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers;


import co.edu.uniquindio.estructurasDatos.ProyectoFinal.aplication.Aplicacion;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.model.Usuario;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class LoginViewController {

	//Atributos de la clase LoginViewController

	private Aplicacion             aplicacion;
	private LoginController        loginController;
	private ModelFactoryController modelFactoryController;

	ArrayList<String> listaRolUsuario = new ArrayList<String>();

	//Atributos FXML de la clase LoginViewController

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private TextField txtNickUsuario;

    @FXML
    private ComboBox<String> comboTipoUsuarioRegistro;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtNombreUsuarioRegistro;

    @FXML
    private Button btnCancelar;

    @FXML
    private Pane paneIniciarSesion;

    @FXML
    private Pane paneRegistro;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private PasswordField txtContrase?aRegistro;

    //Metodos FXML de la clase LoginViewController

    @FXML
    void iniciarSesionAction(ActionEvent event) {
    	iniciarSesion();
    }

	@FXML
    void registrarAction(ActionEvent event) {
		registrarUsuario();
    }

	@FXML
    void registrarseAction(ActionEvent event) {
    	mostrarPaneRegistro();
    }

    @FXML
    void cancelarAction(ActionEvent event) {
    	mostrarPaneIniciarSesion();
    }


    /**
     * Metodo initialize de la clase loginViewController
     */
	@FXML
    void initialize() {

		modelFactoryController = ModelFactoryController.getInstance();
        loginController = new LoginController(modelFactoryController);

        Collections.addAll(listaRolUsuario,new String[]{"Administrador","Cliente"});
        comboTipoUsuarioRegistro.getItems().addAll(listaRolUsuario);

		mostrarPaneIniciarSesion();
		limpiarSingIn();
    }

	/**
	 * Este es el metodo setAplicacion
	 * @param aplicacion
	 */
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		mostrarPaneIniciarSesion();
	}

	/**
	 * Este metodo permite iniciar sesion mostrando la ventana de el login
	 */
	private void iniciarSesion() {

		String nombreUsuario = txtNickUsuario.getText();
		String contrasenia = txtContrasenia.getText();

		if(validarDatosUsuario(nombreUsuario,contrasenia)){

			Usuario usuario = loginController.obtenerUsuario(nombreUsuario);
			if(usuario != null){
				if(usuario.getTipoUsuario().equals("Cliente")){
					aplicacion.mostrarVentanaCliente(usuario);
				}else{
					aplicacion.mostrarVentanaAdministrador(usuario);
				}

			}
		}

	}

	/**
	 * Este metodo permite validar los datos ingresados por el usuario en el sing-in
	 * @param nombreUsuario
	 * @param contrasenia
	 * @return un true o false y mensaje de informacion
	 */
    private boolean validarDatosUsuario(String nombreUsuario, String contrasenia) {

    	String mensaje = "";

    	if(nombreUsuario == null || nombreUsuario.equals(""))
		{
			mensaje += "El nombre de usuario ingresado es incorrecto \n";
		}
    	if(contrasenia == null || contrasenia.equals(""))
		{
			mensaje += "La contrase?a ingresada es incorrecta \n";
		}
    	if(!loginController.verificarUsuario(nombreUsuario,contrasenia)){
    		mensaje += "Los datos ingresados son incorrectos";
    	}

		if(mensaje.equals("") == true)
		{
			return true;
		}
		else
		{
			mostrarMensaje("Notificacion De Usuario","Datos Invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}

    /**
     * Este metodo permite registrar un nuevo usuario
     */
	private void registrarUsuario() {

		String tipoUsuario   = comboTipoUsuarioRegistro.getSelectionModel().getSelectedItem();
		String nombreUsuario = txtNombreUsuarioRegistro.getText();
		String contrasenia   = txtContrase?aRegistro.getText();

		if(validarDatosRegistroUsuario(tipoUsuario,nombreUsuario,contrasenia)){

			Usuario usuario = null;

			usuario = loginController.registrarNuevoUsuario(tipoUsuario,nombreUsuario,contrasenia);

			if(usuario != null){
				mostrarMensaje("Notificacion De Usuario", "Registro realizado", "El registro se realizo correctamente", AlertType.INFORMATION);
				loginController.guardarDatos();
				aplicacion.mostrarVentanaLogin();

			}else{
				mostrarMensaje("Notificacion De Usuario", "Registro no realizado", "El registro no se realizo correctamente", AlertType.WARNING);
			}
		}

	}

	/**
	 * Este metodo valida los datos ingresados en el sing-up
	 * @param tipoUsuario
	 * @param nombreUsuario
	 * @param contrasenia
	 * @return un true o false y mensaje de informacion
	 */
	private boolean validarDatosRegistroUsuario(String tipoUsuario, String nombreUsuario, String contrasenia) {

		String mensaje = "";

		if(nombreUsuario == null || nombreUsuario.equals(""))
		{
			mensaje += "El nombre de usuario ingresado es incorrecto \n";
		}
    	if(contrasenia == null || contrasenia.equals(""))
		{
			mensaje += "La contrase?a ingresada es incorrecta \n";
		}
    	if(tipoUsuario == null || tipoUsuario.equals("") || tipoUsuario.equals("Seleccione una"))
		{
			mensaje += "El tipo de usuario ingresado es incorrecto \n";
		}
//    	if(loginController.verificarUsuario(nombreUsuario,contrasenia)){
//    		mensaje += "El nombre de usuario ya existe";
//    	}
		if(mensaje.equals("") == true)
		{
			return true;
		}
		else
		{
			mostrarMensaje("Notificacion De Usuario","Datos Invalidos",mensaje, AlertType.WARNING);
			return false;
		}
	}



	private void mostrarPaneRegistro() {
		paneRegistro.setTranslateX(-2);
		paneRegistro.setTranslateY(130);
		paneIniciarSesion.setVisible(false);
		paneRegistro.setVisible(true);
		limpiarSingIn();
		aparecerVentanaRegistro();
	}

	/**
	 * Este metodo despliega la ventana de singIn
	 */
	private void mostrarPaneIniciarSesion() {
		paneIniciarSesion.setVisible(true);
		paneIniciarSesion.setTranslateX(-2);
		paneIniciarSesion.setTranslateY(130);
		paneRegistro.setVisible(false);
		limpiarSingUp();
		aparecerVentanaIniciarSesion();
	}

	/**
	 * Este metodo limpia los campos del singIn
	 */
	private void limpiarSingIn() {
		txtNickUsuario.setText("");
		txtContrasenia.setText("");
		txtNickUsuario.setPromptText("Ingrese su nombre de usuario");
		txtContrasenia.setPromptText("Ingrese su contrase?a");
	}

	/**
	 * Este metodo limpia los campos del singUp
	 */

	private void limpiarSingUp() {
		comboTipoUsuarioRegistro.setValue("Seleccione una");
		txtContrase?aRegistro.setText("");
		txtNombreUsuarioRegistro.setText("");
		txtNombreUsuarioRegistro.setPromptText("Ingrese un nombre de usuario");
		txtContrase?aRegistro.setPromptText("Ingrese una contrase?a");
	}

	/**
	 * Este metodo da el efecto de aparecer a la ventana de singUp
	 */
	private void aparecerVentanaRegistro() {

		FadeTransition fade = new FadeTransition();
		TranslateTransition translate = new TranslateTransition();

		fade.setNode(paneRegistro);
		fade.setDuration(Duration.millis(1000));
		fade.setInterpolator(Interpolator.LINEAR);
		fade.setFromValue(0);
		fade.setToValue(1);

		translate.setNode(paneRegistro);
		translate.setByY(-126);
		translate.setDuration(Duration.millis(1000));

		fade.play();
		translate.play();
	}

	/**
	 * Este metodo da el efecto de aparecer a la ventana de singIn
	 */
	private void aparecerVentanaIniciarSesion() {

		FadeTransition fade = new FadeTransition();
		TranslateTransition translate = new TranslateTransition();

		fade.setNode(paneIniciarSesion);
		fade.setDuration(Duration.millis(1000));
		fade.setInterpolator(Interpolator.LINEAR);
		fade.setFromValue(0);
		fade.setToValue(1);

		translate.setNode(paneIniciarSesion);
		translate.setByY(-126);
		translate.setDuration(Duration.millis(1000));

		fade.play();
		translate.play();
	}

	/**
	 * Este metodo muestra en pantalla un mensaje al usuario
	 * @param titulo
	 * @param header
	 * @param contenido
	 * @param alertType
	 */
	private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert aler = new Alert(alertType);
		aler.setTitle(titulo);
		aler.setHeaderText(header);
		aler.setContentText(contenido);
		aler.showAndWait();
	}
}