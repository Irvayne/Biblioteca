package visao.usuario;

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

import DAO.UsuarioDAO;
import excecoes.ObjetoExistente;
import modelo.Usuario;

@SuppressWarnings("serial")
public class TelaEditarUsuario extends JDialog {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelefone;

	/**
	 * Create the frame.
	 */
	public TelaEditarUsuario(Usuario usuario) {
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 205, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(getClass().getResource("/img/usuario.jpg")));
		lblImg.setBounds(10, 11, 130, 121);
		contentPane.add(lblImg);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(27, 246, 46, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 164, 46, 14);
		contentPane.add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setBounds(93, 197, 209, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(93, 238, 209, 30);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblCadastrarLivro = new JLabel("Editar Usuário");
		lblCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastrarLivro.setBounds(150, 82, 173, 41);
		contentPane.add(lblCadastrarLivro);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(27, 284, 65, 14);
		contentPane.add(lblEndereco);
		
		TextArea txtEndereco = new TextArea();
		txtEndereco.setBounds(93, 283, 209, 138);
		contentPane.add(txtEndereco);
		
		JLabel lblCpfTxt = new JLabel("");
		lblCpfTxt.setText(usuario.getCpf());
		lblCpfTxt.setBounds(93, 156, 209, 30);
		contentPane.add(lblCpfTxt);
		
		lblCpfTxt.setText(usuario.getCpf());
		txtNome.setText(usuario.getNome());
		txtTelefone.setText(usuario.getTelefone());
		txtEndereco.setText(usuario.getEndereco());
		
		JButton btnCadastrar = new JButton("Editar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEndereco.getText().equals("") || lblCpfTxt.getText().equals("") || txtNome.getText().equals("") || txtTelefone.getText().equals("")){
					//algum campo esta em branco
					JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos");
				}else{
					
					Usuario usuario = new Usuario(txtNome.getText(), lblCpfTxt.getText(), txtEndereco.getText(), txtTelefone.getText());
					try {
						UsuarioDAO.editarUsuario(usuario.getNome(), usuario.getCpf(), usuario.getEndereco(), usuario.getTelefone());
					} catch (ObjetoExistente e1) {
						JOptionPane.showMessageDialog(null, "Usuário com esse CPF já cadastrado");
						return;
					}
					JOptionPane.showMessageDialog(null, "Usuário editado com sucesso");
					setVisible(false);
					
				}
				
				
			}
		});
		btnCadastrar.setBounds(51, 507, 89, 23);
		contentPane.add(btnCadastrar);
		
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
