package com.example.curso.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "materia")
    private String materia;


    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<RegistroCurso> estudiantes;

    public Curso() {
    }

    public Curso(Long id, String nombre, String descripcion, String materia, Profesor profesor, List<RegistroCurso> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.materia = materia;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<RegistroCurso> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<RegistroCurso> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
