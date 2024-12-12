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
import Gestion.modelo.raw.Proyecto;
import Gestion.utilidades.Mensajes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLAsignarProyectoSSdosController implements Initializable {

    @FXML
    private TableView<Estudiante> tablaAlumnosSinAsignar;
    @FXML
    private TableColumn<?, ?> columnaNombreSinAsignar;
    @FXML
    private TableView<Estudiante> tablaAlumnosAsignados;
    @FXML
    private TableColumn<?, ?> columnaNombreAsignado;
    @FXML
    private TableColumn<?, ?> columnaMatriculaSinAsignar;
    @FXML
    private TableColumn<?, ?> columnaMatriculaAsignado;
    @FXML
    private Label lblNombreProyecto;
    @FXML
    private Label lblOrganizacion;
    @FXML
    private Label lblFechaInicio;
    @FXML
    private Label lblFechaFin;

    Proyecto proyecto = new Proyecto();
    ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickAsignar(ActionEvent event) {
        if (! tablaAlumnosSinAsignar.getSelectionModel().isEmpty()){
            estudiantes.add(tablaAlumnosSinAsignar.getSelectionModel().getSelectedItem());
            actualizarTablaEstudiante();
        }
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        Stage stage = (Stage) lblOrganizacion.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickAceptar(ActionEvent event) {
        try{
            for(Estudiante estudiante: estudiantes){
                estudiante.setProyecto(proyecto);
                EstudianteDAO.modificarEstudiante(estudiante);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            Mensajes.mostrarAlertaConfirmacion("error","Error al conectra a la base de datos");
        }
    }

    private void configurarTablas(){
        columnaNombreSinAsignar.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaNombreAsignado.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaMatriculaAsignado.setCellValueFactory(new PropertyValueFactory("matricula"));
        columnaMatriculaSinAsignar.setCellValueFactory(new PropertyValueFactory("matricula"));

    }
    private void llenarTablaEstudiante(){
        try {
            tablaAlumnosSinAsignar.setItems(EstudianteDAO.obtenerEstudiantes());
        } catch (SQLException e) {
            e.printStackTrace();
            Mensajes.mostrarAlertaConfirmacion("error","Error al conectra a la base de datos");

        }
    }
    private void cargarInformacionProyecto(){
        lblNombreProyecto.setText(proyecto.getNombre());
        lblOrganizacion.setText(proyecto.getOrganizacion().getRazonSocial());
        lblFechaInicio.setText(proyecto.getFechaInicio().toString());
        lblFechaFin.setText(proyecto.getFechaFin().toString());

    }
    public void inicializarValores(Proyecto proyecto) {
        this.proyecto = proyecto;
        configurarTablas();
        llenarTablaEstudiante();
        cargarInformacionProyecto();

    }
    private void actualizarTablaEstudiante(){
        tablaAlumnosAsignados.setItems(estudiantes);
    }
}
