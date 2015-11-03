package trab4bim.classes;

/**
 * @author Alex Santos Rocha, 27/10/2015 - 20:36:07
 * 
 * Comentario: criação da classe produto com todos atributos necessários
 */

import java.math.BigDecimal;

public class Produto {
	private int cod;
	private int codBarra;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal custo;
	private BigDecimal margenLucro;
	
	//Construtores da classe
	public Produto(){}

	public Produto(int cod, int codBarra, String categoria,
			String descricao, String unidade, BigDecimal custo,
			BigDecimal margenLucro) {
		this.cod = cod;
		this.codBarra = codBarra;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margenLucro = margenLucro;
	}

	public Produto(int codBarra, String categoria, String descricao,
			String unidade, BigDecimal custo, BigDecimal margenLucro) {
		this.codBarra = codBarra;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margenLucro = margenLucro;
	}

	// criação dos geters e seters
	public int getCod() {
		return cod;
	}

	public void setCod(int id) {
		this.cod = id;
	}

	public int getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(int codigo) {
		this.codBarra = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargenLucro() {
		return margenLucro;
	}

	public void setMargenLucro(BigDecimal margenLucro) {
		this.margenLucro = margenLucro;
	}
	
	
	/**
	 * @author Alex Santos Rocha, 01/11/2015 - 13:53:52
	 * 
	 * @return valor total do produto
	 */
	public Double CalcularMLP(){
		return this.custo.doubleValue() + (this.custo.doubleValue() * (this.margenLucro.doubleValue() / 100));
	}
	
}
