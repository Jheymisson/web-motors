# language: pt
@PesquisaCarro
Funcionalidade: Pesquisa de marca de carros na WebMotors

	@PesquisaMarcaUm
  Cenario: Pesquisar um carro pela marca na página home da Webmotors
    Dado entrar na página home da WebMotors
    E selecionar aba de Comprar Carros
    E preencher o campo de pesquisa com uma marca ou modelo
    Quando selecionar opção com a marca preenchida no campo
    Entao irá apareccer uma nova tela com resultados obtidos através da pesquisa
