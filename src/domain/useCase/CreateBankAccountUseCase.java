package domain.useCase;

import domain.models.BankAccount;

import java.sql.SQLException;

public class CreateBankAccountUseCase {
    private BankAccountRepository bankAccountRepository;

    public CreateBankAccountUseCase(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public void execute(BankAccount bankAccount) throws SQLException {
        bankAccountRepository.save(bankAccount);
        //primero que mire local y luego bbdd?? o al reves, pero que mire ambas y use una
    }
}

