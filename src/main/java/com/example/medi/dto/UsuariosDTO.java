package com.example.medi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuariosDTO {

    private String email;
    private String cpf;
    private String senha;
    private String nomeUsuario;


    
    public UsuariosDTO(String email, String cpf, String senha, String nomeUsuario) {
        
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }
    
}
