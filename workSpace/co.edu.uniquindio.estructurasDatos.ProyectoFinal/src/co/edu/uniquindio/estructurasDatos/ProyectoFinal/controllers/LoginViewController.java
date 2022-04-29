package co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers;


import co.edu.uniquindio.estructurasDatos.ProyectoFinal.aplication.Aplicacion;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class LoginViewController {

	Aplicacion aplicacion;

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
    private PasswordField txtContrase�aRegistro;

    @FXML
    void iniciarSesionAction(ActionEvent event) {
    	aplicacion.mostrarVentanaCliente();
    }

    @FXML
    void registrarAction(ActionEvent event) {

    }

    @FXML
    void registrarseAction(ActionEvent event) {
    	mostrarPaneRegistro();
    }

    @FXML
    void cancelarAction(ActionEvent event) {
    	mostrarPaneIniciarSesion();
    }

	@FXML
    void initialize() {
		mostrarPaneIniciarSesion();
		limpiarSingIn();


    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		mostrarPaneIniciarSesion();
	}

	private void mostrarPaneRegistro() {
		paneRegistro.setTranslateX(-2);
		paneRegistro.setTranslateY(130);
		paneIniciarSesion.setVisible(false);
		paneRegistro.setVisible(true);
		limpiarSingIn();
		aparecerVentanaRegistro();
	}

	private void mostrarPaneIniciarSesion() {
		paneIniciarSesion.setVisible(true);
		paneIniciarSesion.setTranslateX(-2);
		paneIniciarSesion.setTranslateY(130);
		paneRegistro.setVisible(false);
		limpiarSingUp();
		aparecerVentanaIniciarSesion();
	}

	private void limpiarSingIn() {
		txtNickUsuario.setText("");
		txtContrasenia.setText("");
		txtNickUsuario.setPromptText("Ingrese su nombre de usuario");
		txtContrasenia.setPromptText("Ingrese su contrase�a");
	}
	private void limpiarSingUp() {
		comboTipoUsuarioRegistro.setValue("Seleccione una");
		txtContrase�aRegistro.setText("");
		txtNombreUsuarioRegistro.setText("");
		txtNombreUsuarioRegistro.setPromptText("Ingrese un nombre de usuario");
		txtContrase�aRegistro.setPromptText("Ingrese una contrase�a");
	}

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

}