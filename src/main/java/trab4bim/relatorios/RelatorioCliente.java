package trab4bim.relatorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import org.apache.commons.collections.map.HashedMap;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @author Alex Santos Rocha, 01/11/2015 - 19:23:29
 * 
 * Comentario: classe gera relatório em PDF do cliente.
 *
 */

public class RelatorioCliente {
	private static String OUF_PDF;
	private String arq = "C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\RelatorioCliente.jasper";
	private Connection con;
	
	public RelatorioCliente(){
		JasperPrint jp = null;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("endereco", "Av. Nilza de Oliveira, 401");
			map.put("telefone", "(55) 44 3543-1090");		
			//passar onde está o relatório em forma binarinaria
			//map passa valores do atributos endereco e telefone 
			//e 3 parametro passa a conexão
			jp = JasperFillManager.fillReport(arq, map, getConnetion()); 
			//abre umam janela na mostra uma previa do relatório
			JasperViewer jasperViewer = new JasperViewer(jp);
			 jasperViewer.setLocationRelativeTo(null);
			 jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
			 jasperViewer.setVisible(true);
			 
			 //damos o nome ao arquivo pdf
			 OUF_PDF = nomeRelatorio();
			 System.out.println(OUF_PDF);
			 //criamos o relatório em pdf
			 JasperExportManager.exportReportToPdfFile(jp, 
					 "C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\"+OUF_PDF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private Connection getConnetion() throws Exception {
		String driverName = "com.mysql.jdbc.Driver";
   
			Class.forName(driverName);		
		String url = "jdbc:mysql://localhost/tb4bim";
		String user = "root";
		String pass = "'123'";	
		return con = DriverManager.getConnection(url, user, pass);
	}


	/**
	 * @author Alex Santos Rocha, 01/11/2015 - 19:29:15
	 * 
	 * @return Nome do relatório
	 * 
	 * Exemplo: Cliente-dataAtula-horas
	 */
	public String nomeRelatorio(){
		StringBuilder nome = new StringBuilder();
		SimpleDateFormat frm = new SimpleDateFormat("ddMMyyyy");
		nome.append("Cliente-"+frm.format(new java.util.Date())+"-");

		Calendar hora = Calendar.getInstance();
		return nome.append(String.format("%1$tH-%tM-%1$tS", hora)+".fdf").toString();
	}
	
	public static void main(String[] args) {
		new RelatorioCliente();
	}
}
