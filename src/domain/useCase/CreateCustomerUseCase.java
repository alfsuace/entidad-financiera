package domain.useCase;

import domain.models.Customer;

import java.sql.SQLException;

public class CreateCustomerUseCase {
    private CustomerRepository CustomerRepository;

    public CreateCustomerUseCase(CustomerRepository CustomerRepository){
        this.CustomerRepository=CustomerRepository;
    }

    public void execute(Customer Customer) throws SQLException {
        CustomerRepository.save(Customer);
    }
}
