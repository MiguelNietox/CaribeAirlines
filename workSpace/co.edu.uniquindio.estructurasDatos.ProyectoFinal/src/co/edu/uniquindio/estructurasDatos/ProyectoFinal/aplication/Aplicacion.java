package co.edu.uniquindio.estructurasDatos.ProyectoFinal.aplication;

import java.io.IOException;

import co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers.AdministradorViewController;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers.ClienteViewController;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers.LoginViewController;
import co.edu.uniquindio.estructurasDatos.ProyectoFinal.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	//Atributos de la clase Aplicacion

	private Stage stage;

	//Metodo Star de la clase Aplicacion

	@Override
	public  void start(Stage primaryStage) throws Exception {

		this.stage = primaryStage;
		this.stage.setTitle("Aerolinia");

		mostrarVentanaLogin();
	}

	/**
	 * Este es el metodo main de la clase aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	//-------------------------------------------------Metodos-De-Interfaces--------------------------------------------------------

	/**
	 * Este metodo muestra la interface de login de la aplicacion
	 */
	public void mostrarVentanaLogin() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/loginView.fxml"));

			AnchorPane rootLayout =  loader.load();

			LoginViewController loginViewController = loader.getController();
			loginViewController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(getClass().getResource("../styles/loginView.css").toExternalForm());
			stage.setScene(scene);
			stage.show();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo muestra la interface de login de la aplicacion
	 * @param usuario
	 */
	public void mostrarVentanaCliente(Usuario usuario) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/clienteView.fxml"));

			AnchorPane rootLayout =  loader.load();

			ClienteViewController clienteViewController = loader.getController();
			clienteViewController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(getClass().getResource("../styles/clienteView.css").toExternalForm());
			stage.setScene(scene);
			stage.show();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo muestra la interface de login de la aplicacion
	 * @param usuario
	 */
	public void mostrarVentanaAdministrador(Usuario usuario) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/administradorView.fxml"));

			AnchorPane rootLayout =  loader.load();

			AdministradorViewController administradorViewController = loader.getController();
			administradorViewController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(getClass().getResource("../styles/administradorView.css").toExternalForm());
			stage.setScene(scene);
			stage.show();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
