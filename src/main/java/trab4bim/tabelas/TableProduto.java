package trab4bim.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import trab4bim.Dao.DaoProduto;
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
		case 5: return p.getCusto();
		case 6: return p.getMargenLucro();
		default: return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "C�DIGO";
		case 1: return "C�D_BARRA";
		case 2: return "CATEGORIA";
		case 3: return "DESCRI��O";
		case 4: return "UNIDADE";
		case 5: return "CUSTO";
		case 6: return "MARGEM DE LUCRO";
		default: return "";
		}
	}
	
	public List<Produto> listar(){
		DaoProduto c = new DaoProduto();
		this.fireTableStructureChanged();
		return lista = c.listar();
	}

	public void adicionarLista(Produto c){
		this.lista.add(c);
		listar();
	}
	
	public void atualizarLista(int indice, Produto c){
		lista.set(indice, c);
		this.fireTableStructureChanged();
	}
	
	public void deletar(int indice){
		lista.remove(indice);
		this.fireTableStructureChanged();
	}

}
