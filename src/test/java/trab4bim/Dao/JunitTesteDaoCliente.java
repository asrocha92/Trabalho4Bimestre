package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 12/11/2015 - 09:01:40
 * 
 * Testando os métodos da classe DaoCliente através do JUnit
 */

import static org.junit.Assert.*;
import org.junit.*;
import trab4bim.classes.*;

public class JunitTesteDaoCliente {

	@Test
	public void testInserir() {
		assertEquals("Erro ao inserir dados no banco", 1, 
							new DaoCliente()
								.inserir(new Cliente("Alex", "04590902121","Rua paraná", "Cascavel", Estado.PR, "teste@teste.com",Genero.M)));
		new ResetarDaos().resetar("CLIENTE");
	}

	@Test
	public void testAtualizar() {
		new DaoCliente().inserir(new Cliente("test", "04590902121","Rua paraná", "Cascavel", Estado.PR, "teste@teste.com",Genero.M));
		assertEquals("Erro ao atualizar dados no banco", 1, 
						new DaoCliente()
							.atualizar(new Cliente(1, "Alex", "4655521","Rua São Paulo", "Cascavel", Estado.PR, "teste@teste.com",Genero.M)));
		new ResetarDaos().resetar("CLIENTE");

	}

	@Test
	public void testBuscarUm() {
		new DaoCliente().inserir(new Cliente("Alex", "04590902121","Rua paraná", "Cascavel", Estado.PR, "teste@teste.com",Genero.M));
		assertNotNull("Erro ao buscar Cliente", new DaoCliente().buscarUm(1));
		new ResetarDaos().resetar("CLIENTE");
	}

	@Test
	public void testListar() {
		new DaoCliente().inserir(new Cliente("Alex", "04590902121","Rua paraná", "Cascavel", Estado.PR, "teste@teste.com",Genero.M));
		assertNotNull("Erro ao Listar Cliente", new DaoCliente().listar());
		new ResetarDaos().resetar("CLIENTE");
	}

	@Test
	public void testDeletar() {
		new DaoCliente().inserir(new Cliente("Alex", "04590902121","Rua paraná", "Cascavel", Estado.PR, "teste@teste.com",Genero.M));
		assertEquals("Erro ao deletar cliente",1 , new DaoCliente().deletar(1));
		new ResetarDaos().resetar("CLIENTE");
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro ao retornar conexão", new DaoCliente().getCon());
	}

}
