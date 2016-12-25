package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
						+ "'" + titulo + "', '" + autor + "', '" + editora + "', " + ano + ", '" + codigo + "')";
				System.out.println("SQL INSERT LIVRO: " + cmd);
				st.executeUpdate(cmd);
				st.close();
				return true;
			}catch(Exception e){
				System.out.println("ERROR - INSERT LIVRO\n" + e.getMessage());
			}
		}else{
			throw new ObjetoExistente("LIVRO COM MESMO CÓDIGO JÁ CADASTRADO\n");
		}
		return false;
	}
	
	public static boolean emprestarLivro(String codigo, String cpf){
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
					System.out.println("LIVRO JÁ EMPRESTADO A OUTRO USUARIO");
				}
			}else{
				System.out.println("CPF DE USUÁRIO NÃO ENCONTRADO");
			}
		}else{
			System.out.println("CÓDIGO DE LIVRO NÃO ENCONTRADO");
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
	
	public static ArrayList<Livro> listarLivros(){
		ArrayList<Livro> livros = new ArrayList<Livro>();
		Livro l = null;
		Statement st;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from livros";
			ResultSet rs = st.executeQuery(cmd);
			while(rs.next()){
				l = new Livro(rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano"), rs.getString("codigo"), rs.getString("editora"));
				livros.add(l);
			}
		}catch(Exception e){
			
		}
		return livros;
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
			System.err.println("ERROR - PESQUISAR LIVRO\n" + e.getMessage());
		}
		return l;
	}
	
	public static Livro pesquisarLivroEmprestado(String codigo){
		Livro l = null;
		Statement st;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from emprestimo where codigo = '" + codigo + "'";
			ResultSet rs = st.executeQuery(cmd);
			if(rs.next())
				l = new Livro(rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano"), rs.getString("codigo"), rs.getString("editora"));
		}catch(Exception e ){
			System.out.println("ERROR - PESQUISAR LIVRO EMPRESTADO");
		}
		return l;
	}
}