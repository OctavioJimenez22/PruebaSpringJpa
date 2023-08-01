package com.aprendizaje.jpa.repository.impl;


import com.aprendizaje.jpa.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository <Persona, String > {
}