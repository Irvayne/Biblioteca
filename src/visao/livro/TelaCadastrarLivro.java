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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.LivroControle;
import excecoes.ObjetoExistente;
import modelo.Livro;

@SuppressWarnings("serial")
public class TelaCadastrarLivro extends JDialog {

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
		
		JLabel lblEdio = new JLabel("Edição: ");
		lblEdio.setBounds(27, 287, 46, 14);
		contentPane.add(lblEdio);
		
		txtEdicao = new JTextField();
		txtEdicao.setBounds(93, 283, 209, 23);
		contentPane.add(txtEdicao);
		txtEdicao.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição: ");
		lblDescrio.setBounds(27, 312, 65, 14);
		contentPane.add(lblDescrio);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(93, 312, 209, 138);
		contentPane.add(textArea);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAno.getText().equals("") || txtAutor.getText().equals("") || txtCodigo.getText().equals("") || txtEdicao.getText().equals("") || txtEditora.getText().equals("") || txtTitulo.getText().equals("") || textArea.getText().equals("")){
					//algum campo esta em branco
					JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos");
				}else{
					try{
					Integer.parseInt(txtAno.getText());
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "O valor no campo ano é inválido");
						return;
					}
					Livro livro = new Livro(txtTitulo.getText(), txtAutor.getText(), Integer.parseInt(txtAno.getText()), txtCodigo.getText(), txtEditora.getText(), txtEdicao.getText(), textArea.getText());
					try {
						LivroControle.inserirLivro(livro);
					} catch (ObjetoExistente e1) {
						JOptionPane.showMessageDialog(null, "Livro com esse código já cadastrado");
						return;
					}
					JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");
					setVisible(false);
					
				}
				
				
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
