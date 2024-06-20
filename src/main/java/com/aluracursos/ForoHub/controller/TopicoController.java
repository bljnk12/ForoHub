package com.aluracursos.ForoHub.controller;

import com.aluracursos.ForoHub.dto.TopicoDTO;
import com.aluracursos.ForoHub.repository.RRepository;
import com.aluracursos.ForoHub.repository.TRepository;
import com.aluracursos.ForoHub.respuesta.Respuesta;
import com.aluracursos.ForoHub.service.TopicoService;
import com.aluracursos.ForoHub.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TRepository tRepository;

    @Autowired
    private RRepository rRepository;

    @Autowired
    private TopicoService servicio;


    @GetMapping
    public List<TopicoDTO> obtenerTodos(){
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable long id){
        Optional<Topico> topicoOptional = tRepository.findById(id);

        if(!topicoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(topicoOptional.get());
    }

    @PostMapping
    public ResponseEntity<Topico> guardarBiblioteca(@RequestBody Topico topico){

        Topico topicoGuardado = tRepository.save(topico);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(topicoGuardado.getId()).toUri();
        return ResponseEntity.created(ubicacion).body(topicoGuardado);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarBiblioteca(@PathVariable long id, @RequestBody Topico topico){
        Optional<Topico> topicoOptional = tRepository.findById(id);

        if(!topicoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        topico.setId(topicoOptional.get().getId());
        topico.setFecha_creacion(topicoOptional.get().getFecha_creacion());
        topico.setStatus(topicoOptional.get().getStatus());
        topico.setUsuario_id(topicoOptional.get().getUsuario_id());
        topico.setCurso_id(topicoOptional.get().getCurso_id());
        tRepository.save(topico);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Topico> eliminarTopico(@PathVariable long id){
        Optional<Topico> topicoOptional = tRepository.findById(id);

        if(!topicoOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        tRepository.delete(topicoOptional.get());
        return ResponseEntity.noContent().build();
    }

}
