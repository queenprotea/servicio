/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import Gestion.modelo.raw.Estudiante;
import Gestion.modelo.raw.Proyecto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickAsignar(ActionEvent event) {
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
    }

    @FXML
    private void clickAceptar(ActionEvent event) {
    }

    private void configurarTablas(){

    }
    public void inicializarValores(Proyecto proyecto) {
        this.proyecto = proyecto;

    }
}
