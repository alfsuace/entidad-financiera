package domain.useCase;

import domain.models.Customer;

public class ReadCustomerUseCase {
    private CustomerRepository CustomerRepository;

    public ReadCustomerUseCase(CustomerRepository CustomerRepository){
        this.CustomerRepository=CustomerRepository;
    }

    public Customer execute(String codigoCustomer){
        return CustomerRepository.findById(codigoCustomer);
    }
}
