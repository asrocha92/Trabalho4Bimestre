package trab4bim.telas;

import java.awt.BorderLayout;

public class TelaCadVenda extends ModuraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaCadVenda() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloCadVenda(),  BorderLayout.CENTER);		
	}

}
