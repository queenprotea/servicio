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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXLMCrearProyectoController implements Initializable {

    @FXML
    private TextField tfNombreProyecto;
    @FXML
    private ComboBox<?> cbOrganizacion;
    @FXML
    private DatePicker dpFechaInicio;
    @FXML
    private TextField tfCupos;
    @FXML
    private DatePicker dpFechaFin;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private ComboBox<?> cbEncargado;
    @FXML
    private CheckBox chbPracticasProfesionales;
    @FXML
    private CheckBox chbServicioSocial;

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
    private void clickCrear(ActionEvent event) {
    }
    
}
