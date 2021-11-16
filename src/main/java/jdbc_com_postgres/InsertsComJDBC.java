package jdbc_com_postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertsComJDBC {
	public static void main(String[] args) {
		
	try (Connection con = new ConnectionFactory().criaConexao();
			){
	//Evitando SQLInjection
	String nome= "Xbox SX";
	String descricao ="Video game de ultima geracao";
	PreparedStatement stmt = con.prepareStatement("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
	
	stmt.setString(1, nome);
	stmt.setString(2, descricao);
	Boolean resultado = stmt.execute();
	System.out.println(resultado);
	ResultSet idGerado = stmt.getGeneratedKeys();
	while(idGerado.next()) {
		
		System.out.println("Nome Coluna 1 : "+idGerado.getMetaData().getColumnName(1));
		System.out.println("Nome Coluna 2 : "+idGerado.getMetaData().getColumnName(2));
		System.out.println("Nome Coluna 3 : "+idGerado.getMetaData().getColumnName(3));
		System.out.println(idGerado.getInt("ID"));
		System.out.println(idGerado.getString("NOME"));
		System.out.println(idGerado.getString("DESCRICAO"));
		}	
	}
	catch(SQLException e){
		System.out.println("Ocorreu uma falha ao se conectar com o banco :");
		e.printStackTrace();
	}
}
}
