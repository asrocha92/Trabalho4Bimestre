package trab4bim.tabelas;
/**
 * @author Alex Santos Rocha, 01/11/2015 - 09:07:21
 * 
 * Comentario: Modela da tabela usuário
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import trab4bim.Dao.DaoUsuario;
import trab4bim.classes.Usuario;

@SuppressWarnings("serial")
public class TableUsuario extends AbstractTableModel{
	
	List<Usuario> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Usuario u = lista.get(row);
		switch (col) {
		case 0: return u.getId();
		case 1: return u.getIdCliente();
		case 2: return u.getCliente();
		case 3: return u.getSenha();
		default: return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0: return "ID do USUÁRIO";
		case 1: return "ID do CLIENTE";
		case 2: return "USUÁRIO";
		case 3: return "SENHA";
		default: return "";
		}
	}
	
	public List<Usuario> listar(){
		DaoUsuario u = new DaoUsuario();
		return lista = u.listar();
	}

	public void adicionarLista(List<Usuario> u){
		this.lista = u;
		this.fireTableStructureChanged();
	}
	
	public void atualizarLista(int indice, Usuario u){
		lista.set(indice, u);
		this.fireTableStructureChanged();
	}
	
	public void deletar(int indice){
		lista.remove(indice);
		this.fireTableStructureChanged();
	}
	
}
