/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Gestion.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.CoordinadorDAO;
import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.dao.ProfesorDAO;
import Gestion.utilidades.Mensajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author lolll
 */
public class FXMLInicioSesionController implements Initializable {

    @FXML
    private TextField TFUsuario;
    @FXML
    private TextField TFContrasena;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickIniciarSesion(ActionEvent event) {
        if (camposValidos()){
            try {

                switch (obtenerTipoUsuario(TFContrasena.getText(),TFUsuario.getText())){
                    case 1 :
                        try {
                            Stage stage = (Stage) TFUsuario.getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLMenuPrincipalCoordinador.fxml"));
                            Parent vista = loader.load();
                            Scene scene = new Scene(vista);
                            stage.setScene(scene);
                            stage.show();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    case 2 :
                        try {
                            Stage stage = (Stage) TFUsuario.getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLMenuPrincipalEstudiante.fxml"));
                            Parent vista = loader.load();
                            Scene scene = new Scene(vista);
                            stage.setScene(scene);
                            stage.show();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            Stage stage = (Stage) TFUsuario.getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLMenuPrincipalProfesor.fxml"));
                            Parent vista = loader.load();
                            Scene scene = new Scene(vista);
                            stage.setScene(scene);
                            stage.show();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    default:
                        Mensajes.mostrarAlertaConfirmacion("Credenciales incorrectas", "no se encontro al usuario");
                        break;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private int obtenerTipoUsuario(String contrasena,String idUsuario) throws SQLException {
        int tipoUsuario = 0;

        if (CoordinadorDAO.obtenerCoordinadirPorId(Integer.parseInt(idUsuario)) != null){
            if (CoordinadorDAO.obtenerCoordinadirPorId(Integer.parseInt(idUsuario)).getContrasena() == contrasena){
                tipoUsuario = 1;
            }
        }
        if (EstudianteDAO.obtenerEstudiantePorId(Integer.parseInt(idUsuario)) != null){
            if (EstudianteDAO.obtenerEstudiantePorId(Integer.parseInt(idUsuario)).getPassword() == contrasena){
                tipoUsuario = 2;
            }
        }
        if (ProfesorDAO.obtenerProfesorPorId(Integer.parseInt(idUsuario)) != null){

        }
        return tipoUsuario;
    }

    private boolean camposValidos(){
        if (TFUsuario.getText().isEmpty() ||
                TFContrasena.getText().isEmpty())
            return false;

        return true;
    }
    
}
