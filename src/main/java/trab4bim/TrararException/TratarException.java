package trab4bim.TrararException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TratarException {
	
	public BigDecimal tratarBigDecimal(String valor) throws ParseException, NumberFormatException{
			Number num = NumberFormat.getNumberInstance(Locale.US).parse(valor);
			BigDecimal d = new BigDecimal(num.floatValue());
			return d;	
	}

}
