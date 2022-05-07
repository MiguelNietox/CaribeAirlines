package co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers;

import co.edu.uniquindio.estructurasDatos.ProyectoFinal.aplication.Aplicacion;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ClienteViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInfoViaje;

    @FXML
    private Pane panePantallaGris;

    @FXML
    private Pane paneInfoViaje;

    @FXML
    void infoViajeAction(ActionEvent event) {
    	panePantallaGris.setVisible(true);
    	paneInfoViaje.setVisible(true);
    }
    public void setAplicacion(Aplicacion aplicacion) {


	}
}

