package presentation;

import data.MovementDataRepository;
import data.local.MovementFileDataSource;
import domain.models.Movement;
import domain.useCase.CreateMovementUseCase;

import java.sql.SQLException;

public class NewPayment {

    public void createPayment() throws SQLException {
        Movement movement2=buildMovement();
        saveMovement(movement2);
    }
    private Movement buildMovement(){
        Movement movement2 = new Movement();
        movement2.setAmount(1000);
        movement2.setDescription("sueldo");
        movement2.setId("1");
        return movement2;
    }
    private void saveMovement(Movement movement2) throws SQLException {
        CreateMovementUseCase createMovementUseCase = new CreateMovementUseCase(
                new MovementDataRepository(MovementFileDataSource.getInstance()));
        createMovementUseCase.execute(movement2);
    }
}