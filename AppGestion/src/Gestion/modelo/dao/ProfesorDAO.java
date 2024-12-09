package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Coordinador;
import Gestion.modelo.raw.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProfesorDAO {
    private static HashMap<String, Object> registarProfesor(Profesor profesor) throws SQLException {

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


    private static Profesor serializarProfesor(ResultSet rs) throws SQLException{

        Profesor profesor = new Profesor();

        profesor.setNombre(rs.getString("nombre"));
        profesor.setApellidoPaterno(rs.getString("apellidoPaterno"));
        profesor.setApellidoMaterno(rs.getString("apellidoMaterno"));
        profesor.setCorreo(rs.getString("correo"));
        profesor.setTelefono(rs.getString("telefono"));
        profesor.setContrasena(rs.getString("contrasena"));
        profesor.setEspecialidad(rs.getString("especialidad"));
        profesor.setMatricula(rs.getString("matricula"));
        profesor.setEstado(rs.getString("estado"));
        profesor.setIdUsuario(String.valueOf(rs.getInt("idUsuario")));

        return profesor;

    }

    public static Profesor obtenerProfesorPorId(int idProfesor) throws SQLException {

        try {

            String sqlSentencia = "SELECT * FROM profesor WHERE idprofesor= ?";
            PreparedStatement statement = ConexionBD.abrirConexion().prepareStatement(sqlSentencia);
            statement.setInt(1, idProfesor);
            ResultSet resultSet = statement.executeQuery();

            return serializarProfesor(resultSet);
        }catch (SQLException e){
            return null;
        }
    }
}
