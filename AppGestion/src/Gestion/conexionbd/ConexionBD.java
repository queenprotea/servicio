package Gestion.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String NOMBRE_BD = "gestionservicio";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";

    public static Connection abrirConexion(){
        Connection conexionBD = null;
        String urlConexion = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                IP, PUERTO, NOMBRE_BD);
        try {
            Class.forName(DRIVER);
            conexionBD = DriverManager.getConnection(urlConexion,
                    "root", "30dtv0105k");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conexionBD;
    }
}
