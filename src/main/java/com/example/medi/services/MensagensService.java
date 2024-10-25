package com.example.medi.services;

import com.example.medi.dto.MensagensDTO;
import com.example.medi.models.Mensagens;
import com.example.medi.models.Usuarios;
import com.example.medi.repository.MediadoresRepository;
import com.example.medi.repository.MensagensRepository;
import com.example.medi.repository.UsuariosRepository;
import com.example.medi.models.Mediadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MensagensService {

    @Autowired
    private MensagensRepository mensagensRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private MediadoresRepository mediadorRepository;

    public Mensagens enviarMensagem(MensagensDTO mensagensDTO) {
        // Determina se o remetente é um usuário ou um mediador
        Usuarios remetente = buscarUsuarioOuMediador(mensagensDTO.getRemetente(), true);

        // Determina se o destinatário é um usuário ou um mediador
        Usuarios destinatario = buscarUsuarioOuMediador(mensagensDTO.getDestinatario(), false);

        // Criar nova mensagem
        Mensagens mensagem = new Mensagens();
        mensagem.setRemetente(remetente);
        mensagem.setDestinatario(destinatario);
        mensagem.setConteudo(mensagensDTO.getConteudo());
        mensagem.setDataEnvio(LocalDateTime.now());

        // Persistir mensagem no banco de dados
        return mensagensRepository.save(mensagem);
    }

    private Usuarios buscarUsuarioOuMediador(Long id, boolean isRemetente) {
        // Busca um usuário
        Usuarios usuario = usuariosRepository.findById(id)
                .orElse(null);
        if (usuario != null) {
            return usuario;
        }

        // Se não encontrou um usuário, busca um mediador
        Mediadores mediador = mediadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário ou Mediador não encontrado"));

        // Aqui você pode optar por retornar um novo objeto Usuario ou manipular conforme necessário
        Usuarios usuarioRepresentativo = new Usuarios();
        usuarioRepresentativo.setId(mediador.getId());
        // Outros atributos que você deseja copiar do mediador para o usuário, se necessário
        return usuarioRepresentativo;
    }
}
