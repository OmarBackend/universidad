package com.example.curso.repositorios;

import com.example.curso.modelo.TituloAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloAcademicoRepo extends JpaRepository<TituloAcademico, Long> {
}
