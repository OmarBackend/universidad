package com.example.curso.servicios;

import com.example.curso.modelo.Curso;
import com.example.curso.repositorios.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {

    private CursoRepo cursoRepositorio;

    private final String messageNotFound = "Curso no encontrado";

    @Autowired
    public CursoServicio(CursoRepo cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    public void crearCurso(Curso curso) {
        this.cursoRepositorio.save(curso);
    }

    public List<Curso> obtenerCursos() {
        return this.cursoRepositorio.findAll();
    }

    public Curso obtenerCursoPorId(Long id) throws Exception {
        Optional<Curso> curso = this.cursoRepositorio.findById(id);
        if (curso.isPresent()) {
            return curso.get();
        }
        throw new ClassNotFoundException(messageNotFound);
    }

    public Curso actualizarCurso(Long id, Curso datosCurso) throws Exception {
        Optional<Curso> cursoPorId = this.cursoRepositorio.findById(id);

        if (cursoPorId.isPresent()) {
            Curso curso = cursoPorId.get();
            curso.setNombre(datosCurso.getNombre());
            curso.setMateria(datosCurso.getMateria());
            curso.setDescripcion(datosCurso.getDescripcion());

            return this.cursoRepositorio.save(curso);
        } else {
            throw new ClassNotFoundException(messageNotFound);
        }
    }

    public void eliminarCurso(Long id) throws Exception {
        Optional<Curso> curso = this.cursoRepositorio.findById(id);

        if (curso.isPresent()) {
            this.cursoRepositorio.delete(curso.get());
        } else {
            throw new ClassNotFoundException(messageNotFound);
        }
    }
}
