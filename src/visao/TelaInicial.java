package visao;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import visao.livro.TelaLivro;
import visao.usuario.TelaUsuario;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLivros = new JButton("Livros");
		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLivro livro = new TelaLivro();
				livro.setVisible(true);
				setVisible(false);
			}
		});
		btnLivros.setBounds(10, 11, 89, 23);
		contentPane.add(btnLivros);
		
		JButton btnUsurios = new JButton("Usu\u00E1rios");
		btnUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaUsuario usuario = new TelaUsuario();
				usuario.setVisible(true);
				setVisible(false);
			}
		});
		btnUsurios.setBounds(109, 11, 89, 23);
		contentPane.add(btnUsurios);
		
		JButton btnRealizarEmprestimos = new JButton("Realizar Emprestimos");
		btnRealizarEmprestimos.setBounds(213, 11, 143, 23);
		contentPane.add(btnRealizarEmprestimos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(366, 11, 64, 23);
		contentPane.add(btnSair);
		
		String [] colunas = {"Nome", "Livro", "Data"};
		Object [][] dados = {
				{"Ana Monteiro", "O pequeno principe", "26/12/2016"},
				{"João da Silva", "A cabana", "24/12/2016"},
				{"Pedro Cascaes", "Fábula de dom casmuso", "22/12/2016"}
			};
		
		table = new JTable(dados, colunas);
		table.setBounds(10, 51, 414, 199);
		contentPane.add(table);
		table.setEnabled(false);
		
		
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(10, 51, 414, 199);
		contentPane.add(barraRolagem);
	}
}
