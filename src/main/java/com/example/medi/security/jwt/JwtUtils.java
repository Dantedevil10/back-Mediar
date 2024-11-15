package com.example.medi.security.jwt;

import java.security.Key;
import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.medi.services.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    @Value("${medi.jwtSecret}")
    private String jwtSecret;

    @Value("${medi.jwtExpirationMs}")
    private int jwtExpirationMs;

    @SuppressWarnings("deprecation")
    public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail){
        return Jwts.builder().setSubject(userDetail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
    }

    public Key getSigninKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    @SuppressWarnings("deprecation")
    public String getUsernameToken(String token){
        return Jwts.parser().setSigningKey(getSigninKey()).build()
        .parseClaimsJws(token).getBody().getSubject();
    }

    @SuppressWarnings("deprecation")
    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;

        }catch(MalformedJwtException e){
            System.out.println("Token inválido " + e.getMessage());
        }catch(ExpiredJwtException e){
            System.out.println("Token expirado " + e.getMessage());
        }catch(UnsupportedJwtException e){
            System.out.println("Token não suportado " + e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Token argumento inválido " + e.getMessage());
        }
        
        return false;
    }
}