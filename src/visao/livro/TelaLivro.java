package visao.livro;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaLivro extends JFrame {

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public TelaLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarLivro cadastrarLivro = new TelaCadastrarLivro();
				cadastrarLivro.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrar.setBounds(10, 11, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(109, 11, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(205, 11, 89, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(308, 11, 89, 23);
		contentPane.add(btnEditar);
		
	}
}
