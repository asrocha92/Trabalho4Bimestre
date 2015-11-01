package trab4bim.tabelas;
/**
 * @author Alex Santos Rocha, 31/10/2015 - 19:55:50
 * 
 * Comentario: carrega o modelo da tabela de clientes armazenados no banco
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import trab4bim.Dao.DaoCliente;
import trab4bim.classes.Cliente;

public class TableCliente extends AbstractTableModel{
	
	List<Cliente> lista = new ArrayList<>();

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
		Cliente o = lista.get(row);
		switch (col) {
		case 0: return o.getId();
		case 1: return o.getNome();
		case 2: return o.getTelefone();
		case 3: return o.getEndreco();
		case 4: return o.getCidade();
		case 5: return o.getEstado().getNome();
		case 6: return o.getEmail(); 
		case 7: return o.getGenero();
		default: return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "ID";
		case 1: return "NOME";
		case 2: return "TELEFONE";
		case 3: return "ENDEREÇO";
		case 4: return "CIDADE";
		case 5: return "ESTADO";
		case 6: return "E-MAIL"; 
		case 7: return "GENÊRO";
		default: return "";
		}
	}
	
	public List<Cliente> listar(){
		DaoCliente c = new DaoCliente();
		return lista = c.listar();
	}

	public void adicionarLista(List<Cliente> c){
		this.lista = c;
		this.fireTableStructureChanged();
	}
	
	public void atualizarLista(int indice, Cliente c){
		lista.set(indice, c);
		this.fireTableStructureChanged();
	}
	
	public void deletar(int indice){
		lista.remove(indice);
		this.fireTableStructureChanged();
	}
	
}
