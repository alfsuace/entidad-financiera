package data;


import Programacion.EntidadFinanciera.domain.models.BankAccount;
import Programacion.EntidadFinanciera.domain.useCase.BankAccountRepository;
import data.local.BankAccountFileDataSource;

public class BankAccountDataRepository implements BankAccountRepository {
    private BankAccountFileDataSource bankAccountFileDataSource;
    public BankAccountDataRepository(BankAccountFileDataSource bankAccountFileDataSource){
        this.bankAccountFileDataSource=bankAccountFileDataSource;
    }

    @Override
    public void save(BankAccount bankAccount) {

    }
}