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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLsubirReporteController implements Initializable {

    @FXML
    private Label lblNombreDeEntrega;
    @FXML
    private Label lblNombreProyecto;
    @FXML
    private TextField tfHorasReportadas;
    @FXML
    private Label lblNombreRazonSocial;
    @FXML
    private Label lblFechaInicio;
    @FXML
    private Label lblFechaFin;
    @FXML
    private Label lblNombreEncargado;
    @FXML
    private Label lblPuestoEncargado;
    @FXML
    private Label lblCorreoEncargado;
    @FXML
    private Label lblTelefono;
    @FXML
    private Label lblFechaInicioReporte;
    @FXML
    private Label lblFechaFinReporte;

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
    private void clickEntregar(ActionEvent event) {
    }

    @FXML
    private void clickSubirReporte(ActionEvent event) {
    }
    
}
