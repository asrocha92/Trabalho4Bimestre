package trab4bim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Usuario;

public class DaoUsuario implements CrudDao<Usuario> {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Usuario u = null;
	private List<Usuario> lista = null;
	private Connection con;

	public void inserir(Usuario u) {
		try {
			ps = con.prepareStatement("INSERT INTO USUARIO (ID_C, CLIENTE, SENHA) VALUES (?, ?, ?)");
			ps.setInt(1, u.getIdCliente());
			ps.setString(2, u.getCliente());
			ps.setString(3, u.getSenha());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com\n"
					+ "Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Usuario u) {
		try {
			ps = con.prepareStatement("UPDATE USUARIO SET ID_C = ?, CLIENTE = ?, SENHA =? WHERE ID_U"
					+ u.getId());
			ps.setInt(1, u.getIdCliente());
			ps.setString(2, u.getCliente());
			ps.setString(3, u.getSenha());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Usuário atualizado com\n"
					+ "Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletar(int id_u) {
		try {
			ps = con.prepareStatement("DELETE FROM USUARIO WHERE ID_U = "
					+ id_u);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, res
					+ ", usuário excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario buscarUm(int id_u) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_C, CLIENTE, SENHA FROM USUARIO WHERE ID_U = "
					+ id_u);
			rs.next();
			if (rs.getString("CLIENTE") != null) {
				u = new Usuario();
				u.setId(id_u);
				u.setIdCliente(rs.getInt("ID_C"));
				u.setCliente(rs.getString("CLIENTE"));
				u.setSenha(rs.getString("SENHA"));
				rs.close();
				st.close();
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Usuario> listar() {
		lista = new ArrayList<Usuario>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_U, ID_C, CLIENTE, SENHA FROM USUARIO");
			while (rs.next()) {				
				u = new Usuario();
				u.setId(rs.getInt("ID_U"));
				u.setIdCliente(rs.getInt("ID_C"));
				u.setCliente(rs.getString("CLIENTE"));
				u.setSenha(rs.getString("SENHA"));
				lista.add(u);
			}
			rs.close();
			st.close();
			if (lista != null)
				return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getCon() {
		return con;
	}
	
	

}
