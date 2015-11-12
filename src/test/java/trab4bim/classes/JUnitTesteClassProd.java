package trab4bim.classes;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class JUnitTesteClassProd {

	@Test
	public void testCalcularMarLucrP() {
		Produto p = new Produto();
		p.setCusto(BigDecimal.valueOf(19.89));
		p.setMargenLucro(BigDecimal.valueOf(20)); 
		assertEquals("Erro de calculo", Double.valueOf(23.868), p.CalcularMarLucrP());
	}

}
