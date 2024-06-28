package com.example.curso.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "estudiante")
    private Set<RegistroCurso> registroCursos = new HashSet<>();

    public Estudiante(){

    }


    public Estudiante(Long id, LocalDate fechaNacimiento, String apellido, String nombre) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Estudiante(Long id, String nombre, String apellido, LocalDate fechaNacimiento, Set<RegistroCurso> registroCursos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.registroCursos = registroCursos;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<RegistroCurso> getRegistrosCursos() {
        return registroCursos;
    }

    public void setCursos(Set<RegistroCurso> cursos) {
        this.registroCursos = cursos;
    }


}
