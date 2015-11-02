package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 28/10/2015 - 01:28:58
 * 
 * Coméntario: Criando a classe DaoCliente que implementa CrudDao,
 * 			   para trabalhar dados do cliente. 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Cliente;
import trab4bim.classes.Estado;
import trab4bim.classes.Genero;

public class DaoCliente implements CrudDao<Cliente> {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Cliente c = null;
	private List<Cliente> lista = null;
	private Connection con = Conexao.getInstace().conOpen();

	public void inserir(Cliente c) {
		try {
			ps = con.prepareStatement("INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndreco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome()
					+ "\n Cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Cliente c) {
		try {
			ps = con.prepareStatement("UPDATE CLIENTE SET NOME = ?,"
					+ " TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?,"
					+ " EMAIL = ?, GENERO = ? WHERE ID_C = " + c.getId());
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndreco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome()
					+ "\n Atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(int id) {
		try {
			ps = con.prepareStatement("DELETE FROM CLIENTE WHERE ID_C =" + id);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cliente buscarUm(int id) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE WHERE ID_C = " + id);
			rs.next();
			if (rs.getString("NOME") != null) {
				c = new Cliente(rs.getString("NOME"), rs.getString("TELEFONE"),
						rs.getString("ENDERECO"), rs.getString("CIDADE"),
						Estado.valueOf(Estado.class, rs.getString("ESTADO")),
						rs.getString("EMAIL"), Genero.valueOf(Genero.class,
								rs.getString("GENERO")));
			}
			rs.close();
			st.close();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Cliente> listar() {
		lista = new ArrayList<Cliente>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_C, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE");
			while (rs.next()) {
				lista.add(c = new Cliente(rs.getInt("ID_C"), rs.getString("NOME"), rs
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

	//get que retorna um tipo de coneção
	public Connection getCon() {
		return con;
	}
	
	

}
