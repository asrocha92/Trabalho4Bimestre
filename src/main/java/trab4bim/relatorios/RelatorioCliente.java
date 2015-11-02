package trab4bim.relatorios;

/**
 * @author Alex Santos Rocha, 01/11/2015 - 21:38:02
 * 
 * Comentario: Configuração do relatório do cliente e gera relatório PDF
 */

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTable;

import trab4bim.Dao.Conexao;
import trab4bim.tabelas.TableModelRelCliente;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Alex Santos Rocha, 01/11/2015 - 19:23:29
 * 
 *         Comentario: classe gera relatório em PDF do cliente.
 *
 */

public class RelatorioCliente extends JPanel{
	private static String OUF_PDF;
	private String arq = "C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\RelatorioCliente.jasper";
	private JTable table;
	private Connection con = Conexao.getInstace().conOpen();

	public RelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("EXPORTAR PRA PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportarPdf();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		

		TableModelRelCliente tbModel = new TableModelRelCliente();
//		tbModel.listar();
		table = new JTable(tbModel);
		scrollPane.setViewportView(table);
		
	}
	
	private void exportarPdf(){
		JasperPrint jp = null;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("endereco", "Av. Nilza de Oliveira, 401");
			map.put("telefone", "(55) 44 3543-1090");
			// passar onde está o relatório em forma binarinaria
			// map passa valores do atributos endereco e telefone
			// e 3 parametro passa a conexão
			jp = JasperFillManager.fillReport(arq, map, con);
			// damos o nome ao arquivo pdf
			OUF_PDF = nomeRelatorio();
			System.out.println(OUF_PDF);
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
