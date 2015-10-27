package trab4bim.classes;

public enum Unidade {
	UN("Unidade"),
	PCT("Pacote");
	
	private String nome;

	public String getNome() {
		return nome;
	}
	
	private Unidade(String und){
		this.nome = und;
	}
	
}
