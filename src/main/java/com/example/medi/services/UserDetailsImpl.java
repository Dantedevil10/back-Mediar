package com.example.medi.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.medi.models.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

    private Long id;

    private String email;

    private String username;

    public static UserDetailsImpl build(Usuarios usuario){

        return new UserDetailsImpl(
            usuario.getId(),
            usuario.getEmail(),
            usuario.getNomeUsuario(),
            new ArrayList<>());
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired(){
     return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    public UserDetailsImpl(UUID id2, String email2, String nomeUsuario, ArrayList<GrantedAuthority> authorities2) {
        
    }

}
