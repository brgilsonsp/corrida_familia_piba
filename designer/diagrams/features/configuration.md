```mermaid
sequenceDiagram
    title Configuração DNS API

    actor Colaborador as Colaborador
    participant Aplicativo as Aplicativo
    participant DB_LOCAL as Banco de dados

    Colaborador->>Aplicativo: Altera configuração
    Aplicativo->>DB_LOCAL: Salva configuração
    Aplicativo-->>Colaborador: Retorno
```