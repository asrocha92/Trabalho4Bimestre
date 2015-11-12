package trab4bim.Dao;

/**
 * 
 * @author Alex Santos Rocha, 12/11/2015 - 09:06:34
 * 
 * Testando os métodos da classe Conexão através do JUnit
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class JunitTesteConexao {
	
	@Test
	public void testConOpen() {
		assertNotNull("Não conseguio conectar ao banco", Conexao.getInstace().conOpen());
		Conexao.getInstace().conClose();
	}

	@Test
	public void testConClose() {
		Conexao.getInstace().conOpen();
		assertTrue("Não conseguio fechar a conexão com o banco", Conexao.getInstace().conClose());
	}

}
