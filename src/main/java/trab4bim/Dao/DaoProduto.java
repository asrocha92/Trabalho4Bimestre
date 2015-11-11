package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 29/10/2015 - 19:18:42
 * 
 * Comentario: DaoProduto implementa método que trabalha com banco com dados do produto. 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Produto;

public class DaoProduto implements CrudDao<Produto>{

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Produto p = null;
	private List<Produto> lista = null;
	private Connection con = Conexao.getInstace().conOpen();
	
	public int inserir(Produto pd) {
		try {
			ps = con
					.prepareStatement("INSERT INTO PRODUTO (COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, pd.getCodBarra());
			ps.setString(2, pd.getCategoria());
			ps.setString(3, pd.getDescricao());
			ps.setString(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargenLucro());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto: " + pd.getDescricao()
					+ "\n Cadastrado com sucesso.");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int atualizar(Produto pd) {
		try {
			ps = con
					.prepareStatement("UPDATE PRODUTO SET COD_BARRA = ?, CATEGORIA = ?, DESCRICAO = ?,"
							+ " UNIDADE = ?, CUSTO = ?, MARGE_LUCRO = ? WHERE COD_P = " + pd.getCod());
			ps.setInt(1, pd.getCodBarra());
			ps.setString(2, pd.getCategoria());
			ps.setString(3, pd.getDescricao());
			ps.setString(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargenLucro());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto: " + pd.getDescricao()
					+ "\n Atualizado com sucesso.");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public int deletar(int id) {
		try {
			ps =con.prepareStatement("DELETE FROM PRODUTO WHERE COD_P =" + id);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso.");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Produto buscarUm(int id) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO "
					+ "FROM PRODUTO WHERE COD_P = " + id);
			rs.next();
			if (rs.getString("NOME") != null) {
				p = new Produto(id , rs.getInt("COD_BARRA"),
						rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"), 
						rs.getString("UNIDADE"), 
						rs.getBigDecimal("CUSTO"),
						rs.getBigDecimal("MARGE_LUCRO"));
			}
			rs.close();
			st.close();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Produto> listar() {
		lista = new ArrayList<Produto>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COD_P, COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO "
					+ "FROM PRODUTO");
			while(rs.next()){
				lista.add(p = new Produto(rs.getInt("COD_P") , 
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

	public Connection getCon() {
		return con;
	}

}
