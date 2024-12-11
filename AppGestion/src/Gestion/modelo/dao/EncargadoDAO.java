package Gestion.modelo.dao;


import Gestion.modelo.raw.Coordinador;
import Gestion.modelo.raw.Encargado;
import Gestion.conexionbd.ConexionBD;
import Gestion.modelo.raw.Organizacion;
import javafx.collections.ObservableList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EncargadoDAO {
    public static HashMap<String, Object> registrarEncargado(Encargado encargado) throws SQLException {

        HashMap<String, Object> respuesta = new HashMap<>();
        Connection connection = ConexionBD.abrirConexion();
        if (connection!= null){
            try {

                String sqlSentencia = "INSERT INTO encargado (nombre, apellidoPaterno, contrasena, apellidoMaterno, puesto, telefono, correo, organizacion) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                statement.setString(1, encargado.getNombre());
                statement.setString(2, encargado.getCorreo());
                statement.setString(3, encargado.getContrasena());
                statement.setString(4, encargado.getApellidoPaterno());
                statement.setString(5, encargado.getPuesto());
                statement.setString(6, encargado.getTelefono());
                statement.setString(7, encargado.getApellidoMaterno());
                statement.setString(8, String.valueOf(encargado.getOrganizacion().getIdOrganizacion()));
                int resultadoSentencia = statement.executeUpdate();

                if(resultadoSentencia>0){
                    respuesta.put("Error", false);
                    respuesta.put("mensaje", "El encargado "+encargado.getNombre()+" fue registrado exitosamente");
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


    private static Encargado serializarEncargado(ResultSet rs) throws SQLException{

        Encargado encargado = new Encargado();

        encargado.setNombre(rs.getString("nombre"));
        encargado.setContrasena(rs.getString("contrasena"));
        encargado.setApellidoPaterno(rs.getString("apellidoPaterno"));
        encargado.setApellidoMaterno(rs.getString("apellidoMaterno"));
        encargado.setPuesto(rs.getString("puesto"));
        encargado.setTelefono(rs.getString("telefono"));
        encargado.setCorreo(rs.getString("correo"));
        encargado.setIdUsuario(rs.getInt("idUsuario"));
        encargado.setOrganizacion(OrganizacionDAO.obtenerOrganizacionPorId(rs.getInt("idOrganizacion")));

        return encargado;

    }

    public static Encargado obtenerEncargadoPorId(int idCoordinador) throws SQLException {

        try {

            Encargado encargado = new Encargado();

            String sqlSentencia = "SELECT * FROM encargado WHERE idEncargado = ?";
            PreparedStatement statement = ConexionBD.abrirConexion().prepareStatement(sqlSentencia);
            statement.setInt(1, idCoordinador);
            ResultSet resultSet = statement.executeQuery();
            encargado = serializarEncargado(resultSet);

            return encargado;
        }catch (SQLException e){
            return null;
        }
    }
    public static ObservableList<Encargado> obtenerEncargados() throws SQLException {

        List<Encargado> encargados = null;

        Connection connection = ConexionBD.abrirConexion();

        if (connection != null) {
            try {

                String sqlSentencia = "SELECT * FROM encargado";
                PreparedStatement statement = connection.prepareStatement(sqlSentencia);
                ResultSet resultSet = statement.executeQuery();
                encargados = new ArrayList<>();
                while (resultSet.next()) {
                    encargados.add(serializarEncargado(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return (ObservableList<Encargado>) encargados;
    }


}
