package com.example.curso.repositorios;

import com.example.curso.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepo extends JpaRepository<Profesor, Long> {
}
