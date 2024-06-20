package com.aluracursos.ForoHub.topico;

import com.aluracursos.ForoHub.Usuario.Usuario;
import com.aluracursos.ForoHub.curso.Curso;
import com.aluracursos.ForoHub.respuesta.Respuesta;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje, String fecha_creacion, Boolean status, Usuario usuario_id, Curso curso_id, List<Respuesta> respuestas) {
}
