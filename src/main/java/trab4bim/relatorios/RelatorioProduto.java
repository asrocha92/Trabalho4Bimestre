package trab4bim.relatorios;

/**
 * @author Alex Santos Rocha, 01/11/2015 - 21:38:02
 * 
 * Comentario: Configuração do relatório produto, e contruira relatório PDF
 */

import java.util.List;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTable;

import trab4bim.classes.Produto;
import trab4bim.tabelas.TableProduto;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class RelatorioProduto extends JPanel {

	private JTextField txt_mLucro;
	private JComboBox<String> cbx_categoria;
	private JTable table;

	private List<Produto> listaP;
	private TableProduto tbModelProduto;

	public RelatorioProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 113, 99, 46, 106, 47, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnNewButton = new JButton("EXPORTAR PRA PDF");
		btnNewButton.setIcon(new ImageIcon(RelatorioProduto.class.getResource("/trab4bim/telas/ico/pdf.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportarPdf();
			}
		});

		JLabel lblMargeDeLucro = new JLabel("MARGE DE LUCRO: ");
		GridBagConstraints gbc_lblMargeDeLucro = new GridBagConstraints();
		gbc_lblMargeDeLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMargeDeLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargeDeLucro.gridx = 0;
		gbc_lblMargeDeLucro.gridy = 1;
		add(lblMargeDeLucro, gbc_lblMargeDeLucro);

		txt_mLucro = new JTextField();
		GridBagConstraints gbc_txt_mLucro = new GridBagConstraints();
		gbc_txt_mLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_mLucro.insets = new Insets(0, 0, 5, 5);
		gbc_txt_mLucro.gridx = 1;
		gbc_txt_mLucro.gridy = 1;
		add(txt_mLucro, gbc_txt_mLucro);
		txt_mLucro.setColumns(10);

		JLabel lblCategoria = new JLabel(" CATEGORIA: ");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 2;
		gbc_lblCategoria.gridy = 1;
		add(lblCategoria, gbc_lblCategoria);

		cbx_categoria = new JComboBox<String>();
		GridBagConstraints gbc_cbx_categoria = new GridBagConstraints();
		gbc_cbx_categoria.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_categoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_categoria.gridx = 3;
		gbc_cbx_categoria.gridy = 1;
		add(cbx_categoria, gbc_cbx_categoria);

		JButton btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.setIcon(new ImageIcon(RelatorioProduto.class.getResource("/trab4bim/telas/ico/seacher.png")));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gerarsql();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 4;
		gbc_btnFiltrar.gridy = 1;
		add(btnFiltrar, gbc_btnFiltrar);
		
		JButton btnNewButton_1 = new JButton("ATUALIZAR");
		btnNewButton_1.setMnemonic(KeyEvent.VK_ENTER);
		btnNewButton_1.setIcon(new ImageIcon(RelatorioProduto.class.getResource("/trab4bim/telas/ico/update.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloTable();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
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

		carregarCBX();
	}

	//Método que carrega a table modelo em uma thread
	private void modeloTable() {
		tbModelProduto = new TableProduto();
		listaP = tbModelProduto.listar();
		new Thread(new Runnable() {
			@Override
			public void run() {
				table.setModel(tbModelProduto);
			}
		}).start();
	}

	//método pra carregar filtro de categoria no comboBox
	private void carregarCBX() {
		for (int i = 0; i < listaP.size(); i++) {
			int indice = 0;
			if (i == 0){
				cbx_categoria.addItem("");
			}			
			for (int j = 0; j < cbx_categoria.getItemCount(); j++) {
				if (listaP.get(i).getCategoria().equals(cbx_categoria.getItemAt(j).toString())) 
					indice++;
				if (indice > 1) break; 
			}			
			if (indice < 1) cbx_categoria.addItem(listaP.get(i).getCategoria());			
		}
	 }

	// gerar sql
	protected void gerarsql() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COD_P, COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO FROM PRODUTO ");
		try {
			if (Double.valueOf(txt_mLucro.getText()) > 0) {
				txt_mLucro.setBackground(Color.WHITE);
				sql.append("WHERE MARGE_LUCRO >= '" + txt_mLucro.getText()+"' ");
				if (cbx_categoria.getSelectedItem() != null)
					sql.append("AND CATEGORIA = '"+ cbx_categoria.getSelectedItem()+"'");
			}else if (cbx_categoria.getSelectedItem() != null) {
				sql.append("WHERRE CATEGORIA = '" + cbx_categoria.getSelectedItem()+"'");
			}
			listaP = tbModelProduto.listarRelatorio(sql.toString());
			table.setModel(tbModelProduto);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite somente números");
			txt_mLucro.setBackground(Color.yellow);
			txt_mLucro.setFocusable(true);
		}
	}

	//Método para exportar para pdf a table produto
	public void exportarPdf() {
		new GerarPDF("Produto", getTableModelProduto());
	}

	// gera uma table com os dados presentes na tela
	private TableModel getTableModelProduto() {
		String[] columnNames = { "cod_p", "cod_barra", "categoria", "descricao", "unidade", "custo", "marge_lucro" };

		Object[][] data = new Object[listaP.size()][7];
		for (int i = 0; i < listaP.size(); i++) {
			int j = 0;
			data[i][j++] = Long.valueOf(listaP.get(i).getCod());
			data[i][j++] = listaP.get(i).getCodBarra();
			data[i][j++] = listaP.get(i).getCategoria();
			data[i][j++] = listaP.get(i).getDescricao();
			data[i][j++] = listaP.get(i).getUnidade();
			data[i][j++] = listaP.get(i).getCusto();
			data[i][j++] = listaP.get(i).getMargenLucro();
		}
		return new DefaultTableModel(data, columnNames);
	}

}