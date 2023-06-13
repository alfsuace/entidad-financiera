package domain.useCase;

public class DeleteCustomerUseCase {
    private CustomerRepository CustomerRepository;

    public DeleteCustomerUseCase (CustomerRepository CustomerRepository){
        this.CustomerRepository=CustomerRepository;
    }

    public void execute(String codigoCliente){
        CustomerRepository.delete(codigoCliente);
    }
}
