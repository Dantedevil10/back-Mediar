package com.example.medi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.medi.dto.AcessDTO;
import com.example.medi.dto.AuthenticationDTO;
import com.example.medi.security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDto){
        

        try{
            // Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth =
            new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());


            // Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Busca o usuário logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO accessDTO = new AcessDTO(token);

            return accessDTO;
            
        }catch(BadCredentialsException e){
            //TO DO LOGIN OU SENHA INVÁLIDO
        }
        return new AcessDTO("Acesso negado");
        
    }
}
