```mermaid
sequenceDiagram
    title Obter atletas no serviço do Organizador do Evento
    
    actor Atleta as Atleta
    participant Servico_Parceiro as Organizador do evento
    participant Aplicativo as Aplicativo
    participant DB as Banco de dados
    actor Admin as Administrador

%% Inscrição
    Atleta->>Servico_Parceiro: Realiza inscrição
    Servico_Parceiro-->>Atleta: Confirma inscrição

%% Obtém dados
    Admin->>Aplicativo: Atualiza base de atletas
    Aplicativo->>Servico_Parceiro: Envia credenciais
    Servico_Parceiro-->>Aplicativo: Fornece token de acesso
    Aplicativo->>Servico_Parceiro: Solicita inscritos no evento
    Servico_Parceiro-->>Aplicativo: Envia lista dos inscritos

%% Atualiza registros
    loop
        Aplicativo->>DB: Consulta registro
        DB-->>Aplicativo: Retorna
        alt Atleta registrado
            Aplicativo->>DB: Atualiza atleta
        else Atleta não registrado
            Aplicativo->>DB: Salva atleta
        end
    end



```