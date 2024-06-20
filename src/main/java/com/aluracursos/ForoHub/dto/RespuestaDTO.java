package com.aluracursos.ForoHub.dto;

import com.aluracursos.ForoHub.Usuario.Usuario;
import com.aluracursos.ForoHub.topico.Topico;

public record RespuestaDTO(Long id_respuesta,
                           String mensaje_respuesta,
                           Topico topico_id,
                           String fecha_respuesta,
                           Usuario usuario_respuesta_id,
                           Boolean solucion

    ){
}
