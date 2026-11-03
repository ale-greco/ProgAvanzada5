package com.ejemplo.personas.repository;

import com.ejemplo.personas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
