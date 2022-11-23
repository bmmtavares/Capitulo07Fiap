package br.com.fiap.mercado.view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteCrudEstatico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			// define o driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// interface jdbc cuja implementacao drivemanager abre uma conexao
			// com a url definida para acesso ao banco
			Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "teste1");

			System.out.println("Conectou!");

			Statement stmt = conexao.createStatement();
			stmt.executeUpdate("INSERT INTO t_produto (cd_produto, nm_produto, vl_produto, dt_validade)"
					+ " VALUES (SEQ_PRODUTO.nextval, 'Uva', 12.80 ,TO_DATE('19/01/2022','dd/mm/yyyy'))");

			String sqlUpdate = "UPDATE t_produto SET vl_produto = 13 WHERE" + "    cd_produto = 1";
			stmt.executeUpdate(sqlUpdate);

			ResultSet result = stmt
					.executeQuery("SELECT cd_produto,nm_produto," + "    vl_produto, dt_validade FROM t_produto ");

			// percorrer registros encontrados
			while (result.next()) {
				// recupera valor de cada coluna e imprime
				System.out.println(result.getInt("CD_PRODUTO") + " " + result.getString("NM_PRODUTO") + " "
						+ result.getDouble("VL_PRODUTO") + " " + result.getDate("dt_validade"));
			}

			// delete
			String sqlDelete = "DELETE FROM t_produto\r\n" + "WHERE\r\n" + "    cd_produto = 2";
			stmt.executeUpdate(sqlDelete);

			// fecha conexao
			conexao.close();

			// tratamento erro conexao
		} catch (SQLException e) {
			System.err.println("Nao foi possivel conectar no Oracle Localhost");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("O driver JDBC nao foi achado!");
			e.printStackTrace();
		}

	}

}
