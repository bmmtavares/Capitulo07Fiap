package br.com.fiap.mercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.mercado.entity.Produto;
import br.com.fiap.mercado.jdbc.ConnectionManager;
import br.com.fiap.mercado.jdbc.MercadoDbManager;

public class ProdutoDAOImpl implements ProdutoDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void gravar(Produto produto) {

		try {
			//conexao = MercadoDbManager.obterConexao();
			conexao = ConnectionManager.getInstance().getConnection();

			pstmt = conexao.prepareStatement("INSERT INTO t_produto (cd_produto, nm_produto, vl_produto, dt_validade)"
					+ " VALUES (SEQ_PRODUTO.nextval, ?, ?, ?)");
			pstmt.setString(1, produto.getNome()); // primeiro parametro (nome)
			pstmt.setFloat(2, produto.getValor()); // segundo parametro (valor)
			java.sql.Date data = new java.sql.Date(produto.getDataValidade().getTimeInMillis());
			pstmt.setDate(3, data); // terceiro parametro (data validade)
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Produto> buscarTodos() {
		// cria uma lista de produtos
		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet rs = null;
		try {
			conexao = MercadoDbManager.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_PRODUTO");
			rs = pstmt.executeQuery();

			// percorrer registros encontrados
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_VALIDADE");
				Calendar dtValidade = Calendar.getInstance();
				dtValidade.setTimeInMillis(data.getTime());
				// criar objeto produto
				Produto produto = new Produto(rs.getInt("CD_PRODUTO"), rs.getString("NM_PRODUTO"),
						rs.getFloat("VL_PRODUTO"), dtValidade);
				// adicionar produto na lista
				produtos.add(produto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return produtos;

	}

	@Override
	public Produto buscarTodosPorCodigo(int codigo) {

		ResultSet rs = null;
		Produto produto = null;
		try {
			conexao = MercadoDbManager.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_PRODUTO  WHERE cd_produto = ?");
			pstmt.setInt(1, codigo); // primeiro parametro (nome)
			rs = pstmt.executeQuery();

			// percorrer registros encontrados			
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_VALIDADE");
				Calendar dtValidade = Calendar.getInstance();
				dtValidade.setTimeInMillis(data.getTime());
				// criar objeto produto
				produto = new Produto(rs.getInt("CD_PRODUTO"), rs.getString("NM_PRODUTO"),
						rs.getFloat("VL_PRODUTO"), dtValidade);

			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return produto;
	
	}

	@Override
	public void atualizar(Produto produto) {

		try {
			conexao = MercadoDbManager.obterConexao();

			pstmt = conexao.prepareStatement(
					"UPDATE t_produto SET nm_produto = ?, vl_produto = ?, dt_validade=? WHERE cd_produto = ?");
			pstmt.setString(1, produto.getNome()); // primeiro parametro (nome)
			pstmt.setFloat(2, produto.getValor()); // segundo parametro (valor)
			java.sql.Date data = new java.sql.Date(produto.getDataValidade().getTimeInMillis());
			pstmt.setDate(3, data); // terceiro parametro (data validade)
			pstmt.setInt(4, produto.getCodigo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(int codigo) {

		try {
			conexao = MercadoDbManager.obterConexao();

			pstmt = conexao.prepareStatement("DELETE FROM t_produto  WHERE cd_produto = ?");
			pstmt.setInt(1, codigo); // primeiro parametro (nome)
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
