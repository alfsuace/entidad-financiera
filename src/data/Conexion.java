package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;

    private static final String CLASE="com.mysql.cj.jdbc.Driver";

    public Conexion() throws SQLException {
        try {
            Class.forName(CLASE);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/entidadFinanciera","root","");
    }

    public void cerrarConexion() throws SQLException{
        if(conexion!=null && !conexion.isClosed()) {
            conexion.close();
        }
    }


    public PreparedStatement prepareStatementFunction(String consulta) throws SQLException {
        PreparedStatement statement = conexion.prepareStatement(consulta);
        return statement;
    }
}
