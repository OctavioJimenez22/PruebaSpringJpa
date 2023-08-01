package com.aprendizaje.jpa.repository;


import java.util.List;

import com.aprendizaje.jpa.model.Persona;
public interface PersonaRepositoryJPAInterface {
    List<Persona> buscarTodos();
    void insertar(Persona persona);
    void borrar(Persona persona);
    Persona buscarUno(String nombre);
}