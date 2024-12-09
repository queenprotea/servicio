package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Organizacion;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrganizacionDAO {

    public static List<Organizacion> obtenerOrganizaciones() throws SQLException {



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
