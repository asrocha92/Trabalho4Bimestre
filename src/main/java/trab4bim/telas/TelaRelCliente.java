package trab4bim.telas;

import java.awt.BorderLayout;

import trab4bim.relatorios.RelatorioCliente;

@SuppressWarnings("serial")
public class TelaRelCliente extends ModuraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaRelCliente() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new RelatorioCliente(), BorderLayout.CENTER);
	}

}
