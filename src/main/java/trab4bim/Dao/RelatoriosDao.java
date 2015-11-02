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
import trab4bim.classes.Genero;
import trab4bim.classes.Produto;
import trab4bim.classes.Venda;

public class RelatoriosDao {
	
	private Connection con = Conexao.getInstace().conOpen();
	private Statement st = null;
	private ResultSet rs = null;
	
	//relatórios de cliente
	public List<Cliente> listarClienteRel(String sql) {
		List<Cliente> lista = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Cliente(rs.getInt("ID_C"), rs.getString("NOME"), rs
						.getString("TELEFONE"), rs.getString("ENDERECO"), rs
						.getString("CIDADE"), Estado.valueOf(Estado.class,
						rs.getString("ESTADO")), rs.getString("EMAIL"), Genero
						.valueOf(Genero.class, rs.getString("GENERO"))));
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
	
	
	public List<Produto> listarRelProduto(String sql) {
		List<Produto> lista = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				lista.add(new Produto(rs.getInt("COD_P") , 
						rs.getInt("COD_BARRA"),
						rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"),
						rs.getString("UNIDADE"),
						rs.getBigDecimal("CUSTO"),
						rs.getBigDecimal("MARGE_LUCRO")));
			}
			rs.close();
			st.close();
			if(lista != null)
				return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Venda> listarRelVenda(StringBuilder sql) {
		System.out.println(sql.toString() + " UNION " + sql.toString());
		List<Venda> lista = new ArrayList<Venda>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql.toString() + " UNION " + sql.toString());
			while (rs.next()) {
				lista.add(new Venda(rs.getInt("COD_V"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"),
						rs.getBigDecimal("VPAGAMENTO"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA")));
			}
			rs.close();
			st.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//método para retornar categoria
	public List<String> listarCatProd() {
		List<String> lista = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT CATEGORIA FROM PRODUTO");
			while(rs.next()){
				lista.add(rs.getString("CATEGORIA"));
			}
			rs.close();
			st.close();
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
