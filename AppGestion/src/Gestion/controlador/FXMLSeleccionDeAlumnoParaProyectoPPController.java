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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLSeleccionDeAlumnoParaProyectoPPController implements Initializable {

    @FXML
    private TextField tfBuscador;
    @FXML
    private TableView<?> tablaEstudiantes;
    @FXML
    private TableColumn<?, ?> columnaNombreEstudiante;
    @FXML
    private TableColumn<?, ?> columnaMatriculaEstudiante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBuscar(ActionEvent event) {
    }

    @FXML
    private void clickVer(ActionEvent event) {
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
    }
    
}
