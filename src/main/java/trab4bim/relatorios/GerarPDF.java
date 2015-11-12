package trab4bim.relatorios;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

/**
 * 
 * @author Alex Santos Rocha, 04/11/2015 - 12:52:02
 * 
 * Comentário: Gerador de DPF para todos as classes. Deixar complexo.
 */
public class GerarPDF {
	
	private String tipo;
	//teste no pc p
	private String arq = "C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\";
	private String salvarLocal = "C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\";
	//teste no pc do s
//	private String arq = "C:\\Users\\e006617\\git\\Trabalho4Bimestre\\src\\main\\resources\\";
//	private String salvarLocal = arq;
	
	public GerarPDF(String tipo, TableModel tbModel){
		this.tipo = tipo;
		this.arq = caminhoArq(tipo);
		GerarPdf(nomeRelatorio(tipo),tbModel);
	}

	private void GerarPdf(String out_pdf,TableModel tbModel){
		JasperPrint jp = null;
		try {
			Map<String, Object> map = new HashMap<>();
			if(this.tipo.equals("Cliente")){
				map.put("enderecop", "Av. Nilza de Oliveira, 401");
				map.put("telefonep", "(55) 44 3543-1090");
			}else{
				map.put("endereco", "Av. Nilza de Oliveira, 401");
				map.put("telefone", "(55) 44 3543-1090");
			}
			// passar onde está o relatório em forma binaria
			// map passa valores do atributos endereco e telefone
			// e 3 parametro passa a conexão
			jp = JasperFillManager.fillReport(arq, map,
					new JRTableModelDataSource(tbModel));
			// criamos o relatório em pdf
			JasperExportManager.exportReportToPdfFile(jp, this.salvarLocal	+ out_pdf);

			Desktop.getDesktop().open(new File(this.salvarLocal + out_pdf));
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
	 *         
	 *         Método agora recebe por parametro somente o tipo, EX: cliente,produto,venda
	 */
	private String nomeRelatorio(String tipo) {
		StringBuilder nome = new StringBuilder();
		SimpleDateFormat frm = new SimpleDateFormat("ddMMyyyy");
		nome.append(tipo+"-" + frm.format(new java.util.Date()) + "-");

		Calendar hora = Calendar.getInstance();
		return nome.append(String.format("%1$tH-%tM-%1$tS", hora) + ".fdf")
				.toString();
	}
	
	private String caminhoArq(String tipo){
		if(tipo.equals("Cliente"))
			return this.arq = this.arq + "RelCliente.jasper";
		else if (tipo.equals("Produto"))
			return this.arq = this.arq + "RelProduto.jasper";
		else if (tipo.equals("Venda"))
			return this.arq = this.arq + "RelVenda.jasper";
		return "NoExisteTipo";
	}
	
}
