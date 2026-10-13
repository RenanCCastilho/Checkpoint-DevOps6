# MotorApp — API em Container (Docker + Azure)

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-6DB33F?logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)
![Azure](https://img.shields.io/badge/Azure_Container_Instances-0078D4?logo=microsoftazure&logoColor=white)

API REST para cadastro de **veículos e seus proprietários**, empacotada em uma imagem **Docker** e publicada no **Azure Container Instances**.

Ela é a versão containerizada do [MotorApp](https://github.com/RenanCCastilho/Checkpoint-DevOps), que roda no Azure App Service.

## Endpoints

| Recurso | Rota base | Operações |
|---|---|---|
| Proprietários | `/proprietarios` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |
| Veículos | `/veiculos` | `GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}` |

**Exemplo — cadastrar veículo** (use o id de um proprietário já cadastrado)

```json
POST /veiculos
{
  "modelo": "Onix",
  "montadora": "Chevrolet",
  "anoFabricacao": 2023,
  "km": 0.0,
  "proprietario": { "id": 1 }
}
```

## Banco de dados

O script de criação das tabelas `PROPRIETARIOS` e `VEICULOS` (Oracle) está em [`DDL_BD.txt`](DDL_BD.txt).

## Executando com Docker

```bash
# 1. Gerar o .jar
./mvnw clean package -DskipTests

# 2. Construir a imagem
docker build -t motor-app .

# 3. Rodar o container
docker run -p 8081:8081 \
  -e DB_USERNAME=seu_usuario \
  -e DB_PASSWORD=sua_senha \
  motor-app
```

Para executar sem Docker:

```bash
export DB_USERNAME=seu_usuario DB_PASSWORD=sua_senha
./mvnw spring-boot:run
```

---

Projeto acadêmico desenvolvido na **FIAP** (DevOps Tools & Cloud Computing, 2023).
