package trab4bim.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import trab4bim.classes.Usuario;

public class DaoUsuario implements CrudDao<Usuario>{

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Usuario u = null;
	private List<Usuario> lista = null;
	
	public void inserir(Usuario u) {
		try {
			ps = Conexao.con.prepareStatement("INSERT INTO USUARIO (ID_C, CLIENTE, SENHA) VALUES (?, ?, ?)");
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
			ps = Conexao.con.prepareStatement("UPDATE USUARIO SET ID_C = ?, CLIENTE = ?, SENHA =? WHERE ID_U"+u.getId());
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
		
	}

	public Usuario buscarUm(int id_u) {
		return null;
	}

	public List<Usuario> listar() {
		return null;
	}

}
