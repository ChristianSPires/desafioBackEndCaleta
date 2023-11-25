#Caleta's Challenge

[ ]

#### GET /balance

Este endpoint será utilizado para consultar o saldo da carteira digital de um jogador. Ele deverá receber como parâmetro na URL o ID do jogador.

[ ]
#### POST /bet

Este endpoint será utilizado para realizar apostas usando a carteira digital de um jogador. Ele deverá receber no corpo da requisição um objeto JSON contendo o ID do jogador e o valor a ser sacado. Como resposta, deverá retornar o saldo atualizado da carteira digital e o ID da transação.

[ ]
#### POST /win

Este endpoint será utilizado para realizar ganhos usando a carteira digital de um jogador. Ele deverá receber no corpo da requisição um objeto JSON contendo o ID do jogador e o valor a ser depositado. Como resposta, deverá retornar o saldo atualizado da carteira digital e o ID da transação.

---

A Adição do endpoint a seguir contabilizará como um extra, a implementação correta dele contará como um diferencial:


[ ]
#### POST /rollback

Este endpoint será utilizado para cancelar transações de apostas (BET) realizadas anteriormente. Ele deverá receber no corpo da requisição um objeto JSON contendo o ID do jogador, o ID da transação e o valor da transação. Se a transação existir no banco de dados, o valor sacado deverá ser retornado à carteira digital do jogador.

---

- Organização do código; [ ]
- Tratamento de erros; [ ]
- Persistência dos dados. [ ]
- Uso do Docker; [ ]
- Implementação de testes automatizados; [ ]
- Documentação da API. [ ]

---