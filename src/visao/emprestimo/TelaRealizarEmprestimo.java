package visao.emprestimo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.LivroDAO;
import controle.LivroControle;
import controle.UsuarioControle;
import modelo.Livro;
import modelo.Usuario;

@SuppressWarnings("serial")
public class TelaRealizarEmprestimo extends JDialog {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtCodigo;

	/**
	 * Create the frame.
	 * @param table 
	 */
	public TelaRealizarEmprestimo(DefaultTableModel table) {
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
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(27, 292, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(getClass().getResource("/img/emprestimo.png")));
		lblImg.setBounds(20, 11, 313, 138);
		contentPane.add(lblImg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 229, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(93, 221, 209, 30);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(93, 284, 209, 30);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCadastrarLivro = new JLabel("Realizar Empréstimo");
		lblCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastrarLivro.setBounds(99, 160, 173, 41);
		contentPane.add(lblCadastrarLivro);
		
		JButton btnEmprestar = new JButton("Confirmar");
		btnEmprestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(txtCpf.getText().equals("") || txtCodigo.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Todos os campos devem estar preenchidos");
						return;
					}else{
						Usuario usuario = UsuarioControle.pesquisarUsuario(txtCpf.getText());
						if(usuario==null){
							JOptionPane.showMessageDialog(null,"Usuário com esse CPF inexistente");
							return;
						}else{
							Livro livro = LivroControle.pesquisarLivro(txtCodigo.getText());
							if(livro==null){
								JOptionPane.showMessageDialog(null,"Livro com esse Código inexistente");
								return;
							}else{
								boolean resposta = LivroControle.emprestarLivro(livro.getCodigo(), usuario.getCpf());
								if(resposta){
									JOptionPane.showMessageDialog(null,"Livro de Código = "+livro.getCodigo()+" foi emprestado com sucesso ao usuário de CPF = "+usuario.getCpf());
									setVisible(false);
									Object[][] dados = null;
									try {
										dados = LivroDAO.relacaoLivroUsuarioEmprestimo();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									table.addRow(new Object[]{usuario.getCpf(),usuario.getNome(),livro.getCodigo(),livro.getTitulo()});
									
								}else{
									JOptionPane.showMessageDialog(null,"Livro já emprestado a outro usuário");
								}
							}
						}
					}
				
				
				
			}
		});
		btnEmprestar.setBounds(51, 507, 89, 23);
		contentPane.add(btnEmprestar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(183, 507, 89, 23);
		contentPane.add(btnFechar);
	}
}
