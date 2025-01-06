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
import Gestion.utilidades.Mensajes;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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
    private ComboBox<Organizacion> CBOrganizaciones;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void clickRegistrar(ActionEvent event) throws SQLException {
        if (validarCampos()){
            try {
                Encargado encargado = new Encargado();

                encargado.setNombre(TfNombre.getText());
                encargado.setApellidoPaterno(TFApellidoPaterno.getText());
                encargado.setApellidoMaterno(TFApellidoMaterno.getText());
                encargado.setPuesto(TFPuesto.getText());
                encargado.setTelefono(TFTelefono.getText());
                encargado.setCorreo(TFCorreo.getText());
                encargado.setEstado("Activo");
                encargado.setOrganizacion(CBOrganizaciones.getValue());

                EncargadoDAO.registrarEncargado(encargado);
                limpiarCampos();
                Mensajes.mostrarAlertaConfirmacion("Confirmacion","Encargado guardado con exito");
            }catch (SQLException e){
                e.printStackTrace();
                Mensajes.mostrarAlertaConfirmacion("Error", "Error al conectar con la base de datos");
                cerrarVentana();
            }
        }
    }

    public void inicializarValores() throws SQLException {
        cargarOrganizacion();
        configurarTextFieldNumerico(TFTelefono);
    }

    public void cargarOrganizacion() {
        // Recuperar la lista de organizaciones desde el DAO
        ObservableList<Organizacion> organizaciones = OrganizacionDAO.obtenerOrganizaciones();

        // Configurar la lista de organizaciones en el ComboBox
        CBOrganizaciones.setItems(organizaciones);
        System.out.println("al emnos entro");

        for (Organizacion organizacion : organizaciones) {
            System.out.println("Organización cargada: " + organizacion.getRazonSocial());
        }

        // Configurar un StringConverter para que el ComboBox muestre los nombres
        CBOrganizaciones.setConverter(new StringConverter<Organizacion>() {
            @Override
            public String toString(Organizacion organizacion) {
                return organizacion != null ? organizacion.getRazonSocial() : " "; // Mostrar el nombre
            }

            @Override
            public Organizacion fromString(String string) {
                return null; // No se utiliza en este caso
            }
        });
    }

    private boolean validarCampos() {
        if (TFApellidoMaterno.getText().isEmpty() ||
                TFApellidoPaterno.getText().isEmpty() ||
                TfNombre.getText().isEmpty() ||
                TFPuesto.getText().isEmpty() ||
                TFTelefono.getText().isEmpty() ||
                TFCorreo.getText().isEmpty() ||
                CBOrganizaciones.getValue() == null)
            return false;

        return true;
    }

    private void limpiarCampos() {
        TfNombre.setText("");
        TFApellidoPaterno.setText("");
        TFApellidoMaterno.setText("");
        TFPuesto.setText("");
        TFTelefono.setText("");
        TFCorreo.setText("");
        CBOrganizaciones.setValue(null);

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
        Stage stage =(Stage) TFApellidoMaterno.getScene().getWindow();
        stage.close();

    }

}
