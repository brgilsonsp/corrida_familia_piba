```mermaid
sequenceDiagram
    title Atualizar as segmentações e seus respectivos valores

    actor Client as Cliente
    participant API as API
    participant DB as Banco de dados

    Client->>API: Informa dados atualizados PUT /segmentos/[id_segmento}
    API->>DB: Atualiza registro
    DB-->>API: Retorno
    alt Sucesso
        API-->>Client: Sucesso
    else Erro
        API->>DB: Rollback
        API->>DB: Detalhe erro
    end
```