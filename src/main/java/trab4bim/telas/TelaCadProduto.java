package trab4bim.telas;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class TelaCadProduto extends ModuraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaCadProduto() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloDoProduto(), BorderLayout.CENTER);
	}

}
