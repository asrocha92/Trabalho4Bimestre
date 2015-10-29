package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 28/10/2015 - 01:28:58
 * 
 * Coméntario: Criando a classe DaoCliente que implementa CrudDao,
 * 			   para trabalhar dados do cliente. 
 */

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Cliente;

public class DaoCliente implements CrudDao<Cliente> {

	private PreparedStatement ps;

	public void inserir(Cliente c) {
		try {
			ps = Conexao.con.prepareStatement("INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndreco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().getNome());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().getNome());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Cliente c) {
		try {
			ps = Conexao.con.prepareStatement("UPDATE CLIENTE SET NOME = ?"
					+ " TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?,"
					+ " EMAIL = ?, GENERO = ? WHERE ID_C ="+c.getId());
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndreco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().getNome());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().getNome());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(int id) {
		try {
			ps = Conexao.con.prepareStatement("DELETE FROM CLIENTE WHERE ID_C ="+id);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null,res + ", cliente excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cliente buscarUm(Cliente tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
