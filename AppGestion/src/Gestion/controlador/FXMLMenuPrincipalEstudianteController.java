package Gestion.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import Gestion.modelo.raw.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Controlador para la interfaz de Menu Principal del Estudiante.
 */
public class FXMLMenuPrincipalEstudianteController implements Initializable {

    @FXML
    private Label proyecto;

    @FXML
    private Label tipoProyecto;

    @FXML
    private Label matricula;

    @FXML
    private Label semestre;

    Estudiante estudiante = new Estudiante();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización del controlador si es necesario
    }

    @FXML
    private void cliclRegistrarSeleccion(ActionEvent event) {
        // Lógica para manejar el evento de "Registrar Selección"
    }

    @FXML
    private void clicSubirReporte(ActionEvent event) {
        // Lógica para manejar el evento de "Subir Reporte"
    }

    @FXML
    private void cliclConsultarExpediente(ActionEvent event) {
        // Lógica para manejar el evento de "Consultar Expediente"
    }

    @FXML
    private void cliclSubirDocumentos(ActionEvent event) {
        // Lógica para manejar el evento de "Subir Documentos"
    }
    public void inicializarValores (Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
