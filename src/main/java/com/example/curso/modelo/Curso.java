package com.example.curso.modelo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "curso")
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

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private Set<RegistroCurso> registrosEstudiante = new HashSet<>();

    public Curso() {
    }

    public Curso(Long id, String nombre, String descripcion, String materia, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.materia = materia;
//        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getMateria() {
        return materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre != null) this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion != null) this.descripcion = descripcion;
    }

    public void setMateria(String materia) {
        if(materia != null) this.materia = materia;
    }

    public void setProfesor(Profesor profesor) {
        if(profesor != null) this.profesor = profesor;
    }
}
