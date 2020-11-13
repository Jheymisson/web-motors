# language: pt
@estoque
Funcionalidade: Testar o estoque

  @testeUm
  Cenario: Verificar o estoque e exportar para arquivo csv
    Dado entrar na pagina de estoque da loja
    E validar a pagina estoque
    Entao exportar os anuncios para um arquivo csv
