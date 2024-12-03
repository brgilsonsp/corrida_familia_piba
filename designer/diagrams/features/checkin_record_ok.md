```mermaid
sequenceDiagram
    title Checkin do atleta registrado

    actor Atleta as Atleta
    actor Colaborador as Colaborador
    participant Aplicativo as Aplicativo
    participant DB_LOCAL as Base Local
    participant API as API
    participant DB as Banco de Dados
    
    Atleta->>Colaborador: Entrega documento
    Colaborador->>Aplicativo: Informa documento
    Aplicativo->>DB_LOCAL: Solicita dados
    DB_LOCAL-->>Aplicativo: Resultado
    Aplicativo-->>Colaborador: Dados do atleta
    Colaborador->>Atleta: Valida dados
    Atleta-->>Colaborador: Dados ok
    Colaborador->>Aplicativo: Registra checkin
    Aplicativo->>API: Registra checkin
    API->>DB: Atualiza dados
    API-->>Aplicativo: Resultado
    Aplicativo-->>Colaborador: Resultado
    Colaborador-->>Atleta: Entrega número de peito
```