package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DAO.LivroDAO;
import controle.LivroControle;
import controle.UsuarioControle;
import excecoes.ObjetoInexistente;
import modelo.Livro;
import modelo.Usuario;
import visao.emprestimo.TelaRealizarEmprestimo;
import visao.livro.TelaCadastrarLivro;
import visao.livro.TelaEditarLivro;
import visao.livro.TelaListarTodos;
import visao.livro.TelaListarTodosEmprestimos;
import visao.livro.TelaPesquisarLivro;
import visao.usuario.TelaCadastrarUsuario;
import visao.usuario.TelaEditarUsuario;
import visao.usuario.TelaPesquisarUsuario;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 750);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 218, 319);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(getClass().getResource("/img/livro.png")));
		lblImg.setBounds(10, 11, 130, 112);
		panel.add(lblImg);
		
		JLabel lblLivros = new JLabel("Livros");
		lblLivros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLivros.setBounds(150, 71, 58, 34);
		panel.add(lblLivros);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarLivro livro = new TelaCadastrarLivro();
				livro.setVisible(true);
			}
		});
		btnCadastrar.setBounds(10, 134, 89, 50);
		panel.add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = null;
				Livro livro = null;
				do{
				do{
				codigo = JOptionPane.showInputDialog("Digite o código do livro");
				if(codigo==null)
					return;
				if(codigo.equals(""))
					JOptionPane.showMessageDialog(null,"Digite um código de livro válido");
				}while(codigo.equals(""));
				
				livro = LivroControle.pesquisarLivro(codigo);
				if(livro==null){
					JOptionPane.showMessageDialog(null,"Não existe livro cadastrado com código: "+codigo);
				}else{
					TelaPesquisarLivro telaPesquisarLivro = new TelaPesquisarLivro(livro);
					telaPesquisarLivro.setVisible(true);
				}
				}while(livro==null);
			}
		});
		btnPesquisar.setBounds(10, 256, 89, 50);
		panel.add(btnPesquisar);
		
	
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = null;
				do{
				codigo = JOptionPane.showInputDialog("Qual o código do livro a ser removido: ");
				if(codigo==null)
					return;
				if(codigo.equals(""))
					JOptionPane.showMessageDialog(null,"Digite um código de livro válido");
				}while(codigo.equals(""));
				int dialogResult = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja remover o livro de código: "+ codigo);
				if(dialogResult == JOptionPane.YES_OPTION){
				  try {
					LivroControle.deletarLivro(codigo);
					JOptionPane.showMessageDialog(null,"Livro de código: "+codigo+" removido com sucesso");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Erro no banco de dados");
				} catch (ObjetoInexistente e) {
					JOptionPane.showMessageDialog(null,"Não existe livro cadastrado com o código: "+codigo);
				}
				}
				
			}
		});
		btnRemover.setBounds(10, 195, 89, 50);
		panel.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = null;
				Livro livro = null;
				do{
				do{
				codigo = JOptionPane.showInputDialog("Digite o código do livro");
				if(codigo==null)
					return;
				if(codigo.equals(""))
					JOptionPane.showMessageDialog(null,"Digite um código de livro válido");
				}while(codigo.equals(""));
				
				livro = LivroControle.pesquisarLivro(codigo);
				if(livro==null){
					JOptionPane.showMessageDialog(null,"Não existe livro cadastrado com código: "+codigo);
				}else{
					TelaEditarLivro telaEditarLivro = new TelaEditarLivro(livro);
					telaEditarLivro.setVisible(true);
				}
				}while(livro==null);
			}
		});
		btnEditar.setBounds(109, 134, 99, 50);
		panel.add(btnEditar);
		
		JButton btnListarTodos = new JButton("Listar todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarTodos listarTodos = new TelaListarTodos();
				listarTodos.setVisible(true);
			}
		});
		btnListarTodos.setBounds(109, 197, 99, 48);
		panel.add(btnListarTodos);
		
		JButton btnEmprstimos = new JButton("Empr\u00E9stimos");
		btnEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarTodosEmprestimos listarTodosEmprestimos = new TelaListarTodosEmprestimos();
				listarTodosEmprestimos.setVisible(true);
			}
		});
		btnEmprstimos.setBounds(109, 256, 99, 50);
		panel.add(btnEmprstimos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 341, 218, 319);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblImg2 = new JLabel("");
		lblImg2.setIcon(new ImageIcon(getClass().getResource("/img/usuario.jpg")));
		lblImg2.setBounds(10, 11, 127, 115);
		panel_1.add(lblImg2);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rios");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsurio.setBounds(140, 104, 85, 14);
		panel_1.add(lblUsurio);
		
		JButton button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarUsuario cadastrarUsuario = new TelaCadastrarUsuario();
				cadastrarUsuario.setVisible(true);
			}
		});
		button.setBounds(10, 136, 89, 50);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Remover");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = null;
				do{
				cpf = JOptionPane.showInputDialog("Qual o CPF do usuário a ser removido: ");
				if(cpf==null)
					return;
				if(cpf.equals(""))
					JOptionPane.showMessageDialog(null,"Digite um CPF válido");
				}while(cpf.equals(""));
				int dialogResult = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja remover o usuário de CPF: "+ cpf);
				if(dialogResult == JOptionPane.YES_OPTION){
				 
					boolean resul = UsuarioControle.deletarUsuario(cpf);
					if(resul){
						JOptionPane.showMessageDialog(null,"Usuário de CPF: "+cpf+" removido com sucesso");
					}else{
						JOptionPane.showMessageDialog(null,"Não existe usuário cadastrado com esse CPF: "+cpf);
					}
				}
			}
		});
		button_1.setBounds(10, 197, 89, 50);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Pesquisar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = null;
				Usuario usuario = null;
				do{
				do{
				cpf = JOptionPane.showInputDialog("Digite o CPF do usuário");
				if(cpf==null)
					return;
				if(cpf.equals(""))
					JOptionPane.showMessageDialog(null,"Digite um CPF válido");
				}while(cpf.equals(""));
				
				usuario = UsuarioControle.pesquisarUsuario(cpf);
				if(usuario==null){
					JOptionPane.showMessageDialog(null,"Não existe usuário cadastrado com CPF: "+cpf);
				}else{
					TelaPesquisarUsuario telaPesquisarUsuario = new TelaPesquisarUsuario(usuario);
					telaPesquisarUsuario.setVisible(true);
				}
				}while(usuario==null);
			}
		});
		button_2.setBounds(10, 258, 89, 50);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Editar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = null;
				Usuario usuario = null;
				do{
				do{
				cpf = JOptionPane.showInputDialog("Digite o CPF do usuário");
				if(cpf==null)
					return;
				if(cpf.equals(""))
					JOptionPane.showMessageDialog(null,"Digite um CPF válido");
				}while(cpf.equals(""));
				
				usuario = UsuarioControle.pesquisarUsuario(cpf);
				if(usuario==null){
					JOptionPane.showMessageDialog(null,"Não existe usuário cadastrado com CPF: "+cpf);
				}else{
					TelaEditarUsuario telaEditarUsuario = new TelaEditarUsuario(usuario);
					telaEditarUsuario.setVisible(true);
				}
				}while(usuario==null);
			}
		});
		button_3.setBounds(109, 136, 99, 50);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Listar todos");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visao.usuario.TelaListarTodos listarTodos = new visao.usuario.TelaListarTodos();
				listarTodos.setVisible(true);
			}
		});
		button_4.setBounds(109, 197, 99, 48);
		panel_1.add(button_4);
		
		JButton btnPendentes = new JButton("Pendentes");
		btnPendentes.setBounds(109, 257, 99, 51);
		panel_1.add(btnPendentes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(238, 11, 1114, 647);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblImg3 = new JLabel("");
		lblImg3.setIcon(new ImageIcon(getClass().getResource("/img/emprestimo.png")));
		lblImg3.setBounds(10, 11, 340, 148);
		panel_2.add(lblImg3);
		
		JLabel lblEmprestimos = new JLabel("Empr\u00E9stimos");
		lblEmprestimos.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEmprestimos.setBounds(372, 121, 139, 31);
		panel_2.add(lblEmprestimos);
		
		
		
		Object[][] dados = null;
		try {
			dados = LivroDAO.relacaoLivroUsuarioEmprestimo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String [] colunas = {"CPF", "Nome", "Código", "Título"};
		
		table = new JTable(dados, colunas);
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		table.setBounds(10, 41, 1079, 429);
		panel_2.add(table);
		
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBackground(Color.WHITE);
		barraRolagem.setBounds(10, 170, 1079, 466);
		panel_2.add(barraRolagem);
		
		
		JButton btnNovoEmprstimo = new JButton("Novo Empr\u00E9stimo");
		btnNovoEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRealizarEmprestimo emprestimo = new TelaRealizarEmprestimo(table);
				emprestimo.setVisible(true);
			}
		});
		btnNovoEmprstimo.setBounds(569, 11, 204, 67);
		panel_2.add(btnNovoEmprstimo);
		
		JButton btnRealizarDevoluo = new JButton("Realizar Devolu\u00E7\u00E3o");
		btnRealizarDevoluo.setBounds(569, 97, 204, 61);
		panel_2.add(btnRealizarDevoluo);
		
	}
}
