package com.aluracursos.ForoHub.service;

import com.aluracursos.ForoHub.dto.PerfilDTO;
import com.aluracursos.ForoHub.perfil.Perfil;
import com.aluracursos.ForoHub.repository.PRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilService {
    @Autowired
    private PRepository repository;

    public List<PerfilDTO> obtenerPerfil() {
        return convierteDatos(repository.findAll());
    }

    public List<PerfilDTO> convierteDatos(List<Perfil> perfil) {
        return perfil.stream()
                .map(p -> new PerfilDTO(p.getId_perfil(), p.getNombre_perfil()))
                .collect(Collectors.toList());
    }
}
