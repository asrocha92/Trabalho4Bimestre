package trab4bim.telas;

import java.awt.BorderLayout;

public class TelaCadUsuario extends ModuraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaCadUsuario() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new MioloCadUsuário(),  BorderLayout.CENTER);		
	}

}
