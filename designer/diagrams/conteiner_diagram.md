````mermaid
C4Container
    title Sistema de Gerenciamento de Evento Esportivo - Visão Geral

    Person(colaborador, "Colaborador", "Recepção")
    Person(atleta, "Atleta", "Participa do evento")
    System_Ext(parceiro, "Organizador do evento", "Responsável pelas inscrições online")

    System_Boundary(b0, "Sistema de Gerenciamento") {
        Container(appMobile, "Aplicativo Mobile", "React Native", "Interface do Colaborador")
        Container(backend, "Backend API", "Spring Boot", "Fornece APIs REST para o aplicativo mobile")
        ContainerDb(db, "Banco de Dados", "PostgreSQL", "Armazena informações do evento")
    }

    Rel(atleta, parceiro, "Inscrição")
    UpdateRelStyle(atleta, parceiro, "grey", "grey", "-40", "-10")
    Rel(atleta, colaborador, "Checkin/cadastra")
    UpdateRelStyle(atleta, colaborador, "grey", "grey", "-40", "-20")
    Rel(colaborador, appMobile, "Checkin / Cadastro / Cronometro / Classificação")
    UpdateRelStyle(colaborador, appMobile, "grey", "grey", "-50", "-80")
    Rel(appMobile, backend, "Requisição", "HTTPS")
    UpdateRelStyle(appMobile, backend, "grey", "grey", "-40", "-10")
    Rel(backend, db, "Lê/Escreve")
    UpdateRelStyle(backend, db, "grey", "grey", "-30", "-10")
    Rel(backend, parceiro, "Consulta atletas inscritos via API")
    UpdateRelStyle(backend, parceiro, "grey", "grey", "-70", "100")
    UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
    UpdateElementStyle(b0, $fontColor="grey", $borderColor="grey")
````