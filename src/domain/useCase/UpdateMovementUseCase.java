package domain.useCase;

import data.Conexion;
import domain.models.Movement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMovementUseCase {
    public void actualizarMovement(Movement movement) throws SQLException {
        String consulta = "UPDATE movement SET description=?, amount=? WHERE id=?";
        Conexion conexion = new Conexion();
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, movement.getDescription());
        statement.setInt(2, movement.getAmount());
        statement.setString(3, movement.getId());
        statement.executeUpdate();
        statement.close();
        conexion.cerrarConexion();
    }

}
