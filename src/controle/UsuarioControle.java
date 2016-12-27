package controle;

import java.util.ArrayList;
import DAO.UsuarioDAO;
import excecoes.ObjetoExistente;
import modelo.Usuario;

public class UsuarioControle {

	public static boolean inserirUsuario(Usuario u) {
		try {
			UsuarioDAO.inserirUsuario(u.getNome(), u.getCpf(), u.getEndereco(), u.getTelefone());
			return true;
		} catch (ObjetoExistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deletarUsuario(String cpf) {

		if (UsuarioDAO.deletarUsuario(cpf)) {
			return true;
		}

		return false;
	}

	public static ArrayList<Usuario> listaUsuarios() {
		ArrayList<Usuario> usuarios = UsuarioDAO.listaUsuarios();
		return usuarios;
	}
	public static Usuario pesquisarUsuario(String cpf){
		Usuario usuario = UsuarioDAO.pesquisarUsuario(cpf);
		return usuario;
	}

}
