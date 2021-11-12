package jdbc_com_postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectsComJDBC {
	public static void main(String[] args) {
		
	try (Connection con = new ConnectionFactory().criaConexao();
			){
	//dessa forma ele me retorna true ou false ^^
	Statement stmt = con.createStatement();
	boolean resultado =stmt.execute("SELECT * FROM produto");
	System.out.print("Conectado!!!");	
	System.out.println(resultado);
	
	
	
	ResultSet produtos =stmt.getResultSet();
	
	while(produtos.next()){
		Integer id = produtos.getInt("ID");
		System.out.println(id);
		String nome = produtos.getString("Nome");
		System.out.println(nome);
		String descricao = produtos.getString("Descricao");
		System.out.println(descricao);
	}
	
	}
	catch(SQLException e){
		System.out.println("Ocorreu uma falha ao se conectar com o banco :");
		e.printStackTrace();
	}
	}
}
