package com.example.medi.models;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, length = 20)
    private String nomeUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Processos> processosAbertos;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Processos> processosConcluidos;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Processos> processosEmAnalise;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Processos> processosEncerrados;

    @OneToMany(mappedBy = "remetente")
    @JsonIgnoreProperties("remetente")
    private List<Mensagens> mensagensEnviadas;

    @OneToMany(mappedBy = "destinatario")
    @JsonIgnoreProperties("destinatario")
    private List<Mensagens> mensagensRecebidas;
}
