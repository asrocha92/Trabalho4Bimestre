package trab4bim.classes;

/**
 * @author Alex Santos Rocha, 28/10/2015 - 01:09:01
 * 
 * Comentario: criado a classe vendo com atributos nessessarios para realizar uma venda
 */

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Venda {
	private Cliente cliente;
	private Produto produto;
	private BigDecimal vTotal;
	private BigDecimal troco;
	private Timestamp dataFC;
	private Timestamp horaFC;
	
	//Métodos geters e seters
	public Cliente getCliente() {
		return cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public BigDecimal getvTotal() {
		return vTotal;
	}
	public BigDecimal getTroco() {
		return troco;
	}
	public Timestamp getDataFC() {
		return dataFC;
	}
	public Timestamp getHoraFC() {
		return horaFC;
	}
	
	

}
