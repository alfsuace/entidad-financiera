package domain.useCase;

import domain.models.BankAccount;

public interface BankAccountRepository {
    void save(BankAccount bankAccount);
}