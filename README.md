# corrida_familia_piba
Controle do tempo de corrida de cada participante do evento Corrida da Familia da PIBA

# Curl para invocar os endpoints

### Obter todos nomes cadastrados, filtrando pelo inicio do nome
curl --location 'http://localhost:8080/athlete?start_name=m'

### Adiciona o número do atleta
Deve obter o id do atleta através da requisição acima

curl --location --request PUT 'http://localhost:8080/athlete' \
--header 'Content-Type: application/json' \
--data '{
    "id": "b8b0e2aa-c5ab-4475-9fa8-3d5c24e2315f",
    "numero_atleta": 2345
}'


### Adiciona o tempo que o atleta concluiu a corrida
Pode enviar mais um elemento. O numero_atleta deve ser o que foi cadastrado acima. O operador é o usuário que está registrando o cronometro

curl --location 'http://localhost:8080/timing' \
--header 'Content-Type: application/json' \
--data '{
    "dados": [
        {
            "operador": "Carlos",
            "numero_atleta" : 2345,
            "momento_chegada": "19:44:27.7261612"
        }
    ]
}'


### Obtém os segmentos cadastrados

curl --location 'http://localhost:8080/segment'


# Executar a aplicação

Configurar o Java 21 no seu computador.

Deve fazer o clone para o seu repositório localhost

Acesse o diretório do projeto e execute o seguinte comando que está a aplicação

$ cd ./corrida_familia_piba/sporting-event-race

Depois execute o seguinte comando

./mvnw spring-boot:run
