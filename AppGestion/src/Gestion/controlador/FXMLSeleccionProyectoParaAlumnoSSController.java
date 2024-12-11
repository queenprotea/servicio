/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLSeleccionProyectoParaAlumnoSSController implements Initializable {

    @FXML
    private TableView<?> tablaProyectos;
    @FXML
    private TableColumn<?, ?> columnaNombreProyecto;
    @FXML
    private TableColumn<?, ?> columnaOrganizacion;
    @FXML
    private TableColumn<?, ?> columnaSector;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
    }

    @FXML
    private void clickSeleccionar(ActionEvent event) {
    }
    
}
