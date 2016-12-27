package visao.usuario;

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

import controle.UsuarioControle;
import modelo.Usuario;

@SuppressWarnings("serial")
public class TelaListarTodos extends JDialog {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaListarTodos() {
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
		lblImg.setIcon(new ImageIcon(getClass().getResource("/img/usuario.jpg")));
		lblImg.setBounds(10, 11, 130, 121);
		contentPane.add(lblImg);
		
		JLabel lblCadastrarLivro = new JLabel("Todos os Usuários");
		lblCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastrarLivro.setBounds(150, 82, 173, 41);
		contentPane.add(lblCadastrarLivro);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(118, 518, 89, 23);
		contentPane.add(btnFechar);
		
		
		List<Usuario> lista = UsuarioControle.listaUsuarios();
		Object [][] dados = new Object[lista.size()][4];
		
		for(int i = 0; i< lista.size(); i++){
			dados[i][0] = lista.get(i).getCpf();
			dados[i][1] = lista.get(i).getNome();
			dados[i][2] = lista.get(i).getTelefone();
			dados[i][3] = lista.get(i).getEndereco();
		}
		
		String [] colunas = {"CPF", "Nome", "Telefone", "Endereço"};
		
		table = new JTable(dados,colunas);
		table.setEnabled(false);
		table.setBounds(10, 157, 313, 350);
		contentPane.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 157, 313, 350);
		contentPane.add(scroll);
	}
}
