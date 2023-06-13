package domain.useCase;

import data.Conexion;
import domain.models.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerUseCase {
    private CustomerRepository CustomerRepository;

    public List<Customer> obtenerUsuarios() throws SQLException {
        Conexion conexion = new Conexion();
        List<Customer> usuarios = new ArrayList<>();
        String consulta = "SELECT * FROM usuario";
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String dni = resultSet.getString("dni");
            String address = resultSet.getString("address");
            String town = resultSet.getString("town");
            String addressCode = resultSet.getString("addressCode");

            Customer usuario = new Customer();
            usuario.setId(id);
            usuario.setName(name);
            usuario.setSurname(surname);
            usuario.setDni(dni);
            usuario.setAddress(address);
            usuario.setTown(town);
            usuario.setAddressCode(addressCode);

            usuarios.add(usuario);
        }
        resultSet.close();
        statement.close();
        conexion.cerrarConexion();
        return usuarios;
    }
}
