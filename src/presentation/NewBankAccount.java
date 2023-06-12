package presentation;

import data.BankAccountDataRepository;
import data.local.BankAccountFileDataSource;
import domain.models.BankAccount;
import domain.models.Customer;
import domain.models.Movement;
import domain.models.Product;
import domain.useCase.CreateBankAccountUseCase;

import java.sql.SQLException;

public class NewBankAccount {

    public void createBankAccount(Customer customer, Movement movement, Movement movement2, Product product) throws SQLException {
        BankAccount bankAccount= buildBankAccount(customer, movement, movement2, product);
        saveBankAccount(bankAccount);
    }
    private BankAccount buildBankAccount(Customer customer, Movement movement, Movement movement2, Product product){
        BankAccount bankAccount= new BankAccount();
        bankAccount.setAccNumber("1");
        bankAccount.setBalance(500);
        bankAccount.setOwner(customer);
        bankAccount.setTransaction(movement);
        bankAccount.setTransaction(movement2);
        bankAccount.setProduct(product);
        return bankAccount;
    }
    private void saveBankAccount(BankAccount bankAccount) throws SQLException {
        CreateBankAccountUseCase createBankAccountUseCase = new CreateBankAccountUseCase(
                new BankAccountDataRepository(BankAccountFileDataSource.getInstance()));
        createBankAccountUseCase.execute(bankAccount);
    }

}