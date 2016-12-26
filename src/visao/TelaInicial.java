package visao;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

	private JPanel contentPane;

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
		
		JButton btnRealizarEmprestimo = new JButton("Realizar Emprestimo");
		btnRealizarEmprestimo.setBounds(10, 11, 129, 57);
		contentPane.add(btnRealizarEmprestimo);
	}

}
