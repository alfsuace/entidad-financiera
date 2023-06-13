package presentation;

import data.MovementDataRepository;
import data.local.MovementFileDataSource;
import domain.models.Movement;
import domain.useCase.CreateMovementUseCase;

import java.sql.SQLException;

public class NewCharge {
    public void createCharge() throws SQLException {
        Movement movement=buildMovement();
        saveMovement(movement);
    }
    private Movement buildMovement(){
        Movement movement = new Movement();
        movement.setAmount(-15);
        movement.setDescription("cena");
        movement.setId("2");
        return movement;
    }
    private void saveMovement(Movement movement) throws SQLException {
        CreateMovementUseCase createMovementUseCase;
        createMovementUseCase = new CreateMovementUseCase(
                new MovementDataRepository(MovementFileDataSource.getInstance()));
        createMovementUseCase.execute(movement);
    }
}