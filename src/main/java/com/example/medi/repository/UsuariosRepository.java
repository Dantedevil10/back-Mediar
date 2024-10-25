package com.example.medi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medi.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
    boolean existsByEmail(String email);
    boolean existsByNome(String nome);
}