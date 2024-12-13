/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Gestion.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Gestion.modelo.dao.OrganizacionDAO;
import Gestion.modelo.raw.Estudiante;
import Gestion.modelo.raw.Organizacion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lolll
 */
public class FXMLModificarOrganizacionController implements Initializable {

    @FXML
    private TextField tfRazonSocial;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfSector;
    @FXML
    private TextField tfCalle;
    @FXML
    private TextField tfCP;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfCiudad;
    @FXML
    private TableView<Organizacion> tablaOrganizaciones;
    @FXML
    private TableColumn<?, ?> nombreOrganizacion;
    @FXML
    private Button estado;
    @FXML
    private Button botonCambios;

    private boolean modoEddicion = true;
    Organizacion organizacion = new Organizacion();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        Stage stage = (Stage) estado.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickRegistrar(ActionEvent event) {
        if (!modoEddicion){
            modificarEdicion();
            botonCambios.setText("Guardar");
        }else {
            try {
                organizacion.setRazonSocial(tfRazonSocial.getText());
                organizacion.setDescripcion(taDescripcion.getText());
                organizacion.setTelefono(tfTelefono.getText());
                organizacion.setCorreo(tfCorreo.getText());
                organizacion.setSector(tfSector.getText());
                organizacion.setCalle(tfCalle.getText());
                organizacion.setCiudad(tfCiudad.getText());
                organizacion.setEstado(tfEstado.getText());
                organizacion.setCiudad(tfCiudad.getText());

                OrganizacionDAO.modificarOrganizacion(organizacion);
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
            modificarEdicion();
            botonCambios.setText("Modificar");
        }
    }

    @FXML
    private void cliclestado(ActionEvent event) {
        if(tablaOrganizaciones.getSelectionModel().getSelectedItem().getActiva() == "Activo") {
            organizacion.setActiva("Inactivo");
            estado.setText("Inactivo");
        }else {
            organizacion.setActiva("Activo");
            estado.setText("Activo");
        }
    }

    public void inicializarValores(){
        nombreOrganizacion.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        llenarTablaOrganizaciones();

        tablaOrganizaciones.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Organizacion>() {
            @Override
            public void changed(ObservableValue<? extends Organizacion> observable, Organizacion oldValue, Organizacion newValue) {
                if (newValue != null) {
                    if (modoEddicion == false) {
                        actualizarCampos(newValue);
                    }
                }
            }
        });
    }
    private void llenarTablaOrganizaciones(){
        tablaOrganizaciones.setItems(OrganizacionDAO.obtenerOrganizaciones());
    }

    private void actualizarCampos(Organizacion organizacion){
        tfRazonSocial.setText(organizacion.getRazonSocial());
        taDescripcion.setText(organizacion.getDescripcion());
        tfTelefono.setText(organizacion.getTelefono());
        tfCorreo.setText(organizacion.getCorreo());
        tfSector.setText(organizacion.getSector());
        tfCalle.setText(organizacion.getCalle());
        tfCiudad.setText(organizacion.getCiudad());
        tfEstado.setText(organizacion.getEstado());

    }

    private void modificarEdicion(){

        if (modoEddicion){
            tfRazonSocial.setEditable(false);
            taDescripcion.setEditable(false);
            tfTelefono.setEditable(false);
            tfCorreo.setEditable(false);
            tfSector.setEditable(false);
            tfCalle.setEditable(false);
            tfCiudad.setEditable(false);
            tfEstado.setEditable(false);
            estado.setDisable(true);
            modoEddicion = false;

        }else{
            tfRazonSocial.setEditable(true);
            taDescripcion.setEditable(true);
            tfTelefono.setEditable(true);
            tfCorreo.setEditable(true);
            tfSector.setEditable(true);
            tfCalle.setEditable(true);
            tfCiudad.setEditable(true);
            tfEstado.setEditable(true);
            estado.setDisable(false);
            modoEddicion = true;

        }

    }
    
}
