package com.aluracursos.ForoHub.repository;

import com.aluracursos.ForoHub.Usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAll(Pageable paginacion);
}
