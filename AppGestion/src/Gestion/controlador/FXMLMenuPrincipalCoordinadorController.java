package Gestion.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLMenuPrincipalCoordinadorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickCrearProyecto(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLCrearProyecto.fxml"));
            Parent vista = loader.load();
            FXLMCrearProyectoController controller = loader.getController();
            controller.InicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickRegistrarEncargado(ActionEvent event) throws SQLException{

        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLRegistarEncargado.fxml"));
            Parent vista = loader.load();
            FXMLRegistrarEncargadoController controller = loader.getController();
            controller.inicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickRegistrarOrganizacion(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLRegistrarOrganizacion.fxml"));
            Parent vista = loader.load();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickModificarOrganizacion(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLModificarOrganizacion.fxml"));
            Parent vista = loader.load();
            FXMLModificarOrganizacionController controller = loader.getController();
            controller.inicializarValores();
            controller.inicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickRegistrarEstudiante(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLRegistrarEstudiante.fxml"));
            Parent vista = loader.load();
            FXMLRegistrarEstudianteController controller = loader.getController();
            controller.inicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickRegistrarModificarEstudiante(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLModificarEstudiante.fxml"));
            Parent vista = loader.load();
            FXMLModificarEstudianteController controller = loader.getController();
            controller.inicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickRegistrarProfesor(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLRegistrarProfesor.fxml"));
            Parent vista = loader.load();
            FXMLRegistrarProfesorController controller = loader.getController();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickAsignarProyectoPP(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLSeleccionDeAlumnoParaProyectoPP.fxml"));
            Parent vista = loader.load();
            FXMLSeleccionDeAlumnoParaProyectoPPController controller = loader.getController();
            controller.inicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickAsignarProyectoSS(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLSeleccionProyectoParaAlumnoSS.fxml"));
            Parent vista = loader.load();
            FXMLSeleccionProyectoParaAlumnoSSController controller = loader.getController();
            controller.inicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickEvaluarReportes(ActionEvent event) {
    }

    @FXML
    private void clickDarDeBajaEstudiante(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLSelecionEstudianteDarDeBaja.fxml"));
            Parent vista = loader.load();
            FXMLSeleccionDeEstudianteDarDeBajaControllador controller = loader.getController();
            controller.inicializarValores();
            Scene scene = new Scene(vista);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickConsultarExpediente(ActionEvent event) {
    }

}
