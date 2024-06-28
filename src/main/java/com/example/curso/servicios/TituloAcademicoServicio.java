package com.example.curso.servicios;

import com.example.curso.modelo.TituloAcademico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TituloAcademicoServicio {
    @Autowired
    private TituloAcademicoRepositorio tituloAcademicoRepositorio;

    // Método para crear un nuevo título académico
    public TituloAcademico crearTituloAcademico(TituloAcademico tituloAcademico) {
        return tituloAcademicoRepositorio.save(tituloAcademico);
    }

    // Método para obtener todos los títulos académicos
    public List<TituloAcademico> obtenerTodos() {
        return tituloAcademicoRepositorio.findAll();
    }

    // Método para obtener un título académico por ID
    public TituloAcademico obtenerPorId(Long id) {
        Optional<TituloAcademico> tituloAcademico = tituloAcademicoRepositorio.findById(id);
        return tituloAcademico.orElse(null);
    }

    // Método para actualizar un título académico existente
    public TituloAcademico actualizarTituloAcademico(Long id, TituloAcademico tituloAcademicoActualizado) {
        Optional<TituloAcademico> tituloAcademicoOpt = tituloAcademicoRepositorio.findById(id);

        if (tituloAcademicoOpt.isPresent()) {
            TituloAcademico tituloAcademico = tituloAcademicoOpt.get();
            tituloAcademico.setTitulo(tituloAcademicoActualizado.getTitulo());

            return tituloAcademicoRepositorio.save(tituloAcademico);
        } else {
            return null;
        }
    }

    // Método para eliminar un título académico por ID
    public boolean eliminarTituloAcademico(Long id) {
        Optional<TituloAcademico> tituloAcademico = tituloAcademicoRepositorio.findById(id);

        if (tituloAcademico.isPresent()) {
            tituloAcademicoRepositorio.delete(tituloAcademico.get());
            return true;
        } else {
            return false;
        }
    }
}
