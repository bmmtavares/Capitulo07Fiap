package br.com.fiap.mercado.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MercadoDbManager {

	public static Connection obterConexao() {
		Connection conexao = null;

		try {
			// define o driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// interface jdbc cuja implementacao drivemanager abre uma conexao
			// com a url definida para acesso ao banco
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "teste1");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;

	}

}
