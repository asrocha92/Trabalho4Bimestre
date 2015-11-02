package trab4bim.telas;

/**
 * @author Alex Santos Rocha, 31/10/2015 - 9:00:37
 * 
 * Comentario: configuração da tela de cadastro do cliente 
 */

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import trab4bim.Dao.DaoCliente;
import trab4bim.classes.Cliente;
import trab4bim.classes.Estado;
import trab4bim.classes.Genero;
import trab4bim.tabelas.TableCliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MioloCadCliente extends JPanel {
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private JTextField txt_endereco;
	private JTextField txt_cidade;
	private JTextField txt_email;
	private JTable table;
	private JTextField txt_id;
	private JComboBox<String> cbx_estado;
	private JComboBox<String> cbx_genero;
	
	private TableCliente tableCliente;
	private DaoCliente c = new DaoCliente();
	private List<Cliente> listaC = new ArrayList<>();
	private int indece = -1;

	/**
	 * Create the panel.
	 */
	public MioloCadCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 77, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNome = new JLabel("ID: ");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);

		txt_id = new JTextField();
		GridBagConstraints gbc_txt_id = new GridBagConstraints();
		gbc_txt_id.ipadx = 99;
		gbc_txt_id.anchor = GridBagConstraints.WEST;
		gbc_txt_id.insets = new Insets(0, 0, 5, 5);
		gbc_txt_id.gridx = 1;
		gbc_txt_id.gridy = 1;
		add(txt_id, gbc_txt_id);
		txt_id.setColumns(10);
		txt_id.enable(false);

		JLabel lblNome_1 = new JLabel("NOME: ");
		GridBagConstraints gbc_lblNome_1 = new GridBagConstraints();
		gbc_lblNome_1.anchor = GridBagConstraints.EAST;
		gbc_lblNome_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome_1.gridx = 0;
		gbc_lblNome_1.gridy = 2;
		add(lblNome_1, gbc_lblNome_1);

		txt_nome = new JTextField();
		GridBagConstraints gbc_txt_nome = new GridBagConstraints();
		gbc_txt_nome.gridwidth = 3;
		gbc_txt_nome.insets = new Insets(0, 0, 5, 0);
		gbc_txt_nome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_nome.gridx = 1;
		gbc_txt_nome.gridy = 2;
		add(txt_nome, gbc_txt_nome);
		txt_nome.setColumns(10);

		JLabel lblTelefone = new JLabel("TELEFONE: ");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		add(lblTelefone, gbc_lblTelefone);

		txt_telefone = new JTextField();
		GridBagConstraints gbc_txt_telefone = new GridBagConstraints();
		gbc_txt_telefone.gridwidth = 3;
		gbc_txt_telefone.anchor = GridBagConstraints.NORTH;
		gbc_txt_telefone.insets = new Insets(0, 0, 5, 0);
		gbc_txt_telefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_telefone.gridx = 1;
		gbc_txt_telefone.gridy = 3;
		add(txt_telefone, gbc_txt_telefone);
		txt_telefone.setColumns(10);

		JLabel lblEndereo = new JLabel("ENDERE\u00C7O: ");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 4;
		add(lblEndereo, gbc_lblEndereo);

		txt_endereco = new JTextField();
		GridBagConstraints gbc_txt_endereco = new GridBagConstraints();
		gbc_txt_endereco.gridwidth = 3;
		gbc_txt_endereco.anchor = GridBagConstraints.NORTH;
		gbc_txt_endereco.insets = new Insets(0, 0, 5, 0);
		gbc_txt_endereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_endereco.gridx = 1;
		gbc_txt_endereco.gridy = 4;
		add(txt_endereco, gbc_txt_endereco);
		txt_endereco.setColumns(10);

		JLabel lblCidade = new JLabel("CIDADE: ");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 5;
		add(lblCidade, gbc_lblCidade);

		txt_cidade = new JTextField();
		GridBagConstraints gbc_txt_cidade = new GridBagConstraints();
		gbc_txt_cidade.gridwidth = 3;
		gbc_txt_cidade.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cidade.gridx = 1;
		gbc_txt_cidade.gridy = 5;
		add(txt_cidade, gbc_txt_cidade);
		txt_cidade.setColumns(10);

		JLabel lblEstado = new JLabel("ESTADO: ");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 6;
		add(lblEstado, gbc_lblEstado);

		cbx_estado = new JComboBox<String>();
		cbx_estado.setPreferredSize(new Dimension(115, 20));
		GridBagConstraints gbc_cbx_estado = new GridBagConstraints();
		gbc_cbx_estado.ipadx = 99;
		gbc_cbx_estado.gridwidth = 3;
		gbc_cbx_estado.anchor = GridBagConstraints.WEST;
		gbc_cbx_estado.insets = new Insets(0, 0, 5, 0);
		gbc_cbx_estado.gridx = 1;
		gbc_cbx_estado.gridy = 6;
		add(cbx_estado, gbc_cbx_estado);

		JLabel lblEmail = new JLabel("EMAIL: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);

		txt_email = new JTextField();
		GridBagConstraints gbc_txt_email = new GridBagConstraints();
		gbc_txt_email.gridwidth = 3;
		gbc_txt_email.insets = new Insets(0, 0, 5, 0);
		gbc_txt_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_email.gridx = 1;
		gbc_txt_email.gridy = 7;
		add(txt_email, gbc_txt_email);
		txt_email.setColumns(10);

		JLabel lblGenro = new JLabel("GEN\u00CARO: ");
		GridBagConstraints gbc_lblGenro = new GridBagConstraints();
		gbc_lblGenro.anchor = GridBagConstraints.EAST;
		gbc_lblGenro.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenro.gridx = 0;
		gbc_lblGenro.gridy = 8;
		add(lblGenro, gbc_lblGenro);

		cbx_genero = new JComboBox<String>();
		cbx_genero.setPreferredSize(new Dimension(115, 20));
		GridBagConstraints gbc_cbx_genero = new GridBagConstraints();
		gbc_cbx_genero.ipadx = 99;
		gbc_cbx_genero.anchor = GridBagConstraints.WEST;
		gbc_cbx_genero.gridwidth = 3;
		gbc_cbx_genero.insets = new Insets(0, 0, 5, 0);
		gbc_cbx_genero.gridx = 1;
		gbc_cbx_genero.gridy = 8;
		add(cbx_genero, gbc_cbx_genero);

		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("ATUALIZAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 9;
		add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton("DELETAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 9;
		add(btnNewButton_2, gbc_btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		// click duplo para alterar o cliente
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Cliente c = (Cliente) listaC.get(table.getSelectedRow());
					returnCliente(c);
					indece = table.getSelectedRow();
				}
			}
		});
		scrollPane.setViewportView(table);

		// lista os dados das enum no cbxEstado e cbxGenero
		listarEnumCBX();
		// iniciar conexão
		c.getCon();
		//listar todos os clientes na table
		listaDeCliente();
	}

	// lista os dados das enum no cbxEstado e cbxGenero
	public void listarEnumCBX() {
		for (Estado e : Estado.values())
			cbx_estado.addItem(e.name());
		for (Genero g : Genero.values())
			cbx_genero.addItem(g.name());
	}

	// lista dados armazenados no banco na table
	public void listaDeCliente() {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				tableCliente = new TableCliente();
				listaC = tableCliente.listar();
				table.setModel(tableCliente);		
			}
		}).start();
	}

	protected void cadastrar() {
		Cliente cliente = new Cliente(txt_nome.getText(),
				txt_telefone.getText(), 
				txt_endereco.getText(),
				txt_cidade.getText(),
				Estado.valueOf(String.valueOf(cbx_estado.getSelectedItem())),
				txt_email.getText(),
				Genero.valueOf(String.valueOf(cbx_genero.getSelectedItem())));
		c.inserir(cliente);
		listaC = c.listar();
		tableCliente.adicionarLista(listaC);
		limpar();
	}

	protected void atualizar() {
		if (indece > -1) {
			Cliente cliente = new Cliente(
					Integer.parseInt(txt_id.getText()),
					txt_nome.getText(),
					txt_telefone.getText(),
					txt_endereco.getText(),
					txt_cidade.getText(),
					Estado.valueOf(String.valueOf(cbx_estado.getSelectedItem())),
					txt_email.getText(),
					Genero.valueOf(String.valueOf(cbx_genero.getSelectedItem())));
			c.atualizar(cliente);
			tableCliente.atualizarLista(indece, cliente);
			limpar();
			indece = -1;
		}else{
			JOptionPane.showMessageDialog(null, "Selecio um cliente para editar!");
		}
	}

	protected void deletar() {
		c.deletar(table.getSelectedRow());
		tableCliente.deletar(table.getSelectedRow());
	}

	public void returnCliente(Cliente c) {
		txt_id.setText(String.valueOf(c.getId()));
		txt_nome.setText(c.getNome());
		txt_telefone.setText(c.getTelefone());
		txt_endereco.setText(c.getEndreco());
		txt_cidade.setText(c.getCidade());
		cbx_estado.setSelectedItem(c.getEstado().name());
		txt_email.setText(c.getEmail());
		cbx_genero.setSelectedItem(c.getGenero().name());
	}

	public void limpar() {
		txt_id.setText("");
		txt_nome.setText("");
		txt_telefone.setText("");
		txt_endereco.setText("");
		txt_cidade.setText("");
		cbx_estado.setSelectedIndex(0);
		txt_email.setText("");
		cbx_genero.setSelectedIndex(0);
	}
}
