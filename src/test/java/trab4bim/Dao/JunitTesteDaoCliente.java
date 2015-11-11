package trab4bim.Dao;

import static org.junit.Assert.*;

import org.junit.*;

import trab4bim.classes.Cliente;
import trab4bim.classes.Estado;
import trab4bim.classes.Genero;

public class JunitTesteDaoCliente {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserir() {
		int res = new DaoCliente().inserir(new Cliente("Alex", "04590902121","Rua paraná", "Cascavel", Estado.PR, "teste@teste.com",Genero.M));
		if (res == 1)
			assertTrue(true);
		else 
			assertTrue("Erro ao inserir dados no banco", false);
		new ResetarDaos().resetar("CLIENTE");
	}

	@Test
	public void testAtualizar() {
		new DaoCliente().inserir(new Cliente("test", "04590902121","Rua paraná", "Cascavel", Estado.PR, "teste@teste.com",Genero.M));
		int res = new DaoCliente().atualizar(new Cliente(1, "Alex", "4655521","Rua São Paulo", "Cascavel", Estado.PR, "teste@teste.com",Genero.M));
		if (res == 1)
			assertTrue(true);
		else
			assertTrue("Erro ao inserir dados no banco", false);
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
		int res = new DaoCliente().deletar(1);
		if (res == 1) 
			assertTrue(true);
		else 
			assertTrue("Erro ao deletar Cliente", false);
		new ResetarDaos().resetar("CLIENTE");
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro ao retornar conexão", new DaoCliente().getCon());
	}

}
