package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Persona;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PersonaRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void testSearchString() throws Exception {

        Persona persona1 = new Persona();
        persona1.setNombre("Tomas");
        persona1.setApellido("Guiñazu");


        List<Persona> listaEnviada = new ArrayList();
        listaEnviada.add(persona1);

        entityManager.persist(persona1);
        entityManager.flush();

        assertEquals(listaEnviada, clienteRepository.searchNativo("Tomas"));
        assertEquals(listaEnviada, clienteRepository.searchNativo("Guiñazu"));



    }
}