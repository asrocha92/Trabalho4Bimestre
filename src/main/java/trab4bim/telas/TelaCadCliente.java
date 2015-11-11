package trab4bim.telas;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class TelaCadCliente extends ModuraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaCadCliente() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloCadCliente(),  BorderLayout.CENTER);		
	}

}
