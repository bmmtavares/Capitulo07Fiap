package br.com.fiap.mercado.view;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.mercado.dao.ProdutoDAO;
import br.com.fiap.mercado.dao.ProdutoDAOImpl;
import br.com.fiap.mercado.entity.Produto;
import br.com.fiap.mercado.jdbc.MercadoDbManager;

public class TesteCrudDinamico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//try {

			ProdutoDAO dao = new ProdutoDAOImpl();
			
			Produto produto = new Produto();
			produto.setNome("Pera DAO 2");
			produto.setValor(7);
			Calendar calendar = new GregorianCalendar(2022,01,21);
			produto.setDataValidade(calendar);
			
			dao.gravar(produto);			
			System.out.println("O produto foi gravado via DAO - singleton");
			
			
			//produto.setCodigo(26);
			//produto.setValor(10);
			//dao.atualizar(produto);
			//System.out.println("Produto Pera DAO alterado valor para 10");
			
			List<Produto> produtos = dao.buscarTodos();
			for(Produto prod: produtos) {
				System.out.println(prod.toString());
			}
			
			//Connection conexao = MercadoDbManager.obterConexao();

			//System.out.println("Conectou!");

			
//			PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO t_produto (cd_produto, nm_produto, vl_produto, dt_validade)"
//																+ " VALUES (SEQ_PRODUTO.nextval, ?, ?, ?)");
//			pstmt.setString(1,"Pera dinamico"); //primeiro parametro (nome)
//			pstmt.setFloat(2, 7); //segundo parametro (valor)
//			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
//			pstmt.setDate(3, data); //terceiro parametro (data validade)
//			pstmt.executeUpdate();
//			
//			pstmt = conexao.prepareStatement("UPDATE t_produto SET vl_produto = ? WHERE cd_produto = ?");
//			pstmt.setFloat(1, 8); //primeiro parametro (valor)
//			pstmt.setInt(2, 3); //segundo parametro (codigo)
//			pstmt.executeUpdate();
//			
//			pstmt = conexao.prepareStatement("DELETE FROM t_produto  WHERE cd_produto = ?");
//			pstmt.setInt(1, 4); //primeiro parametro (codigo)
//			pstmt.executeUpdate();
//			
//			//INVOCAR STORED PROCEDURE
//			CallableStatement cs = conexao.prepareCall("{call SP_INSERT_PRODUTO(?, ?, ?)}");
//			cs.setString(1, "Morango");
//			java.sql.Date dataSP = new java.sql.Date(new java.util.Date().getTime());
//			cs.setDate(2, dataSP);
//			cs.setFloat(3, 10);
//			cs.executeUpdate();
//			//executa procedure
//			cs.executeUpdate();
//			
//			PreparedStatement pstmt = conexao.prepareStatement("SELECT cd_produto,nm_produto, vl_produto, dt_validade FROM t_produto WHERE CD_PRODUTO=?");
//			pstmt.setInt(1, 23); //primeiro parametro (codigo)
//			ResultSet result = pstmt.executeQuery();
//			
//					
//			// percorrer registros encontrados
//			while (result.next()) {
//				// recupera valor de cada coluna e imprime
//				System.out.println(result.getInt("CD_PRODUTO") + " " + result.getString("NM_PRODUTO") + " "
//						+ result.getDouble("VL_PRODUTO") + " " + result.getDate("dt_validade"));
//			}
//
//			// fecha conexao
//			conexao.close();
//
			// tratamento erro conexao
//		} catch (SQLException e) {
//			System.err.println("Nao foi possivel conectar no Oracle Localhost");
//			e.printStackTrace();
//		}

	}

}
