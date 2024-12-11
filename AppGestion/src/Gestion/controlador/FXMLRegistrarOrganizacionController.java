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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLRegistrarOrganizacionController implements Initializable {

    @FXML
    private TextField tfRazonSocial;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfSector;
    @FXML
    private TextField tfCalle;
    @FXML
    private TextField tfCP;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfCiudad;

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
