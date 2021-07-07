# language: pt
Funcionalidade: Fazer login em conta cadastrada

  Contexto: 
    Dado que eu acesse o site para login "http://advantageonlineshopping.com/#/"

  @loginConta
  Esquema do Cenario: Fazer login em conta cadastrada
    E clico no menu User para login
    E digito "<username>" e "<password>"
    E clico em Sign in
		Entao valido o username no menu User "<username>" logado

    Exemplos: 
      | username      | password | 
      | zedasilva1234 | Senha123 |