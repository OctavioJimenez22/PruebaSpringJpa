package com.aprendizaje.jpa.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.aprendizaje.jpa.model.Persona;
import com.aprendizaje.jpa.repository.PersonaRepositoryJPAInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonaRepositoryJPA implements PersonaRepositoryJPAInterface {
    @PersistenceContext
    EntityManager em;


    @Override
    public List<Persona> buscarTodos() {
        TypedQuery<Persona> consulta= em.createQuery("select p from Persona p",Persona.class);
        return consulta.getResultList();
    }
    @Transactional
    public void insertar(Persona persona) {

        em.persist(persona);
    }

    @Transactional
    public void borrar(Persona persona) {
        em.remove(em.merge(persona));
    }
    @Override
    public Persona buscarUno(String nombre) {
        // TODO Auto-generated method stub
        return em.find(Persona.class, nombre);
    }
}