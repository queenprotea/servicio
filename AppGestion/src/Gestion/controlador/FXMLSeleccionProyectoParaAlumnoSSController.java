/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.ProyectoDAO;
import Gestion.modelo.raw.Proyecto;
import Gestion.utilidades.Mensajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLSeleccionProyectoParaAlumnoSSController implements Initializable {

    @FXML
    private TableView<Proyecto> tablaProyectos;
    @FXML
    private TableColumn<?, ?> columnaNombreProyecto;
    @FXML
    private TableColumn<?, ?> columnaOrganizacion;
    @FXML
    private TableColumn<?, ?> columnaSector;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void clickSeleccionar(ActionEvent event) {
        if (! tablaProyectos.getSelectionModel().isEmpty()){
            Proyecto proyecto = tablaProyectos.getSelectionModel().getSelectedItem();

            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(Gestion.Main.class.getResource("vista/FXMLAsignarProyectoSSdosController.fxml"));
                Parent vista = loader.load();
                FXMLAsignarProyectoSSdosController controller = loader.getController();
                controller.inicializarValores(proyecto);
                Scene scene = new Scene(vista);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            Mensajes.mostrarAlertaConfirmacion("Atencion","debe de seleccionar un proyecto");
        }
    }

    private void configurarTabla(){
        columnaNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaOrganizacion.setCellValueFactory(new PropertyValueFactory("organizacion"));
        columnaSector.setCellValueFactory(new PropertyValueFactory("sector"));
    }

    private void llenarTabla(){
        try{
            tablaProyectos.setItems(ProyectoDAO.obtenerProyectosSS());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cerrarVentana(){
        Stage stage = (Stage) tablaProyectos.getScene().getWindow();
        stage.close();
    }

    public void inicializarValores(){
        configurarTabla();
        llenarTabla();
    }

}
