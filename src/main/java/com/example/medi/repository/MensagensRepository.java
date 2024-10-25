package com.example.medi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.medi.models.Mensagens;
import com.example.medi.models.Usuarios;

import jakarta.transaction.Transactional;

public interface MensagensRepository extends JpaRepository<Mensagens, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Mensagens m WHERE m.remetente = :usuario OR m.destinatario = :usuario")
    void deleteByUsuario(Usuarios usuario);
}
