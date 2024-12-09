/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.EncargadoDAO;
import Gestion.modelo.dao.OrganizacionDAO;
import Gestion.modelo.raw.Encargado;
import Gestion.modelo.raw.Organizacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
    private ComboBox<Organizacion> CBOrganizacion;

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
    private void clickRegistrar(ActionEvent event) throws SQLException {
        if (validarCampos()){

            Encargado encargado = new Encargado();

            encargado.setNombre(TfNombre.getText());
            encargado.setApellidoPaterno(TFApellidoPaterno.getText());
            encargado.setApellidoMaterno(TFApellidoMaterno.getText());
            encargado.setPuesto(TFPuesto.getText());
            encargado.setTelefono(TFTelefono.getText());
            encargado.setCorreo(TFCorreo.getText());
            encargado.setEstado("Activo");
            encargado.setOrganizacion(CBOrganizacion.getValue());

            EncargadoDAO.registrarEncargado(encargado);

        }
    }

    public void inicializarValores() throws SQLException {
        llenarComboBoxOrganizaciones();
    }

    private void llenarComboBoxOrganizaciones() throws SQLException {
        try {

            CBOrganizacion.setItems(OrganizacionDAO.obtenerOrganizaciones());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean validarCampos() {
        if (TFApellidoMaterno.getText().isEmpty() ||
                TFApellidoPaterno.getText().isEmpty() ||
                TfNombre.getText().isEmpty() ||
                TFPuesto.getText().isEmpty() ||
                TFTelefono.getText().isEmpty() ||
                TFCorreo.getText().isEmpty() ||
                CBOrganizacion.getValue() == null){

            return false;

        }

        return true;
    }

}
