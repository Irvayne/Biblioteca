package DAO;

import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import excecoes.ObjetoExistente;
import excecoes.ObjetoInexistente;
import modelo.Livro;

public class LivroDAO {
	public static boolean inserirLivro(String titulo, String autor, String editora, int ano, String codigo) throws ObjetoExistente{
		if(pesquisarLivro(codigo) == null){
			Statement st;
			try{
				st = (Statement) Conexao.getConnection().createStatement();
				String cmd = "insert into livros (titulo, autor, editora, ano, codigo) values("
						+ "'" 
						+ titulo
						+ "', '"
						+ autor
						+ "', '"
						+ editora
						+ "', "
						+ ano
						+ ", '"
						+ codigo
						+ "')";
				System.out.println("SQL INSERT LIVRO: " + cmd);
				st.executeUpdate(cmd);
				st.close();
				return true;
			}catch(Exception e){
				System.out.println("ERROR - INSERT LIVRO\n" + e.getMessage());
			}
		}else{
			throw new ObjetoExistente("LIVRO COM MESMO CÓDIGO JÁ CADASTRADO!");
		}
		return false;
	}
	
	public static boolean deletarLivro(String codigo) throws ObjetoInexistente{
		if(pesquisarLivro(codigo) != null){
			Statement st;
			try{
				st = (Statement) Conexao.getConnection().createStatement();
				String cmd = "delete from livros where codigo = '" + codigo + "'";
				System.out.println(cmd);
				st.executeUpdate(cmd);
				st.close();
				return true;
			}catch(Exception e){
				System.err.println("ERROR - DELETE LIVRO\n");
			}
		}else{
			throw new ObjetoInexistente("CÓDIGO NÃO ENCONTRADO NO BANCO DE DADOS!");
		}
		return false;
	}
	
	public static Livro pesquisarLivro(String codigo){
		Statement st;
		Livro l = null;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from livros where codigo = '" + codigo + "'";
			ResultSet rs = st.executeQuery(cmd);
			if(rs.next()){
				l = new Livro(rs.getLong("id"),rs.getString("titulo"),rs.getString("autor"), rs.getInt("ano"), rs.getString("codigo"), rs.getString("editora"));
			}
		}catch(Exception e){
			System.out.println("Erro ao recuperar cliente: " + e.getMessage());
		}
		return l;
	}
	
	public static Livro pesquisarLivro(String tipoDePesquisa, String valor){
		Statement st;
		Livro l = null;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from livros where " + tipoDePesquisa + " = '" + valor + "'"; 
			ResultSet rs = st.executeQuery(cmd);
			if(rs.next()){
				l = new Livro(rs.getLong("id"),rs.getString("titulo"),rs.getString("autor"), rs.getInt("ano"), rs.getString("codigo"), rs.getString("editora"));
			}
		}catch(Exception e){
			System.out.println("Erro ao recuperar cliente: " + e.getMessage());
		}
		return l;
	}
}