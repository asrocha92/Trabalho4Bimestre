package trab4bim.TrararException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class TratarException {
	
	public BigDecimal tratarBigDecimal(String valor){
		try{
			Number num = NumberFormat.getNumberInstance(Locale.US).parse(valor);
			BigDecimal d = new BigDecimal(num.floatValue());
			return d;
		}catch (Exception e){
			throw new RuntimeException("Digite somente números\n"
					+ "Ex: 45 quarenta e cinco reais"
					+ "	   12.12 doze reais e doze centavos"
					+ "	   2,000 dois mil reais\n"
					+ "	   2,300.45  dois mil e trezentos reais e quarenta e cinco centavos");
		}	
	}

	
	public String tratarString(String valor, String nome){
		char[] v = valor.toCharArray();
		int cont = 0;
		for(int i = 0; i < v.length; i++){	
			if( (String.valueOf(v[i]).matches("[0-9]")))
				cont++;
		}
		if(cont == 0)
			return nome;
		else
			throw new RuntimeException("Escreva somente letras em: "+nome);
	}
	
	public String tratarNumero(String valor, String nome){
		char[] v = valor.toCharArray();
		int cont = 0;
		for(int i = 0; i < v.length; i++){	
			if( (!String.valueOf(v[i]).matches("^[0-9]")))
				cont++;
		}
		if(cont == 0)
			return nome;
		else
			throw new RuntimeException("Escreva somente números em: "+nome);
	}
	
}
