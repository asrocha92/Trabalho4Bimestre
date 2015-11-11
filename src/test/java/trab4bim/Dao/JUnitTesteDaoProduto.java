package trab4bim.Dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import trab4bim.classes.Produto;

public class JUnitTesteDaoProduto {

	@Test
	public void testInserir() {
		int res = new DaoProduto().inserir(new Produto(1, 111,"PEÇA", "CURVA 3/4 INOX", "UND", BigDecimal.valueOf(13.4), BigDecimal.valueOf(20.0)));
		if (res == 1)
			assertTrue(true);
		else 
			assertTrue("Erro ao inserir dados no banco", false);
		new ResetarDaos().resetar("PRODUTO");
	}

	@Test
	public void testAtualizar() {
		new DaoProduto().inserir(new Produto(1, 111,"PEÇA", "CURVA 3/4 INOX", "UND", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		int res = new DaoProduto().atualizar(new Produto(1, 113,"PEÇA", "CURVA 3/4 INOX", "PCT", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		if (res == 1)
			assertTrue(true);
		else 
			assertTrue("Erro ao atualizar dados no banco", false);
		new ResetarDaos().resetar("PRODUTO");
	}

	@Test
	public void testDeletar() {
		new DaoProduto().inserir(new Produto(1, 113,"PEÇA", "CURVA 3/4 INOX", "PCT", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		int res = new DaoProduto().deletar(1);
		if (res == 1)
			assertTrue(true);
		else 
			assertTrue("Erro ao deletar dados do banco", false);
		new ResetarDaos().resetar("PRODUTO");
	}

	@Test
	public void testBuscarUm() {
		new DaoProduto().inserir(new Produto(1, 113,"PEÇA", "CURVA 3/4 INOX", "PCT", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		assertNotNull("Erro ao buscar Produto", new DaoProduto().buscarUm(1));
		new ResetarDaos().resetar("PRODUTO");
	}

	@Test
	public void testListar() {
		new DaoProduto().inserir(new Produto(1, 113,"PEÇA", "CURVA 3/4 INOX", "PCT", BigDecimal.valueOf(29.4), BigDecimal.valueOf(20.0)));
		assertNotNull("Erro ao listar Produto", new DaoProduto().listar());
		new ResetarDaos().resetar("PRODUTO");
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro ao retornar conexão", new DaoProduto().getCon());
	}

}
