package com.example.curso.servicios;

import com.example.curso.modelo.Curso;
import com.example.curso.modelo.RegistroCurso;
import com.example.curso.repositorios.RegistroCursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroCursoServicio {

    private RegistroCursoRepo registroCursoRepositorio;

    private final String messageNotFound = "Registro del curso no encontrado";

    @Autowired
    public RegistroCursoServicio(RegistroCursoRepo registroCursoRepositorio) {
        this.registroCursoRepositorio = registroCursoRepositorio;
    }

    public void crearRegistroCurso(RegistroCurso registro) {
        this.registroCursoRepositorio.save(registro);
        System.out.println("");
    }

    public List<RegistroCurso> obtenerRegistrosCursoPorEstudiante(Long estudianteId) {
        return this.registroCursoRepositorio.findByEstudianteId(estudianteId);
    }

    public RegistroCurso actualizarRegistroCurso(Long id, RegistroCurso datosRegistroCurso) throws Exception {
        Optional<RegistroCurso> registroPorId = this.registroCursoRepositorio.findById(id);

        if (registroPorId.isPresent()) {
            RegistroCurso registro = registroPorId.get();
            registro.setFechaMatricula(datosRegistroCurso.getFechaMatricula());
            registro.setFechaDesmatricula(datosRegistroCurso.getFechaDesmatricula());

            return this.registroCursoRepositorio.save(registro);
        } else {
            throw new ClassNotFoundException(messageNotFound);
        }
    }

    public void eliminarRegistroCurso(Long id) throws Exception {
        Optional<RegistroCurso> registro = this.registroCursoRepositorio.findById(id);

        if (registro.isPresent()) {
            this.registroCursoRepositorio.delete(registro.get());
        } else {
            throw new ClassNotFoundException(messageNotFound);
        }
    }
}
