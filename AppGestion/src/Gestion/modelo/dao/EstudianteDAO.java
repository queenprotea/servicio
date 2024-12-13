package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;

import Gestion.modelo.raw.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class EstudianteDAO {

    public static HashMap<String, Object> registarEstudiante(Estudiante estudiante) throws SQLException {

        HashMap<String, Object> respuesta = new HashMap<>();
        Connection connection = ConexionBD.abrirConexion();
        if (connection!= null){
            try {
                String sqlsentencia = "INSERT INTO estudiante (nombre, apellidoPaterno, apellidoMaterno, correo, telefono, semestre, promedio, creditos, matricula, tipoproyecto, contrasena) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
                statement.setString(10, estudiante.getTipoProyecto());
                statement.setString(11,estudiante.getContrasena());

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


    public static Estudiante serializarEstudiante(ResultSet rs) throws SQLException{

        Estudiante estudiante = new Estudiante();

        estudiante.setIdEstudiante(rs.getInt("idEstudiante"));
        estudiante.setNombre(rs.getString("nombre"));
        estudiante.setApellidoPaterno(rs.getString("apellidoPaterno"));
        estudiante.setApellidoMaterno(rs.getString("apellidoMaterno"));
        estudiante.setCorreo(rs.getString("correo"));
        estudiante.setTelefono(rs.getString("telefono"));
        estudiante.setSemestre(String.valueOf(rs.getInt("semestre")));
        estudiante.setPromedio(String.valueOf(rs.getDouble("promedio")));
        estudiante.setContrasena(rs.getString("contrasena"));
        estudiante.setMatricula(rs.getString("matricula"));
        estudiante.setEstado(rs.getString("estado"));
        estudiante.setProyecto(ProyectoDAO.obtenerProyectoPorId(rs.getInt("idProyecto")));

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

    public static ObservableList<Estudiante> obtenerEstudiantes() throws SQLException {

        ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM estudiante";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    estudiantes.add(serializarEstudiante(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection.close();
            }
        }

        return  estudiantes;
    }

    public static void modificarEstudiante(Estudiante estudiante) throws SQLException {
        Connection connection = ConexionBD.abrirConexion();
        System.out.println(estudiante.getNombre() + estudiante.getIdEstudiante());
        if (connection != null) {
            try {
                String sqlsentencia = "UPDATE estudiante SET nombre = ?, apellidopaterno = ?, apellidomaterno = ?," +
                        " matricula = ?, telefono = ?, semestre = ?, correo = ?, estado  = ?, creditos = ?, idProyecto = ? ," +
                        "seleccionproyecto = ? WHERE idEstudiante = ?";
                PreparedStatement statement = connection.prepareStatement(sqlsentencia);
                statement.setString(1, estudiante.getNombre());
                statement.setString(2, estudiante.getApellidoPaterno());
                statement.setString(3, estudiante.getApellidoMaterno());
                statement.setString(4, estudiante.getMatricula());
                statement.setString(5, estudiante.getTelefono());
                statement.setString(6, estudiante.getSemestre());
                statement.setString(7, estudiante.getCorreo());
                statement.setString(8, estudiante.getEstado());
                statement.setInt(9, estudiante.getCreditos());
                statement.setInt(10, estudiante.getProyecto().getIdProyecto());
                statement.setString(11, estudiante.getSeleccionProyecto());
                statement.setInt(12, estudiante.getIdEstudiante());


                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                connection.close();
            }
        }
    }
    public static ObservableList<Estudiante> obtenerEstudiantesSS() throws SQLException {

        List<Estudiante> estudiantes = null;

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM estudiante WHERE tipoproyecto = 1";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();
                estudiantes = new ArrayList<>();
                while (resultSet.next()) {
                    estudiantes.add(serializarEstudiante(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection.close();
            }
        }

        return (ObservableList<Estudiante>) estudiantes;
    }

    public static ObservableList<Estudiante> obtenerEstudiantesPP() throws SQLException {

        List<Estudiante> estudiantes = null;

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM estudiante WHERE tipoproyecto = 0";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();
                estudiantes = new ArrayList<>();
                while (resultSet.next()) {
                    estudiantes.add(serializarEstudiante(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection.close();
            }
        }

        return (ObservableList<Estudiante>) estudiantes;
    }

    public static ObservableList<Estudiante> obtenerEstudiantesPorMatricula(String  matricula) throws SQLException {

        List<Estudiante> estudiantes = null;

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM estudiante WHERE matricula = "+ matricula;
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();
                estudiantes = new ArrayList<>();
                while (resultSet.next()) {
                    estudiantes.add(serializarEstudiante(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection.close();
            }
        }

        return (ObservableList<Estudiante>) estudiantes;
    }

}
