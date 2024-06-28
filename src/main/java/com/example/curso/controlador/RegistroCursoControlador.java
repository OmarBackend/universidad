package com.example.curso.controlador;

import com.example.curso.modelo.RegistroCurso;
import com.example.curso.servicios.RegistroCursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso/registro")

public class RegistroCursoControlador {

    @Autowired
    private RegistroCursoServicio registroCursoServicio;

    @PostMapping
    public ResponseEntity<String> crearRegistroCurso(@RequestBody RegistroCurso registro) {
        try {
            System.out.println(registro.getCurso());
            registroCursoServicio.crearRegistroCurso(registro);
            return ResponseEntity.status(HttpStatus.CREATED).body("Creado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{estudianteId}")
    public ResponseEntity<?> obtenerRegistrosCursoPorEstudiante(@PathVariable Long estudianteId) {
        try {
            List<RegistroCurso> registros = registroCursoServicio.obtenerRegistrosCursoPorEstudiante(estudianteId);
            return ResponseEntity.ok(registros);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarRegistroCurso(@PathVariable Long id, @RequestBody RegistroCurso registro) {
        try {
            registroCursoServicio.actualizarRegistroCurso(id, registro);
            return ResponseEntity.ok().body("Actualizado");
        } catch (ClassNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRegistroCurso(@PathVariable Long id) {
        try {
            registroCursoServicio.eliminarRegistroCurso(id);
            return ResponseEntity.ok().body("Eliminado");
        } catch (ClassNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
