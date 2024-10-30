package com.example.medi.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios extends ParticipanteBase {
    @Id
    private UUID id;

    public Usuarios() {
        this.id = UUID.randomUUID();
    }

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, length = 20)
    private String nomeUsuario;

    @Column(nullable = false)
    private String tipoDeConta = "USUARIO";

    // Relacionamento com processos abertos (que o usuário criou)
    @OneToMany(mappedBy = "criador")  
    @JsonIgnoreProperties("criador")
    private List<Processos> processosAbertos;

    // Para processos concluídos, você pode querer mudar a lógica
    @OneToMany(mappedBy = "mediadorEscolhido")
    @JsonIgnoreProperties("mediadorEscolhido")
    private List<Processos> processosConcluidos;

    // Relacionamentos adicionais conforme necessário
    @OneToMany(mappedBy = "criador") // Se houver um campo que representa 'usuario' no futuro
    @JsonIgnoreProperties("criador")
    private List<Processos> processosEmAnalise;

    @OneToMany(mappedBy = "criador") // Se houver um campo que representa 'usuario' no futuro
    @JsonIgnoreProperties("criador")
    private List<Processos> processosEncerrados;

    @OneToMany(mappedBy = "remetente")
    @JsonIgnoreProperties("remetente")
    private List<Mensagens> mensagensEnviadas;

    @OneToMany(mappedBy = "destinatario")
    @JsonIgnoreProperties("destinatario")
    private List<Mensagens> mensagensRecebidas;
}
