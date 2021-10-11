## Administração de Votações e Pautas

#### Teste Mobi / Sicredi

Neste projeto eu procurei fazer de maneira muito simples, porém a idéia era ser efetivo.

Separei os objetos de domínios sendo os principais

- Users (usuarios que irão votar)
- Pauta (a pauta a ser votada)
- Sessao (uma sessao de votação para uma respectiva pauta)
- Voto (O voto propriamente dito)

Há mais objetos porém auxiliares no tocante a execução.

O processo ocorre da seguinte forma:

- Primeiramente o usuário é cadastrado.

     Criando um usuário
     POST para http://localhost:8080/v1/user
     
     Payload:
```json
 
      {
          "username":"João da Silva",
          "cpf":"53543856600"
      }

 ```

 Obs: Não criei verificação para remover pontos e traços. Mas se fosse algo em produção certamente o faria.

- Após, é criada uma pauta.

     Criando uma pauta: http://localhost:8080/v1/pauta
     
     Payload:
     
```json

      {
          "descricao":"Votação de Teste"
      }

 ```
- Em seguida, é aberta uma sessão.

     Criando uma Sessao: http://localhost:8080/v1/sessao
     Payload de exemplo:
     
```json

      {
          "foi_aberta": true,
          "pautaid": 2,
          "data_abertura": "2021-10-06 18:42:00",
          "tempo_determinado": 60
      }

  ```    

- Os usuários podem então, votar.
    
     Voto do Usuário: http://localhost:8080/v1/voto
     
     Payload exemplo:
     
```json

      {
          "usuarioid":1,
          "pauta_id": 2,
          "data_voto": "2021-10-06 19:50:01",
          "voto":"Sim" //Nao
      }

  ``` 
Obs: Eu evitei de colocar relações oneToMany devido ao curto tempo.

## Executando o Sistema

Primeiramente suba um container de postgres, e em seguida configure o application,properties com as configurações
do container, faça um build e rode, usando maven (mvn clean package e mvn boot:run).

Você pode criar uma imagem usando o meu dockerfile, e depois subir usando o docker-compose que eu
deixei de exemplo, mas para isto, você teria já deixar configurado o application.properties, então gerar
a imagem e deixar salva. Não tive tempo de automatizar isso, mas é fácil de fazer.

Enfim, para fins de demonstração, tá aí ... ;)
