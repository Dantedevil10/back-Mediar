package com.example.medi.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medi.dto.MensagensDTO;
import com.example.medi.models.Mediadores;
import com.example.medi.models.Mensagens;
import com.example.medi.models.Usuarios;
import com.example.medi.repository.MediadoresRepository;
import com.example.medi.repository.MensagensRepository;
import com.example.medi.repository.UsuariosRepository;

@Service
public class MensagensService {
    @Autowired
    private MensagensRepository mensagensRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;
    private MediadoresRepository mediadoresRepository;

    public MensagensDTO enviarMensagem(Long remetente, Long destinatario, String conteudo) {
        return (null);
    }
}