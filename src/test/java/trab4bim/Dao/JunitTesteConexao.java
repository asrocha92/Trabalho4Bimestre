package trab4bim.Dao;

import static org.junit.Assert.*;
import org.junit.Test;


public class JunitTesteConexao {
	
	
	
	@Test
	public void testConOpen() {
		assertNotNull("N�o conseguio conectar ao banco", Conexao.getInstace().conOpen());
		Conexao.getInstace().conClose();
	}

	@Test
	public void testConClose() {
		Conexao.getInstace().conOpen();
		assertTrue("N�o conseguio fechar a conex�o com o banco", Conexao.getInstace().conClose());
	}

}
