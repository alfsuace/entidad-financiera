package domain.useCase;

import domain.models.Customer;
import domain.models.Movement;

import java.sql.SQLException;

public interface MovementRepository {
    public void save(Movement movement) throws SQLException;

}
