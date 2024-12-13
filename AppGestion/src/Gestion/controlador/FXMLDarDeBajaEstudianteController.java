package Gestion.controlador;

import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.dao.ProyectoDAO;
import Gestion.modelo.raw.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class FXMLDarDeBajaEstudianteController {

    @FXML
    private Label nombre;
    @FXML
    private Label apellidoPaterno;
    @FXML
    private Label apellidoMaterno;
    @FXML
    private Label matricula;
    @FXML
    private Label correo;
    @FXML
    private Label telefono;
    @FXML
    private Label semestre;
    @FXML
    private Label tipoProyecto;
    @FXML
    private Label proyecto;
    @FXML
    private Label razonSocial;
    @FXML
    private Label fechaInicio;
    @FXML
    private Label fechaFin;


    private Estudiante estudiante;

    // Método que se ejecuta cuando el controlador es inicializado
    @FXML
    public void initialize() {
        // Lógica de inicialización
    }

    // Método para inicializar la información del estudiante en la vista
    public void inicializarValores(Estudiante estudiante) {
        // Lógica para inicializar el estudiante
        this.estudiante = estudiante;
        cargarDatos(estudiante);
    }

    // Método para manejar la acción de dar de baja al estudiante
    @FXML
    private void clickDarDeBaja(ActionEvent event) {
        // Lógica para dar de baja al estudiante
        estudiante.setEstadoProyecto(false);

        try {
            EstudianteDAO.modificarEstudiante(estudiante);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para cancelar la acción y cerrar la ventana o volver a la vista anterior
    @FXML
    private void clickCancelar(ActionEvent event) {
        // Lógica para cancelar la acción
        Stage stage = (Stage) nombre.getScene().getWindow();
        stage.close();
    }

    private void cargarDatos(Estudiante estudiante) {
        nombre.setText(estudiante.getNombre());
        apellidoPaterno.setText(estudiante.getApellidoPaterno());
        apellidoMaterno.setText(estudiante.getApellidoMaterno());
        matricula.setText(estudiante.getMatricula());
        correo.setText(estudiante.getCorreo());
        telefono.setText(estudiante.getTelefono());
        semestre.setText(estudiante.getSemestre());
        if(estudiante.getTipoProyecto() == 1){
            tipoProyecto.setText("Servicio social");
        }else {
            tipoProyecto.setText("Practicas profesionales");
        }
        proyecto.setText(estudiante.getProyecto().getNombre());
        razonSocial.setText(estudiante.getProyecto().getNombre());
        fechaInicio.setText(estudiante.getProyecto().getFechaInicio());
        fechaFin.setText(estudiante.getProyecto().getFechaFin());
    }
}
