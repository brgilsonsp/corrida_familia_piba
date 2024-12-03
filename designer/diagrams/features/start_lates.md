```mermaid
sequenceDiagram
    title Momento de largada atrasado

    actor Colaborador as Colaborador
    participant Aplicativo as Aplicativo
    participant API as API
    participant DB as Banco de Dados

    Colaborador->>Aplicativo: Insere númere de peito
    Colaborador->>Aplicativo: Registra momento
    Aplicativo->>API: Envio momento largada
    API->>DB: Registra momento largada
    DB-->>API: Retorno
    API-->>Aplicativo: Retorno
    Aplicativo-->>Colaborador: Retorno
```