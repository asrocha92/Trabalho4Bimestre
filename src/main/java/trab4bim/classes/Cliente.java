package trab4bim.classes;

/**
 * 
 * @author Alex Santos Rocha, 27/10/2015 - 20:07:33
 * 
 *         Comentario: Classe com todos atributos para se cadastrar um cliente
 *
 */

public class Cliente {
	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private Estado estado;
	private String email;
	private Genero genero;

	// Construtores da classe cliente
	public Cliente(){}
	
	public Cliente(int id, String nome, String telefone, String endereco,
			String cidade, Estado estado, String email, Genero genero) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco= endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
	}
	
	public Cliente(String nome, String telefone, String endereco,
			String cidade, Estado estado, String email, Genero genero) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco= endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
		
	}

	// Métodos geters e setrs da classe cliente
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndreco() {
		return endereco;
	}

	public void setEndreco(String endreco) {
		this.endereco = endreco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
