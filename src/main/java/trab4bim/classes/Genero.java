package trab4bim.classes;
/**
 * 
 * @author Alex Santos Rocha, 27/10/2015 - 20:05:12
 * 
 * Comentario: Enum serve para retorna qual o sexo do cliente.
 *
 */

public enum Genero {
	M("Masculino"),
	F("Feminino");

	//criado uma variavél do tipo nome
	private String nome;

	//criado um get para retornar o valor que está atribuido ao sexo
	public String getNome() {
		return nome;
	}
	
	//construtor da classe
	private Genero(String nome){
		this.nome = nome;
	}
}
