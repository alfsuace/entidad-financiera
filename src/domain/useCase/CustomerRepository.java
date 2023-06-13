package domain.useCase;

import domain.models.Customer;

import java.sql.SQLException;

public interface CustomerRepository {

    public void save(Customer Customer) throws SQLException;
}