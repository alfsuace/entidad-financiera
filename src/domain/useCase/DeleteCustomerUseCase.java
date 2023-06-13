package domain.useCase;

import data.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCustomerUseCase {
    private CustomerRepository CustomerRepository;

    public void borrarCliente(String id) throws SQLException {
        String consulta = "DELETE FROM customer WHERE id=?";
        Conexion conexion = new Conexion();
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, id);
        statement.execute();
        statement.close();
        conexion.cerrarConexion();
    }

}
