package trab4bim.classes;
/**
 * 
 * @author Alex Santos Rocha, 27/10/2015 - 20:20:00
 * 
 * Comentario: Cada cliente vai ser um uu�rio neste sistemas. 
 * 			   Coma a cria��o de atributos necessarios
 *
 */

public class Usuario {
	
	private int id;
	private int idCliente;
	private String cliente;
	private String senha;
	
	//Contrutores da classe Usuario
	public Usuario(){}

	public Usuario(int id_u, int id_c, String cliente){}
	
	//m�todos geters e serts necess�rios para o usu�rio
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public String getCliente() {
		return cliente;
	}
	
	
}
