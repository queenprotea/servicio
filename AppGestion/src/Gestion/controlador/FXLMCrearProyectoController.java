
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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
        cbOrganizacion.valueProperty().addListener((observable, oldValue, newValue) -> {
            actualizarEncargados(); // Llamar a actualizarEncargados cada vez que cambie la selección
        });
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
        configurarTextFieldNumerico(tfCupos);
    }
    public void cargarOrganizacion() {
        // Recuperar la lista de organizaciones desde el DAO
        ObservableList<Organizacion> organizaciones = OrganizacionDAO.obtenerOrganizaciones();

        // Configurar la lista de organizaciones en el ComboBox
        cbOrganizacion.setItems(organizaciones);
        System.out.println("al emnos entro");

        for (Organizacion organizacion : organizaciones) {
            System.out.println("Organización cargada: " + organizacion.getRazonSocial());
        }

        // Configurar un StringConverter para que el ComboBox muestre los nombres
        cbOrganizacion.setConverter(new StringConverter<Organizacion>() {
            @Override
            public String toString(Organizacion organizacion) {
                return organizacion != null ? organizacion.getRazonSocial() : " "; // Mostrar el nombre
            }

            @Override
            public Organizacion fromString(String string) {
                return null; // No se utiliza en este caso
            }
        });
    }


    private void actualizarEncargados() {
        Organizacion organizacionSeleccionada = cbOrganizacion.getValue();
        if (organizacionSeleccionada != null) {
            try {
                // Obtener encargados de la organización seleccionada
                ObservableList<Encargado> encargados = EncargadoDAO.obtenerEncargadosPorOrganizacion(String.valueOf(organizacionSeleccionada.getIdOrganizacion()));

                // Configurar los encargados en el ComboBox
                cbEncargado.setItems(encargados);

                // Imprimir en consola para depuración
                for (Encargado encargado : encargados) {
                    System.out.println("Encargado cargado: " + encargado.getNombre());
                }

                // Configurar StringConverter para mostrar nombres en el ComboBox
                cbEncargado.setConverter(new StringConverter<Encargado>() {
                    @Override
                    public String toString(Encargado encargado) {
                        return encargado != null ? encargado.getNombre() : " ";
                    }

                    @Override
                    public Encargado fromString(String string) {
                        return null; // No se utiliza en este caso
                    }
                });

            } catch (SQLException e) {
                e.printStackTrace();
                Mensajes.alerta("Error", "No se pudieron cargar los encargados para la organización seleccionada.", Alert.AlertType.ERROR);
            }
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


    private void limpiarCampos(){
        tfNombreProyecto.setText("");
        taDescripcion.setText("");
        tfCupos.setText("");
    }
    private void configurarTextFieldNumerico(TextField textField) {
        TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Solo números
                return change;
            }
            return null; // Rechazar cambios no numéricos
        });
        textField.setTextFormatter(textFormatter);
    }

    private void cerrarVentana(){
        Stage stage = (Stage) taDescripcion.getScene().getWindow();
        stage.close();
    }
}
