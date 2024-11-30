````mermaid
C4Context
    title Sistema de Gerenciamento de Evento Esportivo

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
````