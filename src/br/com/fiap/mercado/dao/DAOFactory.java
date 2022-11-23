package br.com.fiap.mercado.dao;

public abstract class DAOFactory {

	//para 1 banco de dados
//	public static ProdutoDAO getProdutoDAO() {
//		return new ProdutoDAOImpl();
//	}
	
	//trabalhar com varios bancos de dados
	
	//constantes definir tipos de dbs suportados
	public static final int SQL_SERVER=1;
	public static final int ORACLE=2;
	
	//atributos que armazenam as instancias de cada fabrica
	private static OracleDAOFactory oracleDAOFactory;
	private static SQLDAOFactory sqlDAOFactory;
	
	//metodo que retorna a instancia de uma fabrica de acordo com o banco
	public static DAOFactory getDAOFactory(int banco) {
		switch(banco) {
		case SQL_SERVER:
			if(sqlDAOFactory == null)
				sqlDAOFactory = new SQLDAOFactory();
			return sqlDAOFactory;
		case ORACLE:
			if(oracleDAOFactory == null)
					oracleDAOFactory = new	OracleDAOFactory();
			return oracleDAOFactory;
		default:
			return null;
					
		}
	}
	
}
