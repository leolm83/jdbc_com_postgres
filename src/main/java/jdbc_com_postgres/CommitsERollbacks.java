package jdbc_com_postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommitsERollbacks {
	public static void main(String[] args) {
		try (Connection con = new ConnectionFactory().criaConexao()) {
			ArrayList<ProdutoDTO> resultados = new ArrayList<>();
			// o padrao do jdbc é AUTOCOMMIT !

			resultados.add(ProdutoDAO.inserir("Leite", "Copo de Leite 400ml"));
			resultados.add(ProdutoDAO.inserir("Café ", "Copo de Café 500ml"));
			
			
			for (int x=0;x<resultados.size();x++) {
				if(resultados.get(x)!=null){ //estou retornando nulo no produto DAO. inserir caso algo de errado				
					System.out.print(resultados.get(x).getId() + "\t");
					System.out.print(resultados.get(x).getNome() + "\t");
					System.out.print(resultados.get(x).getDescricao()+ "\t\n");			
				}
				else {
					System.out.println("Algo deu errado durante a execução!!!");
				}
				}
			int deletados = ProdutoDAO.deletarIgualA(1);
			System.out.println(deletados);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
