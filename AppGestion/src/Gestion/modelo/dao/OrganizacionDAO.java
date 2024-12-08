package Gestion.modelo.dao;

import Gestion.modelo.raw.Organizacion;
import Restaurante.conexionbd.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrganizacionDAO {

    private static Organizacion recuperarOrganizacion(String idOrganizacion) throws SQLException {

        Connection connection = ConexionBD.abrirConexion();
        String sqlSentencia = "SELECT * FROM organizacion WHERE idOrganizacion = ?";
        PreparedStatement statement = connection.prepareStatement(sqlSentencia);


        return null;
    }

}
