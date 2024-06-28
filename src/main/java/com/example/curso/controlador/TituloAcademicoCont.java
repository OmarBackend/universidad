package com.example.curso.controlador;

import com.example.curso.modelo.TituloAcademico;
import com.example.curso.servicios.TituloAcademicoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titulos-academicos")

public class TituloAcademicoCont {

    @Autowired
    private TituloAcademicoServ tituloAcademicoServ;

    // Endpoint para crear un nuevo título académico
    @PostMapping
    public ResponseEntity<TituloAcademico> crearTituloAcademico(@RequestBody TituloAcademico tituloAcademico) {
        try {
            TituloAcademico nuevoTituloAcademico = tituloAcademicoServ.crearTituloAcademico(tituloAcademico);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTituloAcademico);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para obtener todos los títulos académicos
    @GetMapping
    public ResponseEntity<List<TituloAcademico>> obtenerTodosTitulosAcademicos() {
        List<TituloAcademico> titulosAcademicos = tituloAcademicoServ.obtenerTodos();
        return ResponseEntity.ok(titulosAcademicos);
    }

    // Endpoint para obtener un título académico por ID
    @GetMapping("/{id}")
    public ResponseEntity<TituloAcademico> obtenerTituloAcademicoPorId(@PathVariable Long id) {
        TituloAcademico tituloAcademico = tituloAcademicoServ.obtenerPorId(id);
        if (tituloAcademico != null) {
            return ResponseEntity.ok(tituloAcademico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para actualizar un título académico
    @PutMapping("/{id}")
    public ResponseEntity<TituloAcademico> actualizarTituloAcademico(@PathVariable Long id, @RequestBody TituloAcademico tituloAcademicoActualizado) {
        try {
            TituloAcademico tituloAcademico = tituloAcademicoServ.actualizarTituloAcademico(id, tituloAcademicoActualizado);
            if (tituloAcademico != null) {
                return ResponseEntity.ok(tituloAcademico);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Endpoint para eliminar un título académico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTituloAcademico(@PathVariable Long id) {
        boolean eliminado = tituloAcademicoServ.eliminarTituloAcademico(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
