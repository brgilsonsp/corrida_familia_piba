```mermaid
sequenceDiagram
    title Obtem as segmentações e seus respectivos valores

    actor Admin as Administrador
    participant API as API
    participant DB as Banco de dados

    Admin->>API: Solicita segmentos
    API->>DB: Consulta registros
    DB-->>API: Retorno
    API-->>Admin: Retorno
```