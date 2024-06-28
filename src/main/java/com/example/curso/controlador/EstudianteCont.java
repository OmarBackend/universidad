package com.example.curso.controlador;

import com.example.curso.modelo.Curso;
import com.example.curso.modelo.Estudiante;
import com.example.curso.modelo.RegistroCurso;
import com.example.curso.servicios.EstudianteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/estudiantes")

public class EstudianteCont {

    @Autowired
    private EstudianteServ estudianteServ;

    // Endpoint para crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        try {
            Estudiante nuevoEstudiante = estudianteServ.crearEstudiante(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para obtener todos los estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosEstudiantes() {
        List<Estudiante> estudiantes = estudianteServ.obtenerTodos();
        return ResponseEntity.ok(estudiantes);
    }

    // Endpoint para obtener un estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteServ.obtenerPorId(id);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para actualizar un estudiante
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
        try {
            Estudiante estudiante = estudianteServ.actualizarEstudiante(id, estudianteActualizado);
            if (estudiante != null) {
                return ResponseEntity.ok(estudiante);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        boolean eliminado = estudianteServ.eliminarEstudiante(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint adicional para listar los cursos de un estudiante
    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<Curso>> listarCursosDeEstudiante(@PathVariable Long id) {
        Estudiante estudiante = estudianteServ.obtenerPorId(id);
        if (estudiante != null) {
            Set<RegistroCurso> registrosCursos = estudiante.getRegistrosCursos();
            List<Curso> cursos = new ArrayList<>();
            for (RegistroCurso registroCurso : registrosCursos) {
                cursos.add(registroCurso.getCurso());
            }
            return ResponseEntity.ok(cursos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint adicional para validar si un estudiante es mayor de 18 años
    @GetMapping("/{id}/mayor-edad")
    public ResponseEntity<Boolean> validarMayorEdad(@PathVariable Long id) {
        Estudiante estudiante = estudianteServ.obtenerPorId(id);
        if (estudiante != null) {
            boolean esMayorDeEdad = estudianteServ.esMayorDeEdad(estudiante.getFechaNacimiento());
            return ResponseEntity.ok(esMayorDeEdad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
