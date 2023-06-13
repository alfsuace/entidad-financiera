package domain.useCase;

import domain.models.Customer;

public class CreateCustomerUseCase {
    private CustomerRepository CustomerRepository;

    public CreateCustomerUseCase(CustomerRepository CustomerRepository){
        this.CustomerRepository=CustomerRepository;
    }

    public void execute(Customer Customer){
        CustomerRepository.save(Customer);
    }
}
