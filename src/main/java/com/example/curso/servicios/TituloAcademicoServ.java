package com.example.curso.servicios;

import com.example.curso.modelo.TituloAcademico;
import com.example.curso.repositorios.TituloAcademicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TituloAcademicoServ {
    @Autowired
    private TituloAcademicoRepo tituloAcademicoRepo;

    // Método para crear un nuevo título académico
    public TituloAcademico crearTituloAcademico(TituloAcademico tituloAcademico) {
        return tituloAcademicoRepo.save(tituloAcademico);
    }

    // Método para obtener todos los títulos académicos
    public List<TituloAcademico> obtenerTodos() {
        return tituloAcademicoRepo.findAll();
    }

    // Método para obtener un título académico por ID
    public TituloAcademico obtenerPorId(Long id) {
        Optional<TituloAcademico> tituloAcademico = tituloAcademicoRepo.findById(id);
        return tituloAcademico.orElse(null);
    }

    // Método para actualizar un título académico existente
    public TituloAcademico actualizarTituloAcademico(Long id, TituloAcademico tituloAcademicoActualizado) {
        Optional<TituloAcademico> tituloAcademicoOpt = tituloAcademicoRepo.findById(id);

        if (tituloAcademicoOpt.isPresent()) {
            TituloAcademico tituloAcademico = tituloAcademicoOpt.get();
            tituloAcademico.setTitulo(tituloAcademicoActualizado.getTitulo());

            return tituloAcademicoRepo.save(tituloAcademico);
        } else {
            return null;
        }
    }

    // Método para eliminar un título académico por ID
    public boolean eliminarTituloAcademico(Long id) {
        Optional<TituloAcademico> tituloAcademico = tituloAcademicoRepo.findById(id);

        if (tituloAcademico.isPresent()) {
            tituloAcademicoRepo.delete(tituloAcademico.get());
            return true;
        } else {
            return false;
        }
    }
}
