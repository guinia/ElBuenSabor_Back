package com.tup.buensabor.services;

import com.tup.buensabor.entities.Persona;
import com.tup.buensabor.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonaServiceImplTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaServiceImpl clienteServiceImpl;

    @Test
    void testSearchString() throws Exception {

        Persona persona1 = new Persona();
        persona1.setNombre("Tomas");
        persona1.setApellido("Guiñazu");


        List<Persona> listaEnviada = new ArrayList();
        listaEnviada.add(persona1);

        when(clienteRepository.searchNativo("Tomas")).thenReturn(listaEnviada);
        when(clienteRepository.searchNativo("Guiñazu")).thenReturn(listaEnviada);
        assertEquals(listaEnviada, clienteServiceImpl.search("Tomas"));
        assertEquals(listaEnviada, clienteServiceImpl.search("Guiñazu"));


    }


}
