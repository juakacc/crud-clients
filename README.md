# Clients API

API Rest para consumir recursos, dados dos clientes cadastrados: _id_, _nome_, _CPF_ e _data de nascimento_.

## Executando localmente

```shell
$ git clone git clone https://juakacc@bitbucket.org/juakacc/crud-clients.git
$ cd crud-clients
```

Por default disponível localmente no endereço: `http://localhost:8080/clientes`

Utilize o _Postman_ para consumir a API, importe o arquivo `clients-api.postman_collection.json` na raiz da pasta, ele contém as chamadas disponíveis.

## Métodos disponíveis

- `POST`: Para cadastro de novos clientes;
- `PUT`: Para atualização de clientes;
- `PATCH`: Para atualização parcial de clientes;
- `DELETE`: Para remoção de clientes cadastrados;
- `GET`: Para recuperar clientes cadastrados.

## Consumindo recursos

A rota para listagem de clientes pode receber alguns parâmetros, na forma de query string, são eles:

- `page`: **int** - a página a ser recuperada _(opcional)_;
- `size`: **int** - a quantidade de clientes por página _(opcional)_;
- `nome`: **String** - parte do nome do cliente _(opcional)_;
- `cpf`: **String** - parte do CPF do cliente _(opcional)_.

Exemplo de chamada a API:

http://localhost:8080/clientes?page=0&size=5&nome=jack&cpf=12345678900

##Contribuições

Sinta-se a vontade para contribuir. :)
