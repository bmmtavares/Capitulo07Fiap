package br.com.fiap.mercado.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDeConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			
			//define o driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//interface jdbc cuja implementacao drivemanager abre uma conexao
			//com a url definida para acesso ao banco
			Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "teste1");
			
			System.out.println("Conectou!");
			
			//fecha conexao
			conexao.close();
			
			//tratamento erro conexao
		} catch (SQLException e) {
			System.err.println("Nao foi possivel conectar no Oracle Localhost");
			e.printStackTrace();
			
			//tratamento erro qdo nao acha driver do oracle
		} catch (ClassNotFoundException e) {
			System.err.println("O driver JDBC nao foi achado!");
			e.printStackTrace();
			
		}
		
	}

}
