package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 12/11/2015 - 09:01:02
 * 
 * Testando os métodos da classe DaoUsuário através do JUnit
 */

import static org.junit.Assert.*;
import org.junit.Test;
import trab4bim.classes.Usuario;

public class JunitTesteDaoUsuario {

	@Test
	public void testInserir() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		assertEquals("Erro ao inserir dados no banco",1, new DaoUsuario().inserir(u));
		new ResetarDaos().resetar("USUARIO");
	}

	@Test
	public void testAtualizar() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		new DaoUsuario().inserir(u);
		u.setCliente("teste1");
		u.setSenha("teste1");
		assertEquals("Erro ao atualizar dados no banco",1, new DaoUsuario().atualizar(u));
		new ResetarDaos().resetar("USUARIO");
	}

	@Test
	public void testDeletar() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		new DaoUsuario().inserir(u);
		assertEquals("Erro ao deletar dados no banco",1, new DaoUsuario().deletar(2));
		new ResetarDaos().resetar("USUARIO");
	}

	@Test
	public void testBuscarUm() {
		assertNotNull("Erro ao buscar usuário", new DaoUsuario().buscarUm(1));
	}

	@Test
	public void testListar() {
		assertNotNull("Erro ao listar usuário", new DaoUsuario().listar());
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro ao retornar conexão", new DaoUsuario().getCon());
	}
	
	@Test
	public void testVerifica() {
		Usuario u = new Usuario();
		u.setId(2);
		u.setIdCliente(2);
		u.setCliente("teste");
		u.setSenha("teste");
		new DaoUsuario().inserir(u);
		assertTrue("Erro ao deletar dados no banco", new DaoUsuario().Verifica("teste", "teste"));
		new ResetarDaos().resetar("USUARIO");
	}

}
