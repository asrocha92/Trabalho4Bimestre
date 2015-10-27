package trab4bim.classes;

/**
 * 
 * @author Alex Santos Rocha, 27/10/2015 - 19:58:24
 *
 * Comentario: Enum serve para mostra todos estados através de sua sigla.
 */

public enum Estado {
	AC("Acre"),
	AL("Alagoas"),
	AP("Amapá"),
	AM("Amazonia"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	ES("Espírito Santo"),
	GO("Goiás"),
	MA("Maranhão"),
	MT("Mato Grosso"),
	MS("mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Pará"),
	PB("Paraiba"),
	PR("Paraná"),
	PE("Pernambuco"),
	PI("Piauí"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rondônia"),
	RR("Roraima"),
	SC("Santa Catarina"),
	SP("São Paulo"),
	SE("Sergipe"),
	TO("Tocantins");
	
	//criado uma nome para retorna qual o valor da sigla
	private String nome;

	//método get para retornar somente o valor
	public String getNome() {
		return nome;
	}
	
	//construtor da classe que recebe por parametro uma tipo string 
	private Estado(String nome){
		this.nome = nome;
	}
}
