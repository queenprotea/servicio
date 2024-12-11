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
            FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLRegistrarEncargado.fxml"));
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
    }

    @FXML
    private void clickRegistrarEstudiante(ActionEvent event) {
    }

    @FXML
    private void clickRegistrarModificarEstudiante(ActionEvent event) {
    }

    @FXML
    private void clickRegistrarProfesor(ActionEvent event) {
    }

    @FXML
    private void clickAsignarProyectoPP(ActionEvent event) {
    }

    @FXML
    private void clickAsignarProyectoSS(ActionEvent event) {
    }

    @FXML
    private void clickEvaluarReportes(ActionEvent event) {
    }

    @FXML
    private void clickDarDeBajaEstudiante(ActionEvent event) {
    }

    @FXML
    private void clickConsultarExpediente(ActionEvent event) {
    }

}
