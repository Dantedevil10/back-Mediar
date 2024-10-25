package com.example.medi.models;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "mediadores")
public class Mediadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 20)
    private String nomeUsuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TribunalAtuacao tribunalAtuacao;

    @Column(nullable = false)
    private String cidadeAtuacao;

    @Column(nullable = false)
    private String titulacaoGraduacao;

    @OneToMany(mappedBy = "mediadorEscolhido")
    @JsonIgnoreProperties("mediadorEscolhido")
    private List<Processos> processosRecebidos;

    @OneToMany(mappedBy = "mediadorEscolhido")
    @JsonIgnoreProperties("mediadorEscolhido")
    private List<Processos> processosEmAnalise;

    @OneToMany(mappedBy = "mediadorEscolhido")
    @JsonIgnoreProperties("mediadorEscolhido")
    private List<Processos> processosFinalizados;

    public enum TribunalAtuacao {
        TODOS,
        ESTADUAL,
        FEDERAL
    }
}
