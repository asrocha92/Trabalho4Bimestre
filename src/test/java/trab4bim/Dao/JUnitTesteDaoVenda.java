package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 12/11/2015 - 09:07:19
 * 
 * Testando os m�todos da classe DaoVenda atrav�s do JUnit
 */

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.*;
import trab4bim.classes.Venda;

public class JUnitTesteDaoVenda {
	
	@Test
	public void testInserir() {
		assertEquals("Erro ao inserir dados no banco", 1,
						new DaoVenda()
							.inserir(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41")));
		new ResetarDaos().resetar("VENDA");
	}

	@Ignore
	public void testAtualizar() {
		//toda venda pode ser modificada mas n�o pode mudar o hist�rico da mesma por isso ao atualizar venda ele insere no historico a mesma s� que modificada 
	}

	@Test
	public void testBuscarUm() {
		new DaoVenda().inserir(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41"));
		assertNotNull("Erro ao buscar Venda", new DaoVenda().buscarUm(1));
		new ResetarDaos().resetar("VENDA");
	}

	@Test
	public void testListar() {
		new DaoVenda().inserir(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41"));
		assertNotNull("Erro ao Listar Venda", new DaoVenda().listar());
		new ResetarDaos().resetar("VENDA");
	}

	@Test
	public void testDeletar() {
		new DaoVenda().inserir(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41"));
		assertEquals("Erro ao deletar hist�rico da venda", 1, new DaoVenda().deletar(1));
		new ResetarDaos().resetar("VENDA");
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro ao retornar conex�o", new DaoCliente().getCon());
	}
}
