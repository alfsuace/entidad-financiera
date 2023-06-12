package domain.useCase;

import data.Conexion;
import domain.models.BankAccount;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBankAccountUseCase {
    public void actualizarCuentaBancaria(BankAccount cuentaBancaria) throws SQLException {
        String consulta = "UPDATE cuentaBancaria SET id=?, accNumber=?, owner=?, transaction=?, product=?, balance=? WHERE id=?";
        Conexion conexion= new Conexion();
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, cuentaBancaria.getId());
        statement.setString(2, cuentaBancaria.getAccNumber());
        statement.setString(3, cuentaBancaria.getOwner().toString());
        statement.setString(4, cuentaBancaria.getTransaction().toString());
        statement.setString(5, cuentaBancaria.getProduct().toString());
        statement.setInt(6, cuentaBancaria.getBalance());
        statement.setString(7, cuentaBancaria.getId());
        statement.executeUpdate();
        statement.close();
    }

}
