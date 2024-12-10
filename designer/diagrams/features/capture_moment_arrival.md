```mermaid
sequenceDiagram
    title Registra momento de chegada

    actor Monitor as Monitor
    participant Aplicativo as Aplicativo
    participant DB_LOCAL as Base Local

    Monitor->>Aplicativo: Insere númere de peito
    Monitor->>Aplicativo: Registra momento
    Aplicativo->>DB_LOCAL: Registra momento chegada
    Aplicativo-->>Monitor: Retorno
```