package trab4bim.relatorios;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTable;

import trab4bim.Dao.Conexao;
import trab4bim.classes.Cliente;
import trab4bim.classes.Estado;
import trab4bim.tabelas.TableCliente;
import trab4bim.tabelas.TableProduto;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Alex Santos Rocha, 01/11/2015 - 19:23:29
 * 
 *         Comentario: classe gera relatório em PDF do cliente.
 *
 */

public class RelatorioCliente extends JPanel {

	private JComboBox<String> cbx_estado;
	private JComboBox<String> cbx_cidade;
	private JTable table;

	private static String OUF_PDF;
	private String arq = "C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\RelCliente.jasper";
	private List<Cliente> listaC;
	private TableCliente tbModel;
	private String sql = "SELECT ID_C, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO FROM CLIENTE";

	public RelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 121, 125, 0, 125, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnNewButton = new JButton("EXPORTAR PRA PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportarPdf();
			}
		});

		JLabel lblNewLabel = new JLabel("FILTRO POR ESTADO:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		cbx_estado = new JComboBox<>();
		cbx_estado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2)
					filtrarPorEstado();
			}
		});
		GridBagConstraints gbc_cbx_estado = new GridBagConstraints();
		gbc_cbx_estado.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_estado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_estado.gridx = 1;
		gbc_cbx_estado.gridy = 1;
		add(cbx_estado, gbc_cbx_estado);

		JLabel lblFiltroPorCidade = new JLabel("   FILTRO POR CIDADE: ");
		GridBagConstraints gbc_lblFiltroPorCidade = new GridBagConstraints();
		gbc_lblFiltroPorCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltroPorCidade.anchor = GridBagConstraints.EAST;
		gbc_lblFiltroPorCidade.gridx = 2;
		gbc_lblFiltroPorCidade.gridy = 1;
		add(lblFiltroPorCidade, gbc_lblFiltroPorCidade);

		cbx_cidade = new JComboBox<>();
		cbx_cidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2)
					filtrarPorCidade();
			}
		});
		GridBagConstraints gbc_cbx_cidade = new GridBagConstraints();
		gbc_cbx_cidade.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_cidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_cidade.gridx = 3;
		gbc_cbx_cidade.gridy = 1;
		add(cbx_cidade, gbc_cbx_cidade);

		JButton btnEC = new JButton("FILTRO DE E.C.");
		btnEC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtroEC();
			}
		});
		GridBagConstraints gbc_btnEC = new GridBagConstraints();
		gbc_btnEC.insets = new Insets(0, 0, 5, 5);
		gbc_btnEC.gridx = 4;
		gbc_btnEC.gridy = 1;
		add(btnEC, gbc_btnEC);

		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloTable();
			}
		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 5;
		gbc_btnAtualizar.gridy = 1;
		add(btnAtualizar, gbc_btnAtualizar);
		btnNewButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTable();

		listarDDF();
	}

	// Método que carrega a table modelo em uma thread
	private void modeloTable() {
		tbModel = new TableCliente();
		listaC = tbModel.listar();
		new Thread(new Runnable() {
			@Override
			public void run() {
				table.setModel(tbModel);
			}
		}).start();
	}

	// listar dados de filtro no comboBox
	private void listarDDF() {
		int indice = 0;
		for (Estado e : Estado.values()) {
			if (indice == 0) {
				cbx_estado.addItem("");
				indice = 1;
			}
			cbx_estado.addItem(e.getNome());
		}

		for (int i = 0; i < listaC.size(); i++) {
			indice = 0;
			if (i == 0) {
				cbx_cidade.addItem("");
			}

			for (int j = 0; j < cbx_cidade.getItemCount(); j++) {
				if (listaC.get(i).getCidade()
						.equals(cbx_cidade.getItemAt(j).toString()))
					indice++;
				if (indice > 1)
					break;
			}
			if (indice < 1)
				cbx_cidade.addItem(listaC.get(i).getCidade());
		}
	}

	// filtra por estado e cidade
	protected void filtroEC() {
		if (cbx_cidade.getSelectedItem() != "" && cbx_estado.getSelectedItem() != "") {
			StringBuilder filtrosql = new StringBuilder();
			filtrosql.append(sql+ " WHERE ESTADO = '"
					+ Estado.transforma(cbx_estado.getSelectedItem().toString())
					+ "' AND CIDADE ='"
					+ cbx_cidade.getSelectedItem().toString() +
					"'");
			listaC = tbModel.listarRelatorio(filtrosql.toString());
			table.setModel(tbModel);
		} else {
			JOptionPane.showMessageDialog(null,
					"Selecione cidade e estado para filtrar.");
		}

	}

	protected void filtrarPorCidade() {
		if (cbx_cidade.getSelectedItem() != "") {
			StringBuilder filtrosql = new StringBuilder();
			filtrosql.append(sql + " WHERE CIDADE = '"
					+ cbx_cidade.getSelectedItem() + "'");
			listaC = tbModel.listarRelatorio(filtrosql.toString());
			table.setModel(tbModel);
		}
	}

	protected void filtrarPorEstado() {
		if (cbx_estado.getSelectedItem() != "") {
			StringBuilder filtrosql = new StringBuilder();
			filtrosql.append(sql+ " WHERE ESTADO = '"
						+ Estado.transforma(cbx_estado.getSelectedItem().toString()) + "'");
			listaC = tbModel.listarRelatorio(filtrosql.toString());
			table.setModel(tbModel);
		}
	}

	public void exportarPdf() {
		TableModel tableModel = getTableModelProduto();

		JasperPrint jp = null;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("enderecop", "Av. Nilza de Oliveira, 401");
			map.put("telefonep", "(55) 44 3543-1090");
			// passar onde está o relatório em forma binarinaria
			// map passa valores do atributos endereco e telefone
			// e 3 parametro passa a conexão
			jp = JasperFillManager.fillReport(arq, map,
					new JRTableModelDataSource(tableModel));
			// damos o nome ao arquivo pdf
			OUF_PDF = nomeRelatorio();
			// criamos o relatório em pdf
			JasperExportManager.exportReportToPdfFile(jp,
					"C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\"
							+ OUF_PDF);

			Desktop.getDesktop().open(
					new File(
							"C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\"
									+ OUF_PDF));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// gera uma table com os dados presentes na tela
	private TableModel getTableModelProduto() {
		String[] columnNames = { "id_c", "nome", "telefone", "endereco",
				"cidade", "estado", "email", "genero" };

		Object[][] data = new Object[listaC.size()][8];
		for (int i = 0; i < listaC.size(); i++) {
			int j = 0;
			data[i][j++] = listaC.get(i).getId();
			data[i][j++] = listaC.get(i).getNome();
			data[i][j++] = listaC.get(i).getTelefone();
			data[i][j++] = listaC.get(i).getEndreco();
			data[i][j++] = listaC.get(i).getCidade();
			data[i][j++] = listaC.get(i).getEstado().getNome();
			data[i][j++] = listaC.get(i).getEmail();
			data[i][j++] = listaC.get(i).getGenero().getNome();
		}
		return new DefaultTableModel(data, columnNames);
	}

	/**
	 * @author Alex Santos Rocha, 01/11/2015 - 19:29:15
	 * 
	 * @return Nome do relatório
	 * 
	 *         Exemplo: Cliente-dataAtula-horas
	 */
	public String nomeRelatorio() {
		StringBuilder nome = new StringBuilder();
		SimpleDateFormat frm = new SimpleDateFormat("ddMMyyyy");
		nome.append("Cliente-" + frm.format(new java.util.Date()) + "-");

		Calendar hora = Calendar.getInstance();
		return nome.append(String.format("%1$tH-%tM-%1$tS", hora) + ".fdf")
				.toString();
	}

}
