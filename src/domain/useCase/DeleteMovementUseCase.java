package domain.useCase;


import data.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMovementUseCase {
    public void deleteMovement(String movementId) throws SQLException {
        String consulta = "DELETE FROM movement WHERE id=?";
        Conexion conexion = new Conexion();
        PreparedStatement statement = conexion.prepareStatementFunction(consulta);
        statement.setString(1, movementId);
        statement.execute();
        statement.close();
        conexion.cerrarConexion();
    }
}