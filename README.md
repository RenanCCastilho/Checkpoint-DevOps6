# Checkpoint-DevOps

# Lista de Endpoints
## ***Proprietarios***
## GET 
https://motorapp.azurewebsites.net/proprietarios
### Descrição: Consulta a lista de proprietarios cadastrados.
### Exemplo de resposta:
          
          {
              "nome": "Proprietario",
              "cidade": "Cidade do Proprietario",
              "telefone": "Telefone do Proprietario"
          }


## POST
https://motorapp.azurewebsites.net/proprietarios
### Descrição: Cadastra um novo proprietario.
### Exemplo de solicitação:

          {
          "nome": "Novo Proprietario",
          "cidade": "Cidade do Novo Proprietario",
          "telefone": "Telefone do Novo Proprietario"
          }



## PUT 
https://motorapp.azurewebsites.net/proprietarios/1
### Descrição: Atualiza informações sobre o proprietario cadastrado.
### Exemplo de solicitação:

            {
              "nome": "Atualizar Proprietario",
              "cidade": "Atualizar cidade do Proprietario",
              "telefone": "Atualizar telefone do Proprietario"
          }



## DELETE 
https://motorapp.azurewebsites.net/proprietarios/1
### Descrição: Deleta o proprietario selecionado. No caso deletará o proprietario com o id = 1.
## ***Veiculos***
## GET 
https://motorapp.azurewebsites.net/veiculos
### Descrição: Consulta a lista de veículos cadastrados. 
### Exemplo de resposta:
          
          {
              "modelo": "Modelo do Veiculo",
              "montadora": "Montadora do Veiculo",
              "anoFabricacao": 2023,
              "km": 0.0,
              "proprietario": {
                  "id": 1
                  "nome": "Nome do Proprietario"
                  "cidade": "Cidade do Propretario"
                  "telefone": "Telefone do Proprietario"
              }
          }
          

## POST
https://motorapp.azurewebsites.net/veiculos
### Observação: Colocar id de um proprietario ja cadastrado!
### Descrição: Cadastra um novo veículo
### Exemplo de solicitação:

          {
              "modelo": "Modelo do Novo Veiculo",
              "montadora": "Montadora do Novo Veiculo",
              "anoFabricacao": 2023,
              "km": 0.0,
              "proprietario": {
                  "id": 1
              }
          }


## PUT 
https://motorapp.azurewebsites.net/veiculos/1
### Descrição: Atualiza informações sobre o veículo cadastrado.
### Exemplo de solicitação:

       {
              "modelo": "Atualiza o modelo do Veiculo",
              "montadora": "Atualiza a montadora do Veiculo",
              "anoFabricacao": 2023,
              "km": 0.0,
              "proprietario": {
                  "id": 1
              }
          }


## DELETE 
https://motorapp.azurewebsites.net/veiculos/1
### Descrição: Deleta o veículo selecionado. No caso deletará o veículo com o id = 1.


# How To Implementação do projeto em nuvem

1) 
No SqlDeveloper acesse sua conta no banco e execute o script que está no arquivo txt "DDL_BD";

2) 
Baixe nosso código fonte em nosso repositório no GitHub:
https://github.com/RenanCCastilho/Checkpoint-DevOps;

3)
Na aba básico, defina o nome do seu web app;
Na coluna pilha de runTime coloque Java17;
Sistema Operacional: selecione o seu sistema operacional;
região: Brazil South;

4)
Na aba implementação deixe a opção habilitar na coluna implementação contínua;
Autorize a sua conta do github;
Organização: nome de usuário do github;
repositório: repositorio onde está o projeto;
branch: main;

5)
Na aba rede deixe o acesso público ATIVADO;

6)
Na aba monitoramento deixe o Application Insights DESABILITADO;

7)
Após isso vá até a aba Revisar e criar e clique em criar;
Aguarde a criação dos recursos e vá até o serviço de aplicativo criado;

8)
No github clique na aba Actions;
Aguarde o Build e o Deploy;

Obs:
O link gerado abre uma página default, e como não temos essa página, precisamos usar os endpoints(/proprietarios) ou (/veiculos);
