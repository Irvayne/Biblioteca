package visao.livro;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Livro;

@SuppressWarnings("serial")
public class TelaPesquisarLivro extends JDialog {

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
	public TelaPesquisarLivro(Livro livro) {
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
		
		JLabel lblTtulo = new JLabel("Título:");
		lblTtulo.setBounds(27, 187, 46, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(getClass().getResource("/img/livro.png")));
		lblImg.setBounds(10, 11, 130, 121);
		contentPane.add(lblImg);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(27, 212, 46, 14);
		contentPane.add(lblAutor);
		
		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(27, 237, 46, 14);
		contentPane.add(lblEditora);
		
		JLabel lblAno = new JLabel("Ano: ");
		lblAno.setBounds(27, 262, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblCdigo = new JLabel("Código: ");
		lblCdigo.setBounds(27, 160, 46, 14);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(93, 156, 209, 23);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(93, 181, 209, 23);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setEditable(false);
		txtAutor.setBounds(93, 206, 209, 23);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setEditable(false);
		txtEditora.setBounds(93, 231, 209, 23);
		contentPane.add(txtEditora);
		txtEditora.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setEditable(false);
		txtAno.setBounds(93, 256, 209, 23);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblCadastrarLivro = new JLabel("Pesquisar Livro");
		lblCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastrarLivro.setBounds(150, 82, 117, 41);
		contentPane.add(lblCadastrarLivro);
		
		JLabel lblEdio = new JLabel("Edição: ");
		lblEdio.setBounds(27, 287, 46, 14);
		contentPane.add(lblEdio);
		
		txtEdicao = new JTextField();
		txtEdicao.setEditable(false);
		txtEdicao.setBounds(93, 283, 209, 23);
		contentPane.add(txtEdicao);
		txtEdicao.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição: ");
		lblDescrio.setBounds(27, 312, 65, 14);
		contentPane.add(lblDescrio);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(93, 312, 209, 138);
		contentPane.add(textArea);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(106, 483, 89, 23);
		contentPane.add(btnFechar);
		
		txtAno.setText(livro.getAno()+"");
		txtAutor.setText(livro.getAutor());
		txtCodigo.setText(livro.getCodigo());
		txtEdicao.setText(livro.getEdicao());
		txtEditora.setText(livro.getEditora());
		txtTitulo.setText(livro.getTitulo());
		textArea.setText(livro.getDescricao());
	}
}
