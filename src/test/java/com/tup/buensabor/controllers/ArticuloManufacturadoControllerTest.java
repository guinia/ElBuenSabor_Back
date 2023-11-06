package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.services.ArticuloManufacturadoServiceImpl;
import org.junit.jupiter.api.Test;
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

@WebMvcTest(ArticuloManufacturadoController.class)
public class ArticuloManufacturadoControllerTest {

    @MockBean
    private ArticuloManufacturadoServiceImpl articuloManufacturadoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSearchString() throws Exception {

        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
        articuloManufacturado.setDenominacion("Hamburguesa");

        List<ArticuloManufacturado> listaEnviada = new ArrayList();
        listaEnviada.add(articuloManufacturado);

        when(articuloManufacturadoService.search("Hamburguesa")).thenReturn(listaEnviada);

        mockMvc.perform(get("/api/v1/articulosmanufacturados/search")
                        .param("filtro", "Hamburguesa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].denominacion", is("Hamburguesa")));

    }
}
