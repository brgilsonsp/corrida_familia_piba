```mermaid
sequenceDiagram
    title Configuração DNS API

    actor Admin as Administrador
    participant Aplicativo as Aplicativo
    participant DB_LOCAL as Banco de dados

    Admin->>Aplicativo: Altera configuração
    Aplicativo->>DB_LOCAL: Salva configuração
    Aplicativo-->>Admin: Retorno
```