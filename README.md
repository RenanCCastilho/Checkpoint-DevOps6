# Checkpoint-DevOps6

# Lista de Endpoints
## ***Proprietarios***
## GET 
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/proprietarios
### Descrição: Consulta a lista de proprietarios cadastrados.
### Exemplo de resposta:
          
          {
              "nome": "Proprietario",
              "cidade": "Cidade do Proprietario",
              "telefone": "Telefone do Proprietario"
          }


## POST
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/proprietarios
### Descrição: Cadastra um novo proprietario.
### Exemplo de solicitação:

          {
          "nome": "Novo Proprietario",
          "cidade": "Cidade do Novo Proprietario",
          "telefone": "Telefone do Novo Proprietario"
          }



## PUT 
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/proprietarios/1
### Descrição: Atualiza informações sobre o proprietario cadastrado.
### Exemplo de solicitação:

            {
              "nome": "Atualizar Proprietario",
              "cidade": "Atualizar cidade do Proprietario",
              "telefone": "Atualizar telefone do Proprietario"
          }



## DELETE 
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/proprietarios/1
### Descrição: Deleta o proprietario selecionado. No caso deletará o proprietario com o id = 1.
## ***Veiculos***
## GET 
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/veiculos
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
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/veiculos
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
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/veiculos/1
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
http://rm94394motorapp.brazilsouth.azurecontainer.io:8080/veiculos/1
### Descrição: Deleta o veículo selecionado. No caso deletará o veículo com o id = 1.

