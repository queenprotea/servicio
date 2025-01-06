/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.OrganizacionDAO;
import Gestion.modelo.raw.Organizacion;
import Gestion.utilidades.Mensajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

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
    public void inicializarValores() {
        configurarTextFieldNumerico(tfCP);
    }
    @FXML
    private void clickCancelar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void clickRegistrar(ActionEvent event) {
        if (camposValidos()){
            try {
                Organizacion organizacion = new Organizacion();

                organizacion.setRazonSocial(tfRazonSocial.getText());
                organizacion.setDescripcion(taDescripcion.getText());
                organizacion.setTelefono(tfTelefono.getText());
                organizacion.setCorreo(tfCorreo.getText());
                organizacion.setSector(tfSector.getText());
                organizacion.setCalle(tfCalle.getText());
                organizacion.setEstado(tfEstado.getText());
                organizacion.setCiudad(tfCiudad.getText());
                organizacion.setCodigoPostal(tfCP.getText());

                OrganizacionDAO.registrarOrganizacion(organizacion);
                Mensajes.mostrarAlertaConfirmacion("Confirmacion", "Proyecto registrado correctamente");
                limpiarCampos();

            }catch (SQLException e){
                e.printStackTrace();
                Mensajes.mostrarAlertaConfirmacion("Error", "Error al conectar con la base de datos");
                cerrarVentana();
            }

        }else{
            Mensajes.alerta("Campos incompletos", "Completa todos los campos", Alert.AlertType.INFORMATION);
        }

    }


    private boolean camposValidos(){
        if(tfRazonSocial.getText().isEmpty() ||
            tfCalle.getText().isEmpty() ||
            tfCiudad.getText().isEmpty() ||
            tfTelefono.getText().isEmpty() ||
            tfCP.getText().isEmpty() ||
            tfCorreo.getText().isEmpty() ||
            tfSector.getText().isEmpty() ||
            tfEstado.getText().isEmpty() ||
            taDescripcion.getText().isEmpty())
            return false;

        return true;
    }

    private  void limpiarCampos(){
        tfRazonSocial.setText("");
        taDescripcion.setText("");
        tfTelefono.setText("");
        tfCorreo.setText("");
        tfSector.setText("");
        tfCalle.setText("");
        tfCP.setText("");
        tfEstado.setText("");
        tfCiudad.setText("");
    }

    private void configurarTextFieldNumerico(TextField textField) {
        TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Solo números
                return change;
            }
            return null; // Rechazar cambios no numéricos
        });
        textField.setTextFormatter(textFormatter);
    }

    private void cerrarVentana(){
        Stage stage = (Stage) taDescripcion.getScene().getWindow();
        stage.close();
    }


}
