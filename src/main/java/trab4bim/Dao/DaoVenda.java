package trab4bim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Cliente;
import trab4bim.classes.Venda;

/**
 * 
 * @author Alex Santos Rocha, 29/10/2015 - 19:23:06
 *
 *	Comentario: Classe DaoVenda implementa DaoCrud e 
 *	através implementa métodos que se relacionem com um banco de dados.
 *
 */
public class DaoVenda implements CrudDao<Venda> {
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Venda v = null;
	private List<Cliente> lista = null;
	private Connection con = Conexao.getInstace().conOpen();

	public void inserir(Venda vd) {
		try {
			ps = con.prepareStatement("INSERT INTO VENDA (ID_C, CLIENTE, COD_P,"
					+ " PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, vd.getId_c());
			ps.setString(2, vd.getCliente());
			ps.setInt(3, vd.getCod_p());
			ps.setString(4, vd.getProduto());
			ps.setBigDecimal(5, vd.getvTotal());
			ps.setBigDecimal(6, vd.getvPago());
			ps.setBigDecimal(7, vd.getTroco());
			ps.setDate(8, vd.getData());
			ps.setTime(9, vd.getHora());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Venda Efetuada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Venda vd) {
		try {
			ps = con.prepareStatement("UPDATE VENDA SET ID_C = ?, CLIENTE = ?, COD_P = ?,"
					+ " PRODUTO = ?, VTOTAL = ?, VPAGAMENTO = ?, TROCO = ?, DATA = ?,"
					+ " HORA = ? WHERE COD_V ="+vd.getCod_v());
			ps.setInt(1, vd.getId_c());
			ps.setString(2, vd.getCliente());
			ps.setInt(3, vd.getCod_p());
			ps.setString(4, vd.getProduto());
			ps.setBigDecimal(5, vd.getvTotal());
			ps.setBigDecimal(6, vd.getvPago());
			ps.setBigDecimal(7, vd.getTroco());
			ps.setDate(8, vd.getData());
			ps.setTime(9, vd.getHora());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Venda Efetuada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletar(int cod_v) {
		try {
			ps = con
					.prepareStatement("DELETE FROM VENDA WHERE COD_V =" + cod_v);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, res
					+ ", Requisição de venda excluida com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Venda buscarUm(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Venda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
