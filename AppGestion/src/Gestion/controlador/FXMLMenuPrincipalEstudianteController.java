package Gestion.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Gestion.modelo.raw.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    @FXML
            private Label nommbre;
    @FXML
            private Label apellidoMaterno;
    @FXML
            private Label apellidoPaterno;

    Estudiante estudiante = new Estudiante();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización del controlador si es necesario
    }

    @FXML
    private void cliclRegistrarSeleccion(ActionEvent event) {
        // Lógica para manejar el evento de "Registrar Selección"
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/RegistrarSeleccion.fxml"));
            Parent vista = loader.load();
            RegistrarSeleccion controller = loader.getController();
            controller.inicializarValores(estudiante);
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
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
    private void cargarDatosEstudiante() {
        nommbre.setText(estudiante.getNombre());
        apellidoMaterno.setText(estudiante.getApellidoMaterno());
        apellidoPaterno.setText(estudiante.getApellidoPaterno());
        semestre.setText(estudiante.getSemestre());
        matricula.setText(estudiante.getMatricula());
        proyecto.setText(estudiante.getProyecto().getNombre());
        tipoProyecto.setText(estudiante.getTipoProyecto());
    }
    public void inicializarValores (Estudiante estudiante) {
        this.estudiante = estudiante;
        cargarDatosEstudiante();
    }
}
