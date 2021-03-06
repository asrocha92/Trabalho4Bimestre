package trab4bim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Venda;

/**
 * 
 * @author Alex Santos Rocha, 29/10/2015 - 19:23:06
 *
 *         Comentario: Classe DaoVenda implementa DaoCrud e atrav�s implementa
 *         m�todos que se relacionem com um banco de dados.
 *
 */
public class DaoVenda implements CrudDao<Venda> {
	private PreparedStatement ps;
	private Statement st = null;
	private ResultSet rs = null;
	private Venda v = null;
	private List<Venda> lista = null;
	private Connection con = Conexao.getInstace().conOpen();

	public int inserir(Venda vd) {
		try {
			ps = con.prepareStatement("INSERT INTO VENDA (ID_C, CLIENTE, COD_P, PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, vd.getId_c());
			ps.setString(2, vd.getCliente());
			ps.setInt(3, vd.getCod_p());
			ps.setString(4, vd.getProduto());
			ps.setBigDecimal(5, vd.getvTotal());
			ps.setBigDecimal(6, vd.getvPago());
			ps.setBigDecimal(7, vd.getTroco());
			ps.setString(8, vd.getData());
			ps.setString(9, vd.getHora());
			int res = ps.executeUpdate();
			ps.close();
			if(res == 1)
				return res;
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int atualizar(Venda vd) {
		//uma venda pode se atualizar os dados do registro maa n�o pode modificar o historico do banco por isso vazio esse m�todo
		return 0;
	}

	public int deletar(int cod_v) {
		try {
			ps = con.prepareStatement("DELETE FROM VENDA WHERE COD_V =" + cod_v);
			int res = ps.executeUpdate();
			ps.close();
			if(res == 1)
				JOptionPane.showMessageDialog(null, "Historico selecionado foi\nexcluido com sucesso");
			else
				JOptionPane.showMessageDialog(null, "Hist�rico selecionado n�o foi excluido!");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Venda buscarUm(int cod_v) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM VENDA WHERE COD_V ="+ cod_v);
			rs.next();
			if (rs.getString("ID_C") != null) {
				v = new Venda(rs.getInt("ID_C"),
						rs.getInt("COD_P"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"),
						rs.getBigDecimal("VPAGAMENTO"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA"));
			}
			rs.close();
			st.close();
			return v;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Venda> listar() {
		lista = new ArrayList<Venda>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT COD_V, ID_C, CLIENTE, COD_P,"
					+ "PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA FROM VENDA");
			while (rs.next()) {
				lista.add(v = new Venda(rs.getInt("COD_V"),
						rs.getInt("ID_C"),
						rs.getInt("COD_P"),
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
	
	//get que retorna o valor da conex�o
	public Connection getCon() {
		return con;
	}

}
