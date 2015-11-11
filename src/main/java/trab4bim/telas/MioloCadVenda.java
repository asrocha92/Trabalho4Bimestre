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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import trab4bim.Dao.DaoCliente;
import trab4bim.Dao.DaoProduto;
import trab4bim.Dao.DaoVenda;
import trab4bim.TrararException.TratarException;
import trab4bim.classes.Cliente;
import trab4bim.classes.Produto;
import trab4bim.classes.Venda;
import trab4bim.tabelas.TableVenda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("serial")
public class MioloCadVenda extends JPanel {
	private JTextField txt_vTotal;
	private JTextField txt_vPago;
	private JTextField txt_vTroco;
	private JTextField txt_data;
	private JTextField txt_horas;
	private JTextField txt_codVenda;
	private JComboBox<String> cbx_cliente;
	private JComboBox<String> cbx_produto;
	private JTable table;

	private TableVenda tableVenda;
	private DaoVenda v = new DaoVenda();
	private List<Venda> listaV = new ArrayList<>();
	protected int indece = -1;

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private List<Produto> listaProduto = new ArrayList<Produto>();

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public MioloCadVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 77, 0, 96, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNome = new JLabel("C\u00D3D da VENDA: ");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);

		txt_codVenda = new JTextField();
		GridBagConstraints gbc_txt_codVenda = new GridBagConstraints();
		gbc_txt_codVenda.ipadx = 99;
		gbc_txt_codVenda.anchor = GridBagConstraints.WEST;
		gbc_txt_codVenda.insets = new Insets(0, 0, 5, 5);
		gbc_txt_codVenda.gridx = 1;
		gbc_txt_codVenda.gridy = 1;
		add(txt_codVenda, gbc_txt_codVenda);
		txt_codVenda.setColumns(10);
		txt_codVenda.enable(false);

		JLabel lblNome_1 = new JLabel("CLIENTE: ");
		GridBagConstraints gbc_lblNome_1 = new GridBagConstraints();
		gbc_lblNome_1.anchor = GridBagConstraints.EAST;
		gbc_lblNome_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome_1.gridx = 0;
		gbc_lblNome_1.gridy = 2;
		add(lblNome_1, gbc_lblNome_1);

		cbx_cliente = new JComboBox<String>();
		GridBagConstraints gbc_cbx_cliente = new GridBagConstraints();
		gbc_cbx_cliente.gridwidth = 3;
		gbc_cbx_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cbx_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_cliente.gridx = 1;
		gbc_cbx_cliente.gridy = 2;
		add(cbx_cliente, gbc_cbx_cliente);

		JLabel lblTelefone = new JLabel("PRODUTO: ");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		add(lblTelefone, gbc_lblTelefone);

		cbx_produto = new JComboBox<String>();
		// após um click no cbx_Produto ira preencher alguns campos na tela
		// automatico
		cbx_produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					fazerOsParanaesDasVenda();
				}
			}
		});
		GridBagConstraints gbc_cbx_produto = new GridBagConstraints();
		gbc_cbx_produto.gridwidth = 3;
		gbc_cbx_produto.insets = new Insets(0, 0, 5, 0);
		gbc_cbx_produto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_produto.gridx = 1;
		gbc_cbx_produto.gridy = 3;
		add(cbx_produto, gbc_cbx_produto);

		JLabel lblEndereo = new JLabel("VALOR TOTAL: ");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 4;
		add(lblEndereo, gbc_lblEndereo);

		txt_vTotal = new JTextField();
		GridBagConstraints gbc_txt_vTotal = new GridBagConstraints();
		gbc_txt_vTotal.gridwidth = 3;
		gbc_txt_vTotal.insets = new Insets(0, 0, 5, 0);
		gbc_txt_vTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_vTotal.gridx = 1;
		gbc_txt_vTotal.gridy = 4;
		add(txt_vTotal, gbc_txt_vTotal);
		txt_vTotal.setColumns(10);

		JLabel lblCidade = new JLabel("VALOR PAGO: ");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 5;
		add(lblCidade, gbc_lblCidade);

		txt_vPago = new JTextField();
		GridBagConstraints gbc_txt_vPago = new GridBagConstraints();
		gbc_txt_vPago.gridwidth = 3;
		gbc_txt_vPago.insets = new Insets(0, 0, 5, 0);
		gbc_txt_vPago.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_vPago.gridx = 1;
		gbc_txt_vPago.gridy = 5;
		add(txt_vPago, gbc_txt_vPago);
		txt_vPago.setColumns(10);

		JLabel lblEstado = new JLabel("TROCO: ");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 6;
		add(lblEstado, gbc_lblEstado);

		txt_vTroco = new JTextField();
		GridBagConstraints gbc_txt_vTroco = new GridBagConstraints();
		gbc_txt_vTroco.gridwidth = 3;
		gbc_txt_vTroco.insets = new Insets(0, 0, 5, 0);
		gbc_txt_vTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_vTroco.gridx = 1;
		gbc_txt_vTroco.gridy = 6;
		add(txt_vTroco, gbc_txt_vTroco);
		txt_vTroco.setColumns(10);

		JLabel lblEmail = new JLabel("DATA: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);

		txt_data = new JTextField();
		GridBagConstraints gbc_txt_data = new GridBagConstraints();
		gbc_txt_data.anchor = GridBagConstraints.WEST;
		gbc_txt_data.ipadx = 99;
		gbc_txt_data.insets = new Insets(0, 0, 5, 5);
		gbc_txt_data.gridx = 1;
		gbc_txt_data.gridy = 7;
		add(txt_data, gbc_txt_data);
		txt_data.setColumns(10);

		JLabel lblGenro = new JLabel("HORAS:");
		GridBagConstraints gbc_lblGenro = new GridBagConstraints();
		gbc_lblGenro.anchor = GridBagConstraints.EAST;
		gbc_lblGenro.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenro.gridx = 0;
		gbc_lblGenro.gridy = 8;
		add(lblGenro, gbc_lblGenro);

		JButton btnNewButton = new JButton("EFETUAR VENDA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});

		txt_horas = new JTextField();
		GridBagConstraints gbc_txt_horas = new GridBagConstraints();
		gbc_txt_horas.anchor = GridBagConstraints.WEST;
		gbc_txt_horas.ipadx = 99;
		gbc_txt_horas.insets = new Insets(0, 0, 5, 5);
		gbc_txt_horas.gridx = 1;
		gbc_txt_horas.gridy = 8;
		add(txt_horas, gbc_txt_horas);
		txt_horas.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("ALTERAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
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
					Venda vd = listaV.get(table.getSelectedRow());
					returnVenda(vd);
					indece = table.getSelectedRow();
				}
			}
		});
		scrollPane.setViewportView(table);

		// listar todos os clientes na table
		listaDeVenda();
		// listar cliente e produtos nos comboBox
		listaClienteProduto();
		// preencher os campos data e Hora automatico
		rDataTime();
	}

	// lista dados armazenados no banco na table
	public void listaDeVenda() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				tableVenda = new TableVenda();
				listaV = tableVenda.listar();
				table.setModel(tableVenda);
			}
		}).start();
	}

	protected void cadastrar() {
		Venda venda;
		try {
			venda = new Venda(
					listaCliente.get(cbx_cliente.getSelectedIndex() - 1)
							.getId(),
					listaProduto.get(cbx_produto.getSelectedIndex() - 1)
							.getCod(),
					String.valueOf(cbx_cliente.getSelectedItem()),
					String.valueOf(cbx_produto.getSelectedItem()),
					new TratarException().tratarBigDecimal(txt_vTotal.getText()),
					new TratarException().tratarBigDecimal(txt_vPago.getText()),
					new TratarException().tratarBigDecimal(txt_vTroco.getText()),
					txt_data.getText(), txt_horas.getText());
			v.inserir(venda);
			listaV = v.listar();
			tableVenda.adicionarLista(listaV);
			limpar();
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro com valor digitado!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Digite somete números e não letras");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void atualizar() {
		if (indece > -1) {
			try {
				Venda venda = new Venda(
						Integer.parseInt(txt_codVenda.getText()),
						listaCliente.get(cbx_cliente.getSelectedIndex() - 1)
								.getId(),
						listaProduto.get(cbx_produto.getSelectedIndex() - 1)
								.getCod(),
						String.valueOf(cbx_cliente.getSelectedItem()),
						String.valueOf(cbx_produto.getSelectedItem()),
						new TratarException().tratarBigDecimal(txt_vTotal.getText()),
						new TratarException().tratarBigDecimal(txt_vPago.getText()),
						new TratarException().tratarBigDecimal(txt_vTroco.getText()),
						txt_data.getText(), txt_horas.getText());
				v.inserir(venda);
				listaV = v.listar();
				tableVenda.adicionarLista(listaV);
				limpar();
				indece = -1;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Erro com valor digitado!");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Digite somete números e não letras");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"De um duplo click na tabela venda para poder atualizar!");
		}
	}

	private void deletar() {
		v.deletar(listaV.get(table.getSelectedRow()).getCod_p());
		tableVenda.deletar(table.getSelectedRow());
	}

	private void returnVenda(Venda v) {
		txt_codVenda.setText(String.valueOf(v.getCod_v()));
		cbx_cliente.setSelectedItem(v.getCliente());
		cbx_produto.setSelectedItem(v.getProduto());
		txt_vTotal.setText(String.valueOf(v.getvTotal()));
		txt_vPago.setText(String.valueOf(v.getvPago()));
		txt_vTroco.setText(String.valueOf(v.getTroco()));
		txt_data.setText(v.getData());
		txt_horas.setText(v.getHora());
	}

	private void limpar() {
		txt_codVenda.setText("");
		cbx_cliente.setSelectedIndex(0);
		cbx_produto.setSelectedIndex(0);
		txt_vTotal.setText("");
		txt_vPago.setText("");
		txt_vTroco.setText("");
		rDataTime();
	}

	private void listaClienteProduto() {
		DaoCliente dc = new DaoCliente();
		listaCliente = dc.listar();
		DaoProduto dp = new DaoProduto();
		listaProduto = dp.listar();
		int contador = 0;
		for (Cliente c : listaCliente) {
			if (contador == 0) {
				contador = 1;
				cbx_cliente.addItem("");
			}
			cbx_cliente.addItem(c.getNome());
		}
		contador = 0;
		for (Produto p : listaProduto) {
			if (contador == 0) {
				contador = 1;
				cbx_produto.addItem("");
			}
			cbx_produto.addItem(p.getDescricao());
		}
	}

	/**
	 * @author Alex Santos Rocha, 01/11/2015 - 14:44:01
	 * 
	 * @return valor pago e troco para o cliente.
	 */
	protected void fazerOsParanaesDasVenda() {
		try {
			// cbx_produto.getSelectedIndex() - 1. os dados armazenados na lista
			// começa em zero
			double vt = listaProduto.get(cbx_produto.getSelectedIndex() - 1) .CalcularMLP();
			txt_vTotal.setText(String.valueOf(vt));
			double vp = Double.valueOf(JOptionPane.showInputDialog("Digite o valor do pagamento ?"));
			if (vp >= vt) {
				double troco = vp - vt;
				txt_vPago.setText(String.valueOf(vp));
				// formatar número
				BigDecimal bd = new BigDecimal(troco).setScale(2, RoundingMode.HALF_EVEN);
				txt_vTroco.setText(bd.toString());
			} else {
				JOptionPane.showMessageDialog(null,
						"Valor recebido, e menos que o custo do produto");
			}

		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null,
							"O valor digitado deve ser número ou com ponto\nEX: 50 ou 21.25");
		}

	}

	// Preencher os campos data e hora
	private void rDataTime() {
		SimpleDateFormat frm = new SimpleDateFormat("dd/MM/yyyy");
		txt_data.setText(frm.format(new java.util.Date()));

		Calendar hora = Calendar.getInstance();
		txt_horas.setText(String.format("%1$tH:%tM:%1$tS", hora));
	}

}
