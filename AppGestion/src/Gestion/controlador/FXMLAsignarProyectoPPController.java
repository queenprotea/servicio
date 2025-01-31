package Gestion.controlador;

import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.dao.ProyectoDAO;
import Gestion.modelo.raw.Estudiante;
import Gestion.modelo.raw.Proyecto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLAsignarProyectoPPController implements Initializable {

    @FXML
    private TableView<Proyecto> tablaProyectos;

    @FXML
    private TableColumn<Proyecto, String> columnaProyectos; // Columna de Proyectos

    @FXML
    private Label nombreEstudainte;
    @FXML
    private Label apellidoPaterno;
    @FXML
    private Label apellidoMaterno;
    @FXML
    private Label matricula;
    @FXML
    private Label creditos;
    @FXML
    private Label correo;
    @FXML
    private Label semestre;
    @FXML
    private Label promedio;
    @FXML
    private Label telefono;
    @FXML
    private Label proyectoAsignado;

    private Estudiante estudiante;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Método para cargar los proyectos disponibles en la tabl
    private void cargarProyectos() {
        // Implementar la lógica para cargar proyectos en la tabla
        ObservableList<Proyecto> proyectosParaTabla = FXCollections.observableArrayList();

        try {
            System.out.println(estudiante.getSeleccionProyecto());
            if (estudiante.getSeleccionProyecto() != null) {
                String proyectos = estudiante.getSeleccionProyecto();
                System.out.println(proyectos);
                List<String> proyectosSeleccionadosPorElEstudainte = Arrays.asList(proyectos.split(","));


                for (String proyecto : proyectosSeleccionadosPorElEstudainte) {
                    System.out.println(proyecto);
                    proyectosParaTabla.add(ProyectoDAO.obtenerProyectoPorId(proyecto));
                }
                proyectosParaTabla.addAll(ProyectoDAO.obtenerProyectosPP());
            }else {
                proyectosParaTabla = ProyectoDAO.obtenerProyectosPP();
            }


            tablaProyectos.setItems( proyectosParaTabla);


        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    // Método para asignar un proyecto al estudiante
    @FXML
    private void aceptar(ActionEvent event) {
        if (!tablaProyectos.getSelectionModel().isEmpty()) {
            estudiante.setProyecto(tablaProyectos.getSelectionModel().getSelectedItem());
            try {
                EstudianteDAO.modificarEstudiante(estudiante);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para cancelar la asignación
    @FXML
    private void cancelar(ActionEvent event) {
        // Implementar la lógica para cancelar la asignación
        Stage stage = (Stage) nombreEstudainte.getScene().getWindow();
        stage.close();
    }

    // Método para inicializar los valores del estudiante (llamado desde otro controlador)
    public void inicializarEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        cargarProyectos();
        cargarInformacionEstudiante(estudiante);
        columnaProyectos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaProyectos.setOnMouseClicked(event -> actualizarProyectoAsignado());
    }

    private void actualizarProyectoAsignado() {
        Proyecto proyectoSeleccionado = tablaProyectos.getSelectionModel().getSelectedItem();
        if (proyectoSeleccionado != null) {
            proyectoAsignado.setText(proyectoSeleccionado.getNombre());
        }
    }

    private void cargarInformacionEstudiante(Estudiante estudiante) {
        nombreEstudainte.setText(estudiante.getNombre());
        apellidoPaterno.setText(estudiante.getApellidoPaterno());
        apellidoMaterno.setText(estudiante.getApellidoMaterno());
        matricula.setText(estudiante.getMatricula());
        creditos.setText(String.valueOf(estudiante.getCreditos()));
        correo.setText(estudiante.getCorreo());
        semestre.setText(estudiante.getSemestre());
        promedio.setText(estudiante.getPromedio());
        telefono.setText(estudiante.getTelefono());

    }
}
