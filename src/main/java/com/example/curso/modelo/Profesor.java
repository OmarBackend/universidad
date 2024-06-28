package com.example.curso.modelo;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "titulos_academicos")
    @OneToMany(mappedBy = "profesor")
    private List<TituloAcademico> titulosAcademicos;
    @Column(name = "fecha_inicio_trabajo")
    private LocalDate fechaInicioTrabajo;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

    public Profesor() {
    }

    public Profesor(Long id, String nombre, String apellido, List<TituloAcademico> titulosAcademicos, LocalDate fechaInicioTrabajo, List<Curso> cursos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulosAcademicos = titulosAcademicos;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
        this.cursos = cursos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<TituloAcademico> getTitulosAcademicos() {
        return titulosAcademicos;
    }

    public void setTitulosAcademicos(List<TituloAcademico> titulosAcademicos) {
        this.titulosAcademicos = titulosAcademicos;
    }

    public LocalDate getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public void setFechaInicioTrabajo(LocalDate fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
