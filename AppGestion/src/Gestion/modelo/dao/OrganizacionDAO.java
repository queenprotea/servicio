package Gestion.modelo.dao;

import Gestion.modelo.raw.Organizacion;
import Restaurante.conexionbd.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizacionDAO {

    private static Organizacion recuperarOrganizacion(ResultSet resultSet) throws SQLException {

        Organizacion organizacion = new Organizacion();
        organizacion.setIdOrganizacion(resultSet.getInt("idOrganizacion"));
        organizacion.setActiva(String.valueOf(resultSet.getBoolean("activa")));
        organizacion.setCalle(resultSet.getString("calle"));
        organizacion.setCiudad(resultSet.getString("ciudad"));
        organizacion.setCodigoPostal(resultSet.getString("codigoPostal"));
        organizacion.setCorreo(resultSet.getString("correo"));
        organizacion.setEstado(resultSet.getString("estado"));





        return null;
    }

}
