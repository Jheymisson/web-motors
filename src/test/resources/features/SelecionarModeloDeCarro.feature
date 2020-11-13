# language: pt
@pesquisaModelo
Funcionalidade: Selecionar modelo de carro

	@SelecionaModeloUm
  Cenario: Selecionar modelo de carro dentro da página de pesquisa
    Dado entrar na página de resultados da pesquisa
    E selecionar modelo de um carro
    Quando modelo for selecionado
    Entao exportar os anuncios para um arquivo csv