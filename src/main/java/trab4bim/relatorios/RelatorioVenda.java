package trab4bim.relatorios;
/**
 * @author Alex Santos Rocha, 02/11/2015 - 18:46:50
 * 
 * Comentario: Configuração da tela de relatório
 */

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import trab4bim.Dao.DaoProduto;
import trab4bim.Dao.RelatoriosDao;
import trab4bim.classes.Produto;
import trab4bim.classes.Venda;
import trab4bim.tabelas.TableProduto;
import trab4bim.tabelas.TableVenda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioVenda extends JPanel {

	private JTextField txt_cliente;
	private JTable table;
	private JComboBox<Object> cbx_dia;
	private JComboBox<Object> cbx_mes;
	private JComboBox<Object> cbx_categ;
	
	private List<Venda> listaV;
	private TableVenda tbModel;

	/**
	 * Create the panel.
	 */
	public RelatorioVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{224, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 50, 0, 50, 0, 100, 0, 150, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel(" DIA: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		cbx_dia = new JComboBox<>();
		GridBagConstraints gbc_cbx_dia = new GridBagConstraints();
		gbc_cbx_dia.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_dia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_dia.gridx = 1;
		gbc_cbx_dia.gridy = 0;
		panel.add(cbx_dia, gbc_cbx_dia);
		
		JLabel lblNewLabel_1 = new JLabel("  M\u00CAS: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cbx_mes = new JComboBox<>();
		GridBagConstraints gbc_cbx_mes = new GridBagConstraints();
		gbc_cbx_mes.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_mes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_mes.gridx = 3;
		gbc_cbx_mes.gridy = 0;
		panel.add(cbx_mes, gbc_cbx_mes);
		
		JLabel lblCategoriaDoProduto = new JLabel("  CATEGORIA DO PRODUTO: ");
		GridBagConstraints gbc_lblCategoriaDoProduto = new GridBagConstraints();
		gbc_lblCategoriaDoProduto.anchor = GridBagConstraints.EAST;
		gbc_lblCategoriaDoProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoriaDoProduto.gridx = 4;
		gbc_lblCategoriaDoProduto.gridy = 0;
		panel.add(lblCategoriaDoProduto, gbc_lblCategoriaDoProduto);
		
		cbx_categ = new JComboBox<>();
		GridBagConstraints gbc_cbx_categ = new GridBagConstraints();
		gbc_cbx_categ.insets = new Insets(0, 0, 5, 5);
		gbc_cbx_categ.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbx_categ.gridx = 5;
		gbc_cbx_categ.gridy = 0;
		panel.add(cbx_categ, gbc_cbx_categ);
		
		JLabel lblCliente = new JLabel("  CLIENTE: ");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 6;
		gbc_lblCliente.gridy = 0;
		panel.add(lblCliente, gbc_lblCliente);
		
		txt_cliente = new JTextField();
		txt_cliente.setToolTipText("DIGITE O PRIMEIRO NOME DO CLIENTE");
		GridBagConstraints gbc_txt_cliente = new GridBagConstraints();
		gbc_txt_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_txt_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cliente.gridx = 7;
		gbc_txt_cliente.gridy = 0;
		panel.add(txt_cliente, gbc_txt_cliente);
		txt_cliente.setColumns(10);
		
		JButton btnNewButton = new JButton("FILTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarsql();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloTable();
			}
		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.anchor = GridBagConstraints.WEST;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 9;
		gbc_btnAtualizar.gridy = 0;
		panel.add(btnAtualizar, gbc_btnAtualizar);
		
		JButton btnGerarRelatrio = new JButton("GERAR RELAT\u00D3RIO");
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportarPdf();
			}
		});
		GridBagConstraints gbc_btnGerarRelatrio = new GridBagConstraints();
		gbc_btnGerarRelatrio.anchor = GridBagConstraints.EAST;
		gbc_btnGerarRelatrio.insets = new Insets(0, 0, 5, 0);
		gbc_btnGerarRelatrio.gridx = 10;
		gbc_btnGerarRelatrio.gridy = 0;
		panel.add(btnGerarRelatrio, gbc_btnGerarRelatrio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 11;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		//carregar modelo da table
		modeloTable();
		//carregar dia e mês
		carregarCBX();
		//carregar gategoria
		carregarCBXCateg();
	}
	
	private void modeloTable() {
		tbModel = new TableVenda();
		listaV = tbModel.listar();
		new Thread(new Runnable() {
			@Override
			public void run() {
				table.setModel(tbModel);
			}
		}).start();
	}

	//método pra carregar filtro de categoria no comboBox
	private void carregarCBX() {
		for (int i = 1; i < 32; i++) {
			if(i <= 12){
				if(i <= 9){
					cbx_mes.addItem("0"+i);
					cbx_dia.addItem("0"+i);
				}else{
					cbx_mes.addItem(i);
					cbx_dia.addItem(i);
				}
			}else{	
				cbx_dia.addItem(i);
			}
		}
	 }
	//método pra carregar filtro de categoria no comboBox
	private void carregarCBXCateg() {
			RelatoriosDao d = new RelatoriosDao();
			List<String> lct = d.listarCatProd();
			for (int i = 0; i < lct.size(); i++) {
				int indice = 0;			
				for (int j = 0; j < cbx_categ.getItemCount(); j++) {
					if (lct.get(i).toString().equals(cbx_categ.getItemAt(j).toString())) 
						indice++;
					if (indice > 1) break; 
				}			
				if (indice < 1) cbx_categ.addItem(lct.get(i).toString());			
			}
	}

	// gerar sql
	protected void gerarsql() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cod_v,cliente,produto,vtotal,vpagamento,troco,data,hora FROM VENDA, PRODUTO WHERE ");
		sql.append("venda.data LIKE '"+cbx_dia.getSelectedItem()+"/"+cbx_mes.getSelectedItem().toString()+ "%' AND categoria = '"+cbx_categ.getSelectedItem()
					+"' AND venda.cliente LIKE '"+txt_cliente.getText().trim()+"%'"); 
		listaV = tbModel.listarRelatorio(sql);
		table.setModel(tbModel);		
	}

	//Método para exportar para pdf a table produto
	public void exportarPdf() {
		new GerarPDF("Venda", getTableModelProduto());
	}

	// gera uma table com os dados presentes na tela
	private TableModel getTableModelProduto() {
		String[] columnNames = {"cod_v","cliente","produto","vtotal","vpagamento","troco","data","hora"};

		Object[][] data = new Object[listaV.size()][8];
		for (int i = 0; i < listaV.size(); i++) {
			int j = 0;
			data[i][j++] = listaV.get(i).getCod_v();
			data[i][j++] = listaV.get(i).getCliente();
			data[i][j++] = listaV.get(i).getProduto();
			data[i][j++] = listaV.get(i).getvTotal();
			data[i][j++] = listaV.get(i).getvPago();
			data[i][j++] = listaV.get(i).getTroco();
			data[i][j++] = listaV.get(i).getData();
			data[i][j++] = listaV.get(i).getHora();
		}
		return new DefaultTableModel(data, columnNames);
	}

}