package data;


import data.local.MovementFileDataSource;
import domain.models.Movement;
import domain.useCase.MovementRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovementDataRepository implements MovementRepository {
    private MovementFileDataSource movementFileDataSource;
    private Conexion conexion;

    public MovementDataRepository(MovementFileDataSource movementFileDataSource){
        this.movementFileDataSource = movementFileDataSource;
    }

    @Override
    public void save(Movement movement) throws SQLException {
        String consulta = "INSERT INTO Movement(id, description, amount) VALUES (?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, movement.getId());
        statement.setString(2, movement.getDescription());
        statement.setInt(3, movement.getAmount());
        statement.executeUpdate();
        statement.close();
    }
}

