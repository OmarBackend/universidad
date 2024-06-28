package com.example.curso.modelo;

import jakarta.persistence.*;

@Entity

public class TituloAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
@ManyToOne
@JoinColumn(name = "profesor_id")
    private Profesor profesor;
    public TituloAcademico() {
    }

    public TituloAcademico(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
