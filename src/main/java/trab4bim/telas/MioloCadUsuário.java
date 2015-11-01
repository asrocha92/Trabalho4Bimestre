package trab4bim.telas;

/**
 * @author Alex Santos Rocha, 31/10/2015 - 22:15:50
 * 
 * Comentario: Cadastrar atualiza e deletar usuário
 * 			   usuário admin já vai existir somente se for necessário para castrar um usuário
 * 			   Configuração da tela pra cadastrar usuário
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import trab4bim.Dao.DaoUsuario;
import trab4bim.classes.Cliente;
import trab4bim.classes.Usuario;
import trab4bim.tabelas.TableUsuario;

public class MioloCadUsuário extends JPanel {

	protected JTextField txt_idUser;
	protected JTextField txt_idCliente;
	private JTextField txt_cliente;
	private JPasswordField txt_senha;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JTable table;

	private TableUsuario tableUsuario;
	private DaoUsuario u = new DaoUsuario();
	private List<Usuario> listaU = new ArrayList<>();
	private int indece = -1;

	/**
	 * Create the panel.
	 */
	public MioloCadUsuário() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 96, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("ID do USU\u00C1RIO: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		txt_idUser = new JTextField();
		GridBagConstraints gbc_txt_idUser = new GridBagConstraints();
		gbc_txt_idUser.gridwidth = 4;
		gbc_txt_idUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_idUser.insets = new Insets(0, 0, 5, 0);
		gbc_txt_idUser.gridx = 1;
		gbc_txt_idUser.gridy = 1;
		add(txt_idUser, gbc_txt_idUser);
		txt_idUser.setColumns(10);

		JLabel lblIdCliente = new JLabel("ID do CLIENTE: ");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 2;
		add(lblIdCliente, gbc_lblIdCliente);

		txt_idCliente = new JTextField();
		GridBagConstraints gbc_txt_idCliente = new GridBagConstraints();
		gbc_txt_idCliente.gridwidth = 4;
		gbc_txt_idCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_idCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txt_idCliente.gridx = 1;
		gbc_txt_idCliente.gridy = 2;
		add(txt_idCliente, gbc_txt_idCliente);
		txt_idCliente.setColumns(10);

		JLabel lblEndereo = new JLabel("CLIENTE");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 3;
		add(lblEndereo, gbc_lblEndereo);

		txt_cliente = new JTextField();
		GridBagConstraints gbc_txt_cliente = new GridBagConstraints();
		gbc_txt_cliente.gridwidth = 4;
		gbc_txt_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cliente.gridx = 1;
		gbc_txt_cliente.gridy = 3;
		add(txt_cliente, gbc_txt_cliente);
		txt_cliente.setColumns(10);

		JLabel lblSenha = new JLabel("SENHA: ");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 4;
		add(lblSenha, gbc_lblSenha);

		txt_senha = new JPasswordField();
		GridBagConstraints gbc_txt_senha = new GridBagConstraints();
		gbc_txt_senha.gridwidth = 4;
		gbc_txt_senha.insets = new Insets(0, 0, 5, 0);
		gbc_txt_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_senha.gridx = 1;
		gbc_txt_senha.gridy = 4;
		add(txt_senha, gbc_txt_senha);

		btnCadastrar = new JButton("CADASTRAR");
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCadastrar.gridx = 2;
		gbc_btnCadastrar.gridy = 5;
		add(btnCadastrar, gbc_btnCadastrar);

		btnAtualizar = new JButton("ATUALIZAR");
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 3;
		gbc_btnAtualizar.gridy = 5;
		add(btnAtualizar, gbc_btnAtualizar);

		btnDeletar = new JButton("DELETAR");
		GridBagConstraints gbc_btnDeletar = new GridBagConstraints();
		gbc_btnDeletar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeletar.gridx = 4;
		gbc_btnDeletar.gridy = 5;
		add(btnDeletar, gbc_btnDeletar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		// click duplo para alterar o Usuário
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Usuario u = (Usuario) listaU.get(table.getSelectedRow());
					returnCliente(u);
					indece = table.getSelectedRow();
				}
			}
		});
		scrollPane.setViewportView(table);

		//retrona conexão com o banco 
		u.getCon();
		//listar todos os clientes na table
		listaDeUsuario();
	}

	// lista dados armazenados no banco na table
	public void listaDeUsuario() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tableUsuario = new TableUsuario();
				listaU = tableUsuario.listar();
				table.setModel(tableUsuario);
			}
		}).start();
	}

	protected void cadastrar() {
		Usuario usuario = new Usuario();
		usuario.setIdCliente(Integer.parseInt(txt_idCliente.getText()));
		usuario.setCliente(txt_cliente.getText());
		usuario.setSenha(txt_senha.getSelectedText());
		u.inserir(usuario);
		tableUsuario.adicionarLista(usuario);
		limpar();
	}

	protected void atualizar() {
		if (indece > -1) {
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(txt_idUser.getText()));
			usuario.setIdCliente(Integer.parseInt(txt_idCliente.getText()));
			usuario.setCliente(txt_cliente.getText());
			usuario.setSenha(txt_senha.getSelectedText());
			u.atualizar(usuario);
			tableUsuario.atualizarLista(indece, usuario);
			limpar();
			indece = -1;
		} else {
			JOptionPane.showMessageDialog(null,
					"Selecio um Usuário para editar!");
		}
	}

	protected void deletar() {
		u.deletar(table.getSelectedRow());
		tableUsuario.deletar(table.getSelectedRow());
	}

	public void returnCliente(Usuario c) {
		txt_idUser.setText(String.valueOf(c.getId()));
		txt_idCliente.setText(String.valueOf(c.getIdCliente()));
		txt_cliente.setText(c.getCliente());
		txt_senha.setText(c.getSenha());
	}

	public void limpar() {
		txt_idUser.setText("");
		txt_idCliente.setText("");
		txt_cliente.setText("");
		txt_senha.setText("");
	}

}
