package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.curso.Curso;
import com.aluracursos.ForoHub.dto.CursoDTO;
import com.aluracursos.ForoHub.repository.CRepository;
import com.aluracursos.ForoHub.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CRepository cRepository;

    @Autowired
    private CursoService servicio;

    @GetMapping
    public List<CursoDTO> obtenerCurso() {
        return servicio.obtenerCurso();
    }

    @PostMapping
    public ResponseEntity<Curso> guardarUsuario(@RequestBody Curso curso){
        Curso cursoGuardado = cRepository.save(curso);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cursoGuardado.getId_curso()).toUri();
        return ResponseEntity.created(ubicacion).body(cursoGuardado);
    }

}
