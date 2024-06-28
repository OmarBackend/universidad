package com.example.curso.modelo;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registro_curso")
public class RegistroCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaMatricula;
    private LocalDate fechaDesmatricula;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public RegistroCurso() {
    }

    public RegistroCurso(Long id, LocalDate fechaMatricula, LocalDate fechaDesmatricula, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.fechaMatricula = fechaMatricula;
        this.fechaDesmatricula = fechaDesmatricula;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public LocalDate getFechaDesmatricula() {
        return fechaDesmatricula;
    }

    public void setFechaDesmatricula(LocalDate fechaDesmatricula) {
        this.fechaDesmatricula = fechaDesmatricula;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
