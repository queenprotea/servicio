package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Encargado;
import Gestion.modelo.raw.Organizacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrganizacionDAO {

    public static HashMap<String, Object> registrarOrganizacion(Organizacion organizacion) throws SQLException {

        HashMap<String, Object> respuesta = new HashMap<>();
        Connection connection = ConexionBD.abrirConexion();
        if (connection!= null){
            try {

                String sqlSentencia = "INSERT INTO organizacion (razonsocial, telefono, calle, ciudad, codigoPostal, correo, estado, activa, descripcion) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                statement.setString(1,organizacion.getRazonSocial());
                statement.setString(2,organizacion.getTelefono());
                statement.setString(3,organizacion.getCalle());
                statement.setString(4,organizacion.getCiudad());
                statement.setString(5,organizacion.getCodigoPostal());
                statement.setString(6,organizacion.getCorreo());
                statement.setString(7,organizacion.getEstado());
                statement.setString(8,organizacion.getActiva());
                statement.setString(9,organizacion.getDescripcion());

                int resultadoSentencia = statement.executeUpdate();

                if(resultadoSentencia>0){
                    respuesta.put("Error", false);
                    respuesta.put("mensaje", "El encargado "+organizacion.getRazonSocial()+" fue registrado exitosamente");
                }else{
                    respuesta.put("Error", true);
                    respuesta.put("mensaje", "Error al registrar");
                }

            }catch (SQLException e){
                respuesta.put("Error", true);
                respuesta.put("mensaje", "Error al registrar");
            }finally {
                connection.close();
            }

        }else {
            respuesta.put("Error", true);
            respuesta.put("mensaje", "Error al conectar con la base de datos");
        }

        return respuesta;
    }

    public static ObservableList<Organizacion> obtenerOrganizaciones()  {

        ObservableList<Organizacion> organizaciones = FXCollections.observableArrayList();

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM organizacion";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    organizaciones.add(serializarOrganizacion(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return organizaciones;
    }

    public static Organizacion serializarOrganizacion(ResultSet resultSet) throws SQLException {

        Organizacion organizacion = new Organizacion();

        organizacion.setRazonSocial(resultSet.getString("razonsocial"));
        organizacion.setIdOrganizacion(resultSet.getInt("idOrganizacion"));
        organizacion.setActiva(resultSet.getString("activa"));
        organizacion.setCalle(resultSet.getString("calle"));
        organizacion.setCiudad(resultSet.getString("ciudad"));
        organizacion.setCodigoPostal(resultSet.getString("codigoPostal"));
        organizacion.setCorreo(resultSet.getString("correo"));
        organizacion.setEstado(resultSet.getString("estado"));


        return organizacion;
    }

    public static Organizacion obtenerOrganizacionPorId(int idOrganizacion) throws SQLException {

        Organizacion organizacion = new Organizacion();

        String sqlSentencia = "SELECT * FROM organizacion WHERE idOrganizacion = ?";
        PreparedStatement statement = ConexionBD.abrirConexion().prepareStatement(sqlSentencia);
        statement.setInt(1, idOrganizacion);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            organizacion = serializarOrganizacion(resultSet);
        }


        return organizacion;
    }

    public static void modificarOrganizacion(Organizacion organizacion) throws SQLException {
        Connection connection = ConexionBD.abrirConexion();
        if (connection != null) {
            try {
                String sqlSentencia = "UPDATE organizacion SET razonsocial = ?, calle = ?, telefono = ?," +
                        "codigopostal = ?, correo = ?, estado = ?, ciudad = ?, sector = ? , activa = ? WHERE idOrganizacion = ?" ;
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                statement.setString(1, organizacion.getRazonSocial());
                statement.setString(2, organizacion.getCalle());
                statement.setString(3, organizacion.getTelefono());
                statement.setString(4, organizacion.getCodigoPostal());
                statement.setString(5, organizacion.getCorreo());
                statement.setString(6, organizacion.getEstado());
                statement.setString(7, organizacion.getCiudad());
                statement.setString(8, organizacion.getSector());
                statement.setString(9, organizacion.getActiva());
                statement.setInt(10, organizacion.getIdOrganizacion());

                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                connection.close();
            }
        }
    }

}
