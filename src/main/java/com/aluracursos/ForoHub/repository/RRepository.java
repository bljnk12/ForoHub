package com.aluracursos.ForoHub.repository;

import com.aluracursos.ForoHub.respuesta.Respuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RRepository extends JpaRepository<Respuesta, Long> {
    Page<Respuesta> findAll(Pageable paginacion);
}
