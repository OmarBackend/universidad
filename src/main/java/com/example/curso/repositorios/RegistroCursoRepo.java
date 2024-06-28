package com.example.curso.repositorios;

import com.example.curso.modelo.RegistroCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroCursoRepo extends JpaRepository<RegistroCurso, Long> {
}
