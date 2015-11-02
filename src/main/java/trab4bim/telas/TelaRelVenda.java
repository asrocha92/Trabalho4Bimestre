package trab4bim.telas;

/**
 * @author Alex Santos Rocha, 02/11/2015 - 17:55:26
 * 
 * Comentario: somente a modura do relatorio cliente que ira ser chamado na tela principal
 */

import java.awt.BorderLayout;
import trab4bim.relatorios.RelatorioVenda;

public class TelaRelVenda extends ModuraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaRelVenda() {
		super();
	}

	@Override
	protected void configura() {
		super.add(new RelatorioVenda(), BorderLayout.CENTER);
	}

}
