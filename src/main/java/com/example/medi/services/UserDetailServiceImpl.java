package com.example.medi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.medi.models.Usuarios;
import com.example.medi.repository.UsuariosRepository;

@Service
public class UserDetailServiceImpl implements  UserDetailsService{

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findByLogin(username).get();
        return UserDetailsImpl.build(usuario);
    }

}
