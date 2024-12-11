/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLAsignarProyectoSSdosController implements Initializable {

    @FXML
    private TableView<?> tablaAlumnosSinAsignar;
    @FXML
    private TableColumn<?, ?> columnaAlumnosSinAsignar;
    @FXML
    private TableView<?> tablaAlumnosAsignados;
    @FXML
    private TableColumn<?, ?> columnaAlumnosAsignados;
    @FXML
    private Label lblNombreProyecto;
    @FXML
    private Label lblOrganizacion;
    @FXML
    private Label lblFechaInicio;
    @FXML
    private Label lblFechaFin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickAsignar(ActionEvent event) {
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
    }

    @FXML
    private void clickAceptar(ActionEvent event) {
    }
    
}
