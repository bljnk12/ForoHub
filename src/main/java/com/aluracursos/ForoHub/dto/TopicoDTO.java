package com.aluracursos.ForoHub.dto;

//import com.aluracursos.screenmatch.model.Categoria;

import com.aluracursos.ForoHub.Usuario.Usuario;
import com.aluracursos.ForoHub.curso.Curso;
import com.aluracursos.ForoHub.respuesta.Respuesta;

import java.util.List;
import java.util.Set;

public record TopicoDTO(Long id,
                        String titulo,
                        String mensaje,
                        String fecha_creacion,
                        Boolean status,
                        Usuario usuario_id,
                        Curso curso_id,
                        List<Respuesta> respuestas

){
}
