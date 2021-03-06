package co.edu.uniquindio.estructurasDatos.ProyectoFinal.controllers;

import co.edu.uniquindio.estructurasDatos.ProyectoFinal.aplication.Aplicacion;

import java.awt.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AdministradorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane anchor;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboRutaVuelo;

    @FXML
    void rutaVueloAction(ActionEvent event) {
    	int man= 200;
    	for (int i = 1; i <= 8; i++) {
    		Label label = new Label("label"+i);

        	label.setLayoutX(620);
        	label.setLayoutY(man);
        	label.setPrefHeight(50);
        	label.setPrefWidth(200);
        	anchor.getChildren().add(label);
        	man+=20;
		}

    }
	private ArrayList<String> rutas = new ArrayList<String>();

    @FXML
    void initialize() {

    	Collections.addAll(rutas,new String[]{"Cedula","Pasaporte","Cedula extrangera"});

    	comboRutaVuelo.getItems().addAll(rutas);


    }
	public void setAplicacion(Aplicacion aplicacion) {



	}

}
