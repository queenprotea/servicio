package Gestion.modelo.dao;


import Gestion.modelo.raw.Encargado;
import Gestion.conexionbd.ConexionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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

}
