/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.dao.ProyectoDAO;
import Gestion.modelo.raw.Estudiante;
import Gestion.modelo.raw.Proyecto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class FXMLSeleccionDeAlumnoParaProyectoPPController implements Initializable {

    @FXML
    private TextField tfBuscador;
    @FXML
    private TableView<Estudiante> tablaEstudiantes;
    @FXML
    private TableColumn<?, ?> columnaNombreEstudiante;
    @FXML
    private TableColumn<?, ?> columnaMatriculaEstudiante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBuscar(ActionEvent event) {
        if (!tfBuscador.getText().isEmpty()) {
            try {
                tablaEstudiantes.getItems().clear();
                tablaEstudiantes.setItems(EstudianteDAO.obtenerEstudiantesPorMatricula(tfBuscador.getText()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void clickVer(ActionEvent event) {
        if (! tablaEstudiantes.getSelectionModel().isEmpty()) {
            try {
                Stage stage = (Stage) tfBuscador.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLAsignarProyectoPP.fxml"));
                Parent vista = loader.load();
                FXMLAsignarProyectoPPController controller = loader.getController();
                controller.inicializarEstudiante(tablaEstudiantes.getSelectionModel().getSelectedItem());

                Scene escena = new Scene(vista);
                stage.setScene(escena);
                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        Stage stage = (Stage) tfBuscador.getScene().getWindow();
        stage.close();
    }

    private void configurarTabla(){
        columnaNombreEstudiante.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaMatriculaEstudiante.setCellValueFactory(new PropertyValueFactory("matricula"));
    }
    private void llenarTabla(){
        try{
            ObservableList<Estudiante> estudiantesValidos = FXCollections.observableArrayList();
            for(Estudiante estudiante: EstudianteDAO.obtenerEstudiantesPP()){
                if (estudiante.getEstadoProyecto() == false){
                    estudiantesValidos.add(estudiante);
                }
            }
            tablaEstudiantes.setItems(estudiantesValidos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inicializarValores(){
        configurarTabla();
        llenarTabla();
    }
}
