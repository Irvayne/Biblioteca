package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import excecoes.ObjetoExistente;
import modelo.Usuario;

public class UsuarioDAO {
	
	public static boolean inserirUsuario(String nome, String cpf, String endereco, String telefone) throws ObjetoExistente{
		if(pesquisarUsuario(cpf) == null){
			Statement st;
			try{
				st = (Statement) Conexao.getConnection().createStatement();
				String cmd = "insert into usuario (nome, cpf, endereco, telefone) values ("
						+ "'" + nome + "', '" + cpf + "', '" + endereco + "', '" + telefone + "')";
				st.executeUpdate(cmd);
				System.out.println("SQL INSERT USUARIO\n" + cmd);
				st.close();
				return true;
			}catch(Exception e){
				System.err.println("ERRO INSERT USUARIO");
			}
		}else{
			throw new ObjetoExistente("USUARIO COM MESMO CPF JÁ CADASTRADO!");
		}
		return false;
	}
	
	public static boolean deletarUsuario(String cpf){
		if(pesquisarUsuario(cpf) != null){
			Statement st;
			try{
				st = (Statement) Conexao.getConnection().createStatement();
				String cmd = "delete from usuario where cpf = '" + cpf + "'";
				st.executeUpdate(cmd);
				st.close();
				return true;
			}catch(Exception e){
				System.err.println("ERROR - DELETE USUARIO");
			}
		}
		return false;
	}
	
	public static ArrayList<Usuario> listaUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = null;
		Statement st;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from usuario";
			ResultSet rs = st.executeQuery(cmd);
			while(rs.next()){
				u = new Usuario(rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getString("telefone"));
				usuarios.add(u);
			}
		}catch(Exception e){
			System.out.println("ERROR - LISTA USUARIOS");
		}
		return usuarios;
	}
	
	public static Usuario pesquisarUsuario(String cpf){
		Usuario u = null;
		Statement st;
		try{
			st = (Statement) Conexao.getConnection().createStatement();
			String cmd = "select * from usuario where cpf = '" + cpf + "'";
			ResultSet rs = st.executeQuery(cmd);
			if(rs.next())
				u = new Usuario(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getString("telefone"));
		}catch(Exception e){
			System.err.println("ERROR - PESQUISAR USUARIO");
		}
		return u;
	}
}     