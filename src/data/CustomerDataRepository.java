package data;

import data.local.CustomerFileDataSource;
import domain.models.Customer;
import domain.useCase.CustomerRepository;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDataRepository implements CustomerRepository {
    private CustomerFileDataSource customerFileDataSource;
    private Conexion conexion;

    public CustomerDataRepository(CustomerFileDataSource customerFileDataSource){
        this.customerFileDataSource = customerFileDataSource;
    }

    @Override
    public void save(Customer customer) throws SQLException {
        String consulta = "INSERT INTO Customer(id, address, town, addressCode, dni, name, surname) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, customer.getId());
        statement.setString(2, customer.getAddress());
        statement.setString(3, customer.getTown());
        statement.setString(4, customer.getAddressCode());
        statement.setString(5, customer.getDni());
        statement.setString(6, customer.getName());
        statement.setString(7, customer.getSurname());
        statement.executeUpdate();
        statement.close();
    }
}
