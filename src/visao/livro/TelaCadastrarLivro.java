package visao.livro;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaCadastrarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JTextField txtAno;
	private JTextField txtEdicao;

	/**
	 * Create the frame.
	 */
	public TelaCadastrarLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 581);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(37, 187, 46, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(getClass().getResource("/img/livro.png")));
		lblImg.setBounds(10, 11, 130, 121);
		contentPane.add(lblImg);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(37, 212, 46, 14);
		contentPane.add(lblAutor);
		
		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(37, 237, 46, 14);
		contentPane.add(lblEditora);
		
		JLabel lblAno = new JLabel("Ano: ");
		lblAno.setBounds(37, 262, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo: ");
		lblCdigo.setBounds(37, 160, 46, 14);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(93, 156, 209, 23);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(93, 181, 209, 23);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(93, 206, 209, 23);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(93, 231, 209, 23);
		contentPane.add(txtEditora);
		txtEditora.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(93, 256, 209, 23);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblCadastrarLivro = new JLabel("Cadastrar Livro");
		lblCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastrarLivro.setBounds(150, 82, 117, 41);
		contentPane.add(lblCadastrarLivro);
		
		JLabel lblEdio = new JLabel("Edi\u00E7\u00E3o: ");
		lblEdio.setBounds(37, 287, 46, 14);
		contentPane.add(lblEdio);
		
		txtEdicao = new JTextField();
		txtEdicao.setBounds(93, 284, 209, 23);
		contentPane.add(txtEdicao);
		txtEdicao.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o: ");
		lblDescrio.setBounds(27, 322, 65, 14);
		contentPane.add(lblDescrio);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(93, 318, 209, 138);
		contentPane.add(textArea);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrar.setBounds(51, 482, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(165, 482, 89, 23);
		contentPane.add(btnFechar);
	}
}
