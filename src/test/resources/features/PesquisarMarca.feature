# language: pt
@PesquisaCarro
Funcionalidade: Pesquisa de marca de carros na WebMotors

	@PesquisaMarcaUm
  Cenario: Pesquisar um carro pela marca na página home da Webmotors
    Dado entrar na pagina home da WebMotors
    E selecionar aba de Comprar Carros
    E preencher o campo de pesquisa com uma marca ou modelo
    Quando selecionar opcao com a marca preenchida no campo
    Entao vai apareccer uma nova tela com resultados obtidos atraves da pesquisa
