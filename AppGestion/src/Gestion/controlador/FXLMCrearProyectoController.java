
package Gestion.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import Gestion.modelo.dao.EncargadoDAO;
import Gestion.modelo.dao.OrganizacionDAO;
import Gestion.modelo.dao.ProyectoDAO;
import Gestion.modelo.raw.Encargado;
import Gestion.modelo.raw.Organizacion;
import Gestion.modelo.raw.Proyecto;
import Gestion.utilidades.Mensajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXLMCrearProyectoController implements Initializable {

    @FXML
    private TextField tfNombreProyecto;
    @FXML
    private ComboBox<Organizacion> cbOrganizacion;
    @FXML
    private DatePicker dpFechaInicio;
    @FXML
    private TextField tfCupos;
    @FXML
    private DatePicker dpFechaFin;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private ComboBox<Encargado> cbEncargado;
    @FXML
    private CheckBox chbPracticasProfesionales;
    @FXML
    private CheckBox chbServicioSocial;

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
    private void clickCrear(ActionEvent event) {

        if (validarCampos()) {
            try {
                Proyecto proyecto = new Proyecto();

                proyecto.setNombre(tfNombreProyecto.getText());
                proyecto.setOrganizacion(cbOrganizacion.getValue());
                proyecto.setEncargado(cbEncargado.getValue());
                proyecto.setCupos(Integer.parseInt(tfCupos.getText()));
                proyecto.setFechaFin(dpFechaFin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                proyecto.setFechaInicio(dpFechaInicio.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                if (chbPracticasProfesionales.isSelected()) {
                    proyecto.setTipo("Practicas profesionales");
                } else if (chbServicioSocial.isSelected()) {
                    proyecto.setTipo("Servicio social");
                }
                ProyectoDAO.registarProyecto(proyecto);
                Mensajes.mostrarAlertaConfirmacion("Confirmacion", "Proyecto registrado correctamente");
                limpiarCampos();

            } catch (SQLException e) {
                e.printStackTrace();
                Mensajes.mostrarAlertaConfirmacion("Error", "Error al conectar con la base de datos");
                cerrarVentana();
            }
        }else {
            Mensajes.alerta("Campos faltantes","Completa todos los campos", Alert.AlertType.WARNING);
        }
    }

    public void InicializarValores(){
        cargarOrganizacion();
        cbEncargado.setOnAction(event -> actualizarEncargados());
        chbPracticasProfesionales.setOnAction(event -> {
            if (chbPracticasProfesionales.isSelected()) {
                chbServicioSocial.setSelected(false);
            }
        });

        chbServicioSocial.setOnAction(event -> {
            if (chbServicioSocial.isSelected()) {
                chbPracticasProfesionales.setSelected(false);
            }
        });
    }
    public void cargarOrganizacion(){
        try {
            cbOrganizacion.setItems(OrganizacionDAO.obtenerOrganizaciones());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void cargarEncargado(){
        try {
            cbEncargado.setItems(EncargadoDAO.obtenerEncargados());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void actualizarEncargados() {
        Organizacion organizacionSeleccionada = cbOrganizacion.getValue();
        if (organizacionSeleccionada != null) {
            try {
                cbEncargado.setItems(EncargadoDAO.obtenerEncargadosPorOrganizacion(String.valueOf(organizacionSeleccionada.getIdOrganizacion())));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            cbEncargado.getItems().clear();
        }
    }
    private boolean validarCampos(){
        if (tfNombreProyecto.getText().isEmpty() ||
            tfCupos.getText().isEmpty() ||
            taDescripcion.getText().isEmpty() ||
                cbEncargado.getValue() == null ||
                cbOrganizacion.getValue() == null){
            return false;
        }

        return true;
    }

    private void cerrarVentana(){
        Stage stage = (Stage) taDescripcion.getScene().getWindow();
        stage.close();
    }
    private void limpiarCampos(){
        tfNombreProyecto.setText("");
        taDescripcion.setText("");
        tfCupos.setText("");
    }
    
}
