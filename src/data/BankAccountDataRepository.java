package data;

import domain.useCase.BankAccountRepository;
import data.local.BankAccountFileDataSource;
import domain.models.BankAccount;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankAccountDataRepository implements BankAccountRepository {
    private BankAccountFileDataSource bankAccountFileDataSource;
    private Conexion conexion;
    public BankAccountDataRepository(BankAccountFileDataSource bankAccountFileDataSource){
        this.bankAccountFileDataSource=bankAccountFileDataSource;
    }

    @Override
    public void save(BankAccount bankAccount) throws SQLException {

        String consulta="INSERT INTO BankAccount(id, accNumber, owner, transaction, product, balance VALUES(?, ?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, bankAccount.getId());
        statement.setString(2, bankAccount.getAccNumber());
        statement.setObject(3, bankAccount.getOwner());
        statement.setObject(4, bankAccount.getTransaction());
        statement.setObject(5, bankAccount.getProduct());
        statement.setDouble(6, bankAccount.getBalance());
        statement.executeUpdate();
        statement.close();
    }
}