package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Coordinador;
import Gestion.modelo.raw.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class EstudianteDAO {

    private static HashMap<String, Object> registarEstudiante(Estudiante estudiante) throws SQLException {

        HashMap<String, Object> respuesta = new HashMap<>();
        Connection connection = ConexionBD.abrirConexion();
        if (connection!= null){
            try {
                String sqlSentencia = "INSERT INTO estudiante (nombre, correo, contrasena, matricula, idUsuario, area_especialidad) VALUES (?,?,?,?,?,?)";
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


    private static Estudiante serializarEstudiante(ResultSet rs) throws SQLException{

        Estudiante estudiante = new Estudiante();

        estudiante.setIdEstudiante(rs.getInt("idEstudiante"));
        estudiante.setNombre(rs.getString("nombre"));
        estudiante.setApellidoPaterno(rs.getString("apellidoPaterno"));
        estudiante.setApellidoMaterno(rs.getString("apellidoMaterno"));
        estudiante.setCorreo(rs.getString("correo"));
        estudiante.setTelefono(rs.getString("telefono"));
        estudiante.setSemestre(String.valueOf(rs.getInt("semestre")));
        estudiante.setPromedio(String.valueOf(rs.getDouble("promedio")));
        estudiante.setPassword(rs.getString("password"));
        estudiante.setMatricula(rs.getString("matricula"));
        estudiante.setEstado(rs.getString("estado"));

        return estudiante;

    }

    public static Estudiante obtenerEstudiantePorId(int idEstudiante) throws SQLException {

        try {

            Estudiante estudiante = new Estudiante();

            String sqlSentencia = "SELECT * FROM estudiante WHERE idOrganizacion = ?";
            PreparedStatement statement = ConexionBD.abrirConexion().prepareStatement(sqlSentencia);
            statement.setInt(1, idEstudiante);
            ResultSet resultSet = statement.executeQuery();
            estudiante = serializarEstudiante(resultSet);

            return estudiante;

        }catch (SQLException e){
            return null;
        }
    }

}
