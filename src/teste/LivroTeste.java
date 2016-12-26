package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LivroDAO;
import DAO.UsuarioDAO;
import excecoes.ObjetoExistente;
import modelo.Livro;
import modelo.Usuario;

public class LivroTeste {

	public static void main(String[] args) {
	
			try {
				LivroDAO.createTable();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//LivroDAO.inserirLivro("asd", "eu", "cu", (int) 2002,"asd123");
	
	}
	
	public static void inserirLivros(Livro livro) throws ObjetoExistente, SQLException{
		LivroDAO.inserirLivro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), (int) livro.getAno(), livro.getCodigo());
	}
	
}