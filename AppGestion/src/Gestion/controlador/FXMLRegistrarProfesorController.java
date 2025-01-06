/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.ProfesorDAO;
import Gestion.modelo.raw.Profesor;
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
public class FXMLRegistrarProfesorController implements Initializable {

    @FXML
    private TextField tfNombres;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfMatricula;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField txApellidoMaterno;
    @FXML
    private TextField tfEspecialidad;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfContrasena;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickRegistrar(ActionEvent event) {
        if (validarCampos()){
            try {
                Profesor profesor = new Profesor();
                profesor.setNombre(tfNombres.getText());
                profesor.setApellidoPaterno(tfApellidoPaterno.getText());
                profesor.setMatricula(tfMatricula.getText());
                profesor.setApellidoMaterno(txApellidoMaterno.getText());
                profesor.setEspecialidad(tfEspecialidad.getText());
                profesor.setTelefono(tfTelefono.getText());
                profesor.setCorreo(tfCorreo.getText());
                profesor.setContrasena(tfContrasena.getText());

                ProfesorDAO.registarProfesor(profesor);
                Mensajes.mostrarAlertaConfirmacion("Confirmacion", "Profesor registrado correctamente");
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

    private void limpiarCampos(){
        tfNombres.setText("");
        tfApellidoPaterno.setText("");
        tfMatricula.setText("");
        tfTelefono.setText("");
        txApellidoMaterno.setText("");
        tfEspecialidad.setText("");
        tfCorreo.setText("");
        tfContrasena.setText("");
    }

    private boolean validarCampos(){
        if(tfNombres.getText().isEmpty() ||
                tfApellidoPaterno.getText().isEmpty() ||
                tfMatricula.getText().isEmpty() ||
                tfTelefono.getText().isEmpty() ||
                txApellidoMaterno.getText().isEmpty() ||
                tfEspecialidad.getText().isEmpty() ||
                tfCorreo.getText().isEmpty() ||
                tfContrasena.getText().isEmpty())
            return false;
        return true;

        }

        private void cerrarVentana(){

            Stage stage = (Stage) tfNombres.getScene().getWindow();
            stage.close();

        }

}
