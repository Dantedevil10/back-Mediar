package com.example.medi.dto;

import com.example.medi.models.Processos.StatusProcesso;
import com.example.medi.models.Usuarios;

public class ProcessosDTO {
    private StatusProcesso status;
    private String nomeAutor;
    private String nomeReu;
    private String cpfAutor;
    private String dadosAcusado;
    private String descricaoAcusacao;
    private String comprovanteResidencia;
    private Boolean urgencia;
    private String emailAutor;
    private String motivoEncerramento;
    private Usuarios criador;
    
    public Usuarios getCriador() {
        return criador;
    }
    public void setCriador(Usuarios criador) {
        this.criador = criador;
    }
    public ProcessosDTO(Usuarios criador) {
        this.criador = criador;
    }
    public ProcessosDTO(StatusProcesso status, String nomeAutor, String nomeReu, String cpfAutor, String dadosAcusado,
            String descricaoAcusacao, String comprovanteResidencia, Boolean urgencia, String emailAutor,
            String motivoEncerramento) {
        this.status = status;
        this.nomeAutor = nomeAutor;
        this.nomeReu = nomeReu;
        this.cpfAutor = cpfAutor;
        this.dadosAcusado = dadosAcusado;
        this.descricaoAcusacao = descricaoAcusacao;
        this.comprovanteResidencia = comprovanteResidencia;
        this.urgencia = urgencia;
        this.emailAutor = emailAutor;
        this.motivoEncerramento = motivoEncerramento;
    }
    public StatusProcesso getStatus() {
        return status;
    }
    public void setStatus(StatusProcesso status) {
        this.status = status;
    }
    public String getNomeAutor() {
        return nomeAutor;
    }
    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
    public String getNomeReu() {
        return nomeReu;
    }
    public void setNomeReu(String nomeReu) {
        this.nomeReu = nomeReu;
    }
    public String getCpfAutor() {
        return cpfAutor;
    }
    public void setCpfAutor(String cpfAutor) {
        this.cpfAutor = cpfAutor;
    }
    public String getDadosAcusado() {
        return dadosAcusado;
    }
    public void setDadosAcusado(String dadosAcusado) {
        this.dadosAcusado = dadosAcusado;
    }
    public String getDescricaoAcusacao() {
        return descricaoAcusacao;
    }
    public void setDescricaoAcusacao(String descricaoAcusacao) {
        this.descricaoAcusacao = descricaoAcusacao;
    }
    public String getComprovanteResidencia() {
        return comprovanteResidencia;
    }
    public void setComprovanteResidencia(String comprovanteResidencia) {
        this.comprovanteResidencia = comprovanteResidencia;
    }
    public Boolean getUrgencia() {
        return urgencia;
    }
    public void setUrgencia(Boolean urgencia) {
        this.urgencia = urgencia;
    }
    public String getEmailAutor() {
        return emailAutor;
    }
    public void setEmailAutor(String emailAutor) {
        this.emailAutor = emailAutor;
    }
    public String getMotivoEncerramento() {
        return motivoEncerramento;
    }
    public void setMotivoEncerramento(String motivoEncerramento) {
        this.motivoEncerramento = motivoEncerramento;
    }
}
