/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.raw.Estudiante;
import Gestion.utilidades.Mensajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLRegistrarEstudianteController implements Initializable {

    @FXML
    private TextField tfNombres;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfMatricula;
    @FXML
    private TextField tfCreditos;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField txApellidoMaterno;
    @FXML
    private TextField tfSemestre;
    @FXML
    private TextField tfPromedio;
    @FXML
    private TextField tfTelefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickRegistrar(ActionEvent event) {
        if (camposValidos()) {
            try {
                Estudiante estudiante = new Estudiante();

                estudiante.setNombre(tfNombres.getText());
                estudiante.setApellidoPaterno(tfApellidoPaterno.getText());
                estudiante.setMatricula(tfMatricula.getText());
                estudiante.setApellidoMaterno(txApellidoMaterno.getText());
                estudiante.setCorreo(tfCorreo.getText());
                estudiante.setTelefono(tfTelefono.getText());
                estudiante.setPromedio(tfPromedio.getText());
                estudiante.setSemestre(tfSemestre.getText());
                estudiante.setCreditos(Integer.parseInt(tfCreditos.getText()));

                EstudianteDAO.registarEstudiante(estudiante);
                Mensajes.mostrarAlertaConfirmacion("Confirmacion", "Estudiante registrado correctamente");
                limpiarCampos();

            }catch (SQLException e){
                e.printStackTrace();
                Mensajes.mostrarAlertaConfirmacion("Error", "Error al conectar con la base de datos");
                cerrarVentana();
            }
        }

    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        cerrarVentana();
    }

    private void limpiarCampos() {
        tfNombres.setText("");
        tfApellidoPaterno.setText("");
        tfMatricula.setText("");
        tfCreditos.setText("");
        tfCorreo.setText("");
        txApellidoMaterno.setText("");
        tfSemestre.setText("");
        tfPromedio.setText("");
        tfTelefono.setText("");
    }

    private boolean camposValidos(){
        if ( tfNombres.getText().isEmpty() ||
                tfApellidoPaterno.getText().isEmpty() ||
                tfMatricula.getText().isEmpty() ||
                tfCreditos.getText().isEmpty() ||
                tfCorreo.getText().isEmpty() ||
                txApellidoMaterno.getText().isEmpty() ||
                tfSemestre.getText().isEmpty() ||
                tfPromedio.getText().isEmpty() ||
                tfTelefono.getText().isEmpty())
            return false;

        return true;
    }

    private void cerrarVentana(){
        Stage stage = (Stage) tfNombres.getScene().getWindow();
        stage.close();
    }

    
}
