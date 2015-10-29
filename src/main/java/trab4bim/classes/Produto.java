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
	private Categoria categoria;
	private String descricao;
	private int unidade;
	private BigDecimal custo;
	private BigDecimal margenLucro;
	
	//Construtores da classe
	public Produto(){}

	public Produto(int cod, int codBarra, Categoria categoria,
			String descricao, int unidade, BigDecimal custo,
			BigDecimal margenLucro) {
		this.cod = cod;
		this.codBarra = codBarra;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margenLucro = margenLucro;
	}

	public Produto(int codBarra, Categoria categoria, String descricao,
			int unidade, BigDecimal custo, BigDecimal margenLucro) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
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
}
