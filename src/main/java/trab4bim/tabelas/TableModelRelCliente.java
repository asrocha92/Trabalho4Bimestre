package trab4bim.tabelas;
/**
 * @author Alex Santos Rocha, 01/11/2015 - 21:30:38
 * 
 * Comentario: Carregar o modelo do relatório pdf na tela
 */

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import trab4bim.Dao.RelatoriosDao;
import trab4bim.classes.Cliente;

public class TableModelRelCliente extends AbstractTableModel{
	
	List<Cliente> lista = new ArrayList<>();
	RelatoriosDao r = new RelatoriosDao();

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cliente o = lista.get(row);
		switch (col) {
		case 0: return o.getNome();
		case 1: return o.getCidade();
		case 2: return o.getEstado().getNome();
		default: return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "NOME DO CLIENTE";
		case 1: return "CIDADE";
		case 2: return "ESTADO";
		default: return "";
		}
	}

	public void listar(){
		this.lista = r.listarClienteRel();
	}
}
