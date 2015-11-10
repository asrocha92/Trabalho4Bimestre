package trab4bim.tabelas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import trab4bim.Dao.DaoProduto;
import trab4bim.Dao.RelatoriosDao;
import trab4bim.classes.Produto;


public class TableProduto extends AbstractTableModel{

	List<Produto> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Produto p = lista.get(row);
		switch (col) {
		case 0: return p.getCod();
		case 1: return p.getCodBarra();
		case 2: return p.getCategoria();
		case 3: return p.getDescricao();
		case 4: return p.getUnidade();
		case 5: return new BigDecimal(p.getCusto().toString()).setScale(2, RoundingMode.HALF_EVEN);
		case 6: return p.getMargenLucro();
		default: return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "CÓDIGO";
		case 1: return "CÓD_BARRA";
		case 2: return "CATEGORIA";
		case 3: return "DESCRIÇÃO";
		case 4: return "UNIDADE";
		case 5: return "CUSTO";
		case 6: return "MARGEM DE LUCRO";
		default: return "";
		}
	}
	
	public List<Produto> listar(){
		DaoProduto c = new DaoProduto();
		this.lista = c.listar();
		this.fireTableStructureChanged();
		return this.lista;
	}

	public void adicionarLista(List<Produto> c){
		this.lista = c;
		this.fireTableStructureChanged();
	}
	
	public void atualizarLista(int indice, Produto c){
		this.lista.set(indice, c);
		this.fireTableStructureChanged();
	}
	
	public void deletar(int indice){
		this.lista.remove(indice);
		this.fireTableStructureChanged();
	}
	
	public List<Produto> listarRelatorio(String sql){
		RelatoriosDao d = new RelatoriosDao();
		this.lista = d.listarRelProduto(sql);
		this.fireTableDataChanged();		
		return lista;
	}

}
