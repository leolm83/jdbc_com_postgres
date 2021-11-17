package jdbc_com_postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {
	//falta um metodo de select
	public static ProdutoDTO inserir(String nome, String descricao) {
		try (Connection con = new ConnectionFactory().criaConexao();
				PreparedStatement stmt = con.prepareStatement("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?,?)",
						Statement.RETURN_GENERATED_KEYS);) {
			con.setAutoCommit(false);
			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.execute();
			con.commit();
			ResultSet result = stmt.getGeneratedKeys();
			result.next();
			return new ProdutoDTO(result.getInt("ID"), result.getString("NOME"), result.getString("DESCRICAO"));

		} catch (Exception e) {
			System.out.println("Ocorreu uma falha ao tentar executar a inserção!!!");
			e.printStackTrace();
			return null;
		}

	}

	public static int deletarIgualA(int id) {
		try (Connection con = new ConnectionFactory().criaConexao();
				PreparedStatement stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");) {
			con.setAutoCommit(false);
			stmt.setInt(1, id);
			boolean resultado = stmt.execute();
			System.out.println(resultado);
			int qtdDeletada = stmt.getUpdateCount();
			System.out.println("Quantidade Deletada : " + qtdDeletada);
			con.commit();
			return qtdDeletada;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int deletarMaiorQue(int id) {
		try (Connection con = new ConnectionFactory().criaConexao();
				PreparedStatement stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");) {
			con.setAutoCommit(false);
			stmt.setInt(1, id);
			boolean resultado = stmt.execute();
			con.commit();
			System.out.println(resultado);
			int qtdDeletada = stmt.getUpdateCount();
			System.out.println("Quantidade Deletada : " + qtdDeletada);
			return qtdDeletada;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int deletarMenorQue(int id) {
		try (Connection con = new ConnectionFactory().criaConexao();
				PreparedStatement stmt = con.prepareStatement("DELETE FROM PRODUTO WHERE ID < ?");) {
			con.setAutoCommit(false);
			stmt.setInt(1, id);
			boolean resultado = stmt.execute();
			con.commit();
			System.out.println(resultado);
			int qtdDeletada = stmt.getUpdateCount();
			System.out.println("Quantidade Deletada : " + qtdDeletada);
			return qtdDeletada;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
