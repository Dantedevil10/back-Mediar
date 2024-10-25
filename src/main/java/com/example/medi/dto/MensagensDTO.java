package com.example.medi.dto;

import java.time.LocalDateTime;

public class MensagensDTO {
    private Long id;
    private Long remetente;
    private Long destinatario;
    private String conteudo;
    private LocalDateTime dataEnvio;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getRemetente() {
        return remetente;
    }


    public void setRemetente(Long remetente) {
        this.remetente = remetente;
    }


    public Long getDestinatario() {
        return destinatario;
    }


    public void setDestinatario(Long destinatario) {
        this.destinatario = destinatario;
    }


    public String getConteudo() {
        return conteudo;
    }


    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }


    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }


    public MensagensDTO(Long id, Long remetente, Long destinatario, String conteudo, LocalDateTime dataEnvio) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
    }

    
}
