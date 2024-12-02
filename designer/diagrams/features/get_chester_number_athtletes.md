```mermaid
sequenceDiagram
    title Obtém números de peito dos atletas

    actor Admin as Administrador
    participant Aplicativo as Aplicativo
    participant DB as Banco de dados

    Admin->>Aplicativo: Solicita lista
    Aplicativo->>DB: Atletas com número de peito
    DB-->>Aplicativo: Resultado
    Aplicativo-->>Admin: Resultado
```