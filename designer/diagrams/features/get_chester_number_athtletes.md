```mermaid
sequenceDiagram
    title Obtém números de peito dos atletas

    actor Admin as Administrador
    participant API as API
    participant DB as Banco de dados

    Admin->>API: Solicita lista
    API->>DB: Atletas com número de peito
    DB-->>API: Resultado
    API-->>Admin: Resultado
```