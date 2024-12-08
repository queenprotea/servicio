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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLRegistrarEncargadoController implements Initializable {

    @FXML
    private TextField TfNombre;
    @FXML
    private TextField TFApellidoPaterno;
    @FXML
    private TextField TFApellidoMaterno;
    @FXML
    private TextField TFPuesto;
    @FXML
    private TextField TFTelefono;
    @FXML
    private TextField TFCorreo;
    @FXML
    private TextField TFOrganizacion;

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
    private void clickRegistrar(ActionEvent event) {
    }
    
}
