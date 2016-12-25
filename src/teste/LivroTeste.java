package teste;

import java.util.ArrayList;

import DAO.LivroDAO;
import DAO.UsuarioDAO;
import excecoes.ObjetoExistente;
import modelo.Livro;
import modelo.Usuario;

public class LivroTeste {

	public static void main(String[] args) {
		ArrayList<Livro> livros = LivroDAO.listarLivros();
		ArrayList<Usuario> usuarios = UsuarioDAO.listaUsuarios();
		for(Livro l : livros)
			System.out.println(l.getCodigo());
		
		for(Usuario u : usuarios)
			System.out.println(u.getCpf());
		
		LivroDAO.emprestarLivro("1923-C", "06322914359");
	}
	
	public static void inserirLivros(Livro livro) throws ObjetoExistente{
		LivroDAO.inserirLivro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), (int) livro.getAno(), livro.getCodigo());
	}
}