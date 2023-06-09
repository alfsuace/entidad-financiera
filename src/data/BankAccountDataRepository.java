package data;

import domain.useCase.BankAccountRepository;
import data.local.BankAccountFileDataSource;
import domain.models.BankAccount;

public class BankAccountDataRepository implements BankAccountRepository {
    private BankAccountFileDataSource bankAccountFileDataSource;
    public BankAccountDataRepository(BankAccountFileDataSource bankAccountFileDataSource){
        this.bankAccountFileDataSource=bankAccountFileDataSource;
    }

    @Override
    public void save(BankAccount bankAccount) {

    }
}