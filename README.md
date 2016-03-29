#Alex Santos Rochas

#Tecnologia em Análise e Desenvolvimento de Sistemas

# Trabalho4Bimestre

# 27 de outubro de 2015
	*Criação das classes
		*Cliente
		*Usuário
		*Produto
	*Criação das Enuns
		*Estado
		*Gênero
		*Categoria
		*Unidade	
		
# 28 de outubro de 2015
	*Criação das classes
		*Venda
		*DaoCliente
	*Criação da interface
		*DaoCrud
	*Arquivo txt
		*SCRIPT_DO_BANCO.TXT
	*Criação e implementação dos métodos da classe DaoCliente
		*Inserir
		*Atualizar
# 29 de outubro de 2015
	*Criação e implementação dos métodos da classe DaoCliente
		*Deletar
		*BuscarUm
		*Listar
	*Criação e implementação dos métodos da classe DaoUsuário
		*Inserir
		*Atualizar
		*Deletar
		*BuscarUm
		*Listar
	*Criação e implementação dos métodos da classe DaoProduto
		*Inserir
		*Atualizar
		*Deletar
		*BuscarUm
		*Listar
	*Criação e implementação dos métodos da classe DaoVenda
		*Inserir
# 30 de outubro de 2015
	*Métodos implementados da classe DaoVenda
		*Atualizar
		*Deletar
		*Buscar
		*Listar
# 31 de outubro de 2015
	*Tela principal criada.
	*ModuraAbstrata pronta
	*Configuração da tela Cliente
	*Tela cadastro de cliente
	*Cadastro de cliente fucionando através da tela.
	*Atualizar, deletar e listar em table da tela de cliente pronta.
	*Tabela modelo da tela cliente.
	*Configuração da tela de Produto
	*Tela Cadastro Produto.
	*Tabela Modelo de Produto.
	*Cadastrar, Atualizar e Deletar pela tela Cadastro de produto.	
# 1 de novembro de 2015
	*Configuração completa da tela de cadastro de usuário cadastrando, atualizando e deletando.
	*Modelo da tabela Usuário criada.
	*Tela cadastro de usuário implementada com a tela principal.
	*Tela de venda pronta
	*Modelo da tabela Venda Pronta	
	*Configuração da tela venda realizando venda, atualizando sem modificar o historico da compra anterior, e deletando.					
	*Criada uma classe RelatorioDao com filtro dos relatórios necessários
	*Criada TableModelRelCliente 
	*Criada classe RelatórioCliente, que fuciona como um confiração do Jpanel, também chamada de miolo.
	*Primeiro relatório do cliente funcionando sobre a interface.
	*RelatórioCliente.jasper na pasta do proj. src/main/resources 
# 2 de novemro de 2015
	*Modificação no relatório de cliente, foi corrigidos os filtros
	*Relatório do produto com fintros de estado e cidade.
	*Gerando pdf apartir do fintro que está mostrando na tela sobre relatório do produto.
	*Relatório da Venda completo com fintro
# 3 de novembro de 2015	
	*Tela de login pronta.
	*Utilizando Padrão de Projeto Proxy
	
# 10 de novebro de 2015
	*Feito algumas correções
	*Criada a classe TratarException	
	*Criação das classe teste 'JUnit', das classe do pacote 'trab4bim.Dao'
# 11 de novebro de 2015
	*Teste JUnit da conexão com banco funcionando.
	*Teste JUnit da classe DaoCliente funcionando.
	*Teste JUnit da classe DaoProduto funcionando.
# 12 de novembro de 2015
	*Teste JUnit da classe DaoUsuário funcionando.
	*Teste JUnit da classe DaoVenda funcionando.
	*Criado uma classe ResetarDaos(para testes)
	*Teste JUnit da classse Produto o método calcularMarLucrP()	

# 05 de dezembro de 2015
	
	* Foi  utilizado os padrãos de projeto 
		*Singleton
			-Para objet somente uma instância da classe conexão na onde implementamos o método conectar e desconectar e o singleton para retorna uma instância se já criada 
		*Decoretor
			-Usado para criar novos componentes de tipos diferentes, tipo: o jpanel de cadastrar cliente, usuário, produto e outras tela do projeto.			
		*Proxy
			-Implementado para controlar entrada de usuários.
		*Dao
		 	-Implementado para suprimir a interação dos objetos associados a um tipo para trabalhar com o crud(inclusão, alteração,seleção e exclusão), através da linguagem sql de um banco de dados 'mysql' ou outros.
	
	*Requisitos minimos para rodar o Sistema SGV(Sistema de gestão de vendas) e processos a instalar.
		
		* - Procesador dual cor
		* - 3G de memória
		* - Espaço em disco 1G
		* - O programa em execução chega a consumir até 98 mb de mémoria
		* - Roda em qualquer plataforma de S.O. que tenha um abiente java instado.
		* - Versão do java 7 até a versão atual.
		* - Precisa ter um serviço Mysql rodando no micro, pois o sistema Desktop sem interação com a internet. Na instalação do msql coloque a senha: '123'
		* - Em sua instação é preciso rodar o escript do banco de dados após ter instado o serviço para que o SGV possa trabalhar corretamente.
		* - Por padrão o sistema já tem usuário admin e senha admin, funcionara após ter rodado o script do banco mysql 
	
	
	
# Commit final.

# Commit Final. 