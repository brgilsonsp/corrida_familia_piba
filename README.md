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
 * Segmentos: A corrida será segmentada por Sexo, Faixa Etária e Categoria. Sexo serão aceitos apenas Masculino e Feminino. Faixa Etária serão nos intervalos 6-7, 8-12, 13-15, 16-20, 21-30, 21-40, 41-50 e 61+. Jà as Categoria serão Corrida e Caminhada.
 * Sincronismo da hora do celular: O monitor deve sincronizar a data e hora do seu celular com o servidor. Assim que acessar o aplicativo, será solicitado a hora do servidor para sincronizar o horário do celular. Com essa feature podemos garantir que todos os monitores estarão com o mesmo horário em seus respectivos celulares.
 * Checkin: Um monitor fará o checkin do atleta que compareceu ao evento. O atleta deverá apresentar um documento com foto, como CPF/RNE. A consulta do regitrso do atleta será com o número do documento que foi efetuado a inscrição. No momento do checkin será cadastrado o número de peito que o atleta irá utilizar.O monitor poderá corrigir qualquer campo do cadastro do atleta.
 * Checkin sem inscrição: Caso ocorreu algum problema com a inscriação do atleta, ou o atleta não efetuou a inscrição préviamente, então o monitor poderá fazer o registro desse atletae cadastrar o número de peito que irá utilizar.
 * Cronometragem: Iremos capturar o momento da largada geral, a largada de cada atleta que iniciou após a largada geral (iremos chamar de largada atrasada) e o momento que cruzou a linha de chegada. O administrador fará a captura da larga geral. Já a largada atrasada e a linha de chegada será capturada pelo monitor. Tanto a largada atrasada quanto o momento que cruzou a linha de chegada, o monitor irá associar o momento ao número de peito.
 * Correção da cronometragem: O administrador poderá acessar o tempo de chegada de um atleta específico, filtrando pelo número do peito, e alterar o momento da chegada manualmente. Se for informado um tempo de chegada vazio, então o atleta foi desclassificado
 * Correção da largada atrasada: O administrador poderá acessar o tempo de largada de um atleta específico, filtrando pelo número do peito, e alterar o momento da largada manualmente. Se for informado um tempo de largada vazio, então será considerado o momento da largada geral
 * Envio da cronometragem: O monitor irá enviar todas as informações de cronometragem registradas para o servidor de forma assíncrona.
 * Envio do momento de largada: O monitor irá enviar todas as informações de largadas atradas registradas para o servidor de forma assíncrona
 * Classificação: A classificação deve ser calculada no momento da consulta, levando em consideração o momento da chegada subtraindo do inicio da corrida, onde sera obtido o tempo total da corrida. A listagem, deve exibir a posição de cada atleta comparando o tempo total da corrida de cada atleta. A consulta da classificação pode ser filtrada pela Segmentação. A largada terá um limite de tempo permitido para entrar na classificação, o atleta que chegar após o limite permitido não entrará na classificação
 * Configuração: Nessa opção será possível alterar endereço do DNS do back-end
 * Autenticação. Para o MVP, iremos salvar, direto na base de dados, os colaboradores que poderão acessar a aplicação.
 * Auditoria: Todas as alterações deve capturar o nome do colaborador para fins de auditoria
 * Enviar classificação para o atleta: Na tela de classificação, pode ser disparado a respectiva classificação para o e-mail de todos os atletas, evidenciando a sua classificação. O Operador deve informar uma mensagem que será enviada no e-mail

## Diagramas
 - [Visão Geral](designer/diagrams/conteiner_diagram.md)
 - Detalhes de cada funcionalidade
   - [Obter dados dos inscritos](designer/diagrams/features/get_athletes.md)
   - Acesso Aplicativo
     - [Sincronizar hora do celular](designer/diagrams/features/sync_hour.md)
   - Checkin
       - [Atleta com registro](designer/diagrams/features/checkin_recorded.md)
       - [Atleta sem registro](designer/diagrams/features/checkin_record_not_saved.md)
   - Cronometragem
       - [Largada atrasados](designer/diagrams/features/start_late_exit.md)
       - [Corrigir largada](designer/diagrams/features/update_exit.md)
       - [Enviar largada](designer/diagrams/features/send_capture_moment_exit.md)
       - [Captura momento chegada](designer/diagrams/features/capture_moment_arrival.md)
       - [Correção momento chegada](designer/diagrams/features/fix_capture_moment_arrival.md)
       - [Envia registros chegada](designer/diagrams/features/send_capture_moment_arrival.md)
   - Segmentação
     - [Configurar segmentação](designer/diagrams/features/add_segment.md)
     - [Obter segmentação](designer/diagrams/features/get_segment.md)
     - [Atualizar segmentação](designer/diagrams/features/update_segment.md)
     - [Excluir segmentação](designer/diagrams/features/delete_segment.md)
   - [Classificação](designer/diagrams/features/classification.md)
   - [Configuração](designer/diagrams/features/configuration.md)

## Projetos envolvidos

 - [API](https://github.com/brgilsonsp/corrida_familia_piba_api)
 - [Back-end](https://github.com/brgilsonsp/corrida_familia_piba_back)
 - [Front-end](https://github.com/brgilsonsp/corrida_familia_piba_front)