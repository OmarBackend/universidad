package com.example.curso.controlador;

import com.example.curso.modelo.Profesor;
import com.example.curso.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")

public class ProfesorControlador {
    @Autowired
    private ProfesorServicio profesorServicio;

    // Endpoint para crear un nuevo profesor
    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        try {
            Profesor nuevoProfesor = profesorServicio.crearProfesor(profesor);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProfesor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para obtener todos los profesores
    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodosProfesores() {
        List<Profesor> profesores = profesorServicio.obtenerTodos();
        return ResponseEntity.ok(profesores);
    }

    // Endpoint para obtener un profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Long id) {
        Profesor profesor = profesorServicio.obtenerPorId(id);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para actualizar un profesor
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesorActualizado) {
        try {
            Profesor profesor = profesorServicio.actualizarProfesor(id, profesorActualizado);
            if (profesor != null) {
                return ResponseEntity.ok(profesor);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para eliminar un profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        boolean eliminado = profesorServicio.eliminarProfesor(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
