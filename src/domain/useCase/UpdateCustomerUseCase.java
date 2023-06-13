package domain.useCase;

import data.Conexion;
import domain.models.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustomerUseCase {
    public void actualizarCustomer(Customer customer) throws SQLException {
        String consulta = "UPDATE customer SET address=?, town=?, addressCode=?, dni=?, name=?, surname=? WHERE id=?";
        Conexion conexion = new Conexion();
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, customer.getAddress());
        statement.setString(2, customer.getTown());
        statement.setString(3, customer.getAddressCode());
        statement.setString(4, customer.getDni());
        statement.setString(5, customer.getName());
        statement.setString(6, customer.getSurname());
        statement.setString(7, customer.getId());
        statement.executeUpdate();
        statement.close();
    }

}
