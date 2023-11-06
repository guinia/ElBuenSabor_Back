package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ArticuloManufacturadoServiceImplTest {

    @MockBean
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ArticuloManufacturadoServiceImpl articuloManufacturadoService;

    @Test
    void testSearchString() throws Exception {
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
        articuloManufacturado.setDenominacion("Hamburguesa");

        List<ArticuloManufacturado> listaEnviada = new ArrayList();
        listaEnviada.add(articuloManufacturado);

        when(articuloManufacturadoRepository.searchNativo("Hamburguesa")).thenReturn(listaEnviada);
        assertEquals(listaEnviada, articuloManufacturadoService.search("Hamburguesa"));


    }


}
