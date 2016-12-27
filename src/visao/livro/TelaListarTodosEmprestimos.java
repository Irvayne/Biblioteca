package visao.livro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controle.LivroControle;
import modelo.Livro;

@SuppressWarnings("serial")
public class TelaListarTodosEmprestimos extends JDialog {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaListarTodosEmprestimos() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		setBounds(515, 50, 339, 581);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(getClass().getResource("/img/livro.png")));
		lblImg.setBounds(10, 11, 130, 121);
		contentPane.add(lblImg);
		
		JLabel lblCadastrarLivro = new JLabel("Todos os Livro Emprestados");
		lblCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastrarLivro.setBounds(137, 82, 196, 41);
		contentPane.add(lblCadastrarLivro);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(118, 518, 89, 23);
		contentPane.add(btnFechar);
		
		
		List<Livro> lista = LivroControle.listarLivrosEmprestados();
		Object [][] dados = new Object[lista.size()][4];
		
		for(int i = 0; i< lista.size(); i++){
			dados[i][0] = lista.get(i).getCodigo();
			dados[i][1] = lista.get(i).getTitulo();
			dados[i][2] = lista.get(i).getAutor();
			dados[i][3] = lista.get(i).getEdicao();
		}
		
		String [] colunas = {"Código", "Título", "Autor", "Edição"};
		
		table = new JTable(dados,colunas);
		table.setEnabled(false);
		table.setBounds(10, 157, 313, 350);
		contentPane.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 157, 313, 350);
		contentPane.add(scroll);
	}
}
