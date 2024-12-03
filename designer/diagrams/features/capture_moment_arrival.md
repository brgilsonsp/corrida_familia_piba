```mermaid
sequenceDiagram
    title Registra momento de chegada

    actor Colaborador as Colaborador
    participant Aplicativo as Aplicativo
    participant DB_LOCAL as Base Local

    Colaborador->>Aplicativo: Insere númere de peito
    Colaborador->>Aplicativo: Registra momento
    Aplicativo->>DB_LOCAL: Registra momento largada
    Aplicativo-->>Colaborador: Retorno
```