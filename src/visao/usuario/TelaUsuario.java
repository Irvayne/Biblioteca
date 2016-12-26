package visao.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarUsuario cadastrarUsuario = new TelaCadastrarUsuario();
				cadastrarUsuario.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrar.setBounds(10, 11, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(208, 11, 89, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(109, 11, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(304, 11, 89, 23);
		contentPane.add(btnEditar);
	}

}
