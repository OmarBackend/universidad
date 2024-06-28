package com.example.curso.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registro_curso")
public class RegistroCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_matricula")
    private LocalDate fechaMatricula;

    @Column(name = "fecha_desmatricula")
    private LocalDate fechaDesmatricula;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public RegistroCurso() {
    }

    public RegistroCurso(Long id, LocalDate fechaMatricula, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.fechaMatricula = fechaMatricula;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public LocalDate getFechaDesmatricula() {
        return fechaDesmatricula;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        if(fechaMatricula != null) this.fechaMatricula = fechaMatricula;
    }

    public void setFechaDesmatricula(LocalDate fechaDesmatricula) {
        if(fechaDesmatricula != null) this.fechaDesmatricula = fechaDesmatricula;
    }
}
