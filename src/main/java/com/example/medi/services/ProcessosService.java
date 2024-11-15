package com.example.medi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.medi.dto.ProcessosDTO;

import com.example.medi.models.Processos;
import com.example.medi.repository.ProcessosRepository;
import java.util.UUID;

@Service
public class ProcessosService {

    @Autowired
    private ProcessosRepository processosRepository;

    public Processos criarProcesso( ProcessosDTO proDTO ){

        Processos processo = new Processos();
        processo.setComprovanteResidencia(proDTO.getComprovanteResidencia());
        processo.setCpfAutor(proDTO.getCpfAutor());
        processo.setCriador(proDTO.getCriador());
        processo.setDadosAcusado(proDTO.getDadosAcusado());
        processo.setDescricaoAcusacao(proDTO.getDescricaoAcusacao());
        processo.setEmailAutor(proDTO.getEmailAutor());
        processo.setMotivoEncerramento(proDTO.getMotivoEncerramento());
        processo.setNomeAutor(proDTO.getNomeAutor());
        processo.setNomeReu(proDTO.getNomeReu());
        processo.setStatus(proDTO.getStatus());
        processo.setUrgencia(proDTO.getUrgencia());
        
        return processosRepository.save(processo);
    }

    @SuppressWarnings("unlikely-arg-type")
    public Processos editarProcesso( UUID id, ProcessosDTO proDTO ){
        //Busca Usuario Pelo Id
        Processos process = processosRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Processo não encontrado para o ID: " + id));

        process.setStatus(proDTO.getStatus());

        if("ENCERRADO".equals(proDTO.getStatus())){
            process.setMotivoEncerramento(proDTO.getMotivoEncerramento());
        }
        
        
        return processosRepository.save(process);
    }
    
}
