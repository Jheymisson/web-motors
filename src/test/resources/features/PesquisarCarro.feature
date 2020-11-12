# language: pt
@PesquisaCarro
Funcionalidade: Pesquisa de Carros na WebMotors

  Cenario: Pesquisar um carro pela marca na página home da Webmotors
    Dado entrar na página home da WebMotors
    E selecionar aba de Comprar Carros
    E preencher o campo de pesquisa com uma marca ou modelo
    Quando selecionar opção com a marca preenchida no campo
    Entao irá apareccer uma nova tela com resultados obtidos através da pesquisa

  Cenario: Selecionar um modelo para um carro com marca já especificada
    Dado entrar na página de resultados da pesquisa
    E selecionar modelo de um carro
    Entao modelo será selecionado com sucesso

  Cenario: Verificar a lista de resultados dos anuncios e exporta para arquivo csv
    Dado entrar na página de resultados da pesquisa
    Entao resultados serao exportados para arquivo cvs com sucesso
