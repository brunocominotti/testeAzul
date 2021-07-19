#language: pt

Funcionalidade: Escolher passagem e ir até a tela de efetuar pagamento

  Cenario: Preencher as informações para buscar a passagem
    Dado que estou no site https://www.voeazul.com.br
    Quando Seleciono o local de saida e de chegada
    E seleciono a data de partida
    E clico no botao Buscar passagens
    E clico no botao Prosseguir
    E preencho os dados dos passageiros
    E seleciono o assento
    E clico no botao prosseguir em bagagem
    E preencho os dados de contato
    E marco a checkbox dizendo que Li e Concordo com as regras
    Então valido se o botao esta habilitado