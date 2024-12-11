/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.CoordinadorDAO;
import Gestion.modelo.dao.EstudianteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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



    }

    private void obtenerTipoUsuario(String contrasena,String idUsuario) throws SQLException {
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

    }
    
}
