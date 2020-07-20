# Clients API

API Rest para consumir recursos, dados dos clientes cadastrados: _id_, _nome_, _CPF_ e _data de nascimento_.

## Configurando Banco de dados

Como foi solicidado na descrição do projeto, o mesmo está configurado utilizando o Docker.

```shell
# Baixe a imagem do DockerHub
$ docker pull juakacc/clientapibd:latest
```

```shell
# Execute a imagem
$ docker run --publish 3308:3306 --detach --name clientapidb juakacc/clientapibd:latest
```

**Obs:** No caso do comando acima o acesso ao banco de dados será realizado por meio da porta `3308` do container.
Caso essa porta esteja em uso na sua máquina, altera para uma disponível, com isso é necessário também alterar a porta no arquivo `src/main/resources/application.properties`, para que a API acesse o banco corretamente.

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

Exemplo de chamada à API:

http://localhost:8080/clientes?page=0&size=5&nome=jack&cpf=12345678900

## Contribuições

Sinta-se a vontade para contribuir. :)

## Dúvidas/Ajuda

Qualquer dúvida sobre a executação ou configuração do projeto é só entrar em contato, será um prazer ajudá-lo:

E-mail: juakacc@gmail.com
