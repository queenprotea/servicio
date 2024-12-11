package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Encargado;
import Gestion.modelo.raw.Organizacion;
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

    public static ObservableList<Organizacion> obtenerOrganizaciones() throws SQLException {

        List<Organizacion> organizaciones = null;

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM organizacion";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();
                organizaciones = new ArrayList<>();
                while (resultSet.next()) {
                    organizaciones.add(serializarOrganizacion(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return (ObservableList<Organizacion>) organizaciones;
    }

    public static Organizacion serializarOrganizacion(ResultSet resultSet) throws SQLException {

        Organizacion organizacion = new Organizacion();

        organizacion.setIdOrganizacion(resultSet.getInt("idOrganizacion"));
        organizacion.setActiva(String.valueOf(resultSet.getBoolean("activa")));
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
        organizacion = serializarOrganizacion(resultSet);

        return organizacion;
    }

}
