package domain.useCase;

import domain.models.BankAccount;

import java.sql.SQLException;

public interface BankAccountRepository {
    void save(BankAccount bankAccount) throws SQLException;
}