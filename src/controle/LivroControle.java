package controle;

import DAO.LivroDAO;
import excecoes.ObjetoExistente;
import excecoes.ObjetoInexistente;
import modelo.Livro;

public class LivroControle {
	
	/**
	 * insere o livro que foi passado por parametro
	 * @param livro
	 */
	public static void inserirLivro(Livro livro){
		try {
			LivroDAO.inserirLivro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAno(), livro.getCodigo());
			System.out.println("Livro cadastrado com sucesso!");
		} catch (ObjetoExistente e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * deleta um livro de acordo com o codigo unico passado por parametro
	 * @param codigo
	 */
	public static void deletarLivro(String codigo){
		try{
			LivroDAO.deletarLivro(codigo);
			System.out.println("Livro deletado com sucesso!");
		}catch(ObjetoInexistente e){
			System.err.println(e.getMessage());
		}
	}
	
	
	/**
	 * Retorna o livro de acordo com seu codigo unico
	 * @param codigo
	 * @return
	 */
	public static Livro pesquisarLivro(String codigo){
		Livro livro = pesquisarLivro(codigo);
		if(livro != null){
			return livro; 
		}
		return null;
	}
}