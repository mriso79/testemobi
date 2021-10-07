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
- Após, é criada uma pauta.
- Em seguida, é aberta uma sessão.
- Os usuários podem então, votar.

Obs: Eu evitei de colocar relações oneToMany devido ao curto tempo.

O sistema roda usando Docker, e persiste os dados usando um banco Postgres. Para subir, basta ter docker
instalado na sua máquina e rodar o docker-compose.