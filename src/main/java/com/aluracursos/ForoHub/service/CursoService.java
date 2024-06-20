package com.aluracursos.ForoHub.service;

import com.aluracursos.ForoHub.curso.Curso;
import com.aluracursos.ForoHub.dto.CursoDTO;
import com.aluracursos.ForoHub.repository.CRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired
    private CRepository repository;

    public List<CursoDTO> obtenerCurso() {
        return convierteDatos(repository.findAll());
    }

    public List<CursoDTO> convierteDatos(List<Curso> curso) {
        return curso.stream()
                .map(c -> new CursoDTO(c.getId_curso(), c.getNombre_curso(), c.getCategoria()))
                .collect(Collectors.toList());
    }
}
