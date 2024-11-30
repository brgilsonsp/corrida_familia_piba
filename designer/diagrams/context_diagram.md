````mermaid
C4Context
    title Sistema de Gerenciamento de Evento Esportivo - Visão Contexto
    Person(colaborador, "Colaborador", "Atua na organização do evento")
    Person(atleta, "Atleta", "Participa do evento")
    System_Ext(parceiro, "Sistema do Parceiro", "Responsável pelas inscrições online")

    System_Boundary(b0, "Sistema de Gerenciamento") {
        System(gestaoEvento, "Sistema de Gestão de Evento", "Realiza a gestão do evento")
    }

    Rel(atleta, parceiro, "Inscrição")
    Rel(atleta, colaborador, "Checkin")
    Rel(colaborador, gestaoEvento, "Gerencia o evento")
    Rel(gestaoEvento, parceiro, "Consulta atletas inscritos via API")
    UpdateRelStyle(atleta, parceiro, "grey", "grey", "-40", "-10")
    UpdateRelStyle(atleta, colaborador, "grey", "grey", "-10", "-10")
    UpdateRelStyle(colaborador, gestaoEvento, "grey", "grey", "-9", "-60")
    UpdateRelStyle(gestaoEvento, parceiro, "grey", "grey", "-180", "100")
    UpdateElementStyle(b0, $fontColor="grey", $borderColor="grey")
````