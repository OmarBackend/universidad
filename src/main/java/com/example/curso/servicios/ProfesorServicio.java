package com.example.curso.servicios;

import com.example.curso.modelo.Profesor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfesorServicio {

    @Autowired
    private ProfesorRepositorio profesorRepositorio;

    // Método para crear un nuevo profesor
    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepositorio.save(profesor);
    }

    // Método para obtener todos los profesores
    public List<Profesor> obtenerTodos() {
        return profesorRepositorio.findAll();
    }

    // Método para obtener un profesor por ID
    public Profesor obtenerPorId(Long id) {
        Optional<Profesor> profesor = profesorRepositorio.findById(id);
        return profesor.orElse(null);
    }

    // Método para actualizar un profesor existente
    public Profesor actualizarProfesor(Long id, Profesor profesorActualizado) {
        Optional<Profesor> profesorOpt = profesorRepositorio.findById(id);

        if (profesorOpt.isPresent()) {
            Profesor profesor = profesorOpt.get();
            profesor.setNombre(profesorActualizado.getNombre());
            profesor.setApellido(profesorActualizado.getApellido());
            profesor.setTitulosAcademicos(profesorActualizado.getTitulosAcademicos());
            profesor.setFechaInicioTrabajo(profesorActualizado.getFechaInicioTrabajo());

            // Validar otras reglas de negocio si es necesario

            return profesorRepositorio.save(profesor);
        } else {
            return null;
        }
    }

    // Método para eliminar un profesor por ID
    public boolean eliminarProfesor(Long id) {
        Optional<Profesor> profesor = profesorRepositorio.findById(id);

        if (profesor.isPresent()) {
            profesorRepositorio.delete(profesor.get());
            return true;
        } else {
            return false;
        }
    }

    // Método para obtener la cantidad de cursos que imparte cada profesor
    public Map<String, Integer> obtenerCantidadCursosPorProfesor() {
        List<Profesor> profesores = profesorRepositorio.findAll();
        Map<String, Integer> cantidadCursosPorProfesor = new HashMap<>();

        for (Profesor profesor : profesores) {
            cantidadCursosPorProfesor.put(profesor.getNombre() + " " + profesor.getApellido(), profesor.getCursos().size());
        }

        return cantidadCursosPorProfesor;
    }
}