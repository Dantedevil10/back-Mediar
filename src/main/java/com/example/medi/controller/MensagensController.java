package com.example.medi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medi.dto.MensagensDTO;
import com.example.medi.models.Mensagens;
import com.example.medi.repository.MensagensRepository;
import com.example.medi.services.MensagensService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/mensagens")
@CrossOrigin(origins = "http://localhost:4200")
public class MensagensController {

    @Autowired
    private MensagensService mensagensService;
    @Autowired
    private MensagensRepository menRepo;

    @GetMapping
    public List<Mensagens> listaMensagens(){
        return menRepo.findAll();
    }

    @PostMapping("/enviar")
    public Mensagens enviarMensagem(@RequestBody MensagensDTO mensagemDto) {
       return mensagensService.enviarMensagem(mensagemDto);
    }
    
}
