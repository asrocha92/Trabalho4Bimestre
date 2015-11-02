package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 01/11/2015 - 21:44:52
 * 
 * Comentario: Somente trás dados de relatorio que o cliente Pediu
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trab4bim.classes.Cliente;
import trab4bim.classes.Estado;

public class RelatoriosDao {
	
	private List<Cliente> lista = new ArrayList<>();
	private Connection con = Conexao.getInstace().conOpen();
	
	//relatórios de cliente
	public List<Cliente> listarClienteRel() {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT NOME, CIDADE, ESTADO FROM CLIENTE");
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setNome(rs.getString("NOME"));
				c.setCidade(rs.getString("CIDADE"));
				c.setEstado(Estado.valueOf(Estado.class,rs.getString("ESTADO")));
				lista.add(c);
			}
			rs.close();
			st.close();
			if (lista != null)
				return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Connection getCon() {
		return con;
	}
}
