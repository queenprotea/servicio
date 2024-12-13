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
    private TableColumn<?, ?> nombreProyecto;
    @FXML
    private TableColumn<?, ?> organizacion;
    @FXML
    private TableColumn<?, ?> sector;
    @FXML
    private TableColumn<?, ?> correo;
    @FXML
    private TableColumn<?, ?> descripcion;
    @FXML
    private Button cliclSeleccionar;
    @FXML
    private TableView<Proyecto> tablaProyectos;

    private Estudiante estudiante = new Estudiante();
    List<String> proyectos = new ArrayList<>();
    private int conteoProyectosSeleccionado = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cliclCancelarSeleccion(ActionEvent event) {
        Stage stage = (Stage) cliclSeleccionar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cliclConfirmarSeleccion(ActionEvent event) {
        if (conteoProyectosSeleccionado < 3){
            List<String> proyectos = Arrays.asList(estudiante.getSeleccionProyecto());
            if (proyectos.get(0) == String.valueOf(tablaProyectos.getSelectionModel().getSelectedItem().getIdProyecto()) ||
                    proyectos.get(1) == String.valueOf(tablaProyectos.getSelectionModel().getSelectedItem().getIdProyecto())){



            }else{

                proyectos.add(String.valueOf(tablaProyectos.getSelectionModel().getSelectedItem().getIdProyecto()));
                String proyectosConcatenados = (proyectos != null && !proyectos.isEmpty())
                        ? String.join(",", proyectos) : "";

                estudiante.setSeleccionProyecto(proyectosConcatenados);
                conteoProyectosSeleccionado++;
                if (conteoProyectosSeleccionado == 3){
                    try {
                        EstudianteDAO.modificarEstudiante(estudiante);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (conteoProyectosSeleccionado == 3) {
            Mensajes.mostrarAlertaConfirmacion("Alerta","ya se han agregado 3 proyectos");
        }
    }
    public void inicializarValores(Estudiante estudiante) {
        this.estudiante = estudiante;
        configurarTablas();
        llenarTablas();
    }
    private void configurarTablas(){
        sector.setCellValueFactory(new PropertyValueFactory("sector"));
        nombreProyecto.setCellValueFactory(new PropertyValueFactory("nombreProyecto"));
        organizacion.setCellValueFactory(new PropertyValueFactory("organizacion"));
        correo.setCellValueFactory(new PropertyValueFactory("correo"));
        descripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));

    }

    private void llenarTablas(){
        try{
            tablaProyectos.setItems(ProyectoDAO.obtenerProyectos());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
