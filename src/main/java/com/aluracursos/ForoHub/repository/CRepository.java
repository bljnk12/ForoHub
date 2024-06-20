package com.aluracursos.ForoHub.repository;

import com.aluracursos.ForoHub.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findAll(Pageable paginacion);
}
