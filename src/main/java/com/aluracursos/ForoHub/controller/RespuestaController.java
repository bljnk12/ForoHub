package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.Usuario.Usuario;
import com.aluracursos.ForoHub.dto.RespuestaDTO;
import com.aluracursos.ForoHub.repository.RRepository;
import com.aluracursos.ForoHub.repository.TRepository;
import com.aluracursos.ForoHub.repository.URepository;
import com.aluracursos.ForoHub.respuesta.Respuesta;
import com.aluracursos.ForoHub.service.RespuestaService;
import com.aluracursos.ForoHub.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RRepository rRepository;

    @Autowired
    private TRepository tRepository;

    @Autowired
    private URepository uRepository;

    @Autowired
    private RespuestaService servicio;

    @GetMapping
        public List<RespuestaDTO> obtenerRespuestas() {
        return servicio.obtenerRespuestas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRespuestaPorId(@PathVariable long id){
        Optional<Respuesta> respuestaOptional = rRepository.findById(id);

        if(!respuestaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(respuestaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Respuesta> registrartRespuesta(@RequestBody Respuesta respuesta) {

        Optional<Topico> topicoOptional = tRepository.findById(respuesta.getTopico_id().getId());
        if(!topicoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Usuario> usuarioOptional = uRepository.findById(respuesta.getUsuario_respuesta_id().getId_usuario());
        if(!usuarioOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        respuesta.setTopico_id(topicoOptional.get());
        respuesta.setUsuario_respuesta_id(usuarioOptional.get());
        Respuesta respuestaGuardada = rRepository.save(respuesta);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(respuestaGuardada.getId_respuesta()).toUri();
        return ResponseEntity.created(ubicacion).body(respuestaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> actualizarBiblioteca(@PathVariable long id, @RequestBody Respuesta respuesta){
        Optional<Respuesta> respuestaOptional = rRepository.findById(id);

        if(!respuestaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        respuesta.setId_respuesta(respuestaOptional.get().getId_respuesta());
        respuesta.setTopico_id(respuestaOptional.get().getTopico_id());
        respuesta.setFecha_respuesta(respuestaOptional.get().getFecha_respuesta());
        respuesta.setUsuario_respuesta_id(respuestaOptional.get().getUsuario_respuesta_id());
        respuesta.setSolucion(respuestaOptional.get().getSolucion());
        rRepository.save(respuesta);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respuesta> eliminaRespuesta(@PathVariable long id){
        Optional<Respuesta> respuestaOptional = rRepository.findById(id);

        if(!respuestaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        rRepository.delete(respuestaOptional.get());
        return ResponseEntity.noContent().build();
    }

}