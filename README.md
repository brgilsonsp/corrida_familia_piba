# Organização evento esportivo
A Primeira Igreja Batista de Atibaia (PIBA) organiza um evento de corrida e caminhada para a população. O evento é aberto para todos públicos, sendo membros da PIBA ou não.

## Visão Geral
Nos eventos organizados, o processo foi mesclado, parte automizado e parte manual.

A inscrição é automatizada, que fica sob responsabilidade de empresa que organiza o evento. Porém a gestão do evento, como a jornada do checkin do atleta, a correção dos dados do atleta, a captação do tempo do atleta e a classificação é realizado manualmente.

## Proposta de valor
O objetivo do projeto é automatizar a gestão do evento que é efetuada manualmente.

A base de dados dos atletas inscritos será obtido de um serviço disponibilizado pela empresa que efetuou a jornada da inscrição.

A solução permitirá que um colaborador possa efetuar o checkin, correção dos dados do atleta, a captura do tempo da corrida do atleta em um aplicativo. A soluçã deverá também processar a classificação de forma automatizada, possibilitando acompanhar a classificação em tempo real e filtrar por características específicas do evento.

## Objetivos principais
Facilitar o checkin do atleta e a captura do tempo da corrida/caminhada, onde será enviado para um serviço que fará o armazemento dos dados e o processamento da classificação em tempo real.

## Detalhes da solução
A solução é um sistema de software que fará a gestão de um evento de corrida e/ou caminhada. O software deve fornecer as seguintes funcionalidades com suas respectivas regras:
 * Obter atletas: A solução deve consultar uma API de um parceiro para obter todos os atletas inscritos. Esse processo será efetuado através de uma rotina batch, apenas no back-end
 * Checkin: Um colaborador irá efetuar marcar que o atleta compareceu ao evento. O atleta deverá apresentar um documento com foto, que com o CPF/RNE. A consulta do regitrso do atleta será com o número do documento que foi efetuado a inscrição
 * Checkin sem inscrição: Caso ocorreu algum problema com a inscriação do atleta e o parceiro não a processou, então o colaborador poderá fazer o registro desse atleta
 * Correção checkin: O Operador pode corrigir o número de peito, nome e data de nascimento do atleta
 * Cronometragem: Um colaborador fará a captura do tempo exato que o atleta cruzou a linha de chegada, associando ao número de peito do atleta. Esse dado ficará salvo no celular do colaborador para ser enviado em um momento posterior.
 * Envio da cronometragem: O Operador irá enviar todas as informações de cronometragem que registrou para o servidor.
 * Momento da largada: Para os atletas que chegarem pontualmente no evento, todos terão o seu tempo inicial igual. Para os atletas que chegerem atrasados terão o momento de saída captado por um Colaborador.
 * Envio do momento de largada: Todos os momentos de partida capturados devem ser enviados no exato momento da captura.
 * Cronometragem divergentes: O colaborador poderá obter todos os atletas que possui mais de uma cronometragem registrada onde o colaborador em questão esteja envolvido. O colaborador poderá corrigir a cronometragem manualmente
 * Correção da cronometragem: O colaborador poderá acessar o tempo de chegada de um atleta específico, filtrando pelo número do peito, e alterar o momento da chegada manualmente. O sistema pode aceitar um valor vazio, indicando que o atleta foi desclassificado
 * Classificação: A classificação deve ser calculada no momento da consulta, levando em consideração o momento da chegada subtraindo do inicio da corrida, onde sera obtido o tempo total da corrida. A listagem, deve exibir a posição de cada atleta comparando o tempo total da corrida de cada atleta. A consulta da classificação pode ser filtrada por Sexo, Faixa Etária e Categoria. Sexo será aceito apenas Masculino e Feminino. Faixa Etária serão nos intervalos 6-7, 8-12, 13-15, 16-20, 21-30, 21-40, 41-50 e 61+. Jà as Categoria serão Corrida e Caminhada. A largada terá um limite de tempo permitido para entrar na classificação, o atleta que chegar após o limite permitido não entrará na classificação
* Sincronismo da hora do celular: O colaborador deve sincronizar a data e hora do seu celular com o servidor. Assim que acessar o aplicativo, será solicitado a hora do servidor para sincronizar o horário do celular. Com essa feature podemos garantir que todos os colaboradores estarão com o mesmo horário em seus respectivos celulares.
 * Logs auditoria: Deve exibir qual colaborador que registrou determinado evento. Pode filtrar por nome do colaborador ou número de peito do atleta ou número do documento do atleta. Filtros com o nome do colaborador, deve exibir todos eventos registrados pelo colaborador. Filtro pelo número de peito ou pelo número do documento, deve exibiro todos os colaboradores com seus respetivos eventos registros para o atleta em questão
 * Configuração: Nessa opção será possível criar/alterar/desabilitar colaboradores; alterar perfil de colaboradores; alterar endereço do DNS do back-end
 * Autenticação. Para o MVP, iremos salvar, direto na base de dados, os colaboradores que poderão acessar a aplicação com seus respectivos priviégios. Será disponibilizados os seguintes perfis:
   * operador: checkin; cronometragem; envio da cronometragem; momento largada; envio momento partida; sincronismo hora do celular
   * operador especial: operador; Checkin sem inscrição; Correção checkin; Cronometragem divergentes; 
   * gerente: operador especial; Correção da cronometragem; Classificação; Logs auditoria
   * administrador: Configuração; gerente
 * Auditoria: Todas as alterações deve capturar o nome do colaborador para fins de auditoria
 * Enviar classificação para o atleta: Na tela de classificação, pode ser disparado a respectiva classificação para o e-mail de todos os atletas, evidenciando a sua classificação. O Operador deve informar uma mensagem que será enviada no e-mail

## Diagramas
 - [Visão do contexto](designer/diagrams/context_diagram.md)
 - [Diagrama se sequencia](designer/diagrams/sequence_general.md)

## Como utilizar as APIs
Utilize as orientações em [examples CURL](designer/contracts/exemples_curl.md) 

## Executar a aplicação localmente
Utilize as orientações em [Executar aplicação](./designer/execute_api.md) 