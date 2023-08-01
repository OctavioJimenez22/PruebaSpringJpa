package com.aprendizaje.jpa;

import com.aprendizaje.jpa.model.Persona;
import com.aprendizaje.jpa.repository.impl.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    @Autowired
    PersonaRepository repositorio;
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
    @Override
    public void run(String...args) throws Exception {
        crearPersonas();
        System.out.println("entro");
        repositorio.findAll().forEach((p) -> System.out.println(p.getNombre() + " " + p.getApellidos() + " "+ p.getEdad() ));
        System.out.println("salio");

    }

    private void crearPersonas() {
        Persona persona1 = new Persona();
        persona1.setApellidos("jimenez");
        persona1.setEdad(20);
        persona1.setNombre("tavo");

        Persona persona2 = new Persona();
        persona2.setApellidos("jimenez2");
        persona2.setEdad(25);
        persona2.setNombre("tavis");

        repositorio.saveAll(Arrays.asList(persona1, persona2));
    }
}