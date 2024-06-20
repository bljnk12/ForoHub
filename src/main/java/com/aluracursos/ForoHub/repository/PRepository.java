package com.aluracursos.ForoHub.repository;

import com.aluracursos.ForoHub.curso.Curso;
import com.aluracursos.ForoHub.perfil.Perfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PRepository extends JpaRepository<Perfil, Long> {
    Page<Perfil> findAll(Pageable paginacion);
}
