package trab4bim.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Produto;

public class DaoProduto implements CrudDao<Produto>{

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Produto p = null;
	private List<Produto> lista = null;
	
	public void inserir(Produto pd) {
		try {
			ps = Conexao.con
					.prepareStatement("INSERT INTO PRODUTO (COD_BARRA, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGE_LUCRO) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, pd.getCodBarra());
			ps.setString(2, pd.getCategoria().name());
			ps.setString(3, pd.getDescricao());
			ps.setInt(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargenLucro());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto: " + p.getDescricao()
					+ "\n Cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Produto pd) {
		try {
			ps = Conexao.con
					.prepareStatement("UPDATE PRODUTO SET COD_BARRA = ?, CATEGORIA = ?, DESCRICAO = ?,"
							+ " UNIDADE = ?, CUSTO = ?, MARGE_LUCRO = ? WHERE COD_P = " + pd.getCod());
			ps.setInt(1, pd.getCodBarra());
			ps.setString(2, pd.getCategoria().name());
			ps.setString(3, pd.getDescricao());
			ps.setInt(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMargenLucro());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto: " + p.getDescricao()
					+ "\n Cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deletar(int id) {
		try {
			ps = Conexao.con
					.prepareStatement("DELETE FROM PRODUTO WHERE COD_P =" + id);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, res
					+ ", Usuário excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Produto buscarUm(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
