package com.example.curso.servicios;

import com.example.curso.modelo.Curso;
import com.example.curso.modelo.Estudiante;
import com.example.curso.repositorios.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServ {

    private EstudianteRepo estudianteRepo;
    @Autowired
    public EstudianteServ(EstudianteRepo estudianteRepo) {
        this.estudianteRepo = estudianteRepo;
    }
    public Estudiante crearEstudiante(Estudiante estudiante) {
        // Validar que el estudiante sea mayor de 18 años antes de crearlo
        if (!esMayorDeEdad(estudiante.getFechaNacimiento())) {
            throw new IllegalArgumentException("El estudiante debe ser mayor de 18 años.");
        }
        return estudianteRepo.save(estudiante);
    }

    // Método para obtener todos los estudiantes
    public List<Estudiante> obtenerTodos() {
        return estudianteRepo.findAll();
    }

    // Método para obtener un estudiante por ID
    public Estudiante obtenerPorId(Long id) {
        Optional<Estudiante> estudiante = estudianteRepo.findById(id);
        return estudiante.orElse(null);
    }

    // Método para actualizar un estudiante existente
    public Estudiante actualizarEstudiante(Long id, Estudiante estudianteActualizado) {
        Optional<Estudiante> estudianteOpt = estudianteRepo.findById(id);

        if (estudianteOpt.isPresent()) {
            Estudiante estudiante = estudianteOpt.get();
            estudiante.setNombre(estudianteActualizado.getNombre());
            estudiante.setApellido(estudianteActualizado.getApellido());
            estudiante.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());

            // Validar que el estudiante sea mayor de 18 años antes de actualizarlo
            if (!esMayorDeEdad(estudiante.getFechaNacimiento())) {
                throw new IllegalArgumentException("El estudiante debe ser mayor de 18 años.");
            }

            return estudianteRepo.save(estudiante);
        } else {
            return null;
        }
    }

    // Método para eliminar un estudiante por ID
    public boolean eliminarEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepo.findById(id);

        if (estudiante.isPresent()) {
            estudianteRepo.delete(estudiante.get());
            return true;
        } else {
            return false;
        }
    }

    // Método para validar si un estudiante es mayor de 18 años
    public boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        LocalDate fechaMayorEdad = LocalDate.now().minusYears(18);
        return fechaNacimiento.isBefore(fechaMayorEdad);
    }

    // Método para obtener los cursos de un estudiante en un semestre específico
    public List<Curso> obtenerCursosPorEstudianteEnSemestre(Long idEstudiante, LocalDate fechaSemestre) {
        // Implementa lógica para obtener cursos por estudiante en un semestre específico
        // Puedes usar el EstudianteRepository para acceder a los cursos del estudiante
        return null;  // Implementar según tus requerimientos
    }
}
