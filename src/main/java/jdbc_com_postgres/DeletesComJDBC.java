package jdbc_com_postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletesComJDBC {
	public static void main(String[] args) {
		
	try (Connection con = new ConnectionFactory().criaConexao();
			){
	int id = 5;
	PreparedStatement stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
	stmt.setInt(1,id);
	boolean resultado =stmt.execute();
	System.out.println(resultado);
	Integer linhasModificadas= stmt.getUpdateCount();
	if(linhasModificadas!=0) {
		System.out.println("Quantidade de linhas modificadas(excluidas nesse caso) "+linhasModificadas);
	} else {
		System.out.println("Nao foram modificadas linhas nessa execucao!");
	}
	
	}
	catch(SQLException e){
		System.out.println("Ocorreu uma falha ao se conectar com o banco :");
		e.printStackTrace();
	}
}
}
