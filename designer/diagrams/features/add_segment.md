```mermaid
sequenceDiagram
    title Adicionar as segmentações e seus respectivos valores

    actor Admin as Administrador
    participant API as API
    participant DB as Banco de dados

    Admin->>API: Envia segmentos
    API->>DB: Registra segmentos
    DB-->>API: Retorno
    alt Sucesso
        API-->>Admin: Sucesso
    else Erro
        API->>DB: Rollback
        API->>DB: Detalhe erro
    end
```