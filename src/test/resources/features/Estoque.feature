# language: pt
@PesquisaCarro
Funcionalidade: Verificar estoque

  Cenario: Verificar o estoque e exportar para arquivo csv
    Dado entrar na página de estoque
    E validar a pagina estoque
    Entao exportar os anuncios para um arquivo csv