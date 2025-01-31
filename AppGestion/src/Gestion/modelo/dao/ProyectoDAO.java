package Gestion.modelo.dao;

import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Proyecto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProyectoDAO {
    public static HashMap<String, Object> registarProyecto(Proyecto proyecto) throws SQLException {

        HashMap<String, Object> respuesta = new HashMap<>();
        Connection connection = ConexionBD.abrirConexion();
        if (connection!= null){
            try {
                String sqlSentencia = "INSERT INTO proyecto (nombre, descripcion, fechaInicio, fechaFin, idEncargado, cupos, tipo) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                statement.setString(1, proyecto.getNombre());
                statement.setString(2, proyecto.getDescripcion());
                statement.setString(3, proyecto.getFechaInicio());
                statement.setString(4, proyecto.getFechaFin());
                statement.setString(5, String.valueOf(proyecto.getEncargado().getIdUsuario()));
                statement.setInt(6, proyecto.getCupos());
                statement.setString(7, proyecto.getTipo());
                int resultadoSentencia = statement.executeUpdate();
                if(resultadoSentencia>0){
                    respuesta.put("Error", false);
                    respuesta.put("mensaje", "El coordiandor "+proyecto.getNombre()+" fue registrado exitosamente");
                }else{
                    respuesta.put("Error", true);
                    respuesta.put("mensaje", "Error al registrar");
                }
            }catch (SQLException e){
                respuesta.put("Error", true);
                respuesta.put("mensaje", "Error al registrar");
                e.printStackTrace();
            }finally {
                connection.close();
            }
        }else {
            respuesta.put("Error", true);
            respuesta.put("mensaje", "Error al conectar con la base de datos");
        }
        return respuesta;

    }


    public static Proyecto serializarProyecto(ResultSet rs) throws SQLException{

        Proyecto proyecto = new Proyecto();

        proyecto.setNombre(rs.getString("nombre"));
        proyecto.setDescripcion(rs.getString("descripcion"));
        proyecto.setFechaInicio(rs.getString("fechaInicio"));
        proyecto.setFechaFin(rs.getString("fechaFin"));
        proyecto.setTipo(rs.getString("tipo"));
        proyecto.setCupos(rs.getInt("cupos"));
        proyecto.setEstado(rs.getString("estado"));
        proyecto.setIdProyecto(Integer.parseInt(String.valueOf(rs.getInt("idProyecto"))));
        proyecto.setCoordinador(CoordinadorDAO.obtenerCoordinadorPorId(rs.getInt("idEncargado")));
        proyecto.setOrganizacion(OrganizacionDAO.obtenerOrganizacionPorId(rs.getInt("idOrganizacion")));
        proyecto.setEncargado(EncargadoDAO.obtenerEncargadoPorId(rs.getInt("idEncargado")));

        return proyecto;

    }

    public static Proyecto obtenerProyectoPorId(String idProyecto) throws SQLException {
        Proyecto proyecto = new Proyecto();
        try {

            String sqlSentencia = "SELECT * FROM proyecto WHERE idProyecto= ?";
            PreparedStatement statement = ConexionBD.abrirConexion().prepareStatement(sqlSentencia);
            statement.setString(1, idProyecto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                proyecto = serializarProyecto(resultSet);
            }
        }catch (SQLException e){
            return null;
        }

        return proyecto;
    }
    public static ObservableList<Proyecto> obtenerProyectos() throws SQLException {

        List<Proyecto> proyectos = null;

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM proyecto";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();
                proyectos = new ArrayList<>();
                while (resultSet.next()) {
                    proyectos.add(serializarProyecto(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return (ObservableList<Proyecto>) proyectos;
    }
    public static ObservableList<Proyecto> obtenerProyectosSS() throws SQLException {

        ObservableList<Proyecto> proyectos = FXCollections.observableArrayList();

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM proyecto WHERE tipo = ?" ;
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);

                statement.setString(1,"Servicio Social");
                ResultSet resultSet = statement.executeQuery();


                while (resultSet.next()) {
                    proyectos.add(serializarProyecto(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  proyectos;
    }

    public static ObservableList<Proyecto> obtenerProyectosPP() throws SQLException {

        ObservableList<Proyecto> proyectos = FXCollections.observableArrayList();

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM proyecto WHERE tipo = ?";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                statement.setString(1,"Practicas Profesionales");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    proyectos.add(serializarProyecto(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  proyectos;
    }

}
