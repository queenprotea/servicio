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

    public static HashMap<String, Object> registarEstudiante(Estudiante estudiante) throws SQLException {

        HashMap<String, Object> respuesta = new HashMap<>();
        Connection connection = ConexionBD.abrirConexion();
        if (connection!= null){
            try {
                String sqlsentencia = "INSERT INTO estudiante (nombre, apellidoPaterno, apellidoMaterno, correo, telefono, semestre, promedio, creditos, matricula) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlsentencia);
                statement.setString(1, estudiante.getNombre());
                statement.setString(2, estudiante.getApellidoPaterno());
                statement.setString(3, estudiante.getApellidoMaterno());
                statement.setString(4, estudiante.getCorreo());
                statement.setString(5, estudiante.getTelefono());
                statement.setString(6, estudiante.getSemestre());
                statement.setString(7, estudiante.getPromedio());
                statement.setString(8, String.valueOf(estudiante.getCreditos()));
                statement.setString(9, estudiante.getMatricula());

                int resultadoSentencia = statement.executeUpdate();
                if(resultadoSentencia>0){
                    respuesta.put("Error", false);
                    respuesta.put("mensaje", "El coordiandor "+estudiante.getNombre()+" fue registrado exitosamente");
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
