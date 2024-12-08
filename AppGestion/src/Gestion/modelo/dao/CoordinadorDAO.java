package Gestion.modelo.dao;

import Gestion.modelo.raw.Coordinador;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoordinadorDAO {

    private static Coordinador serializarCoordinador(ResultSet rs) throws SQLException{

        Coordinador coordinador = new Coordinador();
        coordinador.setContrasena(rs.getString("contrasena"));
        coordinador.setNombre(rs.getString("nombre"));
        coordinador.setCorreo(rs.getString("correo"));



    }

}
