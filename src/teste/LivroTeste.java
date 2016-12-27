package teste;

import java.sql.SQLException;

import DAO.LivroDAO;

public class LivroTeste {

	public static void main(String[] args) {
		try {
			LivroDAO.createTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}