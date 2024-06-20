package com.aluracursos.ForoHub.Usuario;

import com.aluracursos.ForoHub.perfil.DatosPerfil;

import jakarta.validation.constraints.NotBlank;

public record DatosUsuario (
        @NotBlank
        String nombre,
        @NotBlank
        String correo_electronico,
        @NotBlank
        String contrasena ) {
}
