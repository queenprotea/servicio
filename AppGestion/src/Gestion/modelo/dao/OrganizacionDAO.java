package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Organizacion;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizacionDAO {

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
