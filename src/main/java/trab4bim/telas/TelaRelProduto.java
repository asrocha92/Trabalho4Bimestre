package trab4bim.telas;

import java.awt.BorderLayout;

import trab4bim.relatorios.RelatorioCliente;
import trab4bim.relatorios.RelatorioProduto;

public class TelaRelProduto extends ModuraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaRelProduto() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new RelatorioProduto(), BorderLayout.CENTER);
	}

}
