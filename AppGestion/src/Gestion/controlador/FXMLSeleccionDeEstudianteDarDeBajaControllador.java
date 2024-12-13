package Gestion.controlador;

import Gestion.modelo.dao.EstudianteDAO;
import Gestion.modelo.raw.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class FXMLSeleccionDeEstudianteDarDeBajaControllador {

    @FXML
    private TextField tfBuscador;

    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<?, ?> columnaNombreEstudiante;
    @FXML
    private TableColumn<?, ?> columnaMatriculaEstudiante;
    @FXML
    private TableColumn<?, ?> columnaNombreProyecto;
    @FXML
    private TableColumn<?, ?> columnaTipoProyecto;

    @FXML
    private Button buscarButton;
    @FXML
    private Button verButton;
    @FXML
    private Button cancelarButton;

    @FXML
    private Label tituloLabel;

    // Método para inicializar la vista (vacío)
    @FXML
    public void initialize() {
        // Lógica de inicialización
    }

    // Método para buscar un estudiante por matrícula
    @FXML
    private void clickBuscar(ActionEvent event) {
        // Lógica para realizar la búsqueda
        if (!tfBuscador.getText().isEmpty()) {
            try {
                tablaEstudiantes.getItems().clear();
                tablaEstudiantes.setItems(EstudianteDAO.obtenerEstudiantesPorMatricula(tfBuscador.getText()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para mostrar detalles del estudiante seleccionado
    @FXML
    private void clickVer(ActionEvent event) {
          Estudiante estudiante = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (estudiante != null) {
            try {
                Stage stage = (Stage) tfBuscador.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLDarDeBajaEstudiante.fxml"));
                Parent vista = loader.load();
                FXMLDarDeBajaEstudianteController controller = loader.getController();

                controller.inicializarValores(estudiante);

                Scene escena = new Scene(vista);
                stage.setScene(escena);
                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        // Lógica para ver los detalles del estudiante
    }

    // Método para cancelar la acción y cerrar la ventana o volver a la vista anterior
    @FXML
    private void clickCancelar(ActionEvent event) {
        // Lógica para cancelar la acción
        Stage stage = (Stage) verButton.getScene().getWindow();
        stage.close();
    }

    private void configurarTabla(){
        columnaMatriculaEstudiante.setCellValueFactory(new PropertyValueFactory("matricula"));
        columnaNombreEstudiante.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaTipoProyecto.setCellValueFactory(new PropertyValueFactory("tipo"));
        columnaNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombreProyecto"));
    }
    private void llenarTabla(){
        try{
            ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();
            for(Estudiante estudiante : EstudianteDAO.obtenerEstudiantes()){
                if (Objects.equals(estudiante.getEstado(), "Activo")){
                    estudiantes.add(estudiante);
                }
            }
            tablaEstudiantes.setItems(estudiantes);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void inicializarValores(){
        configurarTabla();
        llenarTabla();
    }
}
