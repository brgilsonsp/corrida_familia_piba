```mermaid
sequenceDiagram
    title Associa números de peito aos atletas

    actor Admin as Administrador
    participant API as API
    participant DB as Banco de dados

    Admin->>API: Solicita configuração
    API->>DB: Consulta números de peito disponíveis
    DB-->>API: Resultado
    alt Não encontrado
        API-->>Admin: Erro
    end
    API->>DB: Consulta atletas sem número de peito
    DB-->>API: Resultado
    alt Não encontrado
        API-->>Admin: Sem alteração
    end
    alt Núm peito insuficiente
        API-->>Admin: Erro Número de peito insuficiente
    end
    loop Atletas sem núm peito
        API->>DB: Associa número de peito ao atleta
    end
    API-->>Admin: Sucesso
```