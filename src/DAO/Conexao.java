package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Classe para realizar a conexao com o banco de dados
 * @author Irvayne Matheus
 *
 */
public class Conexao {

	static Connection conexao = null;
	
	/**
	 * Metodo que retorna uma instancia da conexao.
	 * @return - conexao ativa
	 */
	public static Connection getConnection(){
		if (conexao == null){
           new Conexao();			
		}
		return conexao;
	}
	
	/**
	 * Relaiza a conexao com o banco. Deve ser informado as configuracoes do banco nesse metodo
	 */
	private Conexao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca",
					"root", "rooot");
	    } catch (Exception e){
	    	  System.out.println(e.getMessage());
	    }
	}
}
