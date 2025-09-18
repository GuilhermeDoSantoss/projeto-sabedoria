package com.tech.guilherme.conhecimentos.CRUD.infrastructure.repository;

import com.tech.guilherme.conhecimentos.CRUD.infrastructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioRepository, Long> {

    UsuarioEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
