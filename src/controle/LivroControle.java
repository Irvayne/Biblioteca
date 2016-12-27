package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LivroDAO;
import excecoes.ObjetoExistente;
import excecoes.ObjetoInexistente;
import modelo.Livro;

public class LivroControle {

	/**
	 * insere o livro que foi passado por parametro
	 * 
	 * @param livro
	 * @throws ObjetoExistente 
	 */

	public static void inserirLivro(Livro livro) throws ObjetoExistente {
		
			LivroDAO.inserirLivro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAno(),
					livro.getCodigo(), livro.getEdicao(), livro.getDescricao());
			
			
		
	}

	/**
	 * deleta um livro de acordo com o codigo unico passado por parametro
	 * 
	 * @param codigo
	 * @throws SQLException
	 * @throws ObjetoInexistente 
	 */
	public static void deletarLivro(String codigo) throws SQLException, ObjetoInexistente {
		
			LivroDAO.deletarLivro(codigo);
			System.out.println("Livro deletado com sucesso!");
		
	}

	/**
	 * Retorna o livro de acordo com seu codigo unico
	 * 
	 * @param codigo
	 * @return
	 */
	public static Livro pesquisarLivro(String codigo) {
		Livro livro;
		try {
			livro = LivroDAO.pesquisarLivro(codigo);
			return livro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Livro pesquisarLivroEmprestado(String codigo) {
		Livro livro;
		try {
			livro = LivroDAO.pesquisarLivroEmprestado(codigo);
			return livro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean emprestarLivro(String codigo, String cpf) {

		try {
			LivroDAO.emprestarLivro(codigo, cpf);
			System.out.println("Livro emprestado com sucesso!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return false;
	}

	public static boolean devolverLivro(String codigo) {
		
		if (LivroDAO.devolverLivro(codigo)) {

			System.out.println("Livro devolvido com sucesso!");
			return true;
		}

		return false;

	}

	public static ArrayList<Livro> listarLivrosEmprestados() {

		try {
			ArrayList<Livro> livros = LivroDAO.listarLivrosEmprestados();
			return livros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			}

		return null;
	}

	public static ArrayList<Livro> listarLivros() {

		try {
			ArrayList<Livro> livros = LivroDAO.listarLivros();
			return livros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

		return null;
	}

}