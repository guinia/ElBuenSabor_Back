package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Persona;
import com.tup.buensabor.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteControllerTest.class)
public class ClienteControllerTest {

    @MockBean
    private PersonaServiceImpl clienteService;

    @Autowired
    private MockMvc mockMvc;

    void testSearchString() throws Exception {

        Persona persona1 = new Persona();
        persona1.setNombre("Tomas");
        persona1.setApellido("Guiñazu");


        List<Persona> listaEnviada = new ArrayList();
        listaEnviada.add(persona1);

        when(clienteService.search("Tomas")).thenReturn(listaEnviada);


        mockMvc.perform(get("/api/v1/clientes/search")
                        .param("filtro", "Tomas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("Pablo")))
                .andExpect(jsonPath("$[0].apellido", is("Peña")));

    }
}