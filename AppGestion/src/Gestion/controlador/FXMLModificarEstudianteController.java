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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private Button botonEstado;
    @FXML
    private TableView<Estudiante> tablaEstudiantes;
    @FXML
    private TableColumn<Estudiante, String> columnaNombreEstudiantes;
    @FXML
    private TableColumn<Estudiante, String> columnaMatriculaEstudiantes;

    private boolean modoEddicion = true;
    Estudiante estudiante = new Estudiante();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickRegistrar(ActionEvent event) {
        if (!modoEddicion) {
            modificarEdicion();
            botonCambios.setText("Guardar");
        }else {
            try{
                estudiante.setIdEstudiante(tablaEstudiantes.getSelectionModel().getSelectedItem().getIdEstudiante());
                estudiante.setNombre(tfNombres.getText());
                estudiante.setMatricula(tfMatricula.getText());
                estudiante.setCorreo(tfCorreo.getText());
                estudiante.setApellidoPaterno(tfApellidoPaterno.getText());
                estudiante.setSemestre(tfSemestre.getText());
                estudiante.setPromedio(tfPromedio.getText());
                estudiante.setTelefono(tfTelefono.getText());
                estudiante.setApellidoMaterno(txApellidoMaterno.getText());
                estudiante.setProyecto(tablaEstudiantes.getSelectionModel().getSelectedItem().getProyecto());

                EstudianteDAO.modificarEstudiante(estudiante);
            }catch (SQLException e){
                e.printStackTrace();
            }
            modificarEdicion();
            botonCambios.setText("Modificar");
        }
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        Stage stage = (Stage) botonCambios.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickEstado(ActionEvent event) {
        if (tablaEstudiantes.getSelectionModel().getSelectedItem().getEstado() == "Activo") {
            estudiante.setEstado("Inactivo");
            botonEstado.setText("Inactivo");
        }else{
            estudiante.setEstado("Activo");
            botonEstado.setText("Activo");
        }

    }

    private void llenarTablaEstudiantes(){
        try{
            tablaEstudiantes.setItems(EstudianteDAO.obtenerEstudiantes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void inicializarValores(){
        modificarEdicion();
        llenarTablaEstudiantes();
        configurarTabla();

        tablaEstudiantes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Estudiante>() {
            @Override
            public void changed(ObservableValue<? extends Estudiante> observable, Estudiante oldValue, Estudiante newValue) {
                if (newValue != null) {
                    if (modoEddicion == false) {
                        actualizarCampos(newValue);
                    }
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
        if (modoEddicion) {
            tfNombres.setEditable(false);
            tfApellidoPaterno.setEditable(false);
            txApellidoMaterno.setEditable(false);
            tfMatricula.setEditable(false);
            tfCreditos.setEditable(false);
            tfCorreo.setEditable(false);
            tfTelefono.setEditable(false);
            tfSemestre.setEditable(false);
            tfPromedio.setEditable(false);
            botonEstado.setDisable(true);
            modoEddicion = false;

        }else {
            tfNombres.setEditable(true);
            tfApellidoPaterno.setEditable(true);
            txApellidoMaterno.setEditable(true);
            tfMatricula.setEditable(true);
            tfCreditos.setEditable(true);
            tfCorreo.setEditable(true);
            tfTelefono.setEditable(true);
            tfSemestre.setEditable(true);
            tfPromedio.setEditable(true);
            botonEstado.setDisable(false);
            modoEddicion = true;

        }
    }

    private void configurarTabla(){
        columnaNombreEstudiantes.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaMatriculaEstudiantes.setCellValueFactory(new PropertyValueFactory("matricula"));
    }
    
}
