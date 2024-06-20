package com.aluracursos.ForoHub.topico;

import com.aluracursos.ForoHub.Usuario.Usuario;
import com.aluracursos.ForoHub.curso.Curso;
import com.aluracursos.ForoHub.respuesta.Respuesta;

import java.util.List;
import java.util.Set;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String fecha_creacion, Boolean status, Usuario usuario_id, Curso curso_id, List<Respuesta> respuestas) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus(), topico.getUsuario_id(), topico.getCurso_id(),topico.getRespuestas());
    }
}
