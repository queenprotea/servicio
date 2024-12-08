package Gestion.modelo.dao;

import Gestion.modelo.raw.Coordinador;
import Restaurante.conexionbd.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CoordinadorDAO {

    private static HashMap<String, Object> registarCoordionador(Coordinador coordinador) throws SQLException{

        HashMap<String, Object> respuesta = new HashMap<>();
        Connection connection = ConexionBD.abrirConexion();
        if (connection!= null){
            try {
                String sqlSentencia = "INSERT INTO usuario (nombre, correo, contrasena, matricula, idUsuario, area_especialidad) VALUES (?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                statement.setString(1, coordinador.getNombre());
                statement.setString(2, coordinador.getCorreo());
                statement.setString(3, coordinador.getContrasena());
                statement.setString(4, coordinador.getMatricula());
                statement.setInt(5, coordinador.getIdUsuario());
                statement.setString(6, coordinador.getArea_especialidad());
                int resultadoSentencia = statement.executeUpdate();
                if(resultadoSentencia>0){
                    respuesta.put("Error", false);
                    respuesta.put("mensaje", "El coordiandor "+coordinador.getNombre()+" fue registrado exitosamente");
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


    private static Coordinador serializarCoordinador(ResultSet rs) throws SQLException{

        Coordinador coordinador = new Coordinador();
        coordinador.setContrasena(rs.getString("contrasena"));
        coordinador.setNombre(rs.getString("nombre"));
        coordinador.setCorreo(rs.getString("correo"));
        coordinador.setMatricula(rs.getString("matricula"));
        coordinador.setIdUsuario(rs.getInt("idUsuario"));
        coordinador.setArea_especialidad(rs.getString("area_especialidad"));

        return coordinador;

    }
}
