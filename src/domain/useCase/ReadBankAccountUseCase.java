package domain.useCase;

import domain.models.BankAccount;
import data.*;
import domain.models.Customer;
import domain.models.Movement;
import domain.models.Product;

import java.security.acl.Owner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadBankAccountUseCase {
    public List<BankAccount> obtenerCuentasBancarias() throws SQLException {
        Conexion conexion = new Conexion();
        List<BankAccount> cuentasBancarias = new ArrayList<>();
        String consulta = "SELECT cb.*, p.nombre AS producto" +
                " FROM cuentaBancaria cb" +
                " JOIN producto p ON cb.idProducto = p.id";
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String accNumber = resultSet.getString("accNumber");

            Customer owner = new Customer();
            owner.setId(resultSet.getString("id"));
            owner.setAddress(resultSet.getString("address"));
            owner.setTown(resultSet.getString("town"));
            owner.setAddressCode(resultSet.getString("addressCode"));

            Movement transaction = new Movement();
            transaction.setId(resultSet.getString("id"));
            transaction.setDescription(resultSet.getString("description"));
            transaction.setAmount(resultSet.getInt("amount"));

            Product product = new Product();
            product.setCode(resultSet.getString("code"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));

            Integer balance = resultSet.getInt("balance");


            BankAccount cuentaBancaria = new BankAccount();
            // Asignar los valores obtenidos a la cuentaBancaria
            cuentaBancaria.setId(id);
            cuentaBancaria.setAccNumber(accNumber);
            cuentaBancaria.setOwner(owner);
            cuentaBancaria.setTransaction(transaction);
            cuentaBancaria.setProduct(product);
            cuentaBancaria.setBalance(balance);

            cuentasBancarias.add(cuentaBancaria);
        }
        resultSet.close();
        statement.close();
        conexion.cerrarConexion();
        return cuentasBancarias;
    }

}
