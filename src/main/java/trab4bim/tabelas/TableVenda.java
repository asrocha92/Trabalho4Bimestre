package trab4bim.tabelas;
/**
 * @author Alex Santos Rocha, 31/10/2015 - 19:55:50
 * 
 * Comentario: carrega o modelo da tabela de clientes armazenados no banco
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import trab4bim.Dao.DaoVenda;
import trab4bim.Dao.RelatoriosDao;
import trab4bim.classes.Venda;


public class TableVenda extends AbstractTableModel{
	
	List<Venda> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Venda o = lista.get(row);
		switch (col) {
		case 0: return o.getCod_v();
		case 1: return o.getCliente();
		case 2: return o.getProduto();
		case 3: return o.getvTotal();
		case 4: return o.getvPago();
		case 5: return o.getTroco();
		case 6: return o.getData(); 
		case 7: return o.getHora();
		default: return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "CÓD DA VENDA";
		case 1: return "CLIENTE";
		case 2: return "PRODUTO";
		case 3: return "VALOR TOTAL";
		case 4: return "VALOR PAGO";
		case 5: return "TROCO";
		case 6: return "DATA"; 
		case 7: return "HORAS";
		default: return "";
		}
	}
	
	public List<Venda> listar(){
		DaoVenda v = new DaoVenda();
		return lista = v.listar();
	}

	public void adicionarLista(List<Venda> v){
		this.lista = v;
		this.fireTableStructureChanged();
	}
	
	public void atualizarLista(int indice, Venda v){
		this.lista.set(indice, v);
		this.fireTableStructureChanged();
	}
	
	public void deletar(int indice){
		this.lista.remove(indice);
		this.fireTableStructureChanged();
	}

	public List<Venda> listarRelatorio(StringBuilder sql) {
		RelatoriosDao d = new RelatoriosDao();
		this.lista = d.listarRelVenda(sql);
		this.fireTableDataChanged();		
		return lista;
	}
	
}
