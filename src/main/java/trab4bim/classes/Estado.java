package trab4bim.classes;

/**
 * 
 * @author Alex Santos Rocha, 27/10/2015 - 19:58:24
 *
 * Comentario: Enum serve para mostra todos estados atrav�s de sua sigla.
 */

public enum Estado {
	AC("Acre"),
	AL("Alagoas"),
	AP("Amap�"),
	AM("Amazonia"),
	BA("Bahia"),
	CE("Cear�"),
	DF("Distrito Federal"),
	ES("Esp�rito Santo"),
	GO("Goi�s"),
	MA("Maranh�o"),
	MT("Mato Grosso"),
	MS("mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Par�"),
	PB("Paraiba"),
	PR("Paran�"),
	PE("Pernambuco"),
	PI("Piau�"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rond�nia"),
	RR("Roraima"),
	SC("Santa Catarina"),
	SP("S�o Paulo"),
	SE("Sergipe"),
	TO("Tocantins");
	
	//criado uma nome para retorna qual o valor da sigla
	private String nome;

	//m�todo get para retornar somente o valor
	public String getNome() {
		return nome;
	}
	
	//construtor da classe que recebe por parametro uma tipo string 
	private Estado(String nome){
		this.nome = nome;
	}
}
