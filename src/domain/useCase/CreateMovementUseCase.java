package domain.useCase;

import domain.models.Movement;

import java.sql.SQLException;


public class CreateMovementUseCase implements MovementRepository{
    private MovementRepository movementRepository;

    public CreateMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void execute(Movement movement) throws SQLException {
        movementRepository.save(movement);
    }

    @Override
    public void save(Movement movement) throws SQLException {

    }
}


