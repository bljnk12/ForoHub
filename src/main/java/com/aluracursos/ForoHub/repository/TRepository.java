package com.aluracursos.ForoHub.repository;

import com.aluracursos.ForoHub.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAll(Pageable paginacion);
}
