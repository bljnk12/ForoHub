package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.dto.PerfilDTO;
import com.aluracursos.ForoHub.perfil.Perfil;
import com.aluracursos.ForoHub.repository.PRepository;
import com.aluracursos.ForoHub.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PRepository pRepository;

    @Autowired
    private PerfilService servicio;

    @GetMapping
    public List<PerfilDTO> obtenerPerfil() {
        return servicio.obtenerPerfil();
    }

    @PostMapping
    public ResponseEntity<Perfil> guardarUsuario(@RequestBody Perfil perfil){
        Perfil perfilGuardado = pRepository.save(perfil);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(perfilGuardado.getId_perfil()).toUri();
        return ResponseEntity.created(ubicacion).body(perfilGuardado);
    }

}
