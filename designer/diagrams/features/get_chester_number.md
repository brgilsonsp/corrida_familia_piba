```mermaid
sequenceDiagram
    title Obtém números de peito

    actor Admin as Administrador
    participant API as API
    participant DB as Banco de dados

    Admin->>API: Solicita lista
    API->>DB: Obtém lista
    DB-->>API: Resultado
    API-->>Admin: Resultado
```