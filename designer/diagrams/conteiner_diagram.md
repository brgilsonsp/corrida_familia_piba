````mermaid
C4Container
    title Sistema de Gerenciamento de Evento Esportivo - Diagrama de Container
    Person(colaborador, "Colaborador", "Atua na organização do evento")
    Person(atleta, "Atleta", "Participa do evento")
    System_Ext(parceiro, "Sistema do Parceiro", "Responsável pelas inscrições online")

    System_Boundary(b0, "Sistema de Gerenciamento") {
        Container(appMobile, "Aplicativo Mobile", "React Native", "Interface do usuário para Colaboradores")
        Container(backend, "Backend API", "Spring Boot", "Fornece APIs REST para o aplicativo mobile")
        ContainerDb(db, "Banco de Dados", "PostgreSQL", "Armazena informações do evento, atletas")
    }

    Rel(atleta, parceiro, "Inscriação")
    Rel(atleta, colaborador, "Checkin")
    Rel(colaborador, appMobile, "Gerencia o evento")
    Rel(appMobile, backend, "Request")
    Rel(backend, db, "Lê/Escreve")
    Rel(backend, parceiro, "Consulta atletas inscritos via API")
    UpdateRelStyle(atleta, parceiro, "grey", "grey", "-40", "-10")
    UpdateRelStyle(atleta, colaborador, "grey", "grey", "-10", "-10")
    UpdateRelStyle(colaborador, appMobile, "grey", "grey", "-20", "-50")
    UpdateRelStyle(appMobile, backend, "grey", "grey", "-40", "-10")
    UpdateRelStyle(backend, parceiro, "grey", "grey", "-50", "90")
    UpdateRelStyle(backend, db, "grey", "grey", "-30", "-10")
    UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
    UpdateElementStyle(b0, $fontColor="grey", $borderColor="grey")
````