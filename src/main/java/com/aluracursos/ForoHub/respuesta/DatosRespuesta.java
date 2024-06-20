package com.aluracursos.ForoHub.respuesta;

import com.aluracursos.ForoHub.Usuario.Usuario;
import com.aluracursos.ForoHub.topico.Topico;
import jakarta.validation.constraints.NotBlank;


public record DatosRespuesta (
        @NotBlank
        String mensaje_respuesta,
        @NotBlank
        Topico topico_id,
        @NotBlank
        String fecha_respuesta,
        @NotBlank
        Usuario usuario_respuesta_id,
        @NotBlank
        Boolean solucion ) {
}
