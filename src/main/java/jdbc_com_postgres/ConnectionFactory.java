package jdbc_com_postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory  {
	//factory method
	// o objetivo é criar mais facilmente objetos
	public Connection criaConexao() throws SQLException{
	return DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja_virtual?user=jdbc1&password=jdbc");
	}
}
