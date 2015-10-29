package trab4bim.classes;
/**
 * @author Alex Santos Rocha, 27/10/2015 - 20:36:07
 * 
 * Comentario: cria��o da classe produto com todos atributos necess�rios
 */

import java.math.BigDecimal;

public class Produto {
	private int cod;
	private int codigo;
	private Categoria categoria;
	private String descricao;
	private int unidade;
	private BigDecimal custo;
	private BigDecimal margenLucro;
	
	//cria��o dos geters e seters
	public int getCod() {
		return cod;
	}
	public void setCod(int id) {
		this.cod = id;
	}
	public int getCodBarra() {
		return codigo;
	}
	public void setCodBarra(int codigo) {
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
