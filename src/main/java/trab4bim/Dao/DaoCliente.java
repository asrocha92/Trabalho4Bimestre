package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 28/10/2015 - 01:28:58
 * 
 * Coméntario: Criando a classe DaoCliente que implementa CrudDao,
 * 			   para trabalhar dados do cliente. 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import trab4bim.classes.Cliente;

public class DaoCliente implements CrudDao<Cliente> {

	Connection con;

	public void inserir(Cliente c) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndreco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().getNome());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Cliente c) {
		// TODO Auto-generated method stub
	}

	public void deletar(int tipo) {
		// TODO Auto-generated method stub

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
