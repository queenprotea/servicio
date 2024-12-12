/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.raw.Estudiante;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLModificarEstudianteController implements Initializable {

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
    @FXML
    private Button botonCambios;
    @FXML
    private TableView<Estudiante> tablaEstudiantes;
    @FXML
    private TableColumn<Estudiante, String> columnaNombreEstudiantes;
    @FXML
    private TableColumn<Estudiante, String> columnaMatriculaEstudiantes;

    private boolean modoEddicion = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickRegistrar(ActionEvent event) {


    }

    @FXML
    private void clickCancelar(ActionEvent event) {
    }

    private void llenarTablaEstudiantes(){
        try{
            tablaEstudiantes.setItems(EstudianteDAO.obtenerEstudiantes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void inicializarValores(){
        tablaEstudiantes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Estudiante>() {
            @Override
            public void changed(ObservableValue<? extends Estudiante> observable, Estudiante oldValue, Estudiante newValue) {
                if (newValue != null) {
                    actualizarCampos(newValue);
                }
            }
        });
    }
    private void actualizarCampos(Estudiante estudiante) {
        tfNombres.setText(estudiante.getNombre());
        tfApellidoPaterno.setText(estudiante.getApellidoPaterno());
        txApellidoMaterno.setText(estudiante.getApellidoMaterno());
        tfMatricula.setText(estudiante.getMatricula());
        tfCorreo.setText(estudiante.getCorreo());
        tfTelefono.setText(estudiante.getTelefono());
        tfSemestre.setText(String.valueOf(estudiante.getSemestre()));
        tfCreditos.setText(String.valueOf(estudiante.getCreditos()));
        tfPromedio.setText(String.valueOf(estudiante.getPromedio()));
    }
    private void modificarEdicion(){

        tfNombres.setEditable(false);
        tfApellidoPaterno.setEditable(false);
        txApellidoMaterno.setEditable(false);
        tfMatricula.setEditable(false);
        tfCreditos.setEditable(false);
        tfCorreo.setEditable(false);
        tfTelefono.setEditable(false);
        tfSemestre.setEditable(false);
        tfPromedio.setEditable(false);

    }
    
}
