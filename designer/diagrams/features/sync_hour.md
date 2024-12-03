```mermaid
sequenceDiagram
    title Sincroniza hora do celular com o servidor

    actor Colaborador as Colaborador
    participant Aplicativo as Aplicativo
    participant API as API

    Colaborador->>Aplicativo: Acessa Aplicativo
    Aplicativo->>API: Obtém hora
    Aplicativo-->>Aplicativo: Valida hora
    alt Sincronizada
        Aplicativo-->>Colaborador: Home do App
    else Hora incorreta
        Aplicativo->>Aplicativo: Mensagem hora incorreta
        Aplicativo->>Aplicativo: Encerra App
    end
```