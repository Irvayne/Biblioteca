package teste;

import java.sql.SQLException;

import excecoes.ObjetoInexistente;
import DAO.LivroDAO;

public class LivroTeste {

	public static void main(String[] args) {
		try {
			try {
				LivroDAO.deletarLivro("000");
			} catch (ObjetoInexistente e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}