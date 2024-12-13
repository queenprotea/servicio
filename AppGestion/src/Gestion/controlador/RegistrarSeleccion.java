/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.dao.ProyectoDAO;
import Gestion.modelo.raw.Estudiante;
import Gestion.modelo.raw.Proyecto;
import Gestion.utilidades.Mensajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class RegistrarSeleccion implements Initializable {

    @FXML
    private TableColumn<Proyecto, String> nombreProyecto;
    @FXML
    private TableColumn<Proyecto, String> organizacion;
    @FXML
    private TableColumn<Proyecto, String> sector;
    @FXML
    private TableColumn<Proyecto, String> correo;
    @FXML
    private TableColumn<Proyecto, String> descripcion;
    @FXML
    private Button cliclSeleccionar;
    @FXML
    private TableView<Proyecto> tablaProyectos;

    private Estudiante estudiante = new Estudiante();
    private List<String> proyectosSeleccionados = new ArrayList<>();
    private int conteoProyectosSeleccionados = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTablas();
    }

    @FXML
    private void cliclCancelarSeleccion(ActionEvent event) {
        Stage stage = (Stage) cliclSeleccionar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cliclConfirmarSeleccion(ActionEvent event) {
        if (conteoProyectosSeleccionados < 3) {
            Proyecto proyectoSeleccionado = tablaProyectos.getSelectionModel().getSelectedItem();
            if (proyectoSeleccionado != null) {
                String idProyecto = String.valueOf(proyectoSeleccionado.getIdProyecto());
                if (!proyectosSeleccionados.contains(idProyecto)) {
                    proyectosSeleccionados.add(idProyecto);
                    conteoProyectosSeleccionados++;
                    estudiante.setSeleccionProyecto(String.join(",", proyectosSeleccionados));
                    System.out.println("Proyecto agregado: " + proyectoSeleccionado.getNombre());

                    if (conteoProyectosSeleccionados == 3) {
                        try {
                            EstudianteDAO.modificarEstudiante(estudiante);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {

                }
            } else {

            }
        } else {

        }
    }

    public void inicializarValores(Estudiante estudiante) {
        this.estudiante = estudiante;
        if (estudiante.getSeleccionProyecto() != null) {
            proyectosSeleccionados = new ArrayList<>(Arrays.asList(estudiante.getSeleccionProyecto().split(",")));
            conteoProyectosSeleccionados = proyectosSeleccionados.size();
        }
        llenarTablas();
    }

    private void configurarTablas() {
        sector.setCellValueFactory(new PropertyValueFactory<>("sector"));
        nombreProyecto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        organizacion.setCellValueFactory(new PropertyValueFactory<>("organizacion"));
        correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }

    private void llenarTablas() {
        try {
            tablaProyectos.setItems(ProyectoDAO.obtenerProyectosPP());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
