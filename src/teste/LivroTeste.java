package teste;

import DAO.LivroDAO;
import excecoes.ObjetoExistente;
import excecoes.ObjetoInexistente;
import modelo.Livro;

public class LivroTeste {

	public static void main(String[] args) {
		try {
			LivroDAO.deletarLivro("0000-B");
			LivroDAO.deletarLivro("0000-C");
			LivroDAO.deletarLivro("0000-D");
			LivroDAO.deletarLivro("0000-E");
		} catch (ObjetoInexistente e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void inserirLivros(Livro livro) throws ObjetoExistente{
		LivroDAO.inserirLivro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), (int) livro.getId(), livro.getCodigo());
	}
}