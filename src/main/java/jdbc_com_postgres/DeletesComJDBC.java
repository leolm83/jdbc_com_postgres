package jdbc_com_postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletesComJDBC {
	public static void main(String[] args) {
		
	try (Connection con = new ConnectionFactory().criaConexao();
			){
	//dessa forma ele me retorna true ou false ^^
	Statement stmt = con.createStatement();
	boolean resultado =stmt.execute("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES ('MOUSE','MOUSE SEM FIO');");
	System.out.println(resultado);//quando nao tem retorno é false !!!! (nesse caso é false pois nao foi retornado nada apenas inserido)
	
	//a forma de obter resposta do que foi inserido é atraves do parametro Statement.RETURN_GENERATED_KEYS
	boolean novoResultado =stmt.execute("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES ('MOUSE','MOUSE SEM FIO');",Statement.RETURN_GENERATED_KEYS);
	System.out.println(novoResultado);
	ResultSet resultadoInsercaoNovoResultado = stmt.getGeneratedKeys();
	while(resultadoInsercaoNovoResultado.next()) {
		String nome =resultadoInsercaoNovoResultado.getString("Nome");
		System.out.println(nome);
	}
	}
	catch(SQLException e){
		System.out.println("Ocorreu uma falha ao se conectar com o banco :");
		e.printStackTrace();
	}
}
}
