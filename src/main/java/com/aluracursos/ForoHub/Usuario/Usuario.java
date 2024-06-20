package com.aluracursos.ForoHub.Usuario;

import com.aluracursos.ForoHub.perfil.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nombre;

    private String correo_electronico;

    private String contrasena;

//    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
//    @JoinColumn(name = "nombre_perfil")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private List<Perfil> perfiles;


    public Usuario(DatosUsuario usuario) {
        this.nombre = usuario.nombre();
        this.correo_electronico = usuario.correo_electronico();
        this.contrasena = usuario.contrasena();
    }

    public Usuario actualizarDatos(DatosUsuario usuario) {
        this.nombre = usuario.nombre();
        this.correo_electronico = usuario.correo_electronico();
        this.contrasena = usuario.contrasena();
        return this;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

//    public List<Perfil> getPerfiles() {
//        return perfiles;
//    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

//    public void setPerfiles(List<Perfil> perfiles) {
//        this.perfiles = perfiles;
//    }
}
