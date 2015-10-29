package trab4bim.classes;
/**
 * @author Alex Santos Rocha, 27/10/2015 - 20:36:07
 * 
 * Comentario: criação da classe produto com todos atributos necessários
 */

import java.math.BigDecimal;

public class Produto {
	private int id;
	private int codigo;
	private Categoria categoria;
	private String descricao;
	private int unidade;
	private BigDecimal custo;
	private BigDecimal margenLucro;
	
	//criação dos geters e seters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
