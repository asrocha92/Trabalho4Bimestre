#Alex Santos Rochas

#Tecnologia em An�lise e Desenvolvimento de Sistemas

# Trabalho4Bimestre

# 27 de outubro de 2015
	*Cria��o das classes
		*Cliente
		*Usu�rio
		*Produto
	*Cria��o das Enuns
		*Estado
		*G�nero
		*Categoria
		*Unidade	
		
# 28 de outubro de 2015
	*Cria��o das classes
		*Venda
		*DaoCliente
	*Cria��o da interface
		*DaoCrud
	*Arquivo txt
		*SCRIPT_DO_BANCO.TXT
	*Cria��o e implementa��o dos m�todos da classe DaoCliente
		*Inserir
		*Atualizar
# 29 de outubro de 2015
	*Cria��o e implementa��o dos m�todos da classe DaoCliente
		*Deletar
		*BuscarUm
		*Listar
	*Cria��o e implementa��o dos m�todos da classe DaoUsu�rio
		*Inserir
		*Atualizar
		*Deletar
		*BuscarUm
		*Listar
	*Cria��o e implementa��o dos m�todos da classe DaoProduto
		*Inserir
		*Atualizar
		*Deletar
		*BuscarUm
		*Listar
	*Cria��o e implementa��o dos m�todos da classe DaoVenda
		*Inserir
# 30 de outubro de 2015
	*M�todos implementados da classe DaoVenda
		*Atualizar
		*Deletar
		*Buscar
		*Listar
# 31 de outubro de 2015
	*Tela principal criada.
	*ModuraAbstrata pronta
	*Configura��o da tela Cliente
	*Tela cadastro de cliente
	*Cadastro de cliente fucionando atrav�s da tela.
	*Atualizar, deletar e listar em table da tela de cliente pronta.
	*Tabela modelo da tela cliente.
	*Configura��o da tela de Produto
	*Tela Cadastro Produto.
	*Tabela Modelo de Produto.
	*Cadastrar, Atualizar e Deletar pela tela Cadastro de produto.	
# 1 de novembro de 2015
	*Configura��o completa da tela de cadastro de usu�rio cadastrando, atualizando e deletando.
	*Modelo da tabela Usu�rio criada.
	*Tela cadastro de usu�rio implementada com a tela principal.
	*Tela de venda pronta
	*Modelo da tabela Venda Pronta	
	*Configura��o da tela venda realizando venda, atualizando sem modificar o historico da compra anterior, e deletando.					
	*Criada uma classe RelatorioDao com filtro dos relat�rios necess�rios
	*Criada TableModelRelCliente 
	*Criada classe Relat�rioCliente, que fuciona como um confira��o do Jpanel, tamb�m chamada de miolo.
	*Primeiro relat�rio do cliente funcionando sobre a interface.
	*Relat�rioCliente.jasper na pasta do proj. src/main/resources 
# 2 de novemro de 2015
	*Modifica��o no relat�rio de cliente, foi corrigidos os filtros
	*Relat�rio do produto com fintros de estado e cidade.
	*Gerando pdf apartir do fintro que est� mostrando na tela sobre relat�rio do produto.
	*Relat�rio da Venda completo com fintro
# 3 de novembro de 2015	
	*Tela de login pronta.
	*Utilizando Padr�o de Projeto Proxy
	
# 10 de novebro de 2015
	*Feito algumas corre��es
	*Criada a classe TratarException	
	*Cria��o das classe teste 'JUnit', das classe do pacote 'trab4bim.Dao'
# 11 de novebro de 2015
	*Teste JUnit da conex�o com banco funcionando.
	*Teste JUnit da classe DaoCliente funcionando.
	*Teste JUnit da classe DaoProduto funcionando.
# 12 de novembro de 2015
	*Teste JUnit da classe DaoUsu�rio funcionando.
	*Teste JUnit da classe DaoVenda funcionando.
	*Criado uma classe ResetarDaos(para testes)
	*Teste JUnit da classse Produto o m�todo calcularMarLucrP()	

# 05 de dezembro de 2015
	
	* Foi  utilizado os padr�os de projeto 
		*Singleton
			-Para objet somente uma inst�ncia da classe conex�o na onde implementamos o m�todo conectar e desconectar e o singleton para retorna uma inst�ncia se j� criada 
		*Decoretor
			-Usado para criar novos componentes de tipos diferentes, tipo: o jpanel de cadastrar cliente, usu�rio, produto e outras tela do projeto.			
		*Proxy
			-Implementado para controlar entrada de usu�rios.
		*Dao
		 	-Implementado para suprimir a intera��o dos objetos associados a um tipo para trabalhar com o crud(inclus�o, altera��o,sele��o e exclus�o), atrav�s da linguagem sql de um banco de dados 'mysql' ou outros.
	
	*Requisitos minimos para rodar o Sistema SGV(Sistema de gest�o de vendas) e processos a instalar.
		
		* - Procesador dual cor
		* - 3G de mem�ria
		* - Espa�o em disco 1G
		* - O programa em execu��o chega a consumir at� 98 mb de m�moria
		* - Roda em qualquer plataforma de S.O. que tenha um abiente java instado.
		* - Vers�o do java 7 at� a vers�o atual.
		* - Precisa ter um servi�o Mysql rodando no micro, pois o sistema Desktop sem intera��o com a internet. Na instala��o do msql coloque a senha: '123'
		* - Em sua insta��o � preciso rodar o escript do banco de dados ap�s ter instado o servi�o para que o SGV possa trabalhar corretamente.
		* - Por padr�o o sistema j� tem usu�rio admin e senha admin, funcionara ap�s ter rodado o script do banco mysql 
	
	
	
# Commit final.

# Commit Final. 