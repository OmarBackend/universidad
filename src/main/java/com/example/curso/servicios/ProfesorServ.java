package com.example.curso.servicios;

import com.example.curso.modelo.Profesor;
import com.example.curso.repositorios.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfesorServ {

    @Autowired
    private ProfesorRepo profesorRepo;

    // Método para crear un nuevo profesor
    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepo.save(profesor);
    }

    // Método para obtener todos los profesores
    public List<Profesor> obtenerTodos() {
        return profesorRepo.findAll();
    }

    // Método para obtener un profesor por ID
    public Profesor obtenerPorId(Long id) {
        Optional<Profesor> profesor = profesorRepo.findById(id);
        return profesor.orElse(null);
    }

    // Método para actualizar un profesor existente
    public Profesor actualizarProfesor(Long id, Profesor profesorActualizado) {
        Optional<Profesor> profesorOpt = profesorRepo.findById(id);

        if (profesorOpt.isPresent()) {
            Profesor profesor = profesorOpt.get();
            profesor.setNombre(profesorActualizado.getNombre());
            profesor.setApellido(profesorActualizado.getApellido());
            profesor.setTitulosAcademicos(profesorActualizado.getTitulosAcademicos());
            profesor.setFechaInicioTrabajo(profesorActualizado.getFechaInicioTrabajo());

            // Validar otras reglas de negocio si es necesario

            return profesorRepo.save(profesor);
        } else {
            return null;
        }
    }

    // Método para eliminar un profesor por ID
    public boolean eliminarProfesor(Long id) {
        Optional<Profesor> profesor = profesorRepo.findById(id);

        if (profesor.isPresent()) {
            profesorRepo.delete(profesor.get());
            return true;
        } else {
            return false;
        }
    }

    // Método para obtener la cantidad de cursos que imparte cada profesor
    public Map<String, Integer> obtenerCantidadCursosPorProfesor() {
        List<Profesor> profesores = profesorRepo.findAll();
        Map<String, Integer> cantidadCursosPorProfesor = new HashMap<>();

        for (Profesor profesor : profesores) {
            cantidadCursosPorProfesor.put(profesor.getNombre() + " " + profesor.getApellido(), profesor.getCursos().size());
        }

        return cantidadCursosPorProfesor;
    }
}