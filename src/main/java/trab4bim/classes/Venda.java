package trab4bim.classes;

/**
 * @author Alex Santos Rocha, 28/10/2015 - 01:09:01
 * 
 * Comentario: criado a classe vendo com atributos nessessarios para realizar uma venda
 */

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Venda {
	private int cod_v;
	private int id_c;
	private int cod_p;
	private String cliente;
	private String produto;
	private BigDecimal vTotal;
	private BigDecimal vPago;
	private BigDecimal troco;
	private Date data;
	private Time hora;

	public Venda() {
	}

	public Venda(int cod_v, int id_c, int cod_p, String cliente,String produto,
			BigDecimal vTotal, BigDecimal vPago, BigDecimal troco, Date data,
			Time hora) {
		this.cod_v = cod_v;
		this.id_c = id_c;
		this.cliente = cliente;
		this.produto = produto;
		this.vTotal = vTotal;
		this.vPago = vPago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;

	}

	// Métodos geters e seters
	public int getCod_v() {
		return cod_v;
	}
	public int getId_c() {
		return id_c;
	}
	public int getCod_p() {
		return cod_p;
	}
	public String getCliente() {
		return cliente;
	}
	public String getProduto() {
		return produto;
	}
	public BigDecimal getvTotal() {
		return vTotal;
	}
	public BigDecimal getvPago() {
		return vPago;
	}
	public BigDecimal getTroco() {
		return troco;
	}
	public Date getData() {
		return data;
	}
	public Time getHora() {
		return hora;
	}
}
