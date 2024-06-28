package com.example.curso.controlador;

import com.example.curso.modelo.Curso;
import com.example.curso.servicios.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")

public class CursoControlador {

    @Autowired
    private CursoServicio cursoServicio;

    @PostMapping
    public ResponseEntity<String> crearCurso(@RequestBody Curso curso) {
        try {
            cursoServicio.crearCurso(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Curso>> obtenerCursos() {
        try {
            List<Curso> cursos = cursoServicio.obtenerCursos();
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCursoPorId(@PathVariable Long id) {
        try {
            Curso curso = cursoServicio.obtenerCursoPorId(id);
            return ResponseEntity.ok(curso);
        } catch (ClassNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCurso(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        try {
            cursoServicio.actualizarCurso(id, cursoActualizado);
            return ResponseEntity.ok().body("Actualizado");
        } catch (ClassNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCurso(@PathVariable Long id) {
        try {
            cursoServicio.eliminarCurso(id);
            return ResponseEntity.ok().body("Eliminado");
        } catch (ClassNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
