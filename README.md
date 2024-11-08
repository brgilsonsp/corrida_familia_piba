# Classificação Corre Família PIBA

A solução é um sistema de software que fará a gestão de um evento de corrida de rua. O software deve fornecer as seguintes funcionalidades com suas respectivas regras:
 * Obter atletas. A solução deve consultar uma API de um parceiro para obter todos os atletas e atualizar a basa de dados. Os registros dos atletas não pode ser duplicados, mesmo se a nossa solução consultar a API mais de uma vez
 * Checkin. O Operador irá associar um número de peito a um Atleta. Um atleta pode possuir apenas um número de peito. Um número de peito pode ser cadastrado para apenas um atleta. O cadastro deve armazenar qual o Operador que fez o checkin. Um atleta não pode fazer dois checkin, apenas correção
 * Correção checkin. O Operador pode corrigir o número de peito de um determinado atleta
 * Cronometragem. O Operador pode cadastrar o nomento de chegada de um determinado atleta, associando ao número do peito. O sistema deve obter a hora do celular para registrar o momento atual. Deve registrar a informação em uma banco de dados local.
 * Sincronismo de hora. O Operador deve sincronizar a data e hora do seu celular com o servidor. Ao iniciar a coleta da cronometragem, o Operador será obrigado a sincronizar a data e hora do celular com o servidor
 * Envio da cronometragem. O Operador irá enviar todas as informações de cronometragem que registrou para o servidor. Deve enviar tambem o nome do Operador. No momento de salvar o momento de chegada do atleta, deve salvar o momento da partida. O momento da partida será um valor fixo para todos atletas e deve ser configurado externamente.
 * Cronometragem divergentes. O Operador poderá obter todos os atletas que possui mais de uma cronometragem registrada onde o Operador em questão esteja envolvido. O Operador poderá corrigir a cronometragem manualmente. Deve salvar qual Operador que efetuou a correção manual.
 * Correção da cronometragem. O Operador poderá acessar o tempo de chegada de um atleta específico, filtrando pelo número do peito, e alterar o momento da chegada manualmente. Deve salvar o nome do Operador que efetuou a alteração
 * Classificação. A classificação deve ser calculada no momento da consulta, levando em consideração o momento da chegada subtraindo do inicio da corrida, onde sera obtido o tempo total da corrida. Dentro da lista filtrada, deve definir a posição de cada atleta comparando o tempo total da corrida de cada atleta. A consulta da classificação pode ser filtrada por Sexo, Faixa Etária e Categoria. Sexo será aceito apenas Masculino e Feminino. Faixa Etária serão os seguintes intervalor 6-7, 8-12, 13-15, 16-20, 21-30, 21-40, 41-50 e 61+. Categoria serão aceitas Corrida e Caminhada 
 * Opções de filtro de classificação. O front-end deve consultar o back-end quais as opções de classificações e seus respectivos valores. Essa consulta deve ocorrer na primeira vez que entrar na opção Classificação. Nas demais consultas o front-end deve obter esses dados de um cache local. Toda vez que abrir o app, deve limpar esse cache local.
 * Autenticação. Para o MVP, o front-end irá persistir uma credencial fixa, para efetuar as requisições as APIs
 * Enviar classificação para o atleta. Na tela de classificação, pode ser disparado a respectiva classificação para o e-mail de todos os atletas, evidenciando a sua classificação. O Operador deve informar uma mensagem que será enviada no e-mail

## Como utilizar as APIs

Utilize as orientações em [Examples CURL](./designer/exemples_curl.md) 

## Executar a aplicação localmente

Utilize as orientações em [Executar aplicação](./designer/execute_api.md.md) 