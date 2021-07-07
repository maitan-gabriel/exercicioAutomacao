# language: pt
Funcionalidade: Cadastrar conta

  Contexto: 
    Dado que eu acesse o site para cadastro "http://advantageonlineshopping.com/#/"

  @cadastrarConta
  Esquema do Cenario: Cadastrar uma conta no site
    E clico no menu User para cadastro
    E clico no botao Create new account
    E preencho o formulario com os dados "<username>" "<password>" "<email>" "<firstName>" "<lastName>" "<phoneNumber>" "<country>" "<city>" "<address>" "<state>" "<postalCode>"
    E seleciono checkbox Conditions of use
    Quando clico no botao Register
    Entao valido o username no menu User "<username>" cadastrado

    Exemplos: 
      | username      | password | email             | firstName | lastName | phoneNumber | country | city   | address     | state | postalCode |
      | zedasilva1234 | Senha123 | asdadd@sadasd.com | Zezinho   | Silva    | 960607070   | Brazil  | Osasco | Rua Tal, 10 | SUS   | 0606070    |
