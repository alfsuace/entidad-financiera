package domain.useCase;

import data.Conexion;
import domain.models.Movement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReadMovementUseCase {
    private MovementRepository movementRepository;

    public List<Movement> obtenerMovimientos() throws SQLException {
        Conexion conexion = new Conexion();
        List<Movement> movimientos = new ArrayList<>();
        String consulta = "SELECT * FROM movimiento";
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String description = resultSet.getString("description");
            Integer amount = resultSet.getInt("amount");

            Movement movimiento = new Movement();
            movimiento.setId(id);
            movimiento.setDescription(description);
            movimiento.setAmount(amount);

            movimientos.add(movimiento);
        }
        resultSet.close();
        statement.close();
        conexion.cerrarConexion();
        return movimientos;
    }
}
