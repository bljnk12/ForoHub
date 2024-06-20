package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.Usuario.Usuario;
import com.aluracursos.ForoHub.dto.RespuestaDTO;
import com.aluracursos.ForoHub.dto.UsuarioDTO;
import com.aluracursos.ForoHub.repository.URepository;
import com.aluracursos.ForoHub.service.RespuestaService;
import com.aluracursos.ForoHub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private URepository uRepository;

    @Autowired
    private UsuarioService servicio;

    @GetMapping
    public List<UsuarioDTO> obtenerUsuario() {
        return servicio.obtenerUsuario();
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioGuardado = uRepository.save(usuario);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioGuardado.getId_usuario()).toUri();
        return ResponseEntity.created(ubicacion).body(usuarioGuardado);
    }

}
