package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import excecoes.ObjetoExistente;
import excecoes.ObjetoInexistente;
import modelo.Livro;

public class LivroDAO {
	
	public static void createTable() throws SQLException {
		String criarTabela = "CREATE TABLE IF NOT EXISTS livros (" + "id BIGINT AUTO_INCREMENT PRIMARY KEY,"
				+ "titulo VARCHAR(50) NOT NULL," + "autor VARCHAR(50) NOT NULL,"
				+ "ano int(4)," + "codigo VARCHAR(20)," + "editora VARCHAR(20),"
				+ "edicao VARCHAR(20)," + "descricao VARCHAR(256))" + "ENGINE=MyISAM";
		PreparedStatement statement = (PreparedStatement) Conexao.getConnection().prepareStatement(criarTabela);
		statement.execute();
		
		criarTabela = "CREATE TABLE IF NOT EXISTS emprestimo (" + "id BIGINT AUTO_INCREMENT PRIMARY KEY,"
				+ "codigo VARCHAR(50) NOT NULL," + "cpf VARCHAR(50) NOT NULL)" + "ENGINE=MyISAM";
		statement = (PreparedStatement) Conexao.getConnection().prepareStatement(criarTabela);
		statement.execute();
		statement.close();
	}
	
	public static boolean inserirLivro(String titulo, String autor, String editora, int ano, String codigo, String edicao, String descricao) throws ObjetoExistente{
		try {
			createTable();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		try {
			if(pesquisarLivro(codigo) == null){
				Statement st;
				try{
					st = (Statement) Conexao.getConnection().createStatement();
					String cmd = "insert into livros (titulo, autor, editora, ano, codigo, edicao, descricao) values("
							+ "'" + titulo + "', '" + autor + "', '" + editora + "', " + ano + ", '" + codigo + "', '" + edicao + "', '" + descricao + "')";
					System.out.println("SQL INSERT LIVRO: " + cmd);
					st.executeUpdate(cmd);
					st.close();
					return true;
				}catch(Exception e){
					System.out.println("ERROR - INSERT LIVRO\n" + e.getMessage());
				}
			}else{
				throw new ObjetoExistente("LIVRO COM MESMO CÃ“DIGO JÃ� CADASTRADO\n");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean emprestarLivro(String codigo, String cpf) throws SQLException{
		createTable();
		if(pesquisarLivro(codigo) != null){
			if(UsuarioDAO.pesquisarUsuario(cpf) != null){
				if(pesquisarLivroEmprestado(codigo) == null){
					Statement st;
					try {
						st = (Statement) Conexao.getConnection().createStatement();
						String cmd = "insert into emprestimo (codigo, cpf) values ("
								+ "'" + codigo + "', '" + cpf + "')";
						System.out.println("SQL EMPRESTAR LIVRO\n" + cmd);
						st.executeUpdate(cmd);
						st.close();
						return true;
					} catch (SQLException e) {
						System.out.println("ERROR - EMPRESTAR LIVRO\n");
					}
				}else{
					System.out.println("LIVRO JÃ� EMPRESTADO A OUTRO USUARIO");
				}
			}else{
				System.out.println("CPF DE USUÃ�RIO NÃƒO ENCONTRADO");
			}
		}else{
			System.out.println("CÃ“DIGO DE LIVRO NÃƒO ENCONTRADO");
		}
		return false;
	}
	
	public static boolean devolverLivro(String codigo){
		try {
			createTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(pesquisarLivro(codigo) != null){
				if(pesquisarLivroEmprestado(codigo) != null){
					Statement st;
					try {
						st = (Statement) Conexao.getConnection().createStatement();
						String cmd = "delete from emprestimo where codigo = '" + codigo + "'";
						System.out.println("SQL EMPRESTAR LIVRO\n" + cmd);
						st.executeUpdate(cmd);
						st.close();
						return true;
					}catch(Exception e){
						
					}
				}else{
					System.out.println("Livro não se encontra emprestado no momento");
				}
			}else{
				System.out.println("Código de livro não encontrado!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;		
	}
	
	public static ArrayList<Livro> listarLivrosEmprestados() throws SQLException{
		createTable();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		Statement st;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from emprestimo";
			ResultSet rs = st.executeQuery(cmd);
			while(rs.next()){
				System.out.println(rs.getString("codigo"));
			}
		}catch(Exception e){
			
		}
		return livros;
	}
	
	public static boolean deletarLivro(String codigo) throws ObjetoInexistente, SQLException{
		createTable();
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
			throw new ObjetoInexistente("CÃ“DIGO NÃƒO ENCONTRADO NO BANCO DE DADOS!");
		}
		return false;
	}
	
	public static ArrayList<Livro> listarLivros() throws SQLException{
		createTable();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		Livro l = null;
		Statement st;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from livros";
			ResultSet rs = st.executeQuery(cmd);
			while(rs.next()){
				l = new Livro(rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano"), rs.getString("codigo"), rs.getString("editora"),rs.getString("edicao"),rs.getString("descricao"));
				livros.add(l);
			}
		}catch(Exception e){
			
		}
		return livros;
	}
	
	public static Livro pesquisarLivro(String codigo) throws SQLException{
		createTable();
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
			System.err.println("ERROR - PESQUISAR LIVRO\n" + e.getMessage());
		}
		return l;
	}
	
	public static Livro pesquisarLivroEmprestado(String codigo) throws SQLException{
		createTable();
		Livro l = null;
		Statement st;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from emprestimo where codigo = '" + codigo + "'";
			ResultSet rs = st.executeQuery(cmd);
			if(rs.next())
				l = new Livro(rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano"), rs.getString("codigo"), rs.getString("editora"),rs.getString("edicao"),rs.getString("descricao"));
		}catch(Exception e ){
			System.out.println("ERROR - PESQUISAR LIVRO EMPRESTADO");
		}
		return l;
	}
}